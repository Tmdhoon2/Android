package com.example.bottomnavigationviewkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ApplyFragment : Fragment(){

    companion object{
        fun newInstatnce() : ApplyFragment{
            return ApplyFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_apply, container, false)
        return view
    }
}