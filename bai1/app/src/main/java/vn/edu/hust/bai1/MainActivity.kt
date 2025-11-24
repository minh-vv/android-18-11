package vn.edu.hust.bai1
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import vn.edu.hust.bai1data.Student

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etMssv: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnUpdate: Button
    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: StudentAdapter
    private val studentList = mutableListOf<Student>()

    // Biến lưu trữ sinh viên đang được chọn để sửa
    private var selectedStudent: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ view
        etName = findViewById(R.id.etName)
        etMssv = findViewById(R.id.etMssv)
        btnAdd = findViewById(R.id.btnAdd)
        btnUpdate = findViewById(R.id.btnUpdate)
        recyclerView = findViewById(R.id.recyclerView)

        // Khởi tạo dữ liệu mẫu (nếu cần)
        studentList.add(Student("Nguyễn Văn A", "20200001"))
        studentList.add(Student("Trần Thị B", "20200002"))

        // Cấu hình RecyclerView
        adapter = StudentAdapter(studentList,
            onEditClick = { student ->
                // Khi nhấn vào item, hiển thị dữ liệu lên EditText
                etName.setText(student.name)
                etMssv.setText(student.mssv)
                etMssv.isEnabled = false // Thường MSSV là khóa chính, không nên sửa, nhưng tùy logic bài

                selectedStudent = student
                btnUpdate.isEnabled = true
                btnAdd.isEnabled = false
            },
            onDeleteClick = { student ->
                // Khi nhấn nút xóa
                studentList.remove(student)
                adapter.notifyDataSetChanged()

                // Nếu đang sửa chính sinh viên bị xóa thì reset form
                if (selectedStudent == student) {
                    resetForm()
                }
            }
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Xử lý nút Add
        btnAdd.setOnClickListener {
            val name = etName.text.toString()
            val mssv = etMssv.text.toString()

            if (name.isNotEmpty() && mssv.isNotEmpty()) {
                // Kiểm tra trùng MSSV (tùy chọn)
                val exists = studentList.any { it.mssv == mssv }
                if (!exists) {
                    studentList.add(Student(name, mssv))
                    adapter.notifyDataSetChanged()
                    resetForm()
                } else {
                    Toast.makeText(this, "MSSV đã tồn tại", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show()
            }
        }

        // Xử lý nút Update
        btnUpdate.setOnClickListener {
            if (selectedStudent != null) {
                selectedStudent?.name = etName.text.toString()
                // selectedStudent?.mssv = etMssv.text.toString() // Nếu cho phép sửa MSSV

                adapter.notifyDataSetChanged()
                resetForm()
                Toast.makeText(this, "Cập nhật thành công", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun resetForm() {
        etName.text.clear()
        etMssv.text.clear()
        etMssv.isEnabled = true
        selectedStudent = null
        btnAdd.isEnabled = true
        btnUpdate.isEnabled = false
        etMssv.requestFocus()
    }
}