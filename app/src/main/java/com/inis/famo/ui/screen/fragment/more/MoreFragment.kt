package com.inis.famo.ui.screen.fragment.more

import android.annotation.SuppressLint
import com.inis.famo.R
import com.inis.famo.data.model.ItemMoreEntity
import com.inis.famo.databinding.MoreBinding
import com.inis.famo.ui.base.BaseFragment
import com.inis.famo.utils.showSnackMessage
import com.inis.famo.widget.CustomItemMoreView

class MoreFragment : BaseFragment<MoreBinding, MoreViewModel>(R.layout.fragment_more) {

    companion object {
        const val TAG = "MoreFragment"
        fun newInstance() = MoreFragment()
    }

    private val listCustomView = arrayListOf<CustomItemMoreView>()

    private var listData = arrayListOf(
        ItemMoreEntity(R.drawable.ic_upgrade, R.string.row_1),
        ItemMoreEntity(R.drawable.ic_language, R.string.row_2),
        ItemMoreEntity(R.drawable.ic_theme, R.string.row_3),
        ItemMoreEntity(R.drawable.ic_logout, R.string.row_4)
    )

    override fun viewModelClass() = MoreViewModel::class.java

    @SuppressLint("CheckResult")
    override fun MoreBinding.initComponents() {
    }

    @SuppressLint("StringFormatMatches")
    override fun MoreViewModel.observeLiveData() {

    }

    override fun MoreBinding.addEvent() {
//        listCustomView.add(viewUpgrade)
//        listCustomView.add(viewTheme)
//        listCustomView.add(viewLanguage)
//        listCustomView.add(viewLogout)
//
//        listCustomView.forEach {
//            it.setData(listData)
//        }
//
//        viewUpgrade.setOnClickListener {
//            viewUpgrade.showSnackMessage("Nâng cấp")
//        }
//        viewTheme.setOnClickListener {
//            viewTheme.showSnackMessage("Thay đổi giao diện")
//        }
//        viewLanguage.setOnClickListener {
//            viewLanguage.showSnackMessage("Thay đổi ngôn ngữ")
//        }
//        viewLogout.setOnClickListener {
//            viewLogout.showSnackMessage("Log out")
//        }
    }
}