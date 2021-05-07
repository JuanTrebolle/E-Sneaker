package com.example.e_sneaker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FireSneakersAdapter extends RecyclerView.Adapter<FireSneakersAdapter.ViewHolder> {
    private List<Sneaker> sneakers;

    public FireSneakersAdapter(List<Sneaker> sneakers) {
        this.sneakers = sneakers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.sneaker_list_item, parent, false);
        return new FireSneakersAdapter.ViewHolder(view);
    }

    //Binds the data to the view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sneakerImage.setImageResource(sneakers.get(position).getImage());
        holder.sneakerName.setText(sneakers.get(position).getModelName());
        holder.sneakerPrice.setText((int) sneakers.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return sneakers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView sneakerName;
        ImageView sneakerImage;
        TextView sneakerPrice;
        Button deleteFromFire;

        ViewHolder(View itemView){
            super(itemView);
            sneakerName = itemView.findViewById(R.id.sneakerName);
            sneakerImage = itemView.findViewById(R.id.sneakerImage);
            sneakerPrice = itemView.findViewById(R.id.sneakerPrice);
            deleteFromFire = itemView.findViewById(R.id.itemDeleteFromFire);
        }
    }
}
