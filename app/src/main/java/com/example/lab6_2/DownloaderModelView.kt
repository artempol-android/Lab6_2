package com.example.lab6_2

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.net.URL
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class DownloaderModelView : ViewModel() {

    val bitmap: MutableLiveData<Bitmap> = MutableLiveData()
    private val polytechURL= URL("https://ivteleradio.ru/images/2017/6/2/7accc16664a74ff9a6d92b432ae05561.jpg")
    private val executor: ExecutorService = Executors.newSingleThreadExecutor()


    fun downloadPicture() =
        executor.execute {
            Log.d("Thread: ", Thread.currentThread().name)
            bitmap.postValue(BitmapFactory.decodeStream(polytechURL.openConnection().getInputStream()))
        }

    override fun onCleared() {
        executor.shutdown()
        super.onCleared()
    }
}