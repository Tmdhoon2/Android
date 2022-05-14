package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentPolicyBinding

class PolicyFragment : Fragment(){
    companion object{
        fun newInstance() : PolicyFragment {
            return PolicyFragment()
        }
    }

    private lateinit var binding: FragmentPolicyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPolicyBinding.inflate(layoutInflater)

        val view = inflater.inflate(R.layout.fragment_policy, container, false)

        return view
    }
}