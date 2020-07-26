package milu.kiriu2010.miluand01.c2x.c21

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import milu.kiriu2010.entity.team0.Team0Abs
import milu.kiriu2010.entity.team0.Team0BaseBall
import milu.kiriu2010.entity.team0.Team0Soccer
import milu.kiriu2010.miluand01.R
import milu.kiriu2010.miluand01.databinding.FragmentC21ABinding

// -----------------------------------
// チーム一覧を表示するフラグメント
// -----------------------------------
// DataBindingを使った例
// https://medium.com/swlh/android-recyclerview-with-data-binding-and-coroutine-3192097a0496
// https://qiita.com/furusin_oriver/items/5d791e638e9c53ea0a61
// https://qiita.com/ta_sato_kuu/items/7e9e99b30b6ab45f5a84
class C21AFragment : Fragment() {

    private val viewModel: C21ViewModel by lazy {
        ViewModelProviders.of(this).get(C21ViewModel::class.java)
    }

    // チーム一覧を表示するリサイクラビュー
    //private lateinit var rvC21: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.setTitle(javaClass.simpleName)

        // Inflate the layout for this fragment
        //val view = inflater.inflate(R.layout.fragment_c21_a, container, false)
        val binding = DataBindingUtil.setContentView<FragmentC21ABinding>(activity!!,R.layout.fragment_c21_a)
        //val binding = DataBindingUtil.inflate<FragmentC21ABinding>(inflater,R.layout.fragment_c21_a,container,false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        //binding.lifecycleOwner = viewLifecycleOwner

        Log.d(javaClass.simpleName,"size=${viewModel.teams.size}")

        binding.rvC21.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val adapter = C21AAdapter(context!!,viewModel,this)
        binding.rvC21.adapter = adapter

        // チーム一覧を表示するリサイクラビュー
        //rvC21 = view.findViewById(R.id.rvC21)

        //val adapter = C21AAdapter(createData())
        //rvC21.adapter = adapter

        return view
    }

    // チーム一覧を生成
    /*
    private fun createData(): MutableList<Team0Abs> {
        val teamLst = mutableListOf<Team0Abs>()

        // チーム一覧:野球
        val teamBaseBalls = Team0BaseBall.createLst()
        teamLst += teamBaseBalls

        // チーム一覧:サッカー
        val teamSoccers = Team0Soccer.createLst()
        teamLst += teamSoccers

        return teamLst
    }

     */

    companion object {
        @JvmStatic
        fun newInstance() =
            C21AFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}