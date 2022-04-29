package com.example.kamusindonesia_jepang.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kamusindonesia_jepang.ItemCallback
import com.example.kamusindonesia_jepang.adapters.HiraganaAdapter
import com.example.kamusindonesia_jepang.data.HiraganaEntity
import com.example.kamusindonesia_jepang.databinding.FragmentHiraganaIBinding
import com.example.kamusindonesia_jepang.viewmodel.MainViewModel


class HiraganaIFragment : Fragment(), ItemCallback {

    private lateinit var binding: FragmentHiraganaIBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHiraganaIBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null)
        {
            val viewModel = ViewModelProvider(this)
                .get(MainViewModel(activity!!.application)::class.java)

            val data = viewModel.getListHiraganaI()

            val adapter = HiraganaAdapter(this)
            adapter.setData(data)

            with(binding.rvHiraganaI){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }
    override fun onItemClicked(data: HiraganaEntity) {
        Toast.makeText(activity, " "+data.description, Toast.LENGTH_SHORT).show()
    }

}