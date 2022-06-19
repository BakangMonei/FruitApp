package com.freedmore.fruitsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder>{
    Context ctx;
    ArrayList<Fruit> fruits;

    public FruitAdapter(Context ctx, ArrayList<Fruit> fruits) {
        this.ctx = ctx;
        this.fruits = fruits;
    }

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating the item layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        //passing the view to the viewHolder
        FruitViewHolder fvh =new FruitViewHolder(v);
        return fvh;
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
        holder.txtFruitName.setText(fruits.get(position).getFruitName());
        holder.txtFruitDescription.setText(fruits.get(position).getFruitDescription());
        holder.txtFruitPrice.setText("P " + String.valueOf(fruits.get(position).getFruitPrice()));
        Picasso.get().load((int)fruits.get(position).getFruitImage()).into(holder.imgFruit);

        //implement click listener method
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedFruitPosition =holder.getBindingAdapterPosition();
                Intent detailIntent = new Intent(holder.itemView.getContext(),DetailActivity.class);
                detailIntent.putExtra("pos",selectedFruitPosition);
                holder.itemView.getContext().startActivity(detailIntent);

//                Snackbar snackbar = Snackbar.make(view,fruits.get(holder.getBindingAdapterPosition()).getFruitName().toString() +" Selected !",Snackbar.LENGTH_LONG);
//                snackbar.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public class FruitViewHolder extends RecyclerView.ViewHolder{
        TextView txtFruitName;
        TextView txtFruitDescription;
        TextView txtFruitPrice;
        ImageView imgFruit;

        public FruitViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFruitName = itemView.findViewById(R.id.idTextViewFruitName);
            txtFruitDescription = itemView.findViewById(R.id.idTextViewFruitDescription);
            txtFruitPrice = itemView.findViewById(R.id.idTextViewFruitPrice);
            imgFruit = itemView.findViewById(R.id.idImageViewFruit);
        }
    }
}
