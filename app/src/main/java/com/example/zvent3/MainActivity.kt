package com.example.zvent3

import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.get
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.example.zvent3.data.Guest
import com.example.zvent3.data.GuestUser
import com.example.zvent3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , GuestUser {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration : AppBarConfiguration
    val seekBar = findViewById<SeekBar>(R.id.seekBar)

    override lateinit var guests: MutableList<Guest>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        drawerLayout = binding.drawerLayout

        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController( this, navController, drawerLayout)
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        //aparezca hambuerguesa o no en todas las pantallas
        navController.addOnDestinationChangedListener {nc: NavController, nd: NavDestination, bundle: Bundle? ->
            if(nd.id == nc.graph.startDestination || nd.id == nc.graph.get(R.id.guestFragment).id)
            {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            }
            else
            {
                drawerLayout.setDrawerLockMode((DrawerLayout.LOCK_MODE_LOCKED_CLOSED))
            }
        }
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)

        initialize()
    }

    fun onStopTrackingTouch(seekBar: SeekBar) {
        Toast.makeText(this@MainActivity, "El valor es " + seekBar.progress, Toast.LENGTH_SHORT).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
        return navController.navigateUp(drawerLayout) ||super.onSupportNavigateUp()
    }
}
