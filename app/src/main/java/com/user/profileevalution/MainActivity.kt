package com.user.profileevalution

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    private lateinit var btnSearch:AppCompatButton
    private lateinit var btnMostView:AppCompatButton
    private lateinit var btnMostShared:AppCompatButton
    private lateinit var btnMostEmail:AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSearch = findViewById(R.id.btnSearch)
        btnSearch.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, Searching::class.java))
        })
        btnMostView = findViewById(R.id.btnMostView)
        btnMostShared = findViewById(R.id.btnMostShared)
        btnMostEmail = findViewById(R.id.btnMostEmail)

    }
}