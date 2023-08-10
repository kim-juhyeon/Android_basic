package ju.tutorials.myquizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuetionsActivity : AppCompatActivity(), View.OnClickListener{

    private  var mnCurrentPostion : Int = 1
    private  var mQuetionsList : ArrayList<Question>? = null
    private var mSelectedOptionPostion : Int = 0

    private var progressBar: ProgressBar? = null
    private var tvProgress : TextView? = null
    private var tvQuestion : TextView? = null
    private var ivImage : ImageView? = null

    private var tvOptionOne : TextView? = null
    private var tvOptionTwo : TextView? = null
    private var tvOptionThree : TextView? = null
    private var tvOptionFour : TextView? = null
    private var btnSubmit : Button? = null

    constructor()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_quetions)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_subimt)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)


        mQuetionsList = Constants.getQuestions()


        setQuestion()
        defaultOptionsView()

    }

    private fun setQuestion() {

        val question: Question = mQuetionsList!![mnCurrentPostion - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mnCurrentPostion
        tvProgress?.text = "$mnCurrentPostion / ${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        if(mnCurrentPostion == mQuetionsList!!.size){
            btnSubmit?.text = "Finish"
        }else{
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionsView(){
         val options = ArrayList<TextView>()
        tvOptionOne?.let{
            options.add(0,it)
        }
        tvOptionTwo?.let{
            options.add(1,it)
        }
        tvOptionThree?.let{
            options.add(2,it)
        }
        tvOptionFour?.let{
            options.add(3,it)
        }
        for (option in options){
            option.setTextColor(Color.parseColor("$7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg

            )

        }
    }
    private fun seletedoptionView(tv:TextView, selectedOptionNum: Int){
        defaultOptionsView()

        mSelectedOptionPostion = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option_one -> {
                tvOptionOne?.let{
                    seletedoptionView(it,1)
                }
            }
            R.id.tv_option_two -> {
                tvOptionTwo?.let{
                    seletedoptionView(it,2)
                }
            }
            R.id.tv_option_three -> {
                tvOptionThree?.let{
                    seletedoptionView(it,3)
                }
            }
            R.id.tv_option_four -> {
                tvOptionFour?.let{
                    seletedoptionView(it,4)
                }
            }
            R.id.btn_subimt ->{
                if(mSelectedOptionPostion ==0){
                    mnCurrentPostion++
                    when{
                        mnCurrentPostion <= mQuetionsList!!.size ->{
                            setQuestion()
                        }else -> {
                        Toast.makeText(this,"마지막 입니다.", Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    val question =mQuetionsList?.get(mnCurrentPostion -1)
                    if(question!!.correctAnswer != mSelectedOptionPostion)
                        answerView(mSelectedOptionPostion,R.drawable.wrong_option_border_bg)

                }
                answerView(question.correctAnswer,R.drawable.correct_option_border_bg)

                if(mnCurrentPostion == mQuetionsList!!.size){
                    btnSubmit?.text = "Finsh"
                }else{
                    btnSubmit?.text = "60 To Next Question"
                }
                mSelectedOptionPostion = 0

            }
        }
    }
    private fun answerView(answer : Int, drawableView: Int){
        when(answer){
            1 ->{
                tvOptionOne?.background = ContextCompat.getDrawable(this,
                    drawableView)
            }
            2 ->{
                tvOptionTwo?.background = ContextCompat.getDrawable(this,
                    drawableView)
            }
            3 ->{
                tvOptionThree?.background = ContextCompat.getDrawable(this,
                    drawableView)
            }
            4 ->{
                tvOptionFour?.background = ContextCompat.getDrawable(this,
                    drawableView)
            }
        }

    }
}