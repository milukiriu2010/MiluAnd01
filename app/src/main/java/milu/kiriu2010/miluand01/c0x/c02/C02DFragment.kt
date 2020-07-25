package milu.kiriu2010.miluand01.c0x.c02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_c02a.*

import milu.kiriu2010.miluand01.R
import milu.kiriu2010.miluand01.databinding.FragmentC02dBinding

// ---------------------------------------------
// ラジオボタンのON/OFFサンプル
// ---------------------------------------------
// DataBindingを使った例
// ---------------------------------------------
class C02DFragment : Fragment() {

    private val viewModel: C02DViewModel by lazy {
        ViewModelProviders.of(this).get(C02DViewModel::class.java)
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
        // Inflate the layout for this fragment
        //val view = inflater.inflate(R.layout.fragment_c02d, container, false)
        activity?.setTitle(javaClass.simpleName)

        // DataBindingのインスタンスを作成
        val binding = DataBindingUtil.inflate<FragmentC02dBinding>(inflater,R.layout.fragment_c02d,container,false)
        // ViewModelのインスタンスを設定
        binding.viewModel = viewModel
        // ライフサイクル所有者を設定
        binding.lifecycleOwner = this

        // ラジオボタンをクリック
        binding.rgC02D.setOnCheckedChangeListener { _, checkedId ->
            // クリックしたアイテムによってテキストを設定
            viewModel.data.value = when ( checkedId ) {
                R.id.rbC02DA -> "A"
                else -> "B"
            }
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            C02DFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
