package com.example.parkdusang.homework2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    EditText e1, e2, e3, e4;
    Button b;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;
    Boolean passwordck;
    String pwd, checkpwd = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //초기에 비밀번호를 받고
        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        //처음 받을땐 checked 가 없으므로 default값인 false를 받아옵니다.
        //하지만 두번째 실행부턴 true이므로 이전에 입력됬던 패스워드를 가져옵니다.
        passwordck = sh_Pref.getBoolean("checked", false);
        if (passwordck) {
            pwd = sh_Pref.getString("Password", "0000");
        } else {
            toEdit.putBoolean("checked", true);
            toEdit.putString("Password", "0000");
            toEdit.commit();
            pwd = "0000";
        }


        e1 = (EditText) findViewById(R.id.edt1);
        e2 = (EditText) findViewById(R.id.edt2);
        e3 = (EditText) findViewById(R.id.edt3);
        e4 = (EditText) findViewById(R.id.edt4);


        e1.addTextChangedListener(this);
        e2.addTextChangedListener(this);
        e3.addTextChangedListener(this);
        e4.addTextChangedListener(this);
        b = (Button) findViewById(R.id.loginbtn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //입력한 비밀번호와 pwd가 일치하면 listActivity로 넘어갑니다.
                if (checkpwd.equals(pwd)) {
                    Intent intent = new Intent(getApplicationContext(), ListActivity.class);

                    startActivity(intent);
                }
                //틀렸다면 토스트를 하나 띄워줍니다.
                else
                    Toast.makeText(getApplicationContext(), "Wrong password", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {


    }

    @Override
    public void afterTextChanged(Editable s) {
        String text1;
        if (e1.getText().length() == 1) {
            e2.requestFocus();
            // 이전의 Edittext가 입력되있으면 다음으로 포커스가 넘어가는식입니다
            if (e2.getText().length() == 1) {
                e3.requestFocus();
                if (e3.getText().length() == 1) {
                    e4.requestFocus();
                    if (e4.getText().length() == 1) {
                        //4개의 포커스가 모두 입력되면 비밀번호와 비교하기 위해 저장합니다.
                        checkpwd = "";
                        checkpwd += e1.getText().toString();
                        checkpwd += e2.getText().toString();
                        checkpwd += e3.getText().toString();
                        checkpwd += e4.getText().toString();
                        //모든 Edittext가 체워지면 버튼을 강제로 누릅니다
                        b.performClick();

                    }
                }
            }


        }
    }

    //비밀번호 변경후 바로 로그인 화면으로 돌아갈시 바뀐비밀번호를 재지정 해줍니다.
    @Override
    protected void onRestart() {
        super.onRestart();
        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        pwd = sh_Pref.getString("Password", "0000");
    }
}
