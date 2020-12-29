package com.example.basicui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener {

    int state = 1;  // trang thai: 1 - nhap toan hang 1, 2 - nhap toan hang 2
    int op1, op2;   // toan hang
    int op = 0;     // toan tu, 1 - ADD, 2 - SUB, 3 - MUL, 4 - DIV

    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        textResult = findViewById(R.id.text_result);

        findViewById(R.id.btn_0).setOnClickListener(this);
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
        findViewById(R.id.btn_4).setOnClickListener(this);
        findViewById(R.id.btn_5).setOnClickListener(this);
        findViewById(R.id.btn_6).setOnClickListener(this);
        findViewById(R.id.btn_7).setOnClickListener(this);
        findViewById(R.id.btn_8).setOnClickListener(this);
        findViewById(R.id.btn_9).setOnClickListener(this);

        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_sub).setOnClickListener(this);
        findViewById(R.id.btn_mul).setOnClickListener(this);
        findViewById(R.id.btn_div).setOnClickListener(this);

        findViewById(R.id.btn_equal).setOnClickListener(this);
        findViewById(R.id.btn_rev).setOnClickListener(this);
        findViewById(R.id.btn_bs).setOnClickListener(this);
        findViewById(R.id.btn_ce).setOnClickListener(this);
        findViewById(R.id.btn_c).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btn_0)
            addDigit(0);
        else if (id == R.id.btn_1)
            addDigit(1);
        else if (id == R.id.btn_2)
            addDigit(2);
        else if (id == R.id.btn_3)
            addDigit(3);
        else if (id == R.id.btn_4)
            addDigit(4);
        else if (id == R.id.btn_5)
            addDigit(5);
        else if (id == R.id.btn_6)
            addDigit(6);
        else if (id == R.id.btn_7)
            addDigit(7);
        else if (id == R.id.btn_8)
            addDigit(8);
        else if (id == R.id.btn_9)
            addDigit(9);
        else if (id == R.id.btn_add)
            setOperator(1);
        else if (id == R.id.btn_sub)
            setOperator(2);
        else if (id == R.id.btn_mul)
            setOperator(3);
        else if (id == R.id.btn_div)
            setOperator(4);
        else if (id == R.id.btn_equal)
            calc();
        else if (id == R.id.btn_bs)
            removeDigit();
        else if (id == R.id.btn_rev)
            reverseOperand();
        else if (id == R.id.btn_ce)
            resetOperand();
        else if (id == R.id.btn_c)
            resetOperator();
    }

    private void resetOperator() {
        state = 1;
        op = 0;
        op1 = 0;
        op2 = 0;
        textResult.setText(String.valueOf(op1));
    }

    private void resetOperand() {
        if (state == 1) {
            op1 = 0;
            textResult.setText(String.valueOf(op1));
        } else {
            op2 = 0;
            textResult.setText(String.valueOf(op2));
        }
    }

    private void reverseOperand() {
        if (state == 1) {
            op1 = -op1;
            textResult.setText(String.valueOf(op1));
        } else {
            op2 = -op2;
            textResult.setText(String.valueOf(op2));
        }
    }

    private void removeDigit() {
        if (state == 1) {
            op1 = op1 / 10;
            textResult.setText(String.valueOf(op1));
        } else {
            op2 = op2 / 10;
            textResult.setText(String.valueOf(op2));
        }
    }

    private void calc() {
        int result = 0;
        if (op == 1)
            result = op1 + op2;
        else if (op == 2)
            result = op1 - op2;
        else if (op == 3)
            result = op1 * op2;
        else if (op == 4)
            result = op1 / op2;
        textResult.setText(String.valueOf(result));

        state = 1;
        op1 = 0;
        op2 = 0;
    }

    private void setOperator(int type) {
        state = 2;
        op = type;
        textResult.setText(String.valueOf(op2));
    }

    private void addDigit(int digit) {
        if (state == 1) {
            op1 = op1 * 10 + digit;
            textResult.setText(String.valueOf(op1));
        } else {
            op2 = op2 * 10 + digit;
            textResult.setText(String.valueOf(op2));
        }
    }
}