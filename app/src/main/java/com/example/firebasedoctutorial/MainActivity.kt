package com.example.firebasedoctutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var userName: EditText
    lateinit var email: EditText
    lateinit var submit: Button
    lateinit var listView: ListView
    lateinit var adapter: ArrayAdapter<*>
    val database = FirebaseDatabase.getInstance().reference
    val users = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        userName = findViewById(R.id.username)
        email = findViewById(R.id.email)
        submit = findViewById(R.id.submit)
        listView = findViewById(R.id.entries)


        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
        listView.adapter = adapter


        submit.setOnClickListener {
            val uName = name.text.toString()
            val uMail = email.text.toString()
            val Uname = name.text.toString()
            val text = User(uName, uMail)
            database.child("test/").child(Uname).setValue(text)
            update()
            reset()
        }


    }

    private fun reset() {
        name.setText("")
        userName.setText("")
        email.setText("")
    }

    private fun update() {
        database.child("test").get().addOnSuccessListener { data ->

            if (data.exists()) {
                for (x in data.children) {


                    val user = x.getValue(User::class.java)

                    users.add(user!!.username)
                }

            }
            adapter.notifyDataSetChanged()
        }
    }
}