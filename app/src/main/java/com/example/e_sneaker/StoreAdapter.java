package com.example.e_sneaker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {
    List<Sneaker> sneakers;
    Context context;

    /*Constructor made so that I can pass some data from an activity and bind that data to the
    customGridLayout(in the fragment)*/
    public StoreAdapter(Context ctx, List<Sneaker> sneakers) {
        this.sneakers = sneakers;
        this.context = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Layout inflator that is going to bind the custom layout file to the recycler view
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.custom_grid_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sneakerName.setText(sneakers.get(position).getModelName());
        holder.sneakerImage.setImageResource(sneakers.get(position).getImage());
        holder.sneakerPrice.setText((int) sneakers.get(position).getPrice());

        //TODO: when clicking the fire, add to fireList
        // TODO: when clicking the cart, add to cartList
    }

    @Override
    public int getItemCount() {
        return sneakers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView sneakerName;
        ImageView sneakerImage;
        TextView sneakerPrice;
        ImageView addToFireList;
        ImageView addToCartList;

        ViewHolder(View itemView){
            super(itemView);
            sneakerName = itemView.findViewById(R.id.sneakerName);
            sneakerImage = itemView.findViewById(R.id.sneakerImage);
            sneakerPrice = itemView.findViewById(R.id.sneakerPrice);
            addToFireList = itemView.findViewById(R.id.addToFireList);
            addToCartList = itemView.findViewById(R.id.addToCartList);
        }
    }
}
