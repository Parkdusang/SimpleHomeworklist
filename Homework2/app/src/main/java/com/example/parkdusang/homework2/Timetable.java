package com.example.parkdusang.homework2;



import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import java.util.Calendar;


public class Timetable extends AppCompatActivity {
    LinearLayout l1,l2,l3,l4,l5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable);
        l1 =(LinearLayout)findViewById(R.id.li1); // LinearLayout 으로 한 요일을 표현헀습니다 이 속성 배경을 바꾸면
        l2 =(LinearLayout)findViewById(R.id.li2); // 요일 전체의 색이 변경됩니다.
        l3 =(LinearLayout)findViewById(R.id.li3);
        l4 =(LinearLayout)findViewById(R.id.li4);
        l5 =(LinearLayout)findViewById(R.id.li5);


        Calendar cal= Calendar.getInstance ();  // 요일처리는 월화수목금 으로 하고 Calendar를 사용했습니다
        int day_of_week = cal.get ( Calendar.DAY_OF_WEEK );

        if ( day_of_week == 2 )
            l1.setBackgroundColor(Color.rgb(204, 255, 153));
        else if ( day_of_week == 3 )
            l2.setBackgroundColor(Color.rgb(204,255,153));
        else if ( day_of_week == 4 )
            l3.setBackgroundColor(Color.rgb(204,255,153));
        else if ( day_of_week == 5 )
            l4.setBackgroundColor(Color.rgb(204,255,153));
        else if ( day_of_week == 6 )
            l5.setBackgroundColor(Color.rgb(204,255,153));
    }
}
