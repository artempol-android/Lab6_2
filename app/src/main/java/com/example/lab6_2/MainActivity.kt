package com.example.lab6_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.lab6_2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model by viewModels<DownloaderModelView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("Thread: ", Thread.currentThread().name)

        observeBitmap()
        if (binding.imageView.drawable == null) {
            model.downloadPicture()
        }
    }

    private fun observeBitmap() {
        model.bitmap.observe(this) {
            if (it != null) {
                binding.imageView.setImageBitmap(it)
            }
        }
    }
}