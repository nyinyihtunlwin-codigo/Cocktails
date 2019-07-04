package com.nyinyihtunlwin.cocktails.feature.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.nyinyihtunlwin.cocktails.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        fun newInstnace(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val sectionPagerAdapter = SectionPagerAdapter(supportFragmentManager)
        vp_meal.adapter = sectionPagerAdapter

        vp_meal.addOnPageChangeListener(object : TabLayout.TabLayoutOnPageChangeListener(tabs) {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setSectionTitle(position)
            }
        })
        tabs.addOnTabSelectedListener(object : TabLayout.ViewPagerOnTabSelectedListener(vp_meal) {
            override fun onTabSelected(tab: TabLayout.Tab) {
                vp_meal.currentItem = tab.position
                setSectionTitle(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
        })
    }

    private fun setSectionTitle(position: Int) {
        var sectionTitle = ""
        when (position) {
            0 -> sectionTitle = resources.getString(R.string.alcoholic)
            1 -> sectionTitle = resources.getString(R.string.non_alcoholic)
        }
        tv_section_name.text = sectionTitle
    }

}
