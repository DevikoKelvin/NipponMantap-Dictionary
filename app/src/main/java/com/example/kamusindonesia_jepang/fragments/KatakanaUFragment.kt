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
import com.example.kamusindonesia_jepang.adapters.HurufAdapter
import com.example.kamusindonesia_jepang.data.HurufEntity
import com.example.kamusindonesia_jepang.databinding.FragmentKatakanaABinding
import com.example.kamusindonesia_jepang.databinding.FragmentKatakanaIBinding
import com.example.kamusindonesia_jepang.databinding.FragmentKatakanaUBinding
import com.example.kamusindonesia_jepang.viewmodel.MainViewModel


class KatakanaUFragment : Fragment() , ItemCallback {

    private lateinit var binding: FragmentKatakanaUBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentKatakanaUBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null)
        {
            val viewModel = ViewModelProvider(this)
                .get(MainViewModel(activity!!.application)::class.java)

            val data = viewModel.getListKatakanaU()

            val adapter = HurufAdapter(this)
            adapter.setData(data)

            with(binding.rvKatakanaU){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }
    override fun onItemClicked(data: HurufEntity) {
        Toast.makeText(activity, " "+data.description, Toast.LENGTH_SHORT).show()
    }

}