package com.example.parkdusang.homework2;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MiniCalculator extends AppCompatActivity implements View.OnClickListener {
    TextView ebox;
    TextView textv1;
    boolean si = false; // 이 부분을 이용해서 기호를 연속으로 입력하지 못하게합니다.
    boolean doubleinput = false;
    String str = "";
    String c = "";
    float result = 0;
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btC, btEND, btX, btP, btM, btD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mini_calculator);

        ebox = (TextView) findViewById(R.id.eView1);
        textv1 = (TextView) findViewById(R.id.textViewtop);
        textv1.setText("계산식을 입력하세요!");
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);
        bt8 = (Button) findViewById(R.id.bt8);
        bt9 = (Button) findViewById(R.id.bt9);
        bt0 = (Button) findViewById(R.id.bt0);
        btC = (Button) findViewById(R.id.btC);
        btEND = (Button) findViewById(R.id.btEND);
        btP = (Button) findViewById(R.id.btP);
        btX = (Button) findViewById(R.id.btX);
        btD = (Button) findViewById(R.id.btD);
        btM = (Button) findViewById(R.id.btM);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        bt0.setOnClickListener(this);
        btEND.setOnClickListener(this);
        btC.setOnClickListener(this);
        btP.setOnClickListener(this);
        btM.setOnClickListener(this);
        btX.setOnClickListener(this);
        btD.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btC) { //AC 를 누르면 초기화 시킵니다
            str = "";
            si = false;  // si
            textv1.setText("계산식을 입력하세요!"); // 숫자나 기호는 이부분에 입력됩니다
            ebox.setText(""); // 오류 출력용 부분입니다
            ebox.setText("");
            doubleinput = false;
            result = 0;
        } else if (v.getId() == R.id.btEND) {
            if (str.equals("") && doubleinput == false && si == false) { // 처음 기호 입력하긴에  눌렀을때 반응합니다
                textv1.setText("" + result);
            } else if (str.equals("") && doubleinput == true && si == false) { // 숫자 입력후 기호만 누르고 =을 누를시 반응합니다
                ebox.setText("Error input");
            } else if (doubleinput == false == si == true) { // 숫자만 입력했을때 입력됩니다
                textv1.setText("" + result);
            } else {
                if (c.equals("-")) {
                    result -= Float.parseFloat(str);
                    textv1.setText("" + result);
                    str = "" + result;
                } else if (c.equals("+")) {
                    result += Float.parseFloat(str);
                    textv1.setText("" + result);
                    str = "" + result;
                } else if (c.equals("*")) {
                    result *= Float.parseFloat(str);
                    textv1.setText("" + result);
                    str = "" + result;
                } else {
                    if (str.equals("0")) { // 0으로 나눌시 예외처리합니다
                        ebox.setText("잘못된 수식입니다");
                        str = "";
                        si = false;
                        doubleinput = false;
                        result = 0;
                        Intent intent = new Intent();
                        intent.putExtra("result", "잘못된 수식입니다.");
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                    } else {
                        result /= Float.parseFloat(str);
                        textv1.setText("" + result);
                        str = "" + result;
                    }
                }
                doubleinput = false; // 결과값을 처음에 숫자만 친거처럼 설정합니다 만약 5.0 에서 숫자를 더쓰면 5.01 이렇게 입력됩니다

                //결과값을 전 엑티비티로 전달해주기위해서 인텐트를 생성 결과값을 저장하고 보내준후 엑티비티를 종료합니다.
                Intent intent = new Intent();
                intent.putExtra("result", str);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        } else if (v.getId() == R.id.btX || v.getId() == R.id.btP || v.getId() == R.id.btD || v.getId() == R.id.btM) {
            Button b = (Button) v;
            if (str.equals("") && ((Button) v).getText().equals("-")) { // 처음인풋이 -일때는 예외로 입력시켜준다()
                str = ((Button) v).getText().toString();
            }
            if (si == true && doubleinput == false) { // 이전에 기호 입력이 없어서 따로 계산할게 없다면 이부분이 돌아갑니다
                result = Float.parseFloat(str);
                c = ((Button) v).getText().toString();
                textv1.setText(str + " " + c);
                str = "";
                si = false;
                doubleinput = true;
            } else if (si == true && doubleinput == true) { // 이번 인풋 이전에 기호입력이 있다면 그전 계산을 먼저 끝냅니다.
                if (c.equals("-"))
                    result -= Float.parseFloat(str);
                else if (c.equals("+"))
                    result += Float.parseFloat(str);

                else if (c.equals("*"))
                    result *= Float.parseFloat(str);
                else {
                    if (str.equals("0")) { // 0으로 나눴을때 예외처리입니다
                        ebox.setText("잘못된 수식입니다");
                        str = "";
                        si = false;
                        doubleinput = false;
                        result = 0;
                    } else
                        result /= Float.parseFloat(str);
                }
                c = ((Button) v).getText().toString();
                textv1.setText("" + result + " " + c);
                str = "";
                si = false;
            }
        } else { // 숫자인풋을 기록합니다(0,1,2,3 ....)
            Button b = (Button) v;
            if (str.equals("0") && b.getText().equals("0")) {
                // 처음에 0을 쓰고 0 을 연속으로 쓰는것을 막았습니다 ( . 을 만들지않아서)
            } else {
                if (str.equals("0")) // 처음 숫자가 0이고 다음인풋이 1~9이면 바꿉니다
                    str = b.getText().toString();
                else
                    str += b.getText().toString();
                textv1.setText(str);
                si = true; // 숫자를 하나라도 입력하면 기호를 쓸수있게 si를 true로 바꿉니다
            }
        }
    }
}
