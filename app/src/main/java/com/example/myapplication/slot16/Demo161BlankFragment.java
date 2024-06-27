package com.example.myapplication.slot16;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;


public class Demo161BlankFragment extends Fragment {
    Button button;
    EditText editText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo161_blank, container, false);
        button = view.findViewById(R.id.demo161_fr1_btn1);
        editText = view.findViewById(R.id.demo161_fr1_txt1);
        //xu ly su kien
        button.setOnClickListener(v->{
            Toast.makeText(getContext(),editText.getText().toString(),Toast.LENGTH_LONG).show();
        });
        return view;
    }
}