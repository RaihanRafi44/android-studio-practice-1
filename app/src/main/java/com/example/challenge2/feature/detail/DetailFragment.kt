package com.example.challenge2.feature.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.challenge2.R
import com.example.challenge2.data.model.Catalog
import toIndonesianFormat
import com.example.challenge2.feature.main.MainActivity

class DetailFragment : Fragment() {

    private var count: Int = 1 // Default quantity is 1
    private lateinit var catalog: Catalog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        catalog = arguments?.getParcelable<Catalog>("catalog") ?: return
        showCatalogData(view)
        setupListeners(view)
        view.findViewById<TextView>(R.id.tv_location_title)?.text =
            getString(R.string.location_title_default)
        view.findViewById<TextView>(R.id.tv_address)?.text = getString(R.string.address_location)
    }

    private fun showCatalogData(view: View) {
        Log.d("DetailFragment", "Catalog: $catalog")
        val ivCatalogImages = view.findViewById<ImageView>(R.id.iv_catalog_images)
        val tvCatalogName = view.findViewById<TextView>(R.id.tv_catalog_name)
        val tvCatalogPrice = view.findViewById<TextView>(R.id.tv_catalog_price)
        val tvFoodDesc = view.findViewById<TextView>(R.id.tv_food_desc)

        catalog?.let { catalog ->
            Log.d("DetailFragment", "Catalog name: ${catalog.name}")
            ivCatalogImages.setImageResource(catalog.image)
            tvCatalogName.text = catalog.name
            tvCatalogPrice.text = catalog.price.toIndonesianFormat()
            tvFoodDesc.text = catalog.desc
        }

        if (catalog == null) {
            // Handle case where catalog is null
            Toast.makeText(context, "Catalog data is null", Toast.LENGTH_SHORT).show()
            activity?.finish() // Close the activity if catalog data is null
        }
    }

    private fun setupListeners(view: View) {
        view.findViewById<Button>(R.id.ic_add).setOnClickListener { incrementCount(view) }
        view.findViewById<Button>(R.id.ic_minus).setOnClickListener { decrementCount(view) }
        view.findViewById<CardView>(R.id.cv_location_detail).setOnClickListener {
            navigateToGoogleMaps()
        }
        view.findViewById<Button>(R.id.btn_back_home)?.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }

    private fun incrementCount(view: View) {
        count++
        updateQuantityText(view)
        updateTotalPrice(view)
    }

    private fun decrementCount(view: View) {
        if (count > 1) {
            count--
            updateQuantityText(view)
            updateTotalPrice(view)
        } else {
            Toast.makeText(context, "Minimum quantity is 1", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateQuantityText(view: View) {
        view.findViewById<TextView>(R.id.tv_quantity_text).text = count.toString()
    }

    @SuppressLint("StringFormatMatches")
    private fun updateTotalPrice(view: View) {
        val price = catalog.price
        val totalPrice = price * count
        val btnAddToCart = view.findViewById<Button>(R.id.btn_add_to_cart)
        btnAddToCart?.text = getString(R.string.add_to_cart_text, totalPrice)
    }

    private fun navigateToGoogleMaps() {
        val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:-6.3016,106.65337"))
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
}
