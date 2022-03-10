package com.example.recyclerview.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.model.Person

class Person_list_adapter  ( private val list: ArrayList<Person>,
                             private val context: Context): RecyclerView.Adapter<Person_list_adapter.Viewholder>(){


   inner class Viewholder (itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItem (person: Person){
            var name: TextView = itemView.findViewById(R.id.nametext)  as TextView
            var Age: TextView = itemView.findViewById(R.id.age)  as TextView
            var image: ImageView = itemView.findViewById(R.id.picview) as ImageView

            name.text = person.name
            Age.text = person.age.toString()

            itemView.setOnClickListener {
                Toast.makeText( context, name.text, Toast.LENGTH_LONG ).show()
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): Viewholder {
        // we create our view from xml file list row
        val view = LayoutInflater.from(context).inflate(R.layout.list_rows,parent,false)
        return Viewholder(view)

    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bindItem(list[position])

    }

    override fun getItemCount(): Int {
        return list.size
    }
}