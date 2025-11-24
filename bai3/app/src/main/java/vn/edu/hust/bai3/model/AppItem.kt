package vn.edu.hust.bai3.model

data class AppItem(
    val name: String,
    val imageRes: Int,
    val genre: String = "",
    val rating: String = "",
    val size: String = ""
)

