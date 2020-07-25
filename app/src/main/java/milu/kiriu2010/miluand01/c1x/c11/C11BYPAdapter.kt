package milu.kiriu2010.miluand01.c1x.c11

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_c11_b_yp.view.*
import milu.kiriu2010.miluand01.R

// 年度別順位表示用アダプタ
class C11BYPAdapter(
    context: Context,
    private val yps: MutableMap<Int,Int> = mutableMapOf()
): RecyclerView.Adapter<C11BYPAdapter.C11BYPViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    private val ypLst = yps.toSortedMap().toList().reversed()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): C11BYPViewHolder {
        val view = inflater.inflate(R.layout.adapter_c11_b_yp,parent,false)
        val viewHolder = C11BYPViewHolder(view)
        return viewHolder
    }

    override fun getItemCount() = yps.size

    override fun onBindViewHolder(holder: C11BYPViewHolder, position: Int) {
        val yp = ypLst[position]

        holder.tvC11B_YEAR.text = yp.first.toString()
        holder.tvC11B_POS.text  = yp.second.toString()
    }

    class C11BYPViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvC11B_YEAR = view.findViewById<TextView>(R.id.tvC11B_YEAR)
        val tvC11B_POS  = view.findViewById<TextView>(R.id.tvC11B_POS)
    }

}