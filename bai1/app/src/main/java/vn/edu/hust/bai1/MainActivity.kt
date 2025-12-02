package vn.edu.hust.bai1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import vn.edu.hust.bai1data.Student

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudentAdapter
    private val studentList = mutableListOf<Student>()

    companion object {
        private const val REQUEST_ADD_STUDENT = 1
        private const val REQUEST_UPDATE_STUDENT = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Đặt tiêu đề cho ActionBar
        supportActionBar?.title = "Danh sách sinh viên"

        // Ánh xạ view
        recyclerView = findViewById(R.id.recyclerView)

        // Khởi tạo dữ liệu mẫu
        studentList.add(Student("20200001", "Nguyễn Văn A", "0123456789", "Hà Nội"))
        studentList.add(Student("20200002", "Trần Thị B", "0987654321", "Hồ Chí Minh"))
        studentList.add(Student("20200003", "Lê Văn C", "0912345678", "Đà Nẵng"))

        // Cấu hình RecyclerView
        adapter = StudentAdapter(studentList) { student, position ->
            // Khi nhấn vào sinh viên, mở activity chi tiết
            val intent = Intent(this, StudentDetailActivity::class.java)
            intent.putExtra("student", student)
            intent.putExtra("position", position)
            startActivityForResult(intent, REQUEST_UPDATE_STUDENT)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_add_student -> {
                // Mở activity thêm sinh viên
                val intent = Intent(this, AddStudentActivity::class.java)
                startActivityForResult(intent, REQUEST_ADD_STUDENT)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && data != null) {
            when (requestCode) {
                REQUEST_ADD_STUDENT -> {
                    // Thêm sinh viên mới
                    val newStudent = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                        data.getParcelableExtra("new_student", Student::class.java)
                    } else {
                        @Suppress("DEPRECATION")
                        data.getParcelableExtra("new_student")
                    }
                    newStudent?.let {
                        studentList.add(it)
                        adapter.notifyItemInserted(studentList.size - 1)
                    }
                }
                REQUEST_UPDATE_STUDENT -> {
                    // Cập nhật sinh viên
                    val updatedStudent = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                        data.getParcelableExtra("updated_student", Student::class.java)
                    } else {
                        @Suppress("DEPRECATION")
                        data.getParcelableExtra("updated_student")
                    }
                    val position = data.getIntExtra("position", -1)

                    if (updatedStudent != null && position != -1) {
                        studentList[position] = updatedStudent
                        adapter.notifyItemChanged(position)
                    }
                }
            }
        }
    }
}