package com.example.e_sneaker.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.e_sneaker.R;
import com.example.e_sneaker.model.Sneaker;
import com.example.e_sneaker.view.MainActivity;
import com.example.e_sneaker.view.adapter.FireSneakersAdapter;
import com.example.e_sneaker.view.adapter.StoreAdapter;
import com.example.e_sneaker.viewmodel.FireViewModel;

import java.util.ArrayList;
import java.util.List;

public class FireSneakers_Fragment extends Fragment {
    RecyclerView rv_fire;
    List<Sneaker> sneakers;
    FireSneakersAdapter fireSneakersAdapter;
    FireViewModel fireViewModel;

    ImageView toDeleteIcon;
    ImageView toShareIcon;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public FireSneakers_Fragment() {
        // Required empty public constructor
    }

    public static FireSneakers_Fragment newInstance(String param1, String param2) {
        FireSneakers_Fragment fragment = new FireSneakers_Fragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fire_sneakers, container, false);

        rv_fire = view.findViewById(R.id.rv_fire);
        rv_fire.hasFixedSize();
        rv_fire.setLayoutManager(new LinearLayoutManager(view.getContext()));

        fireViewModel.getFireSneakersList().observe(getViewLifecycleOwner(), new Observer<List<Sneaker>>() {
            @Override
            public void onChanged(List<Sneaker> sneakers) {
                StoreAdapter storeAdapter = new StoreAdapter(sneakers);
                rv_fire.setAdapter(storeAdapter);
            }
        });

        //TODO:populate the sneakers list
        //fireViewModel = new ViewModelProvider(this).get(FireViewModel.class);
        //fireViewModel.addToFireList();

        //sneakers = new ArrayList<>();
        //sneakers.add(new Sneaker(1234, "Nike", 120, "Nike", ""));

        fireSneakersAdapter = new FireSneakersAdapter(sneakers);
        rv_fire.setAdapter(fireSneakersAdapter);

        return view;
    }
}