package com.example.musicply

import android.media.AudioAttributes
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.musicply.databinding.ActivityMainBinding
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var stop:Boolean = false
    private lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)


        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playBtn.setOnClickListener {
            if (stop){
                mp.seekTo(mp.currentPosition)
                mp.start()
                stop = false
            } else {

                val audioUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"
                mp = MediaPlayer().apply {
                    setAudioAttributes(
                        AudioAttributes.Builder()
                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                            .setUsage(AudioAttributes.USAGE_MEDIA)
                            .build()
                )

                try {
                    mp.setDataSource(audioUrl)
                    mp.prepare()
                    mp.start()

                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            initializeSeekBar()
            binding.playBtn.visibility = View.GONE
            binding.pauseBtn.visibility = View.VISIBLE

        }

    }
}

    private fun initializeSeekBar() {

    }

    }
