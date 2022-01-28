package com.example.fragmentscontacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

import kotlinx.android.synthetic.main.fragment_contacts_info.contact_1
import kotlinx.android.synthetic.main.fragment_contacts_list.*


class ContactsListFragment:Fragment(R.layout.fragment_contacts_list) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        contact_1.setOnClickListener {
            val firstName = firstname1.text.toString()
            val secondName = lastname1.text.toString()
            val phone = phone_number1.text.toString()
            val bundle = Bundle()
            bundle.putString("firstname", firstName)
            bundle.putString("lastname", secondName)
            bundle.putString("phone", phone)
            val fragment = InfoContactsFragment()
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()
                ?.replace(R.id.container, fragment)
                ?.addToBackStack("List")
                ?.commit()
//            activity?.supportFragmentManager?.beginTransaction()
//                ?.replace(R.id.container, InfoContactsFragment())
//                ?.addToBackStack("first")
//
//                ?.commit()
        }

        contact_2.setOnClickListener {
            val firstName = firstname2.text.toString()
            val secondName = lastname2.text.toString()
            val phone = phone_number2.text.toString()
            val bundle = Bundle()
            bundle.putString("firstname", firstName)
            bundle.putString("lastname", secondName)
            bundle.putString("phone", phone)
            val fragment = InfoContactsFragment()
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()
                ?.replace(R.id.container, fragment)
                ?.addToBackStack("List")
                ?.commit()
//            activity?.supportFragmentManager?.beginTransaction()
//                ?.replace(R.id.container, InfoContactsFragment())
//                ?.disallowAddToBackStack()
//
//
//                ?.commit()
        }

        contact_3.setOnClickListener {
            val firstName = firstname3.text.toString()
            val secondName = lastname3.text.toString()
            val phone = phone_number3.text.toString()
            val bundle = Bundle()
            bundle.putString("firstname", firstName)
            bundle.putString("lastname", secondName)
            bundle.putString("phone", phone)
            val fragment = InfoContactsFragment()
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()
                ?.replace(R.id.container, fragment)
                ?.addToBackStack("List")
                ?.commit()
//            activity?.supportFragmentManager?.beginTransaction()
//                ?.replace(R.id.container, InfoContactsFragment())
//                ?.disallowAddToBackStack()
//
//
//                ?.commit()
        }



        super.onViewCreated(view, savedInstanceState)


    }


}