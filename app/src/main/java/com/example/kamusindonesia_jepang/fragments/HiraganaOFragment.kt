package com.example.kamusindonesia_jepang.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kamusindonesia_jepang.ItemCallback
import com.example.kamusindonesia_jepang.R
import com.example.kamusindonesia_jepang.adapters.HiraganaAdapter
import com.example.kamusindonesia_jepang.data.HiraganaEntity
import com.example.kamusindonesia_jepang.databinding.FragmentHiraganaOBinding
import com.example.kamusindonesia_jepang.databinding.FragmentHiraganaUBinding
import com.example.kamusindonesia_jepang.viewmodel.MainViewModel


class HiraganaOFragment : Fragment() , ItemCallback {

    private lateinit var binding: FragmentHiraganaOBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHiraganaOBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null)
        {
            val viewModel = ViewModelProvider(this)
                .get(MainViewModel(activity!!.application)::class.java)

            val data = viewModel.getListHiraganaO()

            val adapter = HiraganaAdapter(this)
            adapter.setData(data)

            with(binding.rvHiraganaO){
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