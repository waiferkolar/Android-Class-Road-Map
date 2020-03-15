package aa.bb.cc.simpleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_async_task_http_app.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class AsyncTaskHttpApp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task_http_app)



        doAsync {
            val jsonAry = URL("https://jsonplaceholder.typicode.com/posts").readText()
            uiThread {
                val posts = Gson().fromJson(jsonAry, Array<Post>::class.java).toList()

                postRecycler.apply {
                    layoutManager = LinearLayoutManager(this@AsyncTaskHttpApp)
                    val adapter = PostAdapter(this@AsyncTaskHttpApp, posts)
                    postRecycler.adapter = adapter
                }
            }
        }
    }
}
