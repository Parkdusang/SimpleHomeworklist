package com.example.parkdusang.homework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InformationTipcalculator extends AppCompatActivity {
    Button BTN2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_tipcalculator);

        BTN2 = (Button)findViewById(R.id.button2_1);

        //버튼 클릭시 Tipcalculator 을 실행시킵니다.
        BTN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tipcalculator.class);
                startActivity(intent);
            }
        });
    }
}
