package com.example.githubuser.ui.adapter

import android.content.Context
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.githubuser.R
import com.example.githubuser.ui.main.FollowersFragment
import com.example.githubuser.ui.main.FollowingFragment

class SectionPagerAdapter(activity: AppCompatActivity, data: Bundle): FragmentStateAdapter(activity) {

    private var fragmentBundle: Bundle

    init {
        fragmentBundle = data
    }

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FollowersFragment()
            1 -> fragment = FollowingFragment()
        }
        fragment?.arguments = this.fragmentBundle
        return fragment as Fragment
    }
}