package id.riky.baseproject.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.riky.baseproject.databinding.LayoutItemBinding
import id.riky.baseproject.domain.model.ModelHeroes
import id.riky.baseproject.ui.detail.DetailActivity


class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.DataPengajuanViewHolder>() {
    private var mFilteredList= mutableListOf<ModelHeroes>()
    private var mArrayList= mutableListOf<ModelHeroes>()
    lateinit var context: Context

    fun initData(data:List<ModelHeroes>){
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
                // nama, role, kelas, data gambar diambil dari array model
                binding.judul.text = nama
                binding.role.text = role
                binding.kelas.text = kelas
                Glide.with(context).load(imageLink).into(binding.gambar)

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