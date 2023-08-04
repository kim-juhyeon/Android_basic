package my.tutorials.myfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClickme = findViewById<Button>(R.id.mybutton) 
        val tvMyTextView = findViewById<TextView>(R.id.textView)
        var timesClicked = 0
        btnClickme.setOnClickListener{
            timesClicked = timesClicked +1

            tvMyTextView.text = timesClicked.toString()
            Toast.makeText(this, "Hi Im Kimjuhyeon", Toast.LENGTH_LONG).show()
        }
    }
}