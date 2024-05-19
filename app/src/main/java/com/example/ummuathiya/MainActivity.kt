package com.example.ummuathiya

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var bottomBarView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        bottomBarView = findViewById(R.id.bottom_nav_view)
        setupBottomNavMenu(navController)

        val save = getSharedPreferences("Profile", MODE_PRIVATE)
        if (save.getString("email", null) == null){
            val pindah = Intent(applicationContext, LoginActivity::class.java)
            startActivity(pindah)
            finish()
        }

        val toolBar = findViewById<MaterialToolbar>(R.id.homeToolbar);
        setSupportActionBar(toolBar);
        supportActionBar?.setDisplayShowTitleEnabled(false);
    }

    private fun setupBottomNavMenu(navController: NavController) {
        bottomBarView.apply { setupWithNavController(navController) }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        return when (itemId) {
            R.id.menuTambahData -> {
                val pindah = Intent(applicationContext, TambahDataActivity::class.java)
                startActivity(pindah)
                true
            }
            R.id.menuDataAlumni -> {
                val pindah = Intent(applicationContext, DataAlumniActivity::class.java)
                startActivity(pindah)
                true
            }
            R.id.menuLogout -> {
                val sharedPref = getSharedPreferences("Profile", Context.MODE_PRIVATE)
                val editor = sharedPref?.edit()
                editor?.clear()
                editor?.apply()
                val pindah = Intent(applicationContext, LoginActivity::class.java)
                startActivity(pindah)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

}