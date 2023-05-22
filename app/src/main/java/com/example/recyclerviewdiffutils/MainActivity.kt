package com.example.recyclerviewdiffutils

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rcvListUser = findViewById<RecyclerView>(R.id.rcvListUser)
        val btnAddItem = findViewById<Button>(R.id.btnAddItem)
        val btnRemoveItem = findViewById<Button>(R.id.btnRemoveItem)
        val users = mutableListOf<Users>(
            Users(1, "User1", "Address 1", 0),
            Users(2, "User2", "Address 2", 1),
            Users(3, "User3", "Address 3", 2),
            Users(4, "User4", "Address 4", 3),
            Users(5, "User5", "Address 5", 4)
        )
        val userAdapter = UserAdapter(users)
        rcvListUser.adapter = userAdapter
        //much be new instance
        val newListUser = mutableListOf<Users>()
        newListUser.addAll(users)
        btnAddItem.setOnClickListener {
            val lastId = newListUser.last().id + 1
            newListUser.add(Users(lastId, "User$lastId", "Address $lastId", lastId))
            userAdapter.setUserList(newListUser)
        }
        btnRemoveItem.setOnClickListener {
            newListUser.removeAt(2)
            userAdapter.setUserList(newListUser)
        }
    }

}