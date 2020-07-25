package milu.kiriu2010.miluand01.c2x.c12

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import milu.kiriu2010.entity.team0.Team0Abs
import milu.kiriu2010.miluand01.databinding.AdapterC12ABinding

// -----------------------------------
// チーム情報を表示するアダプタ
// -----------------------------------
// 以下を表示
// ・ロゴ
// ・チーム名
// -----------------------------------
//class C12AAdapter(C12ACompanion): ListAdapter<Team0Abs, C12AAdapter.C12AViewHolder>(C12ACompanion)
class C12AAdapter(
    // チーム一覧
    private val teamLst: MutableList<Team0Abs> = mutableListOf()
): RecyclerView.Adapter<C12AAdapter.C12AViewHolder>() {

    class C12AViewHolder(val binding: AdapterC12ABinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): C12AViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterC12ABinding.inflate(inflater)
        return C12AViewHolder(binding)
    }

    override fun getItemCount() = teamLst.size

    override fun onBindViewHolder(holder: C12AViewHolder, position: Int) {
        val team = teamLst[position]
        holder.binding.team = team
    }

}