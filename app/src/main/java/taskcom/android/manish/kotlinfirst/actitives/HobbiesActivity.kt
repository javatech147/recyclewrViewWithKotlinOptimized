package taskcom.android.manish.kotlinfirst.actitives

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_hobbies.*
import taskcom.android.manish.kotlinfirst.AppConstants
import taskcom.android.manish.kotlinfirst.models.DataSupplier
import taskcom.android.manish.kotlinfirst.adapters.HobbiesRecyclerAdapter
import taskcom.android.manish.kotlinfirst.R

class HobbiesActivity : AppCompatActivity() {

    // Companion object
    companion object {
        val TAG: String = HobbiesActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)
        val bundle: Bundle? = intent.extras
        bundle?.let {
            val message = bundle.getString(AppConstants.USER_MESSAGE_KEY)
            Log.d(TAG, "Welcome $message")
        }

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        val adapter = HobbiesRecyclerAdapter(this, DataSupplier.hobbies)
        recyclerView.adapter = adapter
    }
}