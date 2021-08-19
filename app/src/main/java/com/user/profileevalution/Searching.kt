package com.user.profileevalution

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat

class Searching : AppCompatActivity() {
    private lateinit var bckBtn:AppCompatImageView
    private lateinit var editText: AppCompatEditText
    private lateinit var searchBtn:AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searching)

        bckBtn = findViewById(R.id.bckBtn)
        bckBtn.setOnClickListener(View.OnClickListener {
            finish()
        })

        searchBtn = findViewById(R.id.btnSearch)

        editText = findViewById(R.id.searchtxt)
        editText.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().trim().isNotEmpty()) {
                    searchBtn.isEnabled = true
                    searchBtn.setBackgroundColor(ContextCompat.getColor(this@Searching, android.R.color.holo_blue_light))
                } else {  //disable button
                    searchBtn.isEnabled = false
                    searchBtn.setBackgroundColor(ContextCompat.getColor(this@Searching, android.R.color.darker_gray))
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }

        })

        searchBtn.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, ViewArticle::class.java).apply {
                putExtra("text", editText.toString())
            })
        })
    }
}