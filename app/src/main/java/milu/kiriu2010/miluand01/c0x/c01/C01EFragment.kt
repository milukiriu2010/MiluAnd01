package milu.kiriu2010.miluand01.c0x.c01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import milu.kiriu2010.miluand01.R
import milu.kiriu2010.miluand01.databinding.FragmentC01eBinding

// ---------------------------------------------
// チェックボックスのON/OFFサンプル
// ---------------------------------------------
// DataBindingを使う:パート２
// ---------------------------------------------
// https://blog.masterka.net/archives/1638
class C01EFragment : Fragment() {
    private val viewModel: C01EViewModel by lazy {
        ViewModelProviders.of(this).get(C01EViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_c01e, container, false)
        activity?.setTitle(javaClass.simpleName)

        // DataBindingのインスタンスを作成
        val binding = DataBindingUtil.inflate<FragmentC01eBinding>(inflater,R.layout.fragment_c01e,container,false)
        // ViewModelのインスタンスを設定
        binding.viewModel = C01EViewModel()
        // ライフサイクル所有者を設定
        binding.lifecycleOwner = this

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            C01EFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}