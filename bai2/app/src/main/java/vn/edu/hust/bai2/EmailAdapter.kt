package vn.edu.hust.bai2

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<EmailModel>) :
    RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvAvatar: TextView = itemView.findViewById(R.id.tvAvatar)
        val tvSender: TextView = itemView.findViewById(R.id.tvSender)
        val tvTime: TextView = itemView.findViewById(R.id.tvTime)
        val tvSubject: TextView = itemView.findViewById(R.id.tvSubject)
        val tvContent: TextView = itemView.findViewById(R.id.tvContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_email, parent, false)
        return EmailViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emails[position]

        holder.tvSender.text = email.sender
        holder.tvTime.text = email.time
        holder.tvSubject.text = email.subject
        holder.tvContent.text = email.content

        // Lấy ký tự đầu tiên của tên người gửi làm Avatar
        holder.tvAvatar.text = email.sender.first().toString().uppercase()

        // Đổi màu nền cho Avatar hình tròn
        val background = holder.tvAvatar.background as GradientDrawable
        background.setColor(email.avatarColor)
    }

    override fun getItemCount(): Int = emails.size
}