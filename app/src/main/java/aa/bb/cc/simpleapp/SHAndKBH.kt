package aa.bb.cc.simpleapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_shand_kbh.*
import org.jetbrains.anko.toast

class SHAndKBH : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shand_kbh)

        btnLogin.setOnClickListener {
            val username = etUseranme.text.toString()
            val password = etPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                val editor: SharedPreferences.Editor = getSharedPreferences("mysecret", Context.MODE_PRIVATE).edit()
                editor.putString("username", username)
                editor.putString("password", password)
                editor.apply()
                editor.commit()

                val intent = Intent(this@SHAndKBH, BeautifulUi::class.java)
                startActivity(intent)
            } else {
                toast("Please fill all required fields!")
            }
        }
    }

    private fun wayTwo() {
        btnLogin.setOnClickListener {
            val username = etUseranme.text.toString()
            val password = etPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                toast(String.format("Username is %s and Password is %s", username, password))
                val intent = Intent(this@SHAndKBH, BeautifulUi::class.java)
                val bundle = Bundle()
                bundle.putString("username", username)
                bundle.putString("password", password)
                intent.putExtras(bundle)
                startActivity(intent)
            } else {
                toast("Please fill all required fields!")
            }
        }
    }

    private fun wayOne() {
        btnLogin.setOnClickListener {
            val username = etUseranme.text.toString()
            val password = etPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                toast(String.format("Username is %s and Password is %s", username, password))
                val intent = Intent(this@SHAndKBH, BeautifulUi::class.java)
                intent.putExtra("username", username)
                intent.putExtra("password", password)
                startActivity(intent)
            } else {
                toast("Please fill all required fields!")
            }
        }
    }
}
