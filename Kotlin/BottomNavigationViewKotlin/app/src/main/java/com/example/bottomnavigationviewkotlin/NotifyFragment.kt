package com.example.bottomnavigationviewkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class NotifyFragment : Fragment(){

    companion object{
        fun newInstatnce() : NotifyFragment{
            return NotifyFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notify, container, false)
        return view
    }
}