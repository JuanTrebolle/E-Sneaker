package com.example.e_sneaker.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.e_sneaker.view.LoginActivity;
import com.example.e_sneaker.viewmodel.ProfileViewModel;
import com.example.e_sneaker.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profile_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile_Fragment extends Fragment {

    EditText profileEmail;
    EditText profileName;
    Button logoutButton;
    ProfileViewModel profileViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Profile_Fragment() {
        // Required empty public constructor
    }

    public static Profile_Fragment newInstance(String param1, String param2) {
        Profile_Fragment fragment = new Profile_Fragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        //Set email to user email
        profileEmail = view.findViewById(R.id.profileEmail);
        profileEmail.setText(profileViewModel.getUserEmail());

        //TODO: set name to username -> PROBABLY NOT GOING TO DO
        //profileName = view.findViewById(R.id.profileName);

        logoutButton = view.findViewById(R.id.logOutButton);
        logoutButton.setOnClickListener((v -> signOut(v)));

        return view;
    }

    public void signOut(View view) {
        //Should I checkIfSignedIn first??
        profileViewModel.signOut();
        Intent intent = new Intent(getContext(), LoginActivity.class);
        Objects.requireNonNull(getContext()).startActivity(intent);
    }
}