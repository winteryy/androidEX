package com.example.room

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.db.TextDatabase
import com.example.room.entity.TextEntity
import com.example.room.entity.WordEntity
import com.example.room.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    val context = getApplication<Application>().applicationContext
    val db = TextDatabase.getDatabase(context)

    private var _textList = MutableLiveData<List<TextEntity>>()
    val textList: LiveData<List<TextEntity>>
        get() = _textList

    private var _wordList = MutableLiveData<List<WordEntity>>()
    val wordList: LiveData<List<WordEntity>>
        get() = _wordList

    val repository = Repository(context)

    fun getData() = viewModelScope.launch(Dispatchers.IO) {
//        db.textDAO().getAllData()
//        db.wordDAO().getAllData()
//        Log.d("MainViewModel", db.textDAO().getAllData().toString())
//        Log.d("MainViewModel", db.wordDAO().getAllData().toString())
        _textList.postValue(repository.getTextList())
        _wordList.postValue(repository.getWordList())
    }

    fun insertData(text: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertTextData(text)
        repository.insertWordData(text)

//        db.textDAO().insert(TextEntity(0, text))
//        db.wordDAO().insert(WordEntity(0, text))
    }

    fun deleteData() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteTextData()
        repository.deleteWordData()

//        db.textDAO().deleteAllData()
//        db.wordDAO().deleteAllData()
    }
}