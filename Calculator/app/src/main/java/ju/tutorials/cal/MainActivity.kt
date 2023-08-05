package ju.tutorials.cal

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.CalendarAlerts
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tvSelectedData : TextView? = null
    private var tvAgeInMinute : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker : Button = findViewById(R.id.btnDatePicker)
        tvSelectedData = findViewById(R.id.tvSelectedView)
        tvAgeInMinute = findViewById(R.id.tvAgeInMinute)


        btnDatePicker.setOnClickListener{
            clickDatePicker()

        }
    }
    fun clickDatePicker(){

        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this,
            {view, selectedyear, selectedmonth, selectedDayOfMonth ->
                Toast.makeText(this,"Year was $selectedyear,${selectedmonth+1},day of $selectedDayOfMonth" ,Toast.LENGTH_LONG).show()

                val seletedData = "$selectedDayOfMonth/${selectedmonth+1}/$selectedyear"

                tvSelectedData?.text = seletedData

                val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
                val theData = sdf.parse(seletedData) //날짜 계산을 위해서 theData변수를 생성합니다.

                val selectedDataInMinutes = theData.time / 60000

                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                val currentDateInMinutes = currentDate.time / 60000

                val diffenceInMinutes = currentDateInMinutes - selectedDataInMinutes //선택한 날짜와 현재 날짜를 뺀값 분으로 나옴

                tvAgeInMinute?.text = diffenceInMinutes.toString()


            },
            year,
            month,
            day
        )
        dpd.datePicker.maxDate = System.currentTimeMillis() - 88640000
        dpd.show()



    }

}