package com.recyclerview.practise.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.recyclerview.practise.csvReader.CSVFile
import com.recyclerview.practise.model.RecyclerModel
import com.recyclerview.practise.R
import java.io.IOException
import java.io.InputStream

class MainViewModel() : ViewModel() {
    val recyclerData = MutableLiveData<List<RecyclerModel>>()
    val showError = MutableLiveData<Boolean>()

    fun readData(context: Context) {
        val inputStream: InputStream = context.resources.openRawResource(R.raw.testcsv)
        try {
            val listData = CSVFile(inputStream).read()
            val transformedData: List<RecyclerModel> = getTransformedData(listData)
            recyclerData.postValue(transformedData)
        } catch (ex: IOException) {
            showError.postValue(true)
        }

    }

    private fun getTransformedData(listData: MutableList<Any?>): List<RecyclerModel> {
        return listData.map {
            it as Array<String>
            RecyclerModel(
                name = it[0],
                address = it[1],
                phone = it[2]
            )
        }
    }
}