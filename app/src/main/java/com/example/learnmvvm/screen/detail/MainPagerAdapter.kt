package com.example.learnmvvm.screen.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.learnmvvm.screen.detail.lastmatch.LastMatchFragment
import com.example.learnmvvm.screen.detail.nextmatch.NextMatchFragment

class MainPagerAdapter(fm : FragmentManager): FragmentPagerAdapter(fm) {

    private val pages = listOf(
        LastMatchFragment(),
        NextMatchFragment()
    )


    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Last Match"
            else -> "Next Match"
        }

    }
}