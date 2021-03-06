package com.krayz.myfootballmatch.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.krayz.myfootballmatch.R
import com.krayz.myfootballmatch.ui.profile.ProfileFragment
import com.krayz.myfootballmatch.ui.search.SearchFragment
import com.krayz.myfootballmatch.ui.team.TeamFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        loadFragment(HomeFragment())
        nav_menu_bottom.setOnNavigationItemSelectedListener {menuItem ->
            when (menuItem.itemId) {
                R.id.home_menu -> {
                    loadFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.team_menu -> {
                    loadFragment(TeamFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.search_menu -> {
                    loadFragment(SearchFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.profile_menu -> {
                    loadFragment(ProfileFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().also {fragmentTransaction ->
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.commit()
        }
    }
}
