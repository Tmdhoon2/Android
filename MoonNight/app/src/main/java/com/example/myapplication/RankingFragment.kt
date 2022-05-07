package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.databinding.FragmentRankingBinding

class RankingFragment : Fragment(){

    private var mBinding: FragmentRankingBinding? = null
    private val binding get() = mBinding!!

    companion object{
        const val TAG: String = "로그"

        fun newInstatnce() : RankingFragment {
            return RankingFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "RankingFragment - onCreate() called")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "RankingFragment - onAttach() called")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "RankingFragment - onCreateView() called")

        val view = inflater.inflate(R.layout.fragment_ranking, container, false)

        return view
    }
}