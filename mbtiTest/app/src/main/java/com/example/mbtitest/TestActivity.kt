package com.example.mbtitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class TestActivity : AppCompatActivity() {

    private lateinit var viewPager : ViewPager2

    val questionResults = QuestionResults();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(this)
        viewPager.isUserInputEnabled = false;
    }

    fun moveToNextQuestion(){
        if(viewPager.currentItem == 3){
            //결과화면으로
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(questionResults.results))
            startActivity(intent)
        } else {
            val nextItem = viewPager.currentItem + 1
            if(nextItem < viewPager.adapter?.itemCount ?: 0){
                viewPager.setCurrentItem(nextItem, true)
            }
        }
    }
}

class QuestionResults {
    val results = mutableListOf<Int>()

    fun addResponses(response: List<Int>){
        val mostFrequent = response.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key
        mostFrequent?.let { results.add(it) }
    }
}