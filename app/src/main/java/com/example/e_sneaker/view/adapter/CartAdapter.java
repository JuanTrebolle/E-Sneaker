package com.example.e_sneaker.view.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.e_sneaker.R;
import com.example.e_sneaker.model.Sneaker;
import com.example.e_sneaker.repository.SneakerRepository;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private List<Sneaker> cartSneakers;
    private SneakerRepository sneakerRepository;

    public CartAdapter(List<Sneaker> sneakers) {
        this.cartSneakers = sneakers;
        sneakerRepository = SneakerRepository.getInstance();
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
        //holder.sneakerImage.setImageResource(String.valueOf(cartSneakers.get(position).getImage()));
        Glide.with(holder.itemView).load(cartSneakers.get(position).getImage()).into(holder.sneakerImage);
        holder.sneakerName.setText(cartSneakers.get(position).getModelName());
        holder.sneakerPrice.setText(String.valueOf(cartSneakers.get(position).getPrice()));

        sneakerRepository = SneakerRepository.getInstance();
        Sneaker toDelete = cartSneakers.get(position);

        holder.deleteFromCart.setOnClickListener(c -> toDeleteFromCart(c, toDelete));
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this sneaker from E-Sneaker 🔥🔥🔥");
                shareIntent.setType("text/plain");
                view.getContext().startActivity(shareIntent);
            }
        });
    }

    private void toDeleteFromCart(View view, Sneaker sneaker) {
        sneakerRepository.deleteFromCart(sneaker);
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
