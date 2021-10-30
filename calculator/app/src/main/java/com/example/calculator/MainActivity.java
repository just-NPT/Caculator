package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    String curr, res ;
    Boolean dot_status,op_status;

    private EditText calculation,result;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnMul;
    private Button btnDiv;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnDot;
    private ImageButton btnDel;
    private Button btnClear;
    private Button btnCE;
    private Button btnEqual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation =(EditText) findViewById(R.id.calculation);
        result =(EditText) findViewById(R.id.result);

        curr ="";
        res = "";
        dot_status = false;
        op_status = false;

        btn0 =(Button) findViewById(R.id.Zero);
        btn1 =(Button) findViewById(R.id.One);
        btn2 =(Button) findViewById(R.id.Two);
        btn3 =(Button) findViewById(R.id.Three);
        btn4 =(Button) findViewById(R.id.Four);
        btn5 =(Button) findViewById(R.id.Five);
        btn6 =(Button) findViewById(R.id.Six);
        btn7 =(Button) findViewById(R.id.Seven);
        btn8 =(Button) findViewById(R.id.Eight);
        btn9 =(Button) findViewById(R.id.Nine);
        btnMul =(Button) findViewById(R.id.MultiBTN);
        btnDiv =(Button) findViewById(R.id.DivBTN);
        btnPlus =(Button) findViewById(R.id.PlusBTN);
        btnMinus =(Button) findViewById(R.id.MinusBTN);
        btnDot =(Button) findViewById(R.id.Dot);
        btnDel = (ImageButton) findViewById(R.id.back_space);
        btnClear =(Button) findViewById(R.id.Clear);
        btnCE =(Button) findViewById(R.id.Clear_EntryBTN);
        btnEqual = (Button) findViewById(R.id.Equal);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "0";
                DisplayOne(curr);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "1";
                DisplayOne(curr);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "2";
                DisplayOne(curr);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "3";
                DisplayOne(curr);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "4";
                DisplayOne(curr);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "5";
                DisplayOne(curr);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "6";
                DisplayOne(curr);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "7";
                DisplayOne(curr);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "8";
                DisplayOne(curr);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "9";
                DisplayOne(curr);
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!dot_status){
                    curr = curr + ".";
                    dot_status = true;
                    DisplayOne(curr);
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curr.charAt(curr.length() - 1) == '.'){
                    curr = curr.substring(0,curr.length()-1);
                }
                if (!op_status){
                    curr = curr + " - ";
                    DisplayOne(curr);
                    op_status = true;
                }
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curr.charAt(curr.length() - 1) == '.'){
                    curr = curr.substring(0,curr.length()-1);
                }
                if (!op_status){
                    curr = curr + " + ";
                    DisplayOne(curr);
                    op_status = true;
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curr.charAt(curr.length() - 1) == '.'){
                    curr = curr.substring(0,curr.length()-1);
                }
                if (!op_status){
                    curr = curr + " / ";
                    DisplayOne(curr);
                    op_status = true;
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curr.charAt(curr.length() - 1) == '.'){
                    curr = curr.substring(0,curr.length()-1);
                }
                if (!op_status){
                    curr = curr + " * ";
                    DisplayOne(curr);
                    op_status = true;
                }
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backSpace();
                DisplayOne(curr);
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(op_status && curr.charAt(curr.length()-1) != ' '){
                    String[] Tokens = curr.split(" ");
                    switch (Tokens[1].charAt(0)){
                        case '+':
                            res = Double.toString(Double.parseDouble(Tokens[0]) + Double.parseDouble(Tokens[2]));
                            break;
                        case '-':
                            res = Double.toString(Double.parseDouble(Tokens[0]) - Double.parseDouble(Tokens[2]));
                            break;
                        case '*':
                            res = Double.toString(Double.parseDouble(Tokens[0]) * Double.parseDouble(Tokens[2]));
                            break;
                        case '/':
                            res = Double.toString(Double.parseDouble(Tokens[0]) / Double.parseDouble(Tokens[2]));
                            break;
                    }
                    DisplayTwo(res);
                }
            }
        });
    }

    public void DisplayOne(String s){
        calculation.setText(s);
    }

    public void DisplayTwo(String s){
        result.setText(s);
    }

    public void backSpace(){
        if(!curr.isEmpty()){
            if(curr.charAt(curr.length()-1) == '.'){
                dot_status = false;
            }
            if(curr.charAt(curr.length()-1) == ' '){
                op_status = false;
                curr=curr.substring(0,curr.length()-3);
            }else curr = curr.substring(0,curr.length()-1);
        }
    }
}