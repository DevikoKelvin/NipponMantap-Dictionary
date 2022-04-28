package com.example.kamusindonesia_jepang.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kamusindonesia_jepang.ItemCallback
import com.example.kamusindonesia_jepang.adapter.HiraganaAdapter
import com.example.kamusindonesia_jepang.data.HiraganaEntity
import com.example.kamusindonesia_jepang.databinding.FragmentHiraganaABinding
import com.example.kamusindonesia_jepang.viewmodel.MainViewModel


class HiraganaAFragment : Fragment(), ItemCallback {

    private lateinit var binding: FragmentHiraganaABinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHiraganaABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null)
        {
            val viewModel = ViewModelProvider(this)
                .get(MainViewModel(activity!!.application)::class.java)

            val data = viewModel.getListHiraganaA()

            val adapter = HiraganaAdapter(this)
            adapter.setData(data)

            with(binding.rvHiraganaA){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }
    override fun onItemClicked(data: HiraganaEntity) {
        Toast.makeText(activity, " "+data.id, Toast.LENGTH_SHORT).show()
    }

}