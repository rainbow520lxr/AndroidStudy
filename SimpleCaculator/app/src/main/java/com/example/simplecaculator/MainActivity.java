package com.example.simplecaculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.googlecode.aviator.AviatorEvaluator;

public class MainActivity extends AppCompatActivity {

    private TextView tv_exp;
    private TextView tv_res;
    private String exp;
    private String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_exp = findViewById(R.id.tv_exp);
        tv_res = findViewById(R.id.tv_res);
        exp = "";
        res = "";
    }

    public void numClick(View view) {
        if(!res.equals("")){
            Log.d("MainActivity", "res = "+res);
            exp = "";
            res = "";
            tv_exp.setText(exp);
            tv_res.setText(res);
        }else Log.d("MainActivity", "res = null");
        Button btn = findViewById(view.getId());
        exp = exp + btn.getText();
        tv_exp.setText(exp);
    }

    public void equalClick(View view) {
        Log.d("MainActivity", "exp = "+exp);
        if(exp.equals("")) Toast.makeText(getApplicationContext(), "请先输入表达式!", Toast.LENGTH_SHORT).show();
        try {
            Log.d("MainActivity", "res.type = "+AviatorEvaluator.execute(exp).getClass().getSimpleName());
            res = AviatorEvaluator.execute(exp).toString();
        }catch (Exception e){
            Log.d("MainActivity", "exp_exception : " + e.getMessage());
            Toast.makeText(getApplicationContext(), "请输入正确的表达式!", Toast.LENGTH_SHORT).show();
        }
        tv_res.setText(res);
    }

    public void clearClick(View view) {
        exp = "";
        res = "";
        tv_exp.setText(exp);
        tv_res.setText(res);
    }


}