package com.example.actionview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.SearchView
import com.example.actionview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    val data1 = arrayOf("aaaa", "bbbb", "cccc", "aabb", "ccdd")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)
        binding.list1.adapter = adapter

        // 검색어 기준으로 필터링 될 수 있도록 설정
        binding.list1.isTextFilterEnabled = true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        // SearchView를 가지고 있는 메뉴 아이템 객체 추출
        val item1 = menu?.findItem(R.id.item1)
        // SearchView 객체를 가지고 온다.
        val search1 = item1?.actionView as androidx.appcompat.widget.SearchView
        // hint 설정
        search1.queryHint = "검색어 입력"

        // 메뉴 아이템에 배치된 뷰가 접히거나 펼쳐질 때 반응하는 리스너
        val listener1 = object: MenuItem.OnActionExpandListener{
            // 접혔을 때 호출
            override fun onMenuItemActionExpand(p0: MenuItem?): Boolean {
                binding.textview.text = "펼쳐졌습니다"
                return true
            }
            // 펼쳐졌을 때 호출
            override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
                binding.textview.text = "접혀졌습니다"
                return true
            }
        }

        item1.setOnActionExpandListener(listener1)

        // SearchView의 리스너
        val listener2 = object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            // SearchView에 문자열을 입력할 때 마다 호출되는 메서드
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.textview.text = "문자열 입력완료"
                binding.textview2.text = "입력완료 : $query"
                search1.clearFocus()
                return true
            }
            // 키보드의 돋보기 버튼을 눌렀을 때 호출되는 메서드
            override fun onQueryTextChange(newText: String?): Boolean {
                binding.textview.text = "문자열 입력중"
                binding.textview2.text = "입력중 : $newText"

                // SearchView에 입력한 내용을 listView의 필터 문자열로 설정
                binding.list1.setFilterText(newText)

                // 만약 설정한 문자열의 길이가 0이면 필터 문자열 제거
                if(newText?.length == 0){
                    binding.list1.clearTextFilter()
                }

                return true
            }
        }

        search1.setOnQueryTextListener(listener2)

        return true
    }
}