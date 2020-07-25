package milu.kiriu2010.miluand01.c0x.c01

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView

import milu.kiriu2010.miluand01.R

// ---------------------------------------------
// チェックボックスのON/OFFサンプル
// ---------------------------------------------
// ViewModelを使わない例
// ---------------------------------------------
class C01AFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_c01a, container, false)
        activity?.setTitle(javaClass.simpleName)

        // テキストAのデフォルト値
        val tvC01A = view.findViewById<TextView>(R.id.tvC01A)
        tvC01A.text = "xa"
        // チェックボックスAをクリック
        val chkC01A = view.findViewById<CheckBox>(R.id.chkC01A)
        chkC01A.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                tvC01A.text = "A"
            }
            else {
                tvC01A.text = "a"
            }
        }

        // テキストBのデフォルト値
        val tvC01B = view.findViewById<TextView>(R.id.tvC01B)
        tvC01B.text = "ya"
        // チェックボックスBをクリック
        val chkC01B = view.findViewById<CheckBox>(R.id.chkC01B)
        chkC01B.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                tvC01B.text = "B"
            }
            else {
                tvC01B.text = "b"
            }
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            C01AFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
