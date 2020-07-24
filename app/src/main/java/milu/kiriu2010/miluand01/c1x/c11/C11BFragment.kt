package milu.kiriu2010.miluand01.c1x.c11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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