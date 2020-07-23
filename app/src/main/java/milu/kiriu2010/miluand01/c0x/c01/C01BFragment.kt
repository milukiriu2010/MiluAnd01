package milu.kiriu2010.miluand01.c0x.c01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders

import milu.kiriu2010.miluand01.R

// ---------------------------------------------
// チェックボックスのON/OFFサンプル
// ---------------------------------------------
// ViewModelを使う
// ---------------------------------------------
class C01BFragment : Fragment() {

    private val viewModel: C01BViewModel by lazy {
        ViewModelProviders.of(this).get(C01BViewModel::class.java)
    }

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
        activity?.setTitle(javaClass.simpleName)

        // テキストAのデフォルト値
        val tvC01A = view.findViewById<TextView>(R.id.tvC01A)
        tvC01A.text = viewModel.a
        // チェックボックスAをクリック
        val chkC01A = view.findViewById<CheckBox>(R.id.chkC01A)
        chkC01A.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                viewModel.a = "A"
            }
            else {
                viewModel.a = "a"
            }
            tvC01A.text = viewModel.a
        }

        // テキストBのデフォルト値
        val tvC01B = view.findViewById<TextView>(R.id.tvC01B)
        tvC01B.text = viewModel.b
        // チェックボックスBをクリック
        val chkC01B = view.findViewById<CheckBox>(R.id.chkC01B)
        chkC01B.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                viewModel.b = "B"
            }
            else {
                viewModel.b = "b"
            }
            tvC01B.text = viewModel.b
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            C01BFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
