package milu.kiriu2010.miluand01.c0x.c02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_c02.*

import milu.kiriu2010.miluand01.R

class C02Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_c02, container, false)
        activity?.setTitle(javaClass.simpleName)
        return view
    }

    override fun onStart() {
        super.onStart()

        // テキスト
        tvC02.text = "A"
        // ラジオボタンをクリック
        rgC02.setOnCheckedChangeListener { _, checkedId ->
            // クリックしたアイテムによってテキストを設定
            tvC02.text = when ( checkedId ) {
                R.id.rbC02A -> "A"
                else -> "B"
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            C02Fragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
