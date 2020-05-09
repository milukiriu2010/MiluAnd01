package milu.kiriu2010.miluand01.c1x.c11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import milu.kiriu2010.entity.team0.Team0Abs
import milu.kiriu2010.entity.team0.Team0BaseBall
import milu.kiriu2010.entity.team0.Team0Soccer

import milu.kiriu2010.miluand01.R

// -----------------------------------
// チーム一覧を表示するフラグメント
// -----------------------------------
class C11Fragment : Fragment() {

    // チーム一覧を表示するリサイクラビュー
    private lateinit var rvC11: RecyclerView

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
        val view = inflater.inflate(R.layout.fragment_c11, container, false)

        // チーム一覧を表示するリサイクラビュー
        rvC11 = view.findViewById(R.id.rvC11)

        // チーム一覧を縦方向に並べて表示
        rvC11.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        // チーム情報を表示するためのアダプタ
        context?.let {
            val adapter = C11Adapter(it, createData()) {
                // チーム情報をクリック時に呼び出されるコールバック

                val toast = Toast.makeText(context,it.name,Toast.LENGTH_SHORT)
                toast.show()
            }
            rvC11.adapter = adapter
        }

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
            C11Fragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
