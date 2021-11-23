package com.inis.famo.utils

import com.inis.famo.data.model.BestSellingEntity
import com.inis.famo.data.model.HomeTab
import com.inis.famo.data.model.ProductEntity
import com.inis.famo.data.model.TabProduct
import com.inis.famo.ui.base.BaseFragment
import com.inis.famo.ui.screen.fragment.home.tab.TabProductFragment

class AppHelper {

    companion object {

        fun prepareListFragment(listProduct: ArrayList<TabProduct>): ArrayList<BaseFragment<*, *>> {
            val result = arrayListOf<BaseFragment<*, *>>()

            listProduct.forEachIndexed { index, _ ->
                result.add(TabProductFragment(listProduct = listProduct[index].listProduct))
            }

            return result
        }

        fun prepareListBestSelling(): ArrayList<BestSellingEntity> {
            return arrayListOf(
                BestSellingEntity(
                    product_name = "Gao ST25",
                    product_uri = "https://s.meta.com.vn/Data/image/2021/10/11/gao-st25-chu-ho-quang-cua.jpg",
                    product_price = "18",
                    product_unit = "10kg"
                ),
                BestSellingEntity(
                    product_name = "Gao ST25",
                    product_uri = "https://s.meta.com.vn/Data/image/2021/10/11/gao-st25-chu-ho-quang-cua.jpg",
                    product_price = "18",
                    product_unit = "10kg"
                ),
                BestSellingEntity(
                    product_name = "Gao ST25",
                    product_uri = "https://s.meta.com.vn/Data/image/2021/10/11/gao-st25-chu-ho-quang-cua.jpg",
                    product_price = "18",
                    product_unit = "10kg"
                ),
                BestSellingEntity(
                    product_name = "Gao ST25",
                    product_uri = "https://s.meta.com.vn/Data/image/2021/10/11/gao-st25-chu-ho-quang-cua.jpg",
                    product_price = "18",
                    product_unit = "10kg"
                ),
                BestSellingEntity(
                    product_name = "Gao ST25",
                    product_uri = "https://s.meta.com.vn/Data/image/2021/10/11/gao-st25-chu-ho-quang-cua.jpg",
                    product_price = "18",
                    product_unit = "10kg"
                ),
                BestSellingEntity(
                    product_name = "Gao ST25",
                    product_uri = "https://s.meta.com.vn/Data/image/2021/10/11/gao-st25-chu-ho-quang-cua.jpg",
                    product_price = "18",
                    product_unit = "10kg"
                )
            )
        }

        private fun prepareListProduct(): ArrayList<ProductEntity> {
            return arrayListOf(
                ProductEntity(
                    product_name = "Gạo ST21",
                    product_price = "18.000đ ",
                    product_unit = "kg",
                    groupName = "Gạo",

                    ),
                ProductEntity(
                    product_name = "Gạo ST22",
                    product_price = "18.000đ ",
                    product_unit = "kg",
                    groupName = "Gạo",
                ),
                ProductEntity(
                    product_name = "Gạo ST23",
                    product_price = "18.000đ ",
                    product_unit = "kg",
                    groupName = "Gạo",

                    ),
                ProductEntity(
                    product_name = "Gạo ST24",
                    product_price = "18.000đ ",
                    product_unit = "kg",
                    groupName = "Gạo",
                ), ProductEntity(
                    product_name = "Gạo ST25",
                    product_price = "18.000đ ",
                    product_unit = "kg",
                    groupName = "Gạo",
                ),
                ProductEntity(
                    product_name = "Gạo ST26",
                    product_price = "18.000đ ",
                    product_unit = "kg",
                    groupName = "Gạo",
                ),
                ProductEntity(
                    product_name = "Gạo ST27",
                    product_price = "18.000đ ",
                    product_unit = "kg",
                    groupName = "Gạo",
                ),
                ProductEntity(
                    product_name = "Gạo ST28",
                    product_price = "18.000đ ",
                    product_unit = "kg",
                    groupName = "Gạo",
                )
            )
        }

        fun prepareListPager(): ArrayList<TabProduct> {
            return arrayListOf(
                TabProduct("Gạo ST21", prepareListProduct()),
                TabProduct("Gạo ST22", prepareListProduct()),
                TabProduct("Gạo ST23", prepareListProduct()),
                TabProduct("Gạo ST24", prepareListProduct()),
                TabProduct("Gạo ST25", prepareListProduct()),
                TabProduct("Gạo ST26", prepareListProduct()),
                TabProduct("Gạo ST27", prepareListProduct()),
                TabProduct("Gạo ST28", prepareListProduct())
            )
        }

        fun prepareListTab(): ArrayList<HomeTab> {
            return arrayListOf(
                HomeTab(groupName = "Gạo ST21", isSelected = true),
                HomeTab(groupName = "Gạo ST22", isSelected = false),
                HomeTab(groupName = "Gạo ST23", isSelected = false),
                HomeTab(groupName = "Gạo ST24", isSelected = false),
                HomeTab(groupName = "Gạo ST25", isSelected = false),
                HomeTab(groupName = "Gạo ST26", isSelected = false),
                HomeTab(groupName = "Gạo ST27", isSelected = false),
                HomeTab(groupName = "Gạo ST28", isSelected = false),
            )
        }
    }
}