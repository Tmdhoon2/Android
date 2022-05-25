package com.example.mediaplayerexample

import android.graphics.Color
import android.graphics.drawable.Animatable
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.view.animation.AnimationUtils
import android.widget.SeekBar
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.mediaplayerexample.databinding.ActivityMediaplayerBinding

class MediaPlayerActivity : AppCompatActivity() {

    private lateinit var runnable: Runnable
    private var handler = Handler()
    private lateinit var binding: ActivityMediaplayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMediaplayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val playlist = arrayOf(                                                                                        // 곡
            R.raw.wakeup,
            R.raw.thinkaboutyou)

        val title = arrayOf(                                                                                           // 노래 제목
            "Wake Up (Prod. 코드 쿤스트)",
            "너를 생각해",
            "다정히 내 이름을 부르면",
            "언제나 사랑해",
            "나의 X에게",
            "정이라고 하자 (Feat. 10CM)",)

        val singer = arrayOf(                                                                                          // 가수
            "개코, 아우릴고트, SINCE, 안병웅, Tabber, 조광일",
            "주시크 (Joosiq)",
            "경서예지 X 전건호",
            "케이시",)

        val cover = arrayOf("https://cdn.kgasa.com/wp-content/uploads/2021/11/Show-Me-the-Money-10-EP-1.jpg",
                            "https://image.bugsm.co.kr/album/images/200/40650/4065044.jpg?version=20211216023014.0",)  // 앨범

        var i = 0                                                                                                      // 리스트 변수

        var mediaPlayer = MediaPlayer.create(this,playlist[i])                                                       // 미디어플레이어 생성

        binding.title.setText(title[i])                                                                                // 제목 setText
        binding.singer.setText(singer[i])                                                                              // 가수 setText

        Glide.with(this)                                                                                        // 이미지 불러오기
            .load(cover[i])
            .into(binding.cover)

        binding.seekbar.progress = 0                                                                                  // seekbar 시작점 설정
        binding.seekbar.max = mediaPlayer.duration                                                                    // seekbar 끝지점 설정

        binding.playbutton.setOnClickListener {                                                                       // playbutton 클릭시
            if(!mediaPlayer.isPlaying){                                                                               // 미디어플레이어 시작
                mediaPlayer.start()
                binding.playbutton.setBackgroundResource(R.drawable.ic_baseline_pause_24)                             // backgroundresource
            }
            else{
                mediaPlayer.pause()                                                                                   // 음악 정지
                binding.playbutton.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24)
            }
        }
        binding.loopbutton.setOnClickListener {
            if(!mediaPlayer.isLooping){                                                                               // 루핑 비활성화시
                mediaPlayer.setLooping(true)                                                                          // 루핑 활성화
                Toast.makeText(this,"현재 곡을 반복재생 합니다", 500).show()                           // 토스트 메시지
                binding.loopbutton.setBackgroundResource(R.drawable.ic_baseline_shuffle_24)                           // backgroundresource
            }
            else{
                mediaPlayer.setLooping(false)
                Toast.makeText(this, "반복재생을 해제 합니다", 500).show()
                binding.loopbutton.setBackgroundResource(R.drawable.ic_baseline_shufflegray_24)
            }
        }
        binding.nextbutton.setOnClickListener {
            i++
            if(mediaPlayer.isPlaying){
                mediaPlayer.stop()
            }
            mediaPlayer = MediaPlayer.create(this,playlist[i])
            binding.playbutton.setBackgroundResource(R.drawable.ic_baseline_pause_24)
            binding.title.setText(title[i])
            binding.singer.setText(singer[i])
            Glide.with(this)
                .load(cover[i])
                .into(binding.cover)
            mediaPlayer.start()
            binding.seekbar.progress = 0
            binding.seekbar.max = mediaPlayer.duration

        }

        binding.previousbutton.setOnClickListener {
            i--
            if(mediaPlayer.isPlaying){
                mediaPlayer.stop()
            }
            mediaPlayer = MediaPlayer.create(this,playlist[i])
            binding.playbutton.setBackgroundResource(R.drawable.ic_baseline_pause_24)
            binding.title.setText(title[i])
            binding.singer.setText(singer[i])
            Glide.with(this)
                .load(cover[i])
                .into(binding.cover)
            mediaPlayer.start()
            binding.seekbar.progress = 0
            binding.seekbar.max = mediaPlayer.duration
        }


        binding.seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                if(p2){
                    mediaPlayer.seekTo(p1)
                }
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        runnable = Runnable {

            binding.seekbar.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)

        mediaPlayer.setOnCompletionListener {
            mediaPlayer.pause()
            binding.playbutton.setBackgroundResource(R.drawable.ic_baseline_pause_24)
        }
    }

}