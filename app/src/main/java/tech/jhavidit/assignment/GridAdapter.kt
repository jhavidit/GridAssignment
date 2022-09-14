package tech.jhavidit.assignment

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*
import tech.jhavidit.assignment.databinding.ListItemBinding
import java.util.*

class GridAdapter : RecyclerView.Adapter<GridAdapter.MyViewHolder>() {

    private var numberList = ArrayList<Int>()

    fun setGridSize(numberList: ArrayList<Int>) {
        val diffCallBack = MyDiffCallBack(this.numberList, numberList)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)
        diffResult.dispatchUpdatesTo(this)
        this.numberList = numberList

    }


    class MyDiffCallBack(
        private val oldList: List<Int>,
        private val newList: List<Int>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }

    class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        with(holder) {
            with(numberList[position]) {
                if (this == 1) {
                    binding.tile.setCardBackgroundColor(Color.parseColor("#FF0000"))
                } else
                    binding.tile.setCardBackgroundColor(Color.parseColor("#808080"))
            }
        }
    }


    override fun getItemCount(): Int {
        return numberList.size
    }


}