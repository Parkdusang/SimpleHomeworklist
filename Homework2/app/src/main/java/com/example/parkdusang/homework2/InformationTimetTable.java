package com.example.parkdusang.homework2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class InformationTimetTable extends AppCompatActivity {
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_timet_table);
        btn1 = (Button)findViewById(R.id.button1_1);
        //버튼 클릭시 TimeTable 을 실행시킵니다.
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Timetable.class);
                startActivity(intent);
            }
        });
    }
}
