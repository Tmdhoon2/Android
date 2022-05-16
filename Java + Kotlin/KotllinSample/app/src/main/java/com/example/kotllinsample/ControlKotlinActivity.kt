package com.example.kotllinsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotllinsample.databinding.LayoutControlBinding

class ControlKotlinActivity : AppCompatActivity() {
    private lateinit var binding: LayoutControlBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutControlBinding.inflate(layoutInflater)

        // UI 로 사용할 레이아웃 XML 파일을 지정한다.
        setContentView(binding.root)

        // 버튼이 클릭되었을때의 이벤트리스너를 설정한다.
        binding.button.setOnClickListener {
            // numberField 의 값을 읽어 int 형으로 변환한다.
            val number = binding.numberField.text.toString().toInt()

//            // if, else if, else 문으로 2의 배수, 3의 배수를 체크해 서로 다른 토스트 메세지를 보여준다.
//            if (number % 2 == 0){
//                Toast.makeText(applicationContext, "&{number} 는 2의 배수입니다.", Toast.LENGTH_SHORT).show()
//            }
//            else if (number % 2 == 0){
//                Toast.makeText(applicationContext, "&{number} 는 3의 배수입니다.", Toast.LENGTH_SHORT).show()
//            }
//            else {
//                Toast.makeText(applicationContext, "&{number}", Toast.LENGTH_SHORT).show()
//            }

            // when 문은 케이스로 조건식도 사용 가능
            when{
                number % 2 == 0 -> Toast.makeText(applicationContext, "${number} 는 2의 배수 입니다.",Toast.LENGTH_SHORT).show()
                number % 3 == 0 -> Toast.makeText(applicationContext, "${number} 는 2의 배수 입니다.",Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(applicationContext, "${number}",Toast.LENGTH_SHORT).show()
            }

            // 코틀린에서는 switch 문을 대체해 when 을 사용할 수 있다.
            when (number){
                // number 가 1~4 까지인 경우 실
                in 1..4-> binding.button.text = "실행 - 4"
                9, 18->{
                    binding.button.text = "실행 - 9"
                }
                else -> binding.button.text = "실행"
            }
        }
    }
}