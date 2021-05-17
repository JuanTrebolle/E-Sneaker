package com.example.e_sneaker.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_sneaker.R;
import com.example.e_sneaker.model.Sneaker;
import com.example.e_sneaker.viewmodel.StoreViewModel;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {
    //private MutableLiveData<List<Sneaker>> sneakers;
    private List<Sneaker> sneakers;
    private StoreViewModel storeViewModel;

    /*Constructor made so that I can pass some data from an activity and bind that data to the
    customGridLayout(in the fragment)*/
    public StoreAdapter(/*MutableLiveData<List<Sneaker>>*/List<Sneaker> sneakers) {
        this.sneakers = sneakers;
        this.storeViewModel = new StoreViewModel();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Layout inflator that is going to bind the custom layout file to the recycler view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_grid_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sneakerName.setText(sneakers.get(position).getModelName());
        //holder.sneakerImage.setImageResource(Integer.parseInt(sneakers.get(position).getImage())); // not sure about the parse
        holder.sneakerPrice.setText(String.valueOf(sneakers.get(position).getPrice()));

        //holder.sneakerName.setText(sneakers.getValue().get(position).getModelName());
        //holder.sneakerPrice.setText((int) sneakers.getValue().get(position).getPrice());
        //holder.sneakerImage.setImageResource(sneakers.getValue().get(position).getImage().);

        //TODO: when clicking the fire, add to fireList with an observer
        //TODO: when clicking the cart, add to cartList with an observer
    }

    @Override
    public int getItemCount() {
        return sneakers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView sneakerName;
        ImageView sneakerImage;
        TextView sneakerPrice;
        Button addToFireList;
        Button addToCartList;

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
