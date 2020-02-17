package com.example.truthtable

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        btn_submit.setOnClickListener {
            checkAnswer()
        }
    }

    private fun checkAnswer() {
        val first = et_first.text.toString().toLowerCase()
        val second = et_second.text.toString().toLowerCase()
        val third = et_third.text.toString().toLowerCase()
        val fourth = et_fourth.text.toString().toLowerCase()

        if(first == "" || second == "" || third == "" || fourth == ""){
            showEmptyFieldError()
        }else {
            var numberOfCorrectAnswers = 0
            if (first == "t") {
                numberOfCorrectAnswers++
            }
            if (second == "f") {
                numberOfCorrectAnswers++
            }
            if (third == "f") {
                numberOfCorrectAnswers++
            }
            if (fourth == "f") {
                numberOfCorrectAnswers++
            }
            showNumberOfCorrectAnswers(number = numberOfCorrectAnswers)
        }
    }

    @SuppressLint("StringFormatMatches")
    private fun showNumberOfCorrectAnswers(number: Number) {
        val text = getString(R.string.answerMessage, number)
        val duration = Toast.LENGTH_LONG

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

    private fun showEmptyFieldError() {
        val text = getString(R.string.errorMessage)
        val duration = Toast.LENGTH_LONG

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
}
