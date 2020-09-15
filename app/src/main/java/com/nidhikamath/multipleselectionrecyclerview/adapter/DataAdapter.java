package com.nidhikamath.multipleselectionrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.nidhikamath.multipleselectionrecyclerview.R;
import com.nidhikamath.multipleselectionrecyclerview.model.Data;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Data> data = new ArrayList<>();

    public DataAdapter(Context context, ArrayList<Data> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int i) {

        setCheckBoxValue(holder, i);

    }

    private void setCheckBoxValue(final MyViewHolder holder, final int i) {
        holder.name.setText(data.get(i).getName());
        holder.name.setOnCheckedChangeListener(null);
        holder.name.setSelected(data.get(i).isSelected());
        holder.name.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    data.get(i).setSelected(true);
                    holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorAccent));
                    holder.name.setTextColor(context.getResources().getColor(R.color.white));
                } else {
                    data.get(i).setSelected(false);
                    holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.white));
                    holder.name.setTextColor(context.getResources().getColor(R.color.black));
                }
            }
        });

        holder.name.setChecked(data.get(i).isSelected());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CheckBox name;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }

}
