package milu.kiriu2010.miluand01.c1x.c11

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
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
class C11AAdapter(
    context: Context,
    private val onC11StartDrag: OnC11StartDrag,
    // チーム一覧
    private val teamLst: MutableList<Team0Abs> = mutableListOf(),
    // チーム情報をクリック時に呼び出されるコールバック
    private val onTeamClicked: (Team0Abs) -> Unit
): RecyclerView.Adapter<C11AAdapter.C11ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    interface OnC11StartDrag {
        fun startDragging(viewHolder: RecyclerView.ViewHolder)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): C11ViewHolder {
        val view = inflater.inflate(R.layout.adapter_c11_a, parent, false)
        val viewHolder = C11ViewHolder(view)

        Log.d(javaClass.simpleName,"size=${teamLst.size}")

        // チーム情報をクリックしたときに呼び出されるコールバック
        // --------------------------------------------------
        // ドラッグ＆ドロップできるようにすると、呼び出されない
        view.setOnClickListener {
            val pos = viewHolder.adapterPosition
            val team = teamLst[pos]
            onTeamClicked(team)
        }

        // タップすると、ドラッグ＆ドロップ可能なことをすぐ知らせるための状態に、即変化する
        // これを入れると、画面領域を超えるスクロールができない
        /*
        viewHolder.itemView.hvC11.setOnTouchListener { v, event ->

            if (event.actionMasked == MotionEvent.ACTION_DOWN) {
                onC11StartDrag.startDragging(viewHolder)
            }

            return@setOnTouchListener true
        }
         */

        return viewHolder
    }

    override fun getItemCount(): Int = teamLst.size

    // ビューホルダーにチーム情報を紐づける
    override fun onBindViewHolder(holder: C11ViewHolder, position: Int) {
        val team = teamLst[position]
        holder.ivC11Logo.setImageResource(team.logo)
        holder.tvC11Name.text = team.name
    }

    // アイテムを移動する
    fun moveItem(from: Int, to: Int) {
        val team = teamLst[from]
        teamLst.removeAt(from)
        teamLst.add(to,team)
        notifyDataSetChanged()
    }

    // アイテム削除
    fun deleteItem(pos: Int) {
        teamLst.removeAt(pos)
        notifyItemRemoved(pos)
    }

    // チーム情報を表示するビューホルダー
    class C11ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val hvC11 = view.findViewById<ConstraintLayout>(R.id.hvC11)
        val ivC11Logo = view.findViewById<ImageView>(R.id.ivC11Logo)
        val tvC11Name = view.findViewById<TextView>(R.id.tvC11Name)
    }
}
