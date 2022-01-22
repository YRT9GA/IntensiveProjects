package com.example.helloconstraint

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import helloconstraint.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mShowCount = findViewById<TextView>(R.id.show_count)
        val zeroBtn = findViewById<Button>(R.id.button_to_zero)
        val countBtn = findViewById<Button>(R.id.button_count)

        button_toast.setOnClickListener {
            val toast = Toast.makeText(
                this, R.string.toast_message,
                Toast.LENGTH_SHORT
            )
            toast.show()
        }

        button_count.setOnClickListener {
            countBtn.setBackgroundColor(Color.GREEN)
            mCount++
            mShowCount?.setText(mCount.toString())
            zeroBtn.setBackgroundColor(Color.RED)
        }

        button_to_zero.setOnClickListener {
            countBtn.setBackgroundColor(Color.BLUE)
            zeroBtn.setBackgroundColor(Color.GRAY)
            mCount = 0
            mShowCount.setText(mCount.toString())
        }
    }


}

