package aa.bb.cc.simpleapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_beautiful_ui.*

class BeautifulUi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beautiful_ui)

        val sh : SharedPreferences = getSharedPreferences("mysecret", Context.MODE_PRIVATE)
        val username = sh.getString("username",resources.getString(R.string.default_name))
        val password = sh.getString("password",resources.getString(R.string.default_password))

        tvLoginUsername.text = username
        tvLoginPassword.text = password


    }

    private fun wayTwo(){
        val bundle = intent.extras
        val username = bundle?.get("username").toString()
        val password = bundle?.get("password").toString()

        if (username.isEmpty() && password.isEmpty()) {
            tvLoginUsername.text = getString(R.string.default_name)
            tvLoginPassword.text = getString(R.string.default_password)
        } else {
            tvLoginUsername.text = username;
            tvLoginPassword.text = password;
        }
    }

    private fun wayOne() {
        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")

        if (username.isNullOrEmpty() && password.isNullOrEmpty()) {
            tvLoginUsername.text = getString(R.string.default_name)
            tvLoginPassword.text = getString(R.string.default_password)
        } else {
            tvLoginUsername.text = username;
            tvLoginPassword.text = password;
        }
    }
}
