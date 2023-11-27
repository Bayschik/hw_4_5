package com.example.lesson_4_5

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lesson_4_5.remote.LoveModel

class LoveViewModel: ViewModel(){
    val repository = Repository()

    fun getLiveLoveData(firstName:String, secondName: String):LiveData<LoveModel>{
        return repository.getData(firstName, secondName)
    }
}