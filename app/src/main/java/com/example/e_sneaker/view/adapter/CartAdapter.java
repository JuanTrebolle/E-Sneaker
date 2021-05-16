package com.example.e_sneaker.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_sneaker.R;
import com.example.e_sneaker.model.Sneaker;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private List<Sneaker> cartSneakers;

    public CartAdapter(List<Sneaker> sneakers) {
        this.cartSneakers = sneakers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.sneaker_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.sneakerImage.setImageResource(sneakers.get(position).getImage());
        holder.sneakerName.setText(cartSneakers.get(position).getModelName());
        holder.sneakerPrice.setText(String.valueOf(cartSneakers.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return cartSneakers.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView sneakerName;
        ImageView sneakerImage;
        TextView sneakerPrice;
        ImageView share;
        ImageView deleteFromCart;

        ViewHolder(View itemView){
            super(itemView);
            sneakerName = itemView.findViewById(R.id.itemName);
            sneakerImage = itemView.findViewById(R.id.itemImage);
            sneakerPrice = itemView.findViewById(R.id.itemPrice);
            share = itemView.findViewById(R.id.itemShare);
            deleteFromCart = itemView.findViewById(R.id.itemDelete);
        }
    }
}
