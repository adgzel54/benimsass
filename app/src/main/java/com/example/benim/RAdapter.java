package com.example.benim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RAdapter extends RecyclerView.Adapter <RAdapter.RowHolder>{
    private ArrayList<KriptoModel> kriptoModelArrayList;

    public RAdapter(ArrayList<KriptoModel> kriptoModelArrayList) {
        this.kriptoModelArrayList = kriptoModelArrayList;
    }



    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout,parent,false);
        return new RowHolder(view);

     }



    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RAdapter.RowHolder holder, int position) {

        holder.bind(kriptoModelArrayList.get(position),position);
     }

    @Override
    public int getItemCount() {return kriptoModelArrayList.size();

    }

    public class RowHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        public RowHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {

            super(itemView);
        }
        public void bind(KriptoModel model, Integer position) {
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
            textView4 = itemView.findViewById(R.id.textView4);
            textView.setText(KriptoModel.userId);
            textView2.setText(KriptoModel.id);
            textView3.setText(KriptoModel.title);
            textView4.setText(KriptoModel.body);


        }

    }
}
