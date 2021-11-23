package com.inis.famo.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.inis.famo.data.model.HomeTab
import com.inis.famo.ui.base.BaseFragment

class HomePagerAdapter(
    private val fragmentManager: FragmentManager,
    private var listFragment: ArrayList<BaseFragment<*, *>>,
    private var listTitleTab: ArrayList<HomeTab>,
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = listFragment.size

    override fun getItem(position: Int): Fragment {
        return listFragment[position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return listTitleTab[position].groupName
    }

    override fun getItemId(position: Int) = listFragment[position].hashCode().toLong()
}
