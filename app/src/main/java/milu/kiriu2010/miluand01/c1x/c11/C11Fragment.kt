package milu.kiriu2010.miluand01.c1x.c11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import milu.kiriu2010.entity.team0.Team0Abs
import milu.kiriu2010.entity.team0.Team0BaseBall
import milu.kiriu2010.entity.team0.Team0Soccer

import milu.kiriu2010.miluand01.R

// -----------------------------------
// チーム一覧を表示するフラグメント
// -----------------------------------
class C11Fragment : Fragment(),
    C11Adapter.OnC11StartDrag {


    // チーム一覧を表示するリサイクラビュー
    private lateinit var rvC11: RecyclerView

    // ロングタッチで移動できるようにするためのおまじない
    // https://medium.com/@yfujiki/drag-and-reorder-recyclerview-items-in-a-user-friendly-manner-1282335141e9
    private val itemTouchHelper by lazy {
        // 1. Note that I am specifying all 4 directions.
        //    Specifying START and END also allows
        //    more organic dragging than just specifying UP and DOWN.
        val simpleItemTouchCallback =
            object: ItemTouchHelper.SimpleCallback(UP or DOWN or START or END,
                0) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    val adapter = recyclerView.adapter as C11Adapter
                    val from = viewHolder.adapterPosition
                    val to = target.adapterPosition
                    // 2. Update the backing model. Custom implementation in
                    //    MainRecyclerViewAdapter. You need to implement
                    //    reordering of the backing model inside the method.
                    adapter.moveItem(from, to)
                    // 3. Tell adapter to render the model update.
                    adapter.notifyItemMoved(from, to)

                    return true
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    // 4. Code block for horizontal swipe.
                    //    ItemTouchHelper handles horizontal swipe as well, but
                    //    it is not relevant with reordering. Ignoring here.
                    val adapter = rvC11.adapter as C11Adapter
                    adapter.deleteItem(viewHolder.adapterPosition)
                }

                // onSelectedChanged と clearView で
                // ロングタッチでドラッグ＆ドロップができることを知らせるおまじない

                // 1. This callback is called when a ViewHolder is selected.
                //    We highlight the ViewHolder here.
                override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?,
                                               actionState: Int) {
                    super.onSelectedChanged(viewHolder, actionState)

                    if (actionState == ACTION_STATE_DRAG) {
                        viewHolder?.itemView?.alpha = 0.5f
                    }
                }
                // 2. This callback is called when the ViewHolder is
                //    unselected (dropped). We unhighlight the ViewHolder here.
                override fun clearView(recyclerView: RecyclerView,
                                       viewHolder: RecyclerView.ViewHolder) {
                    super.clearView(recyclerView, viewHolder)
                    viewHolder.itemView.alpha = 1.0f
                }
            }

        ItemTouchHelper(simpleItemTouchCallback)
    }

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
            val adapter = C11Adapter(it, this, createData()) {
                // チーム情報をクリック時に呼び出されるコールバック

                val toast = Toast.makeText(context,it.name,Toast.LENGTH_SHORT)
                toast.show()
            }
            rvC11.adapter = adapter
        }

        // ロングタッチによるアイテム移動をするために、補助とリサイクラビューを結びつける
        itemTouchHelper.attachToRecyclerView(rvC11)

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

    // ドラッグ＆ドロップ
    override fun startDragging(viewHolder: RecyclerView.ViewHolder) {
        itemTouchHelper.startDrag(viewHolder)
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
