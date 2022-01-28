package com.example.fragmentscontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentscontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ContactsListFragment())
            .commit()


    }

    companion object {

        val EXTRA_FIRSTNAME = "com.example.fragmentscontacts.extra.FIRSTNAME"
        val EXTRA_LASNAME = "com.example.fragmentscontacts.extra.LASTNAME"
        val EXTRA_NUMBER = "com.example.fragmentscontacts.extra.NUMBER"

    }
}