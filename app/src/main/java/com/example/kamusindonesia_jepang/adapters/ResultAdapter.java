package com.example.kamusindonesia_jepang.adapters;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kamusindonesia_jepang.R;
import com.example.kamusindonesia_jepang.data.Result;

import java.util.ArrayList;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultHolder>
{
    private final ArrayList<Result> results = new ArrayList<>();

    @NonNull
    @Override
    public ResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        int set_layout;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (parent.getContext().toString().contains("IndToJpn"))
        {
            set_layout = R.layout.ind_to_jpn_item_list;
        }
        else
        {
            set_layout = R.layout.jpn_to_ind_item_list;
        }

        View view = inflater.inflate(set_layout, parent, false);
        return new ResultHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultHolder holder, int position)
    {
        holder.bind(results.get(position));
    }

    @Override
    public int getItemCount()
    {
        return results.size();
    }

    static class ResultHolder extends RecyclerView.ViewHolder
    {
        TextView indoTv;
        TextView romajiTv;
        TextView kanjiTv;
        TextView keteranganTv;


        public ResultHolder(@NonNull View itemView)
        {
            super(itemView);

            indoTv = itemView.findViewById(R.id.tv_indo);
            romajiTv = itemView.findViewById(R.id.tv_romaji);
            kanjiTv = itemView.findViewById(R.id.tv_kanji);
            keteranganTv = itemView.findViewById(R.id.tv_keterangan);
        }

        public void bind(Result result)
        {
            indoTv.setText(result.getIndo());
            romajiTv.setText(result.getRomaji());
            kanjiTv.setText(result.getKanji());
            keteranganTv.setText(result.getKeterangan());
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(ArrayList<Result> results)
    {
        this.results.clear();
        this.results.addAll(results);

        notifyDataSetChanged();
    }
}
