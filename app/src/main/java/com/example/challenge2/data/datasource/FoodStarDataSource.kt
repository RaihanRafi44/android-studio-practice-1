package com.example.challenge2.data.datasource

import com.example.challenge2.R
import com.example.challenge2.data.model.Catalog
import com.example.challenge2.data.model.Category

interface FoodStarDataSource {
    fun getCatalogMembers(): List<Catalog>
}

class CatalogDataSourceImpl() : FoodStarDataSource {
    override fun getCatalogMembers(): List<Catalog> {
        return mutableListOf(
            Catalog(
                name = "Nasi Goreng Spesial",
                price = 40000.0,
                image = R.drawable.img_fried_rice,
                desc = "Nasi goreng yang dimasak dengan berbagai bahan tambahan dan rempah-rempah untuk memberikan cita rasa yang kaya dan lezat."
            ),
            Catalog(
                name = "Nasi Goreng Lada Hitam",
                price = 30000.0,
                image = R.drawable.img_fried_rice_black_pepper,
                desc = "Nasi goreng lada hitam menonjolkan rasa pedas dan aromatik dari lada hitam yang digunakan dalam proses memasaknya."
            ),
            Catalog(
                name = "Mie Goreng Aceh",
                price = 20000.0,
                image = R.drawable.img_noodle_aceh,
                desc = "Mie goreng Aceh adalah salah satu hidangan khas dari Provinsi Aceh, Indonesia. " +
                        "Hidangan ini memiliki ciri khas dalam penyajiannya, termasuk dalam penggunaan rempah-rempah yang kaya dan rasa yang pedas."
            ),
            Catalog(
                name = "Mie Ayam",
                price = 15000.0,
                image = R.drawable.img_noodle_chicken,
                desc = "Mie ayam adalah hidangan mi yang populer di Indonesia, " +
                        "terutama sebagai salah satu makanan jalanan yang banyak dijual di warung-warung atau kedai kaki lima."
            ),
            Catalog(
                name = "Ayam Bakar Madu",
                price = 16000.0,
                image = R.drawable.img_honey_grilled_chicken,
                desc = "Ayam bakar madu adalah hidangan ayam panggang yang dimasak dengan tambahan madu, memberikan cita rasa manis yang khas."
            ),
            Catalog(
                name = "Ayam Goreng",
                price = 14000.0,
                image = R.drawable.img_fried_chicken,
                desc = "Ayam goreng adalah hidangan yang terbuat dari potongan-potongan daging ayam yang digoreng hingga matang dengan minyak panas."
            ),
            Catalog(
                name = "Sup Asparagus Kepiting",
                price = 50000.0,
                image = R.drawable.img_crab_asparagus_soup,
                desc = "Sup asparagus kepiting adalah hidangan sup yang terdiri dari " +
                        "asparagus, daging kepiting, dan bahan-bahan lainnya yang dibuat menjadi sup yang lezat dan bergizi."
            ),
            Catalog(
                name = "Sayur Asem",
                price = 12000.0,
                image = R.drawable.img_tamarind_vegetable_soup,
                desc = "Sayur asem adalah salah satu hidangan khas Indonesia yang terbuat dari campuran berbagai macam sayuran segar yang dimasak dalam kuah asam yang khas."
            ),
            Catalog(
                name = "Tempe Mendoan",
                price = 8000.0,
                image = R.drawable.img_batter_coated_fried_tempeh,
                desc = "Tempe mendoan adalah hidangan khas Indonesia yang terbuat dari tempe yang dilapisi adonan tepung berbumbu dan kemudian digoreng hingga renyah di luar dan lembut di dalamnya."
            ),
            Catalog(
                name = "Tahu Gejrot",
                price = 7000.0,
                image = R.drawable.img_fried_tofu_in_sweet_spicy_sauce,
                desc = "Tahu gejrot adalah hidangan khas dari Cirebon, Jawa Barat, Indonesia. Hidangan ini terdiri dari tahu yang digoreng dan kemudian disajikan dengan saus"
            ),
            Catalog(
                name = "Es Teh Manis",
                price = 4000.0,
                image = R.drawable.img_ice_tea,
                desc = "Es teh manis adalah minuman segar yang terbuat dari teh hitam atau teh hijau yang diseduh dengan air panas, kemudian ditambahkan gula dan es batu."
            ),
            Catalog(
                name = "Es Jeruk Peras",
                price = 6000.0,
                image = R.drawable.img_squeezed_orange_ice,
                desc = "Es jeruk peras adalah minuman segar yang terbuat dari perasan jeruk segar, gula, air, dan es batu."
            )

        )
    }
}
