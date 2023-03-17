package com.example.nycschool.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nycschool.databinding.ItemViewBinding
import com.example.nycschool.models.SchoolItem

/**
 * an adapter class is a necessary class for us to bind our data to UI while displaying the
 * items in recyclerview. Here, we bind the data that is coming from api or database and
 * help t display to the view
 */

class MyAdapter(private val schoolList: List<SchoolItem>): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    var onItemClick: ((SchoolItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val school = schoolList[position]
        holder.binding.schoolName.text = school.school_name
        holder.binding.schoolName.setOnClickListener {
            onItemClick?.invoke(school)
        }
    }

    override fun getItemCount(): Int {
        return schoolList.size
    }


    class MyViewHolder( val binding: ItemViewBinding ) : RecyclerView.ViewHolder(binding.root) {}
}