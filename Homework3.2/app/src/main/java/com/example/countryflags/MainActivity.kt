package com.example.countryflags

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var buttonHW1: Button
    private lateinit var buttonHW2: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonHW1 = findViewById(R.id.btn_homework1)
        buttonHW2 = findViewById(R.id.btn_homework2)

        buttonHW1.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    CountryFlagsActivity::class.java
                )
            )
        }

        buttonHW2.setOnClickListener {
            val intent = Intent(this, PictureActivity::class.java)
            startActivity(intent)
        }
    }
}