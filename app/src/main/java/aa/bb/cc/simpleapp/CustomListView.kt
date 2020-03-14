package aa.bb.cc.simpleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_custom_list_view.*

class CustomListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_view)

        val strAry = resources.getStringArray(R.array.my_apps)

        val adapter = ArrayAdapter<String>(this@CustomListView,android.R.layout.simple_list_item_1,strAry)
        appList.adapter = adapter
    }
}
