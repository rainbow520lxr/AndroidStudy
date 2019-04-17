package com.example.mortgagecalculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import org.xml.sax.Parser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Spinner category;
    private Spinner type;
    private Spinner mortgagePercentage;
    private Spinner mortgageYear;
    private Spinner interestRate;
    private Spinner commercialInterestRate;
    private Spinner providentFundRate;
    private ArrayAdapter<CharSequence> categoryAdapter;
    private ArrayAdapter<CharSequence> typeAdapter;
    private ArrayAdapter<CharSequence> mortgagePercentageAdapter;
    private ArrayAdapter<CharSequence> mortgageYearAdapter;
    private ArrayAdapter<CharSequence> interestRateAdapter;
    private ArrayAdapter<CharSequence> commercialInterestRateAdapter;
    private ArrayAdapter<CharSequence> providentFundRateAdapter;
    private LinearLayout categoryLayout;   //贷款类别
    private LinearLayout typeLayout;        //计算方式
    private LinearLayout loanAmountLayout;  //商业贷款额
    private LinearLayout housePriceLayout;  //房屋单价
    private LinearLayout totalLoanLayout;   //贷款总额
    private LinearLayout commercialInterestRateLayout;  //商代利率
    private LinearLayout houseSpaceLayout;  //房屋面积
    private LinearLayout providentFundLoanLayout;   //公积金贷款额
    private LinearLayout mortgagePercentageLayout;  //按揭成数
    private LinearLayout providentFundRateLayout;   //公积金利率
    private LinearLayout mortgageYearLayout;    //按揭年数
    private LinearLayout interestRateLayout;    //贷款利率
    private View divider1;
    private View divider2;
    private View divider3;
    private View divider4;
    private View divider5;
    private View divider6;
    private View divider7;
    private EditText interestRateText;
    private EditText commercialInterestRateText;
    private EditText providentFundRateText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取下拉列表框
        category = findViewById(R.id.category);
        type = findViewById(R.id.type);
        mortgagePercentage = findViewById(R.id.mortgage_percentage);
        mortgageYear = findViewById(R.id.mortgage_year);
        interestRate = findViewById(R.id.interest_rate);
        commercialInterestRate = findViewById(R.id.commercial_interest_rate);
        providentFundRate = findViewById(R.id.provident_fund_rate);

        categoryAdapter = ArrayAdapter.createFromResource(this,R.array.category_item,R.layout.my_spinner);
        typeAdapter = ArrayAdapter.createFromResource(this,R.array.type_item,R.layout.my_spinner);
        mortgagePercentageAdapter = ArrayAdapter.createFromResource(this,R.array.mortgage_percentage_item,R.layout.my_spinner);
        mortgageYearAdapter = ArrayAdapter.createFromResource(this,R.array.mortgage_year_item,R.layout.my_spinner);

        interestRateAdapter = ArrayAdapter.createFromResource(this,R.array.interest_rate_item,R.layout.my_spinner);
        commercialInterestRateAdapter = ArrayAdapter.createFromResource(this,R.array.interest_rate_item,R.layout.my_spinner);
        providentFundRateAdapter = ArrayAdapter.createFromResource(this,R.array.interest_rate_item,R.layout.my_spinner);

        category.setAdapter(categoryAdapter);
        type.setAdapter(typeAdapter);
        mortgagePercentage.setAdapter(mortgagePercentageAdapter);
        mortgageYear.setAdapter(mortgageYearAdapter);
        interestRate.setAdapter(interestRateAdapter);
        commercialInterestRate.setAdapter(commercialInterestRateAdapter);
        providentFundRate.setAdapter(providentFundRateAdapter);

        //初始化Layout
        categoryLayout = findViewById(R.id.category_layout);
        divider1 = new View(this);
        typeLayout = findViewById(R.id.type_layout);
        loanAmountLayout = findViewById(R.id.loan_amount_layout);
        divider2 = new View(this);
        housePriceLayout = findViewById(R.id.house_price_layout);
        totalLoanLayout = findViewById(R.id.total_loan_layout);
        commercialInterestRateLayout = findViewById(R.id.commercial_interest_rate_layout);
        divider3 = new View(this);
        houseSpaceLayout = findViewById(R.id.house_space_layout);
        providentFundLoanLayout = findViewById(R.id.provident_fund_loan_layout);
        divider4 = new View(this);
        mortgagePercentageLayout = findViewById(R.id.mortgage_percentage_layout);
        providentFundRateLayout = findViewById(R.id.provident_fund_rate_layout);
        divider5 = new View(this);
        mortgageYearLayout = findViewById(R.id.mortgage_year_layout);
        divider6 = new View(this);
        interestRateLayout = findViewById(R.id.interest_rate_layout);
        divider7 = new View(this);

        //初始化editText
        interestRateText = findViewById(R.id.interest_rate_text);
        commercialInterestRateText = findViewById(R.id.commercial_interest_rate_text);
        providentFundRateText = findViewById(R.id.provident_fund_rate_text);



        //设置监听事件
        //贷款类别监听
        category.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(category.getSelectedItemPosition()==0||category.getSelectedItemPosition()==1){
                    divider1.setVisibility(View.VISIBLE);
                    typeLayout.setVisibility(View.VISIBLE);
                    loanAmountLayout.setVisibility(View.GONE);
                    divider2.setVisibility(View.VISIBLE);
                    housePriceLayout.setVisibility(View.VISIBLE);
                    totalLoanLayout.setVisibility(View.GONE);
                    commercialInterestRateLayout.setVisibility(View.GONE);
                    divider3.setVisibility(View.VISIBLE);
                    houseSpaceLayout.setVisibility(View.VISIBLE);
                    providentFundLoanLayout.setVisibility(View.GONE);
                    divider4.setVisibility(View.VISIBLE);
                    mortgagePercentageLayout.setVisibility(View.VISIBLE);
                    providentFundRateLayout.setVisibility(View.GONE);
                    divider5.setVisibility(View.VISIBLE);
                    mortgageYearLayout.setVisibility(View.VISIBLE);
                    divider6.setVisibility(View.VISIBLE);
                    interestRateLayout.setVisibility(View.VISIBLE);
                    divider7.setVisibility(View.VISIBLE);


                }else{
                    divider1.setVisibility(View.VISIBLE);
                    typeLayout.setVisibility(View.GONE);
                    loanAmountLayout.setVisibility(View.VISIBLE);
                    divider2.setVisibility(View.VISIBLE);
                    housePriceLayout.setVisibility(View.GONE);
                    totalLoanLayout.setVisibility(View.GONE);
                    commercialInterestRateLayout.setVisibility(View.VISIBLE);
                    divider3.setVisibility(View.VISIBLE);
                    houseSpaceLayout.setVisibility(View.GONE);
                    providentFundLoanLayout.setVisibility(View.VISIBLE);
                    divider4.setVisibility(View.VISIBLE);
                    mortgagePercentageLayout.setVisibility(View.GONE);
                    providentFundRateLayout.setVisibility(View.VISIBLE);
                    divider5.setVisibility(View.VISIBLE);
                    mortgageYearLayout.setVisibility(View.VISIBLE);
                    divider6.setVisibility(View.VISIBLE);
                    interestRateLayout.setVisibility(View.GONE);
                    divider7.setVisibility(View.GONE);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //计算种类监听
        type.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(type.getSelectedItemPosition()==0) {
                    divider1.setVisibility(View.VISIBLE);
                    loanAmountLayout.setVisibility(View.GONE);
                    divider2.setVisibility(View.VISIBLE);
                    housePriceLayout.setVisibility(View.VISIBLE);
                    totalLoanLayout.setVisibility(View.GONE);
                    commercialInterestRateLayout.setVisibility(View.GONE);
                    divider3.setVisibility(View.VISIBLE);
                    houseSpaceLayout.setVisibility(View.VISIBLE);
                    providentFundLoanLayout.setVisibility(View.GONE);
                    divider4.setVisibility(View.VISIBLE);
                    mortgagePercentageLayout.setVisibility(View.VISIBLE);
                    providentFundRateLayout.setVisibility(View.GONE);
                    divider5.setVisibility(View.VISIBLE);
                    mortgageYearLayout.setVisibility(View.VISIBLE);
                    divider6.setVisibility(View.VISIBLE);
                    interestRateLayout.setVisibility(View.VISIBLE);
                    divider7.setVisibility(View.VISIBLE);
                }else {
                    divider1.setVisibility(View.VISIBLE);
                    loanAmountLayout.setVisibility(View.GONE);
                    divider2.setVisibility(View.VISIBLE);
                    housePriceLayout.setVisibility(View.GONE);
                    totalLoanLayout.setVisibility(View.VISIBLE);
                    commercialInterestRateLayout.setVisibility(View.GONE);
                    divider3.setVisibility(View.VISIBLE);
                    houseSpaceLayout.setVisibility(View.GONE);
                    providentFundLoanLayout.setVisibility(View.GONE);
                    divider4.setVisibility(View.GONE);
                    mortgagePercentageLayout.setVisibility(View.GONE);
                    providentFundRateLayout.setVisibility(View.GONE);
                    divider5.setVisibility(View.GONE);
                    mortgageYearLayout.setVisibility(View.VISIBLE);
                    divider6.setVisibility(View.VISIBLE);
                    interestRateLayout.setVisibility(View.VISIBLE);
                    divider7.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //贷款利率监听
        interestRate.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("贷款类别｜计算种类", category.getSelectedItemPosition()+"|"+type.getSelectedItemPosition());
                if(interestRate.getSelectedItemPosition()==0&&category.getSelectedItemPosition()==0){
                    interestRateText.setText("4.9");
                }else if(interestRate.getSelectedItemPosition()==0&&category.getSelectedItemPosition()==1){
                    interestRateText.setText("3.25");
                }else{
                    Pattern pattern = Pattern.compile("[0-9.]+");
                    Matcher matcher = pattern.matcher(interestRate.getSelectedItem().toString());
                    BigDecimal num = new BigDecimal(matcher.group(0));
                    BigDecimal base = new BigDecimal(interestRateText.getText().toString());
                    BigDecimal res = base.multiply(base);
                    interestRateText.setText(res.toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                if(interestRate.getSelectedItemPosition()==0&&category.getSelectedItemPosition()==0){
                    interestRateText.setText("4.9");
                }else if(interestRate.getSelectedItemPosition()==0&&category.getSelectedItemPosition()==1) {
                    interestRateText.setText("3.25");
                }
            }
        });

        //商贷利率监听
        //公积金贷款利率监听


    }

    //开始计算
    public void onClickBtn1(View view) {
        if(category.getSelectedItemPosition()==0||category.getSelectedItemPosition()==1){






        }

    }

    //清空
    public void onClickBtn2(View view) {

    }
}
