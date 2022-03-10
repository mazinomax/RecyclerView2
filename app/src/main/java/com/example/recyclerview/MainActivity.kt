package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.data.Person_list_adapter
import com.example.recyclerview.model.Person
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
            private  var adapter: Person_list_adapter? = null
            private var personList: ArrayList<Person>? = null
            private  var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personList = ArrayList<Person>()
        layoutManager  = LinearLayoutManager(this)
        adapter = Person_list_adapter(personList!!,this)

        // setup the list of recyclerview. so we pick the id of the recycler view

        recyclerID.layoutManager = layoutManager
        recyclerID.adapter = adapter

        // load data

        for (i in 1..9){

            val person = Person()
            person.name = "Mazino" + i
            person.age = 24 + i

            personList!!.add(person)


        }
        adapter!!.notifyDataSetChanged()







    }

}