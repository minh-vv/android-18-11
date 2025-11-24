package vn.edu.hust.bai2

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tạo dữ liệu giả giống hệt hình ảnh
        val emails = arrayListOf(
            EmailModel("Edurila.com", "12:34 PM", "$19 Only (First 10 spots)", "Are you looking to Learn Web Designing...", Color.parseColor("#4285F4")), // Blue
            EmailModel("Chris Abad", "11:22 AM", "Help make Campaign Monitor better", "Let us know your thoughts! No Images...", Color.parseColor("#DB4437")), // Red
            EmailModel("Tuto.com", "11:04 AM", "8h de formation gratuite", "Photoshop, SEO, Blender, CSS, WordPre...", Color.parseColor("#0F9D58")), // Green
            EmailModel("support", "10:26 AM", "Société Ovh : suivi de vos services", "SAS OVH - http://www.ovh.com 2 rue K...", Color.parseColor("#607D8B")), // Grey
            EmailModel("Matt from Ionic", "10:00 AM", "The New Ionic Creator Is Here!", "Announcing the all-new Creator, build...", Color.parseColor("#F4B400")), // Yellow
            EmailModel("GitHub", "9:45 AM", "Welcome to GitHub", "Check out your new dashboard...", Color.parseColor("#24292E")),
            EmailModel("StackOverflow", "9:00 AM", "New answer to your question", "Someone answered your question about Kotlin...", Color.parseColor("#F48024"))
        )

        val adapter = EmailAdapter(emails)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}