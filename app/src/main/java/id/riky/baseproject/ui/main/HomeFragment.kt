package id.riky.baseproject.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.riky.baseproject.adapter.RecyclerViewAdapter
import id.riky.baseproject.databinding.FragmentHomeBinding
import id.riky.baseproject.domain.model.ModelHeroes


class HomeFragment : Fragment(){
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    val recyclerViewAdapter = RecyclerViewAdapter()
    val dataArray=ArrayList<ModelHeroes>()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Main Fragment code goes here

        // Populating Data
        dataArray.add(ModelHeroes("Karrie","Gold Lane", "Marksman","https://assets.skor.id/crop/0x0:0x0/x/photo/2022/02/23/4009726391.png"))
        dataArray.add(ModelHeroes("Lapu-Lapu","Exp Lane", "Fighter","https://static.wikia.nocookie.net/mobile-legends/images/1/1e/Courageous_Blade.jpg/revision/latest?cb=20210530114612"))
        dataArray.add(ModelHeroes("Johnson","Roaming", "Tank/Fighter","https://i.pinimg.com/originals/81/43/be/8143beeb1751c41307fef3c52c3c337c.jpg"))
        dataArray.add(ModelHeroes("Angela","Roaming", "Support","https://static.wikia.nocookie.net/mobile-legends/images/6/6b/Hero551-portrait.png/revision/latest?cb=20220525165419"))
        dataArray.add(ModelHeroes("Fanny","Jungle", "Assassin","https://static.wikia.nocookie.net/mobile-legends/images/7/7f/Hero171-portrait.png/revision/latest?cb=20220525164654"))
        dataArray.add(ModelHeroes("Moskov","Gold Lane", "Marksman","https://static.wikia.nocookie.net/mobile-legends/images/1/1d/Twilight_Dragon.jpg/revision/latest?cb=20211220013300"))
        dataArray.add(ModelHeroes("Claude","Gold Lane", "Marksman","https://asset.indosport.com/article/image/q/80/294273/hero_mobile_legends_claude-169.jpg?w=750&h=423"))
        dataArray.add(ModelHeroes("Nana","Mid Lane", "Mage/Support","https://www.ligagame.tv/images/Nana-Hero-Mobile-Legends_4f22c.jpg"))
        dataArray.add(ModelHeroes("Roger","Gold/Exp Lane", "Marksman/Fighter","https://static.wikia.nocookie.net/mobile-legends/images/0/0b/Dire_Wolf_Hunter.jpg/revision/latest?cb=20180705182702"))
        dataArray.add(ModelHeroes("Beatrix","Gold Lane", "Marksman","https://static.wikia.nocookie.net/mobile-legends/images/d/de/Hero1051-portrait.png/revision/latest?cb=20220525170412"))
        dataArray.add(ModelHeroes("Argus","Exp Lane", "Fighter","https://assets.skor.id/crop/0x0:0x0/750x500/photo/2022/05/10/1371485409.jpg"))
        dataArray.add(ModelHeroes("Tigreal","Roaming", "Tank","https://static.wikia.nocookie.net/mobile-legends/images/b/b8/Hero061-portrait.png/revision/latest?cb=20220525164412"))
        dataArray.add(ModelHeroes("Eudora","Mid Lane", "Mage","https://static.wikia.nocookie.net/mobile-legends/images/a/ab/Hero151-portrait.png/revision/latest?cb=20220525164621"))
        dataArray.add(ModelHeroes("Pharsa","Mid Lane", "Mage","https://static.wikia.nocookie.net/mobile-legends/images/1/16/Wings_of_Vengeance.jpg/revision/latest/top-crop/width/360/height/360?cb=20210601142040"))
        dataArray.add(ModelHeroes("Lesley","Gold Lane", "Marksman","https://static.wikia.nocookie.net/mobile-legends/images/f/f1/Hero531-portrait.png/revision/latest/top-crop/width/360/height/360?cb=20220525165349"))

        // Recyclerview adapter and layout configuration
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = recyclerViewAdapter
        }

        // Init Data to Adapter for Recyclerview
        recyclerViewAdapter.initData(dataArray)
    }

}