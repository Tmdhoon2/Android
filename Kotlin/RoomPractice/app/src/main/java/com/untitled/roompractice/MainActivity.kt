package com.untitled.roompractice

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.untitled.roompractice.database.DemoDatabase
import com.untitled.roompractice.databinding.ActivityMainBinding
import com.untitled.roompractice.entity.Recruitment
import com.untitled.roompractice.viewmodel.MainSideEffect
import com.untitled.roompractice.viewmodel.MainViewModel
import com.untitled.roompractice.viewmodel.MainViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val database by lazy {
        Room.databaseBuilder(
            context = this,
            klass = DemoDatabase::class.java,
            name = "demo-database"
        ).build()
    }

    private lateinit var recruitmentAdapter: RecruitmentAdapter

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }

    private val mainViewModel: MainViewModel by lazy {
        MainViewModelFactory(database).create(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        mainViewModel.getRecruitments()

        lifecycleScope.launch(Dispatchers.IO) {
            mainViewModel.mainSideEffect.collect {
                when (it) {
                    is MainSideEffect.SuccessGetRecruitments -> {
                        initRecyclerView(it.recruitments)
                    }

                    is MainSideEffect.Success -> {
                        recruitmentAdapter.notifyDataSetChanged()
                    }

                    is MainSideEffect.Failure -> {
                        Log.d("TEST", it.message)
                    }
                }
            }
        }
    }

    private fun initRecyclerView(recruitments: List<Recruitment>) {
        recruitmentAdapter = RecruitmentAdapter(recruitments)
        binding.recyclerViewRecruitment.apply {
            adapter = recruitmentAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}