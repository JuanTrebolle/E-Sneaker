package com.example.e_sneaker.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.e_sneaker.R;
import com.example.e_sneaker.model.Sneaker;
import com.example.e_sneaker.repository.SneakerRepository;
import com.example.e_sneaker.view.MainActivity;
import com.example.e_sneaker.view.fragment.Store_Fragment;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {
    //private MutableLiveData<List<Sneaker>> sneakers;
    private List<Sneaker> sneakers;
    private MutableLiveData<List<Sneaker>> fireSneakersList;
    private MutableLiveData<List<Sneaker>> cartSneakersList;
    //private StoreViewModel storeViewModel;
    private SneakerRepository sneakerRepository;

    /*Constructor made so that I can pass some data from an activity and bind that data to the
    customGridLayout(in the fragment)*/
    public StoreAdapter(List<Sneaker> sneakers) {
        this.sneakers = sneakers;
        this.sneakerRepository = SneakerRepository.getInstance();

        fireSneakersList = new MutableLiveData<>();
        cartSneakersList = new MutableLiveData<>();
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
        //Glide.with(MainActivity.this).load(pokemon.getImageUrl()).into(ImageView);
        Glide.with(holder.itemView).load(sneakers.get(position).getImage()).into(holder.sneakerImage);
        holder.sneakerPrice.setText(String.valueOf("$" + sneakers.get(position).getPrice()));

        Sneaker toAdd = sneakers.get(position);

        holder.addToFireList.setOnClickListener(c -> onClickAddToFireList(c, toAdd));
        holder.addToCartList.setOnClickListener(c -> onClickAddToCart(c, toAdd));
    }

    //click on cart button
    private void onClickAddToCart(View c, Sneaker toAdd) {
        Toast.makeText(c.getContext(), "Added to Cart", Toast.LENGTH_SHORT).show();
        sneakerRepository.addToCart(toAdd);
    }

    //click on fire button
    private void onClickAddToFireList(View c, Sneaker toAdd) {
        Toast.makeText(c.getContext(), "Added to Fire list", Toast.LENGTH_SHORT).show();
        sneakerRepository.addToFireList(toAdd);
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
