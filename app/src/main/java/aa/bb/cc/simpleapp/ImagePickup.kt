package aa.bb.cc.simpleapp

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_image_pickup.*

class ImagePickup : AppCompatActivity() {
    val MY_REQUEST_CODE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_pickup)

        btnPick.setOnClickListener {
            ActivityCompat.requestPermissions(
                this@ImagePickup,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                MY_REQUEST_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            MY_REQUEST_CODE->{
               if(permissions.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                   val intent = Intent(Intent.ACTION_PICK)
                   intent.type = "image/*"
                   startActivityForResult(Intent.createChooser(intent,"Choose Image"),MY_REQUEST_CODE)
               }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == MY_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null){
            val uri = data.data!!
            val inputStream = contentResolver.openInputStream(uri)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            imgV.setImageBitmap(bitmap)

        }
    }
}
