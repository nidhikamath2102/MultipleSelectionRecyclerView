package com.nidhikamath.multipleselectionrecyclerview;

import android.os.Bundle;

import com.nidhikamath.multipleselectionrecyclerview.adapter.DataAdapter;
import com.nidhikamath.multipleselectionrecyclerview.model.Data;
import com.nidhikamath.multipleselectionrecyclerview.model.DataArray;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private DataAdapter dataAdapter;
    public ArrayList<Data> datas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);

        for(int i = 0; i< DataArray.name.length; i++){
            datas.add(new Data(DataArray.name[i]));
        }

        dataAdapter = new DataAdapter(MainActivity.this, datas);
        recyclerView.setAdapter(dataAdapter);

    }
}