package milu.kiriu2010.miluand01.c1x.c11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import milu.kiriu2010.entity.team0.Team0Abs
import milu.kiriu2010.miluand01.R

// チーム情報を表示
class C11BFragment : Fragment() {
    private lateinit var teamAbs: Team0Abs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            teamAbs = it.getParcelable(TAG)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_c11_b, container, false)

        // ロゴ
        val ivC11B_LOGO = view.findViewById<ImageView>(R.id.ivC11B_LOGO)
        ivC11B_LOGO.setImageResource(teamAbs.logo)

        // チーム名
        val ivC11B_NAME = view.findViewById<TextView>(R.id.tvC11B_NAME)
        ivC11B_NAME.text = teamAbs.name

        // 選手一覧
        val rvC11_PLAYERS = view.findViewById<RecyclerView>(R.id.rvC11B_PLAYERS)
        rvC11_PLAYERS.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        rvC11_PLAYERS.adapter = C11BPlayerAdapter(activity!!.applicationContext,teamAbs.playerLst.toMutableList())

        // 年度別順位一覧
        val rvC11_YP = view.findViewById<RecyclerView>(R.id.rvC11B_YP)
        rvC11_YP.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        rvC11_YP.adapter = C11BYPAdapter(activity!!.applicationContext,teamAbs.yearPosMap.toMutableMap())

        return view
    }

    companion object {
        val TAG = "Team"

        @JvmStatic
        fun newInstance(param: Team0Abs) =
            C11BFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(TAG,param)
                }
            }
    }
}