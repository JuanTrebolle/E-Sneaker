package com.example.e_sneaker.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_sneaker.R;
import com.example.e_sneaker.model.Sneaker;
import com.example.e_sneaker.view.adapter.FireSneakersAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FireSneakers_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FireSneakers_Fragment extends Fragment {
    RecyclerView rv_fire;
    List<Sneaker> sneakers;
    FireSneakersAdapter fireSneakersAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FireSneakers_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FireSneakersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FireSneakers_Fragment newInstance(String param1, String param2) {
        FireSneakers_Fragment fragment = new FireSneakers_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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

        //TODO:populate the sneakers list

        sneakers = new ArrayList<>();
        sneakers.add(new Sneaker(1234, "Nike", 120, "Nike", ""));

        fireSneakersAdapter = new FireSneakersAdapter(sneakers);
        rv_fire.setAdapter(fireSneakersAdapter);

        return view;
    }
}