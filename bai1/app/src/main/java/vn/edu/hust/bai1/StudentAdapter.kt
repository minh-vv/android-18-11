package vn.edu.hust.bai1
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vn.edu.hust.bai1data.Student

class StudentAdapter(
    private val students: MutableList<Student>,
    private val onEditClick: (Student) -> Unit,
    private val onDeleteClick: (Student) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvMssv: TextView = itemView.findViewById(R.id.tvMssv)
        val btnDelete: ImageView = itemView.findViewById(R.id.btnDelete)

        fun bind(student: Student) {
            tvName.text = student.name
            tvMssv.text = student.mssv

            // Xử lý khi nhấn vào nút xóa
            btnDelete.setOnClickListener {
                onDeleteClick(student)
            }

            // Xử lý khi nhấn vào dòng (để sửa)
            itemView.setOnClickListener {
                onEditClick(student)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(students[position])
    }

    override fun getItemCount(): Int = students.size
}