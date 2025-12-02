package vn.edu.hust.bai1

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import vn.edu.hust.bai1data.Student

class StudentDetailActivity : AppCompatActivity() {

    private lateinit var etMssv: TextInputEditText
    private lateinit var etName: TextInputEditText
    private lateinit var etPhone: TextInputEditText
    private lateinit var etAddress: TextInputEditText
    private lateinit var btnUpdate: Button
    private lateinit var btnCancel: Button

    private var student: Student? = null
    private var position: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_detail)

        // Thiết lập action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Chi tiết sinh viên"

        // Ánh xạ view
        etMssv = findViewById(R.id.etMssv)
        etName = findViewById(R.id.etName)
        etPhone = findViewById(R.id.etPhone)
        etAddress = findViewById(R.id.etAddress)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnCancel = findViewById(R.id.btnCancel)

        // Nhận dữ liệu từ intent
        student = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("student", Student::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("student")
        }
        position = intent.getIntExtra("position", -1)

        // Hiển thị thông tin sinh viên
        student?.let {
            etMssv.setText(it.mssv)
            etName.setText(it.name)
            etPhone.setText(it.phone)
            etAddress.setText(it.address)
        }

        // Xử lý nút Cập nhật
        btnUpdate.setOnClickListener {
            val name = etName.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val address = etAddress.text.toString().trim()

            if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Cập nhật thông tin sinh viên
            student?.let {
                it.name = name
                it.phone = phone
                it.address = address

                // Trả về MainActivity
                intent.putExtra("updated_student", it)
                intent.putExtra("position", position)
                setResult(RESULT_OK, intent)
                finish()
            }
        }

        // Xử lý nút Hủy
        btnCancel.setOnClickListener {
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}

