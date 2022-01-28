package com.example.fragmentscontacts

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_contacts_info.*

class InfoContactsFragment: Fragment(R.layout.fragment_contacts_info) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val args = this.arguments
        val inputFirstname = args?.get("firstname")
        val inputLastname = args?.get("lastname")
        val inputPhoneNumber = args?.get("phone")
        firstname_info.text = inputFirstname.toString()
        lastname_info.text = inputLastname.toString()
        phone_number_info.text = inputPhoneNumber.toString()

    }
}