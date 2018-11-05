package taskcom.android.manish.kotlinfirst.actitives

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import taskcom.android.manish.kotlinfirst.AppConstants
import taskcom.android.manish.kotlinfirst.R
import taskcom.android.manish.kotlinfirst.showToast

class MainActivity : AppCompatActivity() {

    // Companion object
    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnHobbies.setOnClickListener {
            Log.d(TAG, "my hobbies")
            showToast("My hobbies", Toast.LENGTH_LONG)
            val hobbiesIntent = Intent(this, HobbiesActivity::class.java)
            hobbiesIntent.putExtra(AppConstants.USER_MESSAGE_KEY, "Manish Kumar")
            startActivity(hobbiesIntent)
        }
    }
}

