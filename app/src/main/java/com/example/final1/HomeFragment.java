package com.example.final1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment{
    public static List<ProductModel> listDeclare;
    RecyclerView lvContact;
    CustomAdapter customAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_trangchu, container, false);

        lvContact = (RecyclerView) view.findViewById(R.id.rcvItem);

        listDeclare = new ArrayList<>();

        getDeclares();
        customAdapter = new CustomAdapter(getContext(), listDeclare);
        lvContact.setLayoutManager(new LinearLayoutManager(getContext()));
        lvContact.setAdapter(customAdapter);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void getDeclares() {
        ApiService.apiService.getProduct().enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                listDeclare = response.body();
                customAdapter = new CustomAdapter(getContext(), listDeclare);
                lvContact.setLayoutManager(new LinearLayoutManager(getContext()));
                lvContact.setAdapter(customAdapter);
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Err", Toast.LENGTH_SHORT).show();
            }
        });
    }




}
