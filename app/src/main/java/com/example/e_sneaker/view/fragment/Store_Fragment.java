package com.example.e_sneaker.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.e_sneaker.R;
import com.example.e_sneaker.view.adapter.StoreAdapter;
import com.example.e_sneaker.viewmodel.StoreViewModel;
import com.example.e_sneaker.model.Sneaker;

import java.util.ArrayList;
import java.util.List;

import static androidx.recyclerview.widget.LinearLayoutManager.VERTICAL;

public class Store_Fragment extends Fragment {
    RecyclerView recyclerView;
    StoreViewModel storeViewModel;
    MutableLiveData<List<Sneaker>> sneakers;
    StoreAdapter storeAdapter;

    //Button addToFireListButton;
    //Button addToCartButton;

    public Store_Fragment(){
        //Required empty constructor
    }

    public static Store_Fragment newInstance() {
        Store_Fragment store_fragment = new Store_Fragment();
        Bundle args = new Bundle();
        store_fragment.setArguments(args);

        return store_fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sneakers = new MutableLiveData<List<Sneaker>>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store, container, false);
        recyclerView = view.findViewById(R.id.rv_store);

        storeViewModel = new ViewModelProvider(this).get(StoreViewModel.class);

        //addToFireListButton = view.findViewById(R.id.addToFireList);
        //addToCartButton = view.findViewById(R.id.addToCartList);

        storeViewModel.getFireSneakers().observe(getViewLifecycleOwner(), new Observer<List<Sneaker>>() {
            @Override
            public void onChanged(List<Sneaker> sneakers) {
                StoreAdapter storeAdapter = new StoreAdapter(sneakers);
                recyclerView.setAdapter(storeAdapter);
            }
        });

        storeViewModel.getAllSneakers().observe(getViewLifecycleOwner(), new Observer<List<Sneaker>>() {
            @Override
            public void onChanged(List<Sneaker> sneakers) {
                StoreAdapter storeAdapter = new StoreAdapter(sneakers);
                recyclerView.setAdapter(storeAdapter);
            }
        });

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, VERTICAL, false));

        recyclerView.hasFixedSize(); // Tells the recyclerView that all of the elements are gonna be the same size
        recyclerView.setAdapter(storeAdapter);

        return view;
    }
}