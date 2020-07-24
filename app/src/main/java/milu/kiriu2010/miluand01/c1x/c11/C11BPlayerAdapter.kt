package milu.kiriu2010.miluand01.c1x.c11

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_c11_b_player.view.*
import milu.kiriu2010.entity.team0.Player
import milu.kiriu2010.miluand01.R
import java.text.SimpleDateFormat
import java.util.*

class C11BPlayerAdapter(
    context: Context,
    private val players: MutableList<Player> = mutableListOf()
): RecyclerView.Adapter<C11BPlayerAdapter.C11BPlayerViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): C11BPlayerViewHolder {
        val view = inflater.inflate(R.layout.adapter_c11_b_player,parent,false)
        val viewHolder = C11BPlayerViewHolder(view)
        return viewHolder
    }

    override fun getItemCount() = players.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: C11BPlayerViewHolder, position: Int) {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val player = players[position]
        holder.tvC11B_PNAME.text = player.lname + " " + player.lname
        holder.tvC11B_PBDAY.text = dateFormat.format(player.bday)
    }

    class C11BPlayerViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvC11B_PNAME = view.findViewById<TextView>(R.id.tvC11B_PNAME)
        val tvC11B_PBDAY = view.findViewById<TextView>(R.id.tvC11B_PBDAY)
    }
}