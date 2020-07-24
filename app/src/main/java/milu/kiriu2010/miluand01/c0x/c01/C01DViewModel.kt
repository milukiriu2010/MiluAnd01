package milu.kiriu2010.miluand01.c0x.c01

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class C01DViewModel: ViewModel() {
    val a: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val b: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        a.value = "xd"
        b.value = "yd"
    }
}
