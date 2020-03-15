package aa.bb.cc.simpleapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post_row.view.*

class PostAdapter(val context: Context, val posts: List<Post>) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.post_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val post = posts[position]

        holder.itemView.tvPostTitle.text = post.title
        holder.itemView.tvPostBody.text = post.body
        holder.itemView.btnPostId.text = post.id.toString()


    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}