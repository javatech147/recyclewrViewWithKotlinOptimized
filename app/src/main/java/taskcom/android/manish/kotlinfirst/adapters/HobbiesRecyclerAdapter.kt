package taskcom.android.manish.kotlinfirst.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.list_item.view.*
import taskcom.android.manish.kotlinfirst.models.Hobby
import taskcom.android.manish.kotlinfirst.R
import taskcom.android.manish.kotlinfirst.showToast

/**
 * Created by Manish Kumar on 11/4/2018
 */

class HobbiesRecyclerAdapter(val context: Context, private val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesRecyclerAdapter.HobbiesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position1: Int): HobbiesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return HobbiesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: HobbiesViewHolder, position: Int) {
        var hobby = hobbies.get(position)
        holder.setData(hobby, position)
    }


    inner class HobbiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var currentHobby: Hobby? = null
        var currentPosition: Int? = 0

        init {
            itemView.setOnClickListener {
                // safe call with let{..}
                // let{...} block will only execute if currentHobby object is not null
                currentHobby?.let {
                    context.showToast("${currentHobby!!.title} is clicked!")
                }
            }

            itemView.imgShare.setOnClickListener {
                // safe call with let{..}
                // let{...} block will only execute if currentHobby object is not null
                currentHobby?.let {
                    val message: String = "My Hobby is : ${currentHobby!!.title}"    // Don't use directly within init{} block
                    val shareIntent = Intent()
                    shareIntent.action = Intent.ACTION_SEND
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, message)
                    context.startActivity(Intent.createChooser(shareIntent, "Please select app "))
                }
            }
        }

        fun setData(hobby: Hobby?, position: Int) {
            // safe call with let{..}
            // let{...} block will only execute if hobby object is not null
            hobby?.let {
                itemView.txvTitle.text = hobby.title
            }
            this.currentHobby = hobby
            this.currentPosition = position
        }
    }
}