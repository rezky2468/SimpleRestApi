package com.example.restapi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.sql.Struct;

public class TransaksiFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaksi, container, false);
        // do something with the view

        Button button = view.findViewById(R.id.tambah_button);
        EditText obat = view.findViewById(R.id.pilih_obat_edit_text);
        EditText jenisObat = view.findViewById(R.id.pilih_jenis_obat_edit_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), StrukActivity.class);
                startActivity(intent);
            }
        });

        obat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showModalBottomSheet();
            }
        });

        return view;
    }

    private void showModalBottomSheet() {
        // Create a new instance of the bottom sheet dialog
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());

        // Set the layout for the bottom sheet
        View bottomSheetView = getLayoutInflater().inflate(R.layout.layout_bottom_sheet, null);
        bottomSheetDialog.setContentView(bottomSheetView);

        // Show the bottom sheet
        bottomSheetDialog.show();
    }


}


