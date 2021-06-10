package com.rajatawar.myapplication

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.rajatawar.myapplication.databinding.ActivityMain2Binding
import com.rajatawar.myapplication.ui.main.add.AddFragment
import com.rajatawar.myapplication.ui.main.cart.CartFragment
import com.rajatawar.myapplication.ui.main.home.HomeFragment
import com.rajatawar.myapplication.ui.main.profile.ProfileFragment
import com.rajatawar.myapplication.ui.main.search.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        addFragment(HomeFragment())

        val navView: BottomNavigationView = binding.navView
        navView.setOnNavigationItemSelectedListener(bottomNavi)

    }
    private val bottomNavi = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        when(menuItem.itemId){
            R.id.navigation_home->{
                addFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_search->{
                addFragment(SearchFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_add->{
                addFragment(AddFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_cart->{
                addFragment(CartFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile->{
                addFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    private fun addFragment(frg: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_main, frg)
            .commit()
    }
}