package com.example.helloconstraint

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import helloconstraint.R

class MainActivity : AppCompatActivity() {

    var mCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        }



    fun countUp(view: android.view.View) {
        val mShowCount = findViewById<TextView>(R.id.show_count)
        val zeroBtn = findViewById<Button>(R.id.zeroButton)
        val countBtn = findViewById<Button>(R.id.button_count)
        countBtn.setBackgroundColor(Color.GREEN)
        mCount++
        mShowCount?.setText(mCount.toString())
        zeroBtn.setBackgroundColor(Color.RED)

    }

    fun showToast(view: android.view.View) {val toast  = Toast.makeText(this, R.string.toast_message,
        Toast.LENGTH_SHORT)
        toast.show()
    }

    fun countZero(view: android.view.View) {
        val mShowCount = findViewById<TextView>(R.id.show_count)
        val zeroBtn = findViewById<Button>(R.id.zeroButton)
        val countBtn = findViewById<Button>(R.id.button_count)
        countBtn.setBackgroundColor(Color.BLUE)
        zeroBtn.setBackgroundColor(Color.GRAY)
        mCount = 0
        mShowCount.setText(mCount.toString())

    }

}

