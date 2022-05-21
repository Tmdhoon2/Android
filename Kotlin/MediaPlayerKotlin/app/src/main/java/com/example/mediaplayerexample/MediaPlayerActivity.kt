package com.example.mediaplayerexample

import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import android.widget.Toast
import com.example.mediaplayerexample.databinding.ActivityMediaplayerBinding

class MediaPlayerActivity : AppCompatActivity() {

    private lateinit var runnable: Runnable
    private var handler = Handler()
    private lateinit var binding: ActivityMediaplayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMediaplayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mediaPlayer = MediaPlayer.create(this, R.raw.wakeup)

        binding.seekbar.progress = 0
        binding.seekbar.max = mediaPlayer.duration

        binding.playbutton.setOnClickListener {
            if(!mediaPlayer.isPlaying){
                mediaPlayer.start()
                binding.playbutton.setBackgroundResource(R.drawable.ic_baseline_pause_24)
            }
            else{
                mediaPlayer.pause()
                binding.playbutton.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24)
            }
        }
        binding.loopbutton.setOnClickListener {
            //mediaPlayer.setLooping(true)
            //mediaPlayer.start()
            if(!mediaPlayer.isLooping){

                mediaPlayer.setLooping(true)
                Toast.makeText(this,"현재 곡을 반복재생 합니다", 500).show()
                binding.loopbutton.setBackgroundResource(R.drawable.ic_baseline_shuffle_24)
            }
            else{

                mediaPlayer.setLooping(false)
                Toast.makeText(this, "반복재생을 해제 합니다", 500).show()
                binding.loopbutton.setBackgroundResource(R.drawable.ic_baseline_shufflegray_24)
            }
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