package com.example.hellotoastwithsecondactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    var mCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    fun countUp(view: android.view.View) {
        mCount++
        val mShowCount = findViewById<TextView>(R.id.show_count)
        if (mShowCount != null)
            mShowCount.setText(mCount.toString())
    }


    fun sayHello(view: android.view.View) {
        val mShowCount = findViewById<TextView>(R.id.show_count)
        val intent = Intent(this, SecondActivity::class.java)
        val message = mShowCount.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivity(intent)
    }

    companion object {

        val EXTRA_MESSAGE = "com.example.hellotoastwithsecondactivity.extra.MESSAGE"

    }

}
