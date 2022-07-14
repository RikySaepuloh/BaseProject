package id.riky.baseproject.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.riky.baseproject.databinding.LayoutItemBinding
import id.riky.baseproject.ui.detail.DetailActivity


class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.DataPengajuanViewHolder>() {
    private var mFilteredList= mutableListOf<String>()
    private var mArrayList= mutableListOf<String>()
    lateinit var context: Context

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

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
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

                // Perintah saat klik item
                binding.root.setOnClickListener {
                    // Perintah pindah activity
                    val intent=Intent(context, DetailActivity::class.java)
                    context.startActivity(intent)

                    // Perintah memunculkan toast dengan data
                    // Toast.makeText(context,binding.judul.text,Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mFilteredList.size
    }

    inner class DataPengajuanViewHolder(val binding:LayoutItemBinding):RecyclerView.ViewHolder(binding.root)

}