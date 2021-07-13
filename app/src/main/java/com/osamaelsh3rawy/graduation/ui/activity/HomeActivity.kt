package com.osamaelsh3rawy.graduation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.osamaelsh3rawy.graduation.R
import com.osamaelsh3rawy.graduation.databinding.ActivityHomeBinding
import com.osamaelsh3rawy.graduation.ui.fragment.home.FragmentHome
import com.osamaelsh3rawy.graduation.ui.fragment.home.HomeViewModel

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

companion object{    lateinit var homeViewModel: HomeViewModel}
    val TAG = "HomeActivity"
    // private lateinit var listener: NavController.OnDestinationChangedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)


        val navController= Navigation.findNavController(this, R.id.fragment)


        appBarConfiguration =AppBarConfiguration(setOf(R.id.fragment_home, R.id.fragmentFav, R.id.fragmentCart),binding.drawerLayout)
        appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)

        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.ahomeBnv.setupWithNavController(navController)
        binding.navView.setupWithNavController(navController)


        ///cart
        homeViewModel.getCart().observe(this, Observer { cartItem ->
            Log.d(TAG, "num onChanged: " + cartItem.size)
        })



        if (navController.currentDestination?.id == R.id.fragment_login
            || navController.currentDestination?.id == R.id.fragmentSignUp
            || navController.currentDestination?.id == R.id.fragmentResetPassword
            || navController.currentDestination?.id == R.id.fragmentForgetPassword)
            { supportActionBar?.hide()
            binding.ahomeBnv.isVisible = false
            } else {
            actionBar?.show()
            supportActionBar?.show()
            binding.ahomeBnv.isVisible = true }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController2 = Navigation.findNavController(this, R.id.fragment)
        return navController2.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun loginCycleVisibility(i: Int) {
        binding.ahomeBnv.visibility = i
        binding.navView.visibility = i
        binding.drawerLayout.visibility = i
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }


}