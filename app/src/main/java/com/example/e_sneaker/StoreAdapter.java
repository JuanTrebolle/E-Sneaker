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
    List<String> sneakerNames;
    List<Integer> sneakerImages; //not sure what type the list should be with images yet
    Context context;
    LayoutInflater inflater;

    /*Constructor made so that I can pass some data from an activity and bind that data to the
    customGridLayout(in the fragment)*/

    public StoreAdapter(Context ctx, List<String> names, List<Integer> images) {
        this.sneakerNames = names;
        this.sneakerImages = images;
        this.context = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Layout inflator that is going to bind the custom layout file to the recycler view
        this.inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.custom_grid_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sneakerName.setText(sneakerNames.get(position));
        holder.sneakerImage.setImageResource(sneakerImages.get(position));
    }

    @Override
    public int getItemCount() {
        return sneakerNames.size();
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
