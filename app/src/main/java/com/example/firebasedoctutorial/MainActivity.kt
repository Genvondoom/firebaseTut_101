package com.example.firebasedoctutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var submit: Button
    lateinit var listView:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        submit = findViewById(R.id.submit)
        listView = findViewById(R.id.entries)
        val adapter: ArrayAdapter<*>
        val users = mutableListOf<String>()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,users)
        listView.adapter = adapter
        val database = FirebaseDatabase.getInstance().reference
        val test2 = mapOf("tester" to User("vd", "email"))
        //database.child("test/hello").setValue(test2)

        database.child("test").get().addOnSuccessListener{

            val test = it.value
            println()
            //users.add(test)
            //adapter.notifyDataSetChanged()
        }



    }
}