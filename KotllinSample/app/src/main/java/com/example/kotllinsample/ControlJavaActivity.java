package com.example.kotllinsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.kotllinsample.databinding.LayoutControlBinding;

public class ControlJavaActivity extends AppCompatActivity {

    private LayoutControlBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = LayoutControlBinding.inflate(getLayoutInflater());

        //UI 로 사용할 레이아웃 XML 파일을 지정한다.
        setContentView(binding.getRoot());

        // 버튼이 클릭되었을때의 이벤트리스너를 설정한다.
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt(binding.numberField.getText().toString());

                // if, else if, else 문으로 2의 배수, 3의 배수를 체크해 서로 다른 토스트 메세지를 보여준다.
                if(number % 2 == 0){
                    Toast.makeText(getApplicationContext(), ""+number + " 는 2의 배수입니다.", Toast.LENGTH_SHORT).show();
                }
                else if(number % 3 == 0){
                    Toast.makeText(getApplicationContext(), ""+number + " 는 3의 배수입니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), ""+number, Toast.LENGTH_SHORT).show();
                }

                // switch 문으로 체크후 버튼의 텍스트를 변경한다.
                switch (number) {
                    case 4:
                        binding.button.setText("실행 - 4");
                        break;
                    case 9:
                        binding.button.setText("실행 - 9");
                        break;
                    default:
                        binding.button.setText("실행");
                        break;
                }
            }
        });
    }
}