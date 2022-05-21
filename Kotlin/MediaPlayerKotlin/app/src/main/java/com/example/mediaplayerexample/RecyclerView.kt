package com.example.mediaplayerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mediaplayerexample.databinding.ActivityMediaplayerBinding
import com.example.mediaplayerexample.databinding.ActivityRecyclerViewBinding

class RecyclerView : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val profileList = arrayListOf(
            Profiles(R.drawable.wakeup, "Wake Up (Prod. 코드 쿤스트)", "개코, 아우릴고트, SINCE, 안병웅, Tabber, 조광일"),
            Profiles(R.drawable.sick, "아퍼 (Band Ver.)", "기리보이(GIRIBOY) (Feat. 영비, YUNHWAY, Lil tachi, 한요한, JUSTHIS, 스윙스)"),
            Profiles(R.drawable.myname, "다정히 내 이름을 부르면", "경서예지 X 전건호"),
            Profiles(R.drawable.alwayslove, "언제나 사랑해", "케이시"),
            Profiles(R.drawable.myx, "나의 X에게", "경서"),
            Profiles(R.drawable.jung, "정이라고 하자 (Feat. 10CM)", "BIG Naughty (서동현)"),
            Profiles(R.drawable.stay, "STAY", "The Kid LAROI, Justin Bieber"),
            Profiles(R.drawable.thatshilarious, "That's Hilarious", "Charlie Puth"),
            Profiles(R.drawable.tomboy, "TOMBOY", "(여자)아이들"),
            Profiles(R.drawable.lovedive, "LOVE DIVE", "IVE (아이브)"),
            Profiles(R.drawable.guzy, "거지 (Feat. YUNHWAY, Jhnovr, JUSTHIS)", "기리보이 (Giriboy)"),
            Profiles(R.drawable.manam, "만남은 쉽고 이별은 어려워 (Feat. Leellamarz) (Prod. by TOIL)", "베이식 (Basick)"),
            Profiles(R.drawable.smiley, "SMILEY (Feat.BIBI)", "YENA (최예나)"),
            Profiles(R.drawable.chal, "찰나가 영원이 될 때 (The Eternal Moment)", "마크툽 (Maktub)"),
        )
        binding.rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rv.setHasFixedSize(true)
        binding.rv.adapter = ProfileAdapter(profileList)


    }
}