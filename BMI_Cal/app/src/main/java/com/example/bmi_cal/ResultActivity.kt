package com.example.bmi_cal

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.round

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var height = intent.getIntExtra("height", 0)
        var weight = intent.getIntExtra("weight", 0)

        //BMI cal
        var m_height = height/100.0
        var value = weight / (m_height * m_height)
        value = round(value * 10) / 10

        var resultText = ""
        var resultImage = 0
        var resultColor = 0

        if (value < 18.5){
            resultText = "저체중"
            resultImage = R.drawable.img_lv1
            resultColor = Color.YELLOW
        } else if (value < 23.0) {
            resultText = "정상 체중"
            resultImage = R.drawable.img_lv2
            resultColor = Color.GREEN
        } else if (value < 25.0){
            resultText = "과체중"
            resultImage = R.drawable.img_lv3
            resultColor = Color.BLACK
        } else if (value < 30.0) {
            resultText = "경도 비만"
            resultImage = R.drawable.img_lv4
            resultColor = Color.CYAN
        } else if (value < 35.0) {
            resultText = "중도 비만"
            resultImage = R.drawable.img_lv5
            resultColor = Color.MAGENTA
        } else {
            resultText = "고도 비만"
            resultImage = R.drawable.img_lv6
            resultColor = Color.RED
        }

        val tv_resValue = findViewById<TextView>(R.id.tv_resValue)
        val tv_resText = findViewById<TextView>(R.id.tv_resText)
        val iv_image = findViewById<ImageView>(R.id.imageView)
        val btn_back = findViewById<Button>(R.id.btn_back)

        tv_resValue.text = value.toString()
        tv_resText.text = resultText
        iv_image.setImageResource(resultImage)
        tv_resText.setTextColor(resultColor)

        btn_back.setOnClickListener{
            finish()
        }

    }
}