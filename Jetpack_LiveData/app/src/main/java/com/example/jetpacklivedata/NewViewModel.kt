package com.example.jetpacklivedata

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class NewViewModel: ViewModel() {

    private var _mutableWord = MutableLiveData("")
    val liveWord: LiveData<String>
        get() = _mutableWord

    private var _randomMutableWord = MutableLiveData("")
    val randomLiveWord: LiveData<String>
        get() = _randomMutableWord

    val newData = Transformations.switchMap(randomLiveWord){
        getShuffledRandomWord(it)
    }

    init{
        getNextData()
    }

    fun getNextData(){
        val currentWord = testDataList.random()
        val randomWord = currentWord.toCharArray()
        randomWord.shuffle()

        _mutableWord.value = currentWord
        _randomMutableWord.value = String(randomWord)
    }

    fun getShuffledRandomWord(word: String): MutableLiveData<String> {
        val liveData = MutableLiveData("")
        val randomTextWord = word.toCharArray()

        randomTextWord.shuffle()
        liveData.value = String(randomTextWord)

        Log.d("NewViewModel", randomTextWord.toString())
        Log.d("NewViewModel", String(randomTextWord))
        return liveData
    }


}