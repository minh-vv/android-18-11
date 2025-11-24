package vn.edu.hust.bai3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import vn.edu.hust.bai3.adapter.RecommendedAppAdapter
import vn.edu.hust.bai3.adapter.SponsoredAppAdapter
import vn.edu.hust.bai3.data.AppDataProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSponsoredApps()
        setupRecommendedApps()
        setupBottomNavigation()
    }

    private fun setupSponsoredApps() {
        val sponsoredData = AppDataProvider.getSponsoredApps()

        val rvGrid = findViewById<RecyclerView>(R.id.rvGrid3)
        rvGrid.layoutManager = LinearLayoutManager(this)
        rvGrid.adapter = SponsoredAppAdapter(sponsoredData)
    }

    private fun setupRecommendedApps() {
        val recommendedData = AppDataProvider.getRecommendedApps()

        val rvHorizontal = findViewById<RecyclerView>(R.id.rvHorizontal)
        rvHorizontal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvHorizontal.adapter = RecommendedAppAdapter(recommendedData)
    }

    private fun setupBottomNavigation() {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.selectedItemId = R.id.nav_apps
    }
}