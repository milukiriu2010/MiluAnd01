package milu.kiriu2010.miluand01.c2x.c12

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import milu.kiriu2010.entity.team0.Team0Abs
import milu.kiriu2010.entity.team0.Team0BaseBall
import milu.kiriu2010.entity.team0.Team0Soccer
import milu.kiriu2010.miluand01.R

// -----------------------------------
// チーム一覧を表示するフラグメント
// -----------------------------------
// DataBindingを使った例
// https://medium.com/swlh/android-recyclerview-with-data-binding-and-coroutine-3192097a0496
// https://qiita.com/furusin_oriver/items/5d791e638e9c53ea0a61
class C12AFragment : Fragment() {

    // チーム一覧を表示するリサイクラビュー
    private lateinit var rvC12: RecyclerView

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
        val view = inflater.inflate(R.layout.fragment_c12_a, container, false)

        // チーム一覧を表示するリサイクラビュー
        rvC12 = view.findViewById(R.id.rvC12)

        val adapter = C12AAdapter(createData())
        rvC12.adapter = adapter

        return view
    }

    // チーム一覧を生成
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

    companion object {
        @JvmStatic
        fun newInstance() =
            C12AFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}