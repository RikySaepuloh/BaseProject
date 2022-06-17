package id.riky.baseproject.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.riky.baseproject.adapter.RecyclerViewAdapter
import id.riky.baseproject.databinding.FragmentHomeBinding


class HomeFragment : Fragment(){
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    val recyclerViewAdapter = RecyclerViewAdapter()
    val dataArray=ArrayList<String>()

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
        dataArray.add("Karrie Lapu-Lapu Johnson")
        dataArray.add("Angela Fanny Moskov")
        dataArray.add("Claude Nana Roger")
        dataArray.add("Beatrix Argus Tigreal")
        dataArray.add("Eudora Pharsa Lesley")

        // Recyclerview adapter and layout configuration
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = recyclerViewAdapter
        }

        // Init Data to Adapter for Recyclerview
        recyclerViewAdapter.initData(dataArray)
    }

}