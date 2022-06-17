package id.riky.baseproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import id.riky.baseproject.databinding.LayoutItemBinding
import java.util.*


class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.DataPengajuanViewHolder>() {
    private var mFilteredList= mutableListOf<String>()
    private var mArrayList= mutableListOf<String>()

    fun initData(data:List<String>){
        mFilteredList.clear()
        mArrayList.clear()
        mFilteredList.addAll(data)
        mArrayList.addAll(data)
        notifyDataSetChanged()
    }

    fun clearData(){
        mFilteredList.clear()
        mArrayList.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataPengajuanViewHolder {
        val binding=LayoutItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataPengajuanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataPengajuanViewHolder, position: Int) {
        with(holder){
            with(mFilteredList[position]){
                binding.judul.text = mFilteredList[position]
            }
        }
    }

    override fun getItemCount(): Int {
        return mFilteredList.size
    }

    inner class DataPengajuanViewHolder(val binding:LayoutItemBinding):RecyclerView.ViewHolder(binding.root)

}