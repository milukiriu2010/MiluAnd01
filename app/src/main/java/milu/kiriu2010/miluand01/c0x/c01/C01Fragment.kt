package milu.kiriu2010.miluand01.c0x.c01

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_c01.*

import milu.kiriu2010.miluand01.R

// ---------------------------------------------
// チェックボックスのON/OFFサンプル
// ---------------------------------------------
class C01Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_c01, container, false)
        Log.d(this.javaClass.simpleName,"ptn1")
        return view
    }

    override fun onStart() {
        super.onStart()

        // テキストAのデフォルト値
        tvC01A.text = "a"
        // チェックボックスAをクリック
        chkC01A.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                tvC01A.text = "A"
            }
            else {
                tvC01A.text = "a"
            }
        }

        // テキストBのデフォルト値
        tvC01B.text = "B"
        // チェックボックスBをクリック
        chkC01B.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                tvC01B.text = "B"
            }
            else {
                tvC01B.text = "b"
            }
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            C01Fragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
