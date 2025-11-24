package vn.edu.hust.bai2

data class EmailModel(
    val sender: String,
    val time: String,
    val subject: String,
    val content: String,
    val avatarColor: Int
)