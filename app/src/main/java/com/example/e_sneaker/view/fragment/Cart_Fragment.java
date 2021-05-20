package com.example.e_sneaker.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_sneaker.R;
import com.example.e_sneaker.model.Sneaker;
import com.example.e_sneaker.view.adapter.CartAdapter;
import com.example.e_sneaker.viewmodel.CartViewModel;

import java.util.List;

import static androidx.recyclerview.widget.LinearLayoutManager.VERTICAL;

public class Cart_Fragment extends Fragment {
    RecyclerView recyclerView;
    MutableLiveData<List<Sneaker>> cartSneakers;
    CartAdapter cartAdapter;
    CartViewModel cartViewModel;

    public Cart_Fragment() {
        // Required empty public constructor
    }

    public static Cart_Fragment newInstance(String param1, String param2) {
        Cart_Fragment fragment = new Cart_Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cartSneakers = new MutableLiveData<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        recyclerView = view.findViewById(R.id.rv_cart);
        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);

        cartViewModel.getCartSneakersList().observe(getViewLifecycleOwner(), new Observer<List<Sneaker>>() {
            @Override
            public void onChanged(List<Sneaker> sneakers) {
                CartAdapter cartAdapter = new CartAdapter(sneakers);
                recyclerView.setAdapter(cartAdapter);
            }
        });

        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, VERTICAL, false));
        recyclerView.setAdapter(cartAdapter);

        return view;
    }
}