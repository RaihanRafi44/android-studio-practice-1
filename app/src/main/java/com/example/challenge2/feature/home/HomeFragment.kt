package com.example.challenge2.feature.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.challenge2.R
import com.example.challenge2.data.datasource.CatalogDataSourceImpl
import com.example.challenge2.data.datasource.FoodStarDataSource
import com.example.challenge2.data.model.Catalog
import com.example.challenge2.data.model.Category
import com.example.challenge2.databinding.FragmentHomeBinding
import com.example.challenge2.presentation.foodstarlist.adapter.CatalogAdapter
import com.example.challenge2.presentation.foodstarlist.adapter.CategoryAdapter
import com.example.challenge2.presentation.foodstarlist.adapter.OnItemClickedListeners

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val adapterCategory = CategoryAdapter()
    private var adapter: CatalogAdapter? = null
    private val dataSourceCatalog: FoodStarDataSource by lazy {
        CatalogDataSourceImpl()
    }

    private var isUsingGridMode: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.rvCategory.adapter = adapterCategory
        binding.rvCatalog.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListCategory()
        bindCatalogList(isUsingGridMode)
        setClickAction()
    }

    private fun setListCategory() {
        val dataCategory = listOf(
            Category(image = R.drawable.img_ricered, name = "Nasi"),
            Category(image = R.drawable.img_noodlebowl, name = "Mie"),
            Category(image = R.drawable.img_popcorn, name = "Snack"),
            Category(image = R.drawable.img_chicken, name = "Ayam"),
            Category(image = R.drawable.img_soup, name = "Sayuran"),
            Category(image = R.drawable.img_drinks, name = "Minuman"),
        )
        binding.rvCategory.adapter = adapterCategory
        adapterCategory.submitData(dataCategory)
    }

    private fun setClickAction() {
        binding.btnChangeListMode.setOnClickListener {
            isUsingGridMode = !isUsingGridMode
            setButtonIcon(isUsingGridMode)
            bindCatalogList(isUsingGridMode)
        }
    }

    private fun setButtonIcon(usingGridMode: Boolean) {
        val iconResource = if (usingGridMode) R.drawable.ic_grid_black else R.drawable.ic_list_black
        binding.btnChangeListMode.setIconResource(iconResource)
    }

    private fun bindCatalogList(isUsingGrid: Boolean) {
        val listMode = if (isUsingGrid) CatalogAdapter.MODE_GRID else CatalogAdapter.MODE_LIST
        adapter = CatalogAdapter(
            listMode = listMode,
            listener = object : OnItemClickedListeners<Catalog> {
                override fun onItemClicked(item: Catalog) {
                    /*navigateToDetail(item)*/
                }
            }
        )

        val layoutManager = GridLayoutManager(requireContext(), if (isUsingGrid) 2 else 1)
        binding.rvCatalog.layoutManager = layoutManager
        binding.rvCatalog.adapter = adapter
        adapter?.submitData(dataSourceCatalog.getCatalogMembers())
    }


    /*private fun navigateToDetail(item: Catalog) {
        val bundle = bundleOf("catalog" to item)
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
    }*/
}
