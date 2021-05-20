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

public class Profile_Fragment extends Fragment {

    EditText profileEmail;
    Button logoutButton;
    ProfileViewModel profileViewModel;

    public Profile_Fragment() {
        // Required empty public constructor
    }

    public static Profile_Fragment newInstance() {
        Profile_Fragment fragment = new Profile_Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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