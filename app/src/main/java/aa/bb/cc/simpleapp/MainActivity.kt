package aa.bb.cc.simpleapp

import android.app.ListActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : ListActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
