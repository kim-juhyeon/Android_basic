package ju.tutorials.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnstart : Button = findViewById(R.id.btn_start)
        val etname : EditText = findViewById(R.id.et_name)
        btnstart.setOnClickListener{
            if(etname.text.isNotEmpty()){
                Toast.makeText(this,"please enter yout name",Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this, QuizQuetionsActivity::class.java) //flutter와 다르게 화면이동이 Intent를 이용합니다.
                startActivity(intent)
                finish()
            }

        }
    }
}