package com.example.parkdusang.homework2;


import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.TextView;

public class Tipcalculator extends AppCompatActivity {
    EditText et1, et2;
    RadioGroup g;
    RadioButton b1,b2,b3;
    Button bt;
    TextView tv1,tv2;
    float tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tipcalculator);
        et1 = (EditText) findViewById(R.id.et1); // 가격 입력창
        et2 = (EditText) findViewById(R.id.et2); // 팁 입력창
        bt = (Button) findViewById(R.id.btn1);
        tv1 = (TextView)findViewById(R.id.tv1); // 팁 결과창
        tv2 = (TextView)findViewById(R.id.tv2); // 총 결과창
        b1 = (RadioButton)findViewById(R.id.rb1);
        b2 = (RadioButton)findViewById(R.id.rb2);
        b3 = (RadioButton)findViewById(R.id.rb3);
        bt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(et1.getText().toString().equals("")){ // input이 없는 부분의 예외처리입니다
                            tv1.setText("No Input");
                            tv2.setText("Please try again");
                        }
                        else {
                            if (et2.getVisibility() == View.VISIBLE) { // 만약 RadioButton 의 other부분이 체크됬을때
                                if (et2.getText().toString().equals("")) { //팁이 입력되지 않았을때 발동됩니다.
                                    tv1.setText("Error tip");
                                    tv2.setText("No input \nif 0% tip, total:" + et1.getText());
                                }
                                else {
                                    tip = Float.parseFloat(et2.getText().toString());
                                    if (tip < 0) { // tip이 마이너스일때 발동하지만 android:inputType="number"로 음수를 방지했습니다.
                                        tv1.setText("Minus tip ?");
                                        tv2.setText("You are joking, right?");
                                    } else {
                                        float pay = Float.parseFloat(et1.getText().toString());
                                        tip = tip / 100;
                                        float tipmoney = pay * tip;
                                        tv1.setText("Tip : " + tipmoney);
                                        tv2.setText("Total : " + (tipmoney + pay));
                                    }
                                }

                            } else { // tip 이 15%나 20%일때 사용합니다.
                                float pay = Float.parseFloat(et1.getText().toString());
                                float tipmoney = pay * tip;
                                tv1.setText("Tip : " + tipmoney);
                                tv2.setText("Total : " + (tipmoney + pay));
                            }
                        }
                    }
                }
        );
        g = (RadioGroup) findViewById(R.id.rg1);

        g.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId) {

                            case R.id.rb1:
                                et2.setVisibility(View.GONE);
                                tip = (float) 0.15;
                                break;
                            case R.id.rb2:
                                et2.setVisibility(View.GONE);
                                tip = (float) 0.2;
                                break;
                            case R.id.rb3:
                                et2.setVisibility(View.VISIBLE); // 체크될시 EditText를 활성화 시킵니다.
                                break;
                        }

                    }
                }

        );
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) { // 수동으로 데이터를 저장하기위해 만들었습니다
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);
        outState.putString("et1", (String) et1.getText().toString());
        outState.putString("et2", (String) et2.getText().toString());
        outState.putString("tv1", (String) tv1.getText().toString());
        outState.putString("tv2", (String) tv2.getText().toString());
        outState.putInt("check", g.getCheckedRadioButtonId());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) { // 수동으로 저장된 데이터를 불러오기위해 만들었습니다
        // TODO Auto-generated method stub

        super.onRestoreInstanceState(savedInstanceState);
        et1.setText(savedInstanceState.getString("et1"));
        et2.setText(savedInstanceState.getString("et2"));
        tv1.setText(savedInstanceState.getString("tv1"));
        tv2.setText(savedInstanceState.getString("tv2"));
        if(R.id.rb1 == savedInstanceState.getInt("check")){
            b1.setChecked(true);
        }
        else if(R.id.rb2 == savedInstanceState.getInt("check")){
            b2.setChecked(true);
        }
        else if(R.id.rb3 == savedInstanceState.getInt("check")){
            b3.setChecked(true);
        }
    }

}
