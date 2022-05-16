package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentHomeBinding

class   HomeFragment : Fragment(){
    companion object{
        fun newInstatnce() : HomeFragment {
            return HomeFragment()
        }
    }

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

}