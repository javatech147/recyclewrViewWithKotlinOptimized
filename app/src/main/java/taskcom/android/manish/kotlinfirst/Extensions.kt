package taskcom.android.manish.kotlinfirst

import android.content.Context
import android.widget.Toast

/**
 * Created by Manish Kumar on 11/5/2018
 */

//Extension function : You can call this method directly from any activity or adater
// because we have added this function to Context class.

// Default parameters
// Here second parameter is default parameter. i.e it is optional to pass this value.
// If you want to show toast for longer duration the pass Toast.LENGTH_LONG while calling this method.
fun Context.showToast(message:String, duration:Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, message, duration).show()
}