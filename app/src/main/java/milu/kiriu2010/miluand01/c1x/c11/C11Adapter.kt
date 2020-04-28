package milu.kiriu2010.miluand01.c1x.c11

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_c11.view.*
import milu.kiriu2010.entity.team.TeamAbs
import milu.kiriu2010.miluand01.R

class C11Adapter(
    context: Context,
    // チーム一覧
    private val teamLst: MutableList<TeamAbs> = mutableListOf()
): RecyclerView.Adapter<C11Adapter.C11ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): C11ViewHolder {
        val view = inflater.inflate(R.layout.adapter_c11, parent, false)
        val viewHolder = C11ViewHolder(view)
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
