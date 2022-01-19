package com.example.hellotoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var mCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        }



    fun countUp(view: android.view.View) {mCount++
        val mShowCount = findViewById<TextView>(R.id.show_count)
        if (mShowCount != null)
            mShowCount.setText(mCount.toString())
    }

    fun showToast(view: android.view.View) {val toast  = Toast.makeText(this, R.string.toast_message,
        Toast.LENGTH_SHORT)
        toast.show()
    }

}

