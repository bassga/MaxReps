package com.example.maxreps

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.maxreps.dummy.DummyContent

class MachineItemViewModel : ViewModel() {

    private val _list: MutableLiveData<MutableList<DummyContent.DummyItem>> = MutableLiveData()
    val list: LiveData<MutableList<DummyContent.DummyItem>> = _list


    fun init() {
        createList()
    }
    private fun createList() {
        var testList = mutableListOf<DummyContent.DummyItem>()
        repeat(20) {
            testList.add(
                DummyContent.DummyItem(it.toString(), "Item $it", makeDetails(it))
            )
        }
        _list.postValue(testList)
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }
}
