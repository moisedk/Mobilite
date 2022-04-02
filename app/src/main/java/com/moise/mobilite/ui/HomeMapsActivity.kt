package com.moise.mobilite.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.moise.mobilite.R
import com.moise.mobilite.databinding.ActivityHomeMapsBinding

class HomeMapsActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityHomeMapsBinding
    private lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        drawerLayout = binding.drawer
        setSupportActionBar(binding.appBarMain.toolbar)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val navigationView: NavigationView = binding.navigationView
        val fragmentManager = supportFragmentManager
        fragment = PlugToFragment()
        fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit()
        navigationView.setNavigationItemSelectedListener {
            item ->
            when (item.itemId){
                R.id.nav_plug_to -> {
                    fragment = PlugToFragment()
                }
                R.id.nav_payments -> {
                    fragment = PaymentFragment()
                }
                R.id.nav_history -> {
                    fragment = HistoryFragment()
                }
                R.id.nav_free_journeys -> {
                    Toast.makeText(this, "Free Journeys!", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_loyalty_points -> {
                    fragment = PointsFragment()
                }
                R.id.nav_promotions -> {
                    fragment = PromotionFragment()
                }
                R.id.nav_work_rides -> {
                    Toast.makeText(this, "On it!", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_support -> {
                    Toast.makeText(this, "Support on its way!", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_about -> {
                    Toast.makeText(this, "We are Plug Motilite", Toast.LENGTH_SHORT).show()
                }
            }
            fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit()
            true
        }


    }

}