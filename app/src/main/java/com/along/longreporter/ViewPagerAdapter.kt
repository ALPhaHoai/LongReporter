package com.along.longreporter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


/**
 * Created by Long
 * Date: 8/3/2019
 * Time: 9:31 AM
 */
class ViewPagerAdapter(val fm: FragmentManager, val tabs: List<FragmentModel>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return tabs[position].fragment
    }

    override fun getCount(): Int {
        return tabs.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabs[position].title
    }
}