package com.example.e_sneaker.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_sneaker.R;
import com.example.e_sneaker.model.Sneaker;
import com.example.e_sneaker.view.adapter.CartAdapter;
import com.example.e_sneaker.view.adapter.StoreAdapter;
import com.example.e_sneaker.viewmodel.CartViewModel;

import java.util.ArrayList;
import java.util.List;

public class Cart_Fragment extends Fragment {
    RecyclerView recyclerView;
    List<Sneaker> sneakers;
    CartAdapter cartAdapter;
    CartViewModel cartViewModel;

    ImageView toDeleteIcon;
    ImageView toShareIcon;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Cart_Fragment() {
        // Required empty public constructor
    }

    public static Cart_Fragment newInstance(String param1, String param2) {
        Cart_Fragment fragment = new Cart_Fragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
        cartViewModel = new CartViewModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerView = view.findViewById(R.id.rv_cart);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        cartViewModel.getCartSneakersList().observe(getViewLifecycleOwner(), new Observer<List<Sneaker>>() {
            @Override
            public void onChanged(List<Sneaker> sneakers) {
                //StoreAdapter storeAdapter = new StoreAdapter(sneakers);
                //recyclerView.setAdapter(storeAdapter);
                CartAdapter cartAdapter = new CartAdapter(sneakers);
                recyclerView.setAdapter(cartAdapter);
            }
        });

        //cartAdapter = new CartAdapter(sneakers);
        //recyclerView.setAdapter(cartAdapter);
        return view;
    }
}