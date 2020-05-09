package milu.kiriu2010.miluand01.c1x.c11

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import milu.kiriu2010.entity.team0.Team0Abs
import milu.kiriu2010.miluand01.R

// -----------------------------------
// チーム情報を表示するアダプタ
// -----------------------------------
// 以下を表示
// ・ロゴ
// ・チーム名
// -----------------------------------
class C11Adapter(
    context: Context,
    // チーム一覧
    private val teamLst: MutableList<Team0Abs> = mutableListOf(),
    // チーム情報をクリック時に呼び出されるコールバック
    private val onTeamClicked: (Team0Abs) -> Unit
): RecyclerView.Adapter<C11Adapter.C11ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): C11ViewHolder {
        val view = inflater.inflate(R.layout.adapter_c11, parent, false)
        val viewHolder = C11ViewHolder(view)

        // チーム情報をクリックしたときに呼び出されるコールバック
        view.setOnClickListener {
            val pos = viewHolder.adapterPosition
            val team = teamLst[pos]
            onTeamClicked(team)
        }

        return viewHolder
    }

    override fun getItemCount(): Int = teamLst.size

    // ビューホルダーにチーム情報を紐づける
    override fun onBindViewHolder(holder: C11ViewHolder, position: Int) {
        val team = teamLst[position]
        holder.ivC11Logo.setImageResource(team.logo)
        holder.tvC11Name.text = team.name
    }

    // チーム情報を表示するビューホルダー
    class C11ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val ivC11Logo = view.findViewById<ImageView>(R.id.ivC11Logo)
        val tvC11Name = view.findViewById<TextView>(R.id.tvC11Name)
    }
}
