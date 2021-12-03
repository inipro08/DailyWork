package com.inis.famo.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.inis.famo.data.model.HomeTab
import com.inis.famo.ui.base.BaseFragment

class MainPagerAdapter(
    private val fragmentManager: FragmentManager,
    private var listFragment: ArrayList<BaseFragment<*, *>>,
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = listFragment.size

    override fun getItem(position: Int): Fragment {
        return listFragment[position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return listFragment[position].javaClass.simpleName
    }

    override fun getItemId(position: Int) = listFragment[position].hashCode().toLong()
}
