package milu.kiriu2010.miluand01.c0x.c01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import milu.kiriu2010.miluand01.R

// ---------------------------------------------
// チェックボックスのON/OFFサンプル
// ---------------------------------------------
// LiveDataを使う
// ---------------------------------------------
class C01CFragment : Fragment() {

    private val viewModel: C01CViewModel by lazy {
        ViewModelProviders.of(this).get(C01CViewModel::class.java)
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
        val view = inflater.inflate(R.layout.fragment_c01a, container, false)
        activity?.setTitle(javaClass.simpleName)

        // チェックボックスAをクリック
        val chkC01A = view.findViewById<CheckBox>(R.id.chkC01A)
        chkC01A.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                viewModel.a.value = "A"
            }
            else {
                viewModel.a.value = "a"
            }
        }

        // チェックボックスBをクリック
        val chkC01B = view.findViewById<CheckBox>(R.id.chkC01B)
        chkC01B.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                viewModel.b.value = "B"
            }
            else {
                viewModel.b.value = "b"
            }
        }

        // オブサーバーA
        val tvC01A = view.findViewById<TextView>(R.id.tvC01A)
        val observerA = Observer<String> {
            tvC01A.setText(it)
        }
        // オブサーバーB
        val tvC01B = view.findViewById<TextView>(R.id.tvC01B)
        val observerB = Observer<String> {
            tvC01B.setText(it)
        }

        // LiveDataを監視A
        viewModel.a.observe(this,observerA)
        // LiveDataを監視B
        viewModel.b.observe(this,observerB)

        // デフォルト値
        //viewModel.a.value = "xc"
        //viewModel.b.value = "yc"

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            C01CFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
