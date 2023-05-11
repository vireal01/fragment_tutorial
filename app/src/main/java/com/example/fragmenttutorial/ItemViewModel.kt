package com.example.fragmenttutorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel : ViewModel() {
    private val mutableSelectedItem = MutableLiveData<String?>()
    val currentTitle: LiveData<String?> get() = mutableSelectedItem

    fun firstButtonTitle(title: String) {
        mutableSelectedItem.value = title
    }

    fun clearData() {
        mutableSelectedItem.value = null
    }
}