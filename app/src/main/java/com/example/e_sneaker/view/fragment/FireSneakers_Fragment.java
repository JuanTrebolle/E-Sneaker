package com.example.e_sneaker.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.e_sneaker.R;
import com.example.e_sneaker.model.Sneaker;
import com.example.e_sneaker.view.adapter.FireSneakersAdapter;
import com.example.e_sneaker.viewmodel.FireViewModel;

import java.util.List;

import static androidx.recyclerview.widget.LinearLayoutManager.VERTICAL;

public class FireSneakers_Fragment extends Fragment {
    RecyclerView rv_fire;
    MutableLiveData<List<Sneaker>> fireSneakers;
    FireSneakersAdapter fireSneakersAdapter;
    FireViewModel fireViewModel;

    public FireSneakers_Fragment() {
        // Required empty public constructor
    }

    public static FireSneakers_Fragment newInstance(String param1, String param2) {
        FireSneakers_Fragment fragment = new FireSneakers_Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //fireViewModel = new FireViewModel();
        fireSneakers = new MutableLiveData<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fire_sneakers, container, false);
        rv_fire = view.findViewById(R.id.rv_fire);

        fireViewModel = new ViewModelProvider(this).get(FireViewModel.class);

        fireViewModel.getFireSneakersList().observe(getViewLifecycleOwner(), new Observer<List<Sneaker>>() {
            @Override
            public void onChanged(List<Sneaker> sneakers) {
                FireSneakersAdapter fireSneakersAdapter = new FireSneakersAdapter(sneakers);
                rv_fire.setAdapter(fireSneakersAdapter);
            }
        });

        rv_fire.setLayoutManager(new GridLayoutManager(getContext(), 1, VERTICAL, false));
        rv_fire.hasFixedSize();
        rv_fire.setAdapter(fireSneakersAdapter);

        return view;
    }
}