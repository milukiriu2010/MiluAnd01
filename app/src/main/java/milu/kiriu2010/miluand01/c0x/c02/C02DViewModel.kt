package milu.kiriu2010.miluand01.c0x.c02

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class C02DViewModel: ViewModel() {
    val data: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        data.value = "x"
    }
}