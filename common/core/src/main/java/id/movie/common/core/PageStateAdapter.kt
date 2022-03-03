package id.movie.common.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PageStateAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    var listPage: List<Fragment> = listOf()

    override fun getItemCount(): Int = listPage.size

    override fun createFragment(position: Int): Fragment = listPage[position]

    fun add(vararg fragment: Fragment) {
        this.listPage = fragment.toList()
    }
}