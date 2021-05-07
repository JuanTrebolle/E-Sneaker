package com.example.e_sneaker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    List<Sneaker> sneakers;
    StoreAdapter storeAdapter;

    public Store_Fragment(){
        //Required empty constructor
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment StoreFragment.
     */
    // TODO: Rename and change types and number of parameters
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

        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store, container, false);
        recyclerView = view.findViewById(R.id.rv_store);

        //TODO: populate list sneakers
        sneakers = new ArrayList<>();

        storeAdapter = new StoreAdapter(sneakers);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, VERTICAL, false));
        recyclerView.hasFixedSize(); // Tells the recyclerView that all of the elements are gonna be the same size
        recyclerView.setAdapter(storeAdapter);

        return view;
    }
}