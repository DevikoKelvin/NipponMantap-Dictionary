package com.example.kamusindonesia_jepang.adapters;

import android.annotation.SuppressLint;
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
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.ind_to_jpn_item_list, parent, false);

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
        TextView wordTv;
        TextView translateTv;
        TextView descTv;

        public ResultHolder(@NonNull View itemView)
        {
            super(itemView);

            wordTv = itemView.findViewById(R.id.tv_word);
            translateTv = itemView.findViewById(R.id.tv_translate);
            descTv = itemView.findViewById(R.id.tv_description);
        }

        public void bind(Result result)
        {
            wordTv.setText(result.getWord());
            translateTv.setText(result.getTranslate());
            descTv.setText(result.getDesc());
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
