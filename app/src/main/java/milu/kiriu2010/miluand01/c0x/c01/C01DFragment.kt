package milu.kiriu2010.miluand01.c0x.c01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import milu.kiriu2010.miluand01.R
import milu.kiriu2010.miluand01.databinding.FragmentC01dBinding

// ---------------------------------------------
// チェックボックスのON/OFFサンプル
// ---------------------------------------------
// DataBindingを使う
// ---------------------------------------------
class C01DFragment : Fragment() {

    private val viewModel: C01DViewModel by lazy {
        ViewModelProviders.of(this).get(C01DViewModel::class.java)
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
        val view = inflater.inflate(R.layout.fragment_c01d, container, false)
        activity?.setTitle(javaClass.simpleName)

        // DataBindingのインスタンスを作成
        val binding = DataBindingUtil.inflate<FragmentC01dBinding>(inflater,R.layout.fragment_c01d,container,false)
        // ViewModelのインスタンスを設定
        binding.viewModel = viewModel
        // ライフサイクル所有者を設定
        binding.lifecycleOwner = this

        // チェックボックスAをクリック
        binding.chkC01DA.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                viewModel.a.value = "A"
            }
            else {
                viewModel.a.value = "a"
            }
        }

        // チェックボックスBをクリック
        binding.chkC01DB.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                viewModel.b.value = "B"
            }
            else {
                viewModel.b.value = "b"
            }
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            C01DFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
