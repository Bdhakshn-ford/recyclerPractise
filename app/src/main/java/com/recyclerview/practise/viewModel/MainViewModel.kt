package com.recyclerview.practise.viewModel

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.recyclerview.practise.csvReader.CSVFile
import com.recyclerview.practise.model.Person
import com.recyclerview.practise.R
import java.io.IOException
import java.io.InputStream

class MainViewModel : ViewModel() {
    val recyclerData = MutableLiveData<List<Person>>()
    val showError = MutableLiveData<Boolean>()
    lateinit var personDetailsRepository: PersonDetailsRepository

    fun readData() {
        try {
            recyclerData.postValue(personDetailsRepository.getPersonDataList())
        } catch (ex: IOException) {
            showError.postValue(true)
        }

    }
}

class PersonDetailsRepository(private val resources: Resources) {
    private val inputStream: InputStream = resources.openRawResource(R.raw.testcsv)

    fun getPersonDataList(): List<Person> {
        val listData = CSVFile(inputStream).read()
        return getTransformedData(listData)
    }

    private fun getTransformedData(listData: MutableList<Any?>): List<Person> {
        return listData.map {
            it as Array<String>
            Person(
                name = it[0],
                address = it[1],
                phone = it[2]
            )
        }
    }
}