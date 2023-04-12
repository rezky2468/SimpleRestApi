package com.example.restapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        // do something with the view

        TextView usernameTextView = view.findViewById(R.id.username_text_view);
        TextView alamatTextView = view.findViewById(R.id.alamat_text_view);

        Intent intent = getActivity().getIntent();

        String username = intent.getStringExtra("username");
        String alamat = intent.getStringExtra("alamat");
        
        usernameTextView.setText(username);
        alamatTextView.setText(alamat);

        return view;
    }

}
