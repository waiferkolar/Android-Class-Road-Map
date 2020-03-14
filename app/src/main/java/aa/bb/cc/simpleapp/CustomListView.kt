package aa.bb.cc.simpleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_custom_list_view.*

class CustomListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_view)

        val strAry = resources.getStringArray(R.array.my_apps)

        val adapter = ArrayAdapter<String>(this@CustomListView,android.R.layout.simple_list_item_1,strAry)
        appList.adapter = adapter

        appList.setOnItemClickListener { adapterView, view, i, l ->
            var str = adapterView.getItemAtPosition(i).toString()
            str = str.replace(" ","")
            val cls = Class.forName("aa.bb.cc.simpleapp.$str")
            val intent = Intent(this@CustomListView,cls)
            startActivity(intent)
        }
    }
}
