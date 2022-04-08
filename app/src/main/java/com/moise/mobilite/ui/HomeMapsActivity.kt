package com.moise.mobilite.ui

import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Gravity
import android.view.MenuItem
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
        setSupportActionBar(binding.appBarMain.toolbar)
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
            .replace(R.id.flContainer, fragment)
            .commit()
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_24)
        navigationView.setNavigationItemSelectedListener {
            item ->
            when (item.itemId){
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
                R.id.nav_support -> {
                    Toast.makeText(this, "Support on its way!", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_about -> {
                    Toast.makeText(this, "We are Plug Motilite", Toast.LENGTH_SHORT).show()
                }
            }
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flContainer, fragment)
                .addToBackStack(null)
                .commit()
            drawerLayout.closeDrawers()
            item.isChecked = true
            title = item.title
            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
            true
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
        }
        else
            onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
            if (supportFragmentManager.backStackEntryCount == 0) {
                supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_24)
                title = application.getString(R.string.app_name)
            }
        }
        else {
            super.onBackPressed()
        }
    }
    companion object {
        const val TAG = "HomeActivityMaps"
    }
}