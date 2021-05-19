package com.example.e_sneaker.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Store_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Store_Fragment extends Fragment {
    RecyclerView recyclerView;
    StoreViewModel storeViewModel;
    List<Sneaker> sneakers;
    StoreAdapter storeAdapter;

    Button addToFireListButton;
    Button addToCartButton;

    public Store_Fragment(){
        //Required empty constructor
    }

    public static Store_Fragment newInstance(/*String param1, String param2*/) {
        Store_Fragment store_fragment = new Store_Fragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        store_fragment.setArguments(args);

        return store_fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store, container, false);
        recyclerView = view.findViewById(R.id.rv_store);

        addToFireListButton = view.findViewById(R.id.addToFireList);
        addToCartButton = view.findViewById(R.id.addToCartList);

        storeViewModel.getFireSneakers().observe(getViewLifecycleOwner(), new Observer<List<Sneaker>>() {
            @Override
            public void onChanged(List<Sneaker> sneakers) {
                StoreAdapter storeAdapter = new StoreAdapter(sneakers);
                recyclerView.setAdapter(storeAdapter);
            }
        });

        //TODO: populate list sneakers
        sneakers = new ArrayList<>();
        //sneakers = storeViewModel.getAllSneakers();
        sneakers.add(new Sneaker(1234, "Nike", 120, "Nike", ""));

        //storeAdapter = new StoreAdapter(storeViewModel.getAllSneakers());
        storeAdapter = new StoreAdapter(sneakers);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, VERTICAL, false));

        recyclerView.hasFixedSize(); // Tells the recyclerView that all of the elements are gonna be the same size
        recyclerView.setAdapter(storeAdapter);

        return view;
    }
}