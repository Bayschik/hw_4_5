package com.example.lesson_4_5

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.lesson_4_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: LoveViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(binding.loveImage)
            .load("https://www.logos.com/grow/wp-content/uploads/2023/02/WxW-Love.png")
            .into(binding.loveImage)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.getLiveLoveData(etFirst.text.toString(), etSecond.text.toString())
                    .observe(this@MainActivity, Observer {
                        binding.tvResult.text = it.percentage.toString()
                    })
            }
        }
    }
}