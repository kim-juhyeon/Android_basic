package eu.tutorials.a7_minutesworkoutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import eu.tutorials.a7_minutesworkoutapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //  The binding is name just like the name of the layout with Binding attached
    private var binding:ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        // viewBinding설정으로 더이상 findviewByid를 사용하지 않아도 됨

        binding?.flStart?.setOnClickListener {
            val intent = Intent(this,ExerciseActivity::class.java) //명시적 intent이고, 화면전환을 나타냅니다.
            startActivity(intent)
        }

        binding?.flBMI?.setOnClickListener {
            // Launching the BMI Activity
            val intent = Intent(this, BMIActivity::class.java)
            startActivity(intent)
        }


        //  Adding a click event to launch the History Screen Activity from Main Activity.)
        // START
        binding?.flHistory?.setOnClickListener {
            // Launching the History Activity
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
        //END
    }


    override fun onDestroy() { //viewbinding을 쓸때 onDestroy 함수를 이용해서 메모리 누락을 방지 할 수 있습니다.
        super.onDestroy()
        binding = null
    }
}