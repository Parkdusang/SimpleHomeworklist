package com.example.parkdusang.homework2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<MyCustomDTO> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listactivity);

        // listview 에 추가할 목록을 표시합니다
        list = new ArrayList<MyCustomDTO>();
        list.add(new MyCustomDTO("TimeTable", "Information TimeTalbe", R.drawable.time));
        list.add(new MyCustomDTO("TipCalculator", "Information TipCalculator", R.drawable.tip));
        list.add(new MyCustomDTO("Mini-calculator", "Information Calculator", R.drawable.calculator));
        list.add(new MyCustomDTO("Change Password", "Change Password Activity", R.drawable.pwd));


        listView = (ListView) findViewById(R.id.listView);

        MyCustomAdapter adapter =
                new MyCustomAdapter(
                        getApplicationContext(),
                        R.layout.list_row,
                        list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), InformationTimetTable.class);
                    startActivity(intent);
                    // InformationTimeTable 을 실행시킵니다
                } else if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(), InformationTipcalculator.class);
                    startActivity(intent);
                    //InformationTipcalculator 을 실행시킵니다
                } else if (position == 2) {
                    Intent intent = new Intent(getApplicationContext(), InformationMiniCalculator.class);
                    startActivity(intent);
                    //InformationMinicalculator 을 실행시킵니다
                } else {
                    Intent intent = new Intent(getApplicationContext(),ChangePwd.class);
                    startActivityForResult(intent,3);
                    // Chang password 를 실행시킵니다
                }

            }
        });
    }
    // 비밃번호를 변경하고 변경했는지 취소했는지를 표시하기위해 받습니다.
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) // 액티비티가 정상적으로 종료되었을 경우
        {
            if (requestCode == 3) // CreateActivity에서 호출한 경우에만 처리
            {
                String txt = data.getStringExtra("result");
                if(txt.equals("cancel"))
                    Toast.makeText(getApplicationContext(), "비밀번호 변경을 취소하셨습니다.", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"비밀번호를 변경했습니다." ,Toast.LENGTH_LONG).show();
            }
        }
    }

}

