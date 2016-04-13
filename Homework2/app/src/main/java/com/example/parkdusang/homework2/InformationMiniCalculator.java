package com.example.parkdusang.homework2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InformationMiniCalculator extends AppCompatActivity {
    Button BTN3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_mini_calculator);
        BTN3 = (Button)findViewById(R.id.button3_1);
        //버튼 클릭시 MiniCalculator 을 실행시킵니다.
        BTN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MiniCalculator.class);
                startActivityForResult(intent, 1);
            }
        });
    }
    // finish된 activity에서 결과값을 받을때 호출됩니다.
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) // 액티비티가 정상적으로 종료되었을 경우
        {
             // CreateActivity에서 호출한 경우에만 처리
            if (requestCode == 1)
            {
                String txt = data.getStringExtra("result");
                // 만약 0으로 나누어진 부분은 이부분을 출력합니다
                if(txt.equals("잘못된 수식입니다."))
                    Toast.makeText(getApplicationContext(),"잘못된 수식을 입력하셨습니다",Toast.LENGTH_LONG).show();
                //정상적으로 결과가 나오면 이부분을 출력합니다
                else
                    Toast.makeText(getApplicationContext(),"result : "+ txt ,Toast.LENGTH_LONG).show();
            }
        }
    }
}
