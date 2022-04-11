package com.moise.mobilite.ui

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.moise.mobilite.R
import com.moise.mobilite.databinding.ActivityHomeMapsBinding

class HomeMapsActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityHomeMapsBinding
    private var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerLayout = binding.drawer
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        actionBarDrawerToggle.isDrawerIndicatorEnabled = true
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val navigationView: NavigationView = binding.navigationView
        // Add the default fragment
        fragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.flContainer, fragment as HomeFragment)
            .commit()
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_24)
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_payments -> {
                    fragment = PaymentFragment()
                }
                R.id.nav_history -> {
                    fragment = HistoryFragment()
                }
                R.id.nav_loyalty_points -> {
                    fragment = PointsFragment()
                }
                R.id.nav_promotions -> {
                    fragment = PromotionFragment()
                }
                R.id.nav_support -> {
                    fragment = SupportFragment()
                }
                R.id.nav_about -> {
                    fragment = null
                    Toast.makeText(this, "We are Plug Motilite", Toast.LENGTH_SHORT).show()
                }
            }
            if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flContainer, fragment!!)
                .addToBackStack(null)
                .commit()
            drawerLayout.closeDrawers()
            item.isChecked = true
            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
            title = ""
            }
            true
        }
        setHeaderOnClickListener(navigationView)
    }

    private fun setHeaderOnClickListener(navigationView: NavigationView) {
        val headerViewItem = navigationView.inflateHeaderView(R.layout.profile_header)
        val profilePicture = headerViewItem.findViewById<ImageView>(R.id.ivProfilePicture)
        profilePicture.setOnClickListener{
            val profileFragment = ProfileFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flContainer, profileFragment)
                .addToBackStack("")
                .commit()
            drawerLayout.closeDrawers()
            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)

        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        actionBarDrawerToggle.syncState()

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        actionBarDrawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home && supportFragmentManager.backStackEntryCount == 0) {
            drawerLayout.openDrawer(Gravity.LEFT)
        } else if (item.itemId == android.R.id.home)
            onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
            if (supportFragmentManager.backStackEntryCount == 0) {
                supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_24)
            }
        } else {
            super.onBackPressed()
        }
    }

    companion object {
        const val TAG = "HomeActivityMaps"
    }
}