package com.example.bottomnavigationviewkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MypageFragment : Fragment(){

    companion object{
        fun newInstatnce() : MypageFragment{
            return MypageFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mypage, container, false)
        return view
    }
}