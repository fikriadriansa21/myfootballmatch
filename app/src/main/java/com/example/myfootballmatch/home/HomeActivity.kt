package com.example.myfootballmatch.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import butterknife.BindView
import com.example.myfootballmatch.R
import com.example.myfootballmatch.profile.ProfileFragment
import com.example.myfootballmatch.search.SearchFragment
import com.example.myfootballmatch.team.TeamFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    @BindView(R.id.navbar_bottom_menu)
    lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        loadFragment(HomeFragment())
        bottomNavigation.setOnNavigationItemSelectedListener {menuItem ->
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
