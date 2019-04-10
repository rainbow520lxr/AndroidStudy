package com.example.mortgagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner category;
    private Spinner type;
    private ArrayAdapter<CharSequence> categoryAdapter;
    private ArrayAdapter<CharSequence> typeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取下拉列表框
        category = findViewById(R.id.category);
        type = findViewById(R.id.type);
        categoryAdapter = ArrayAdapter.createFromResource(this,R.array.category_item,android.R.layout.simple_list_item_1);
        typeAdapter = ArrayAdapter.createFromResource(this,R.array.type_item,android.R.layout.simple_list_item_1);
        category.setAdapter(categoryAdapter);
        type.setAdapter(typeAdapter);


    }
}
