package milu.kiriu2010.miluand01.c2x.c21

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import milu.kiriu2010.miluand01.R
import milu.kiriu2010.miluand01.databinding.AdapterC21ABinding

// -----------------------------------
// チーム情報を表示するアダプタ
// -----------------------------------
// 以下を表示
// ・ロゴ
// ・チーム名
// -----------------------------------
//class C12AAdapter(C12ACompanion): ListAdapter<Team0Abs, C12AAdapter.C12AViewHolder>(C12ACompanion)
class C21AAdapter(
    context: Context,
    // チーム一覧
    private val viewModel: C21ViewModel,
    private val parentLifecycleOwner: LifecycleOwner
): RecyclerView.Adapter<C21AAdapter.C21AViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    class C21AViewHolder(val binding: AdapterC21ABinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): C21AViewHolder {
        //val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<AdapterC21ABinding>(inflater, R.layout.adapter_c21_a,parent,false)
        Log.d(javaClass.simpleName,"size=${viewModel.teams.size}")

        return C21AViewHolder(binding)
    }

    override fun getItemCount() = viewModel.teams.size

    override fun onBindViewHolder(holder: C21AViewHolder, position: Int) {
        holder.binding.viewModel = viewModel
        holder.binding.position = position
        //ここでviewholderのlifecycleOwnerにセットする！
        holder.binding.lifecycleOwner = parentLifecycleOwner
    }

}