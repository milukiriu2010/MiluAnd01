package milu.kiriu2010.miluand01.c0x.c01

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class C01EViewModel: ViewModel() {
    val a: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val b: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val aFlg: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val bFlg: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    init {
        a.value = "xd"
        b.value = "yd"
    }

    fun onMyChanged() {
        a.value = when ( aFlg.value ) {
            true -> "A"
            else -> "a"
        }

        b.value = when ( bFlg.value ) {
            true -> "B"
            else -> "b"
        }
    }

    /* 古い？
    @get: Bindable
    var a: String = "xd"
        set(value) {
            field = value
            // View側にTextAの変更を通知(getTextA()を呼ぶ)
            notifyPropertyChanged(BR.textA)
        }

    @get: Bindable
    var b: String = "yd"
        set(value) {
            field = value
            // View側にTextAの変更を通知(getTextB()を呼ぶ)
            notifyPropertyChanged(BR.textB)
        }

    // フォーム入力内容をフォーム下のTextViewに反映する getter
    @Bindable fun getTextA(): String {
        return a
    }

    // フォーム入力内容をフォーム下のTextViewに反映する getter
    @Bindable fun getTextB(): String {
        return b
    }

    // チェックボックスクリックイベント
    fun onCheckClick() {
        notifyPropertyChanged(BR.a)
    }
     */
}