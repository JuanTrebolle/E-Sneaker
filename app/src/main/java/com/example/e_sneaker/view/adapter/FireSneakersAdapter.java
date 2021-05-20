package com.example.e_sneaker.view.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.e_sneaker.R;
import com.example.e_sneaker.model.Sneaker;
import com.example.e_sneaker.repository.SneakerRepository;

import java.util.List;

public class FireSneakersAdapter extends RecyclerView.Adapter<FireSneakersAdapter.ViewHolder> {
    private List<Sneaker> fireSneakers;
    SneakerRepository sneakerRepository;

    public FireSneakersAdapter(List<Sneaker> sneakers) {
            this.fireSneakers = sneakers;
            this.sneakerRepository = SneakerRepository.getInstance();
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
        //holder.sneakerImage.setImageResource(sneakers.get(position).getImage());
        holder.sneakerName.setText(fireSneakers.get(position).getModelName());
        Glide.with(holder.itemView).load(fireSneakers.get(position).getImage()).into(holder.sneakerImage);
        holder.sneakerPrice.setText("$" + Integer.toString(fireSneakers.get(position).getPrice()));

        Sneaker currentSneaker = fireSneakers.get(position);

        //click on delete button
        holder.deleteFromFire.setOnClickListener(d -> toDeleteFromFireList(d, currentSneaker));
        //click on Share button
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this sneaker from E-Sneaker 🔥🔥🔥. \nName: " + currentSneaker.getModelName() + "\nPrice: $" + currentSneaker.getPrice());
                shareIntent.setType("text/plain");
                view.getContext().startActivity(shareIntent);
            }
        });
    }

    private void toDeleteFromFireList(View view, Sneaker sneaker) {
        sneakerRepository.deleteFromFireList(sneaker);
    }

    @Override
    public int getItemCount() {
        return fireSneakers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView sneakerName;
        ImageView sneakerImage;
        TextView sneakerPrice;
        Button deleteFromFire;
        Button share;

        ViewHolder(View itemView){
            super(itemView);
            sneakerName = itemView.findViewById(R.id.itemName);
            sneakerImage = itemView.findViewById(R.id.itemImage);
            sneakerPrice = itemView.findViewById(R.id.itemPrice);
            deleteFromFire = itemView.findViewById(R.id.itemDelete);
            share = itemView.findViewById(R.id.itemShare);
        }
    }
}
