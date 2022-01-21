package com.example.hellotoastwithsecondactivity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val extraTextView = findViewById<TextView>(R.id.extra_count)
        extraTextView.text = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)


    }
}