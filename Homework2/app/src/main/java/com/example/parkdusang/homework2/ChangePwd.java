package com.example.parkdusang.homework2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePwd extends AppCompatActivity {
    String password;
    EditText edit;
    Button b1,b2;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_pwd);
        edit = (EditText)findViewById(R.id.passwordEdit);
        b1 = (Button)findViewById(R.id.pwdbuttonok);
        b2 = (Button)findViewById(R.id.pwdbuttoncancel);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //edittext에 비밀번호 4자리를 입력했을시 사용됩니다
                //edittext inputtype이 number이며 maxlength를 4로 설정했습니다.
                if (edit.getText().length() == 4) {
                    // 4자리가 맞다면 비밀번호를 재지정해줍니다
                    sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
                    toEdit = sh_Pref.edit();
                    toEdit.putString("Password", edit.getText().toString());
                    toEdit.commit();

                    Intent intent = new Intent();
                    intent.putExtra("result", "ok");
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
                //4자리를 입력하지 않았을시 출력합니다.
                else {
                    Toast.makeText(getApplicationContext(), "4자리 비밀번호를 입력하세요", Toast.LENGTH_LONG).show();

                }
            }
        });
        //취소를 누르면 전엑티비티에 취소를 눌렀다는걸 알려주면서 끝냅니다.
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("result", "cancel");
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }


}
