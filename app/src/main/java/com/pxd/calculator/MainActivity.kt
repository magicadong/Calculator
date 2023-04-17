package com.pxd.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(),ICalculateView{
    lateinit var resultTextView:TextView
    private val presenter = CalculatePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView = findViewById(R.id.textView2)
    }

    override fun showResult(result: String) {
        resultTextView.text = result
    }
    //数字按钮被点击
    //Button -> TextView -> View
    fun numberButtonClicked(view: View){
        // view->Button
        val numBtn = view as Button
        // 获取按钮上面的标题
        val num = numBtn.text.toString().toInt()
        // 拿去计算
        presenter.generateNum(num)
    }
    //操作按钮被点击了
    fun operationButtonClicked(view: View){
        val operationBtn = view as Button
        presenter.setOperation(operationBtn.tag as String)
    }
    //清除按钮被点击了
    fun clearButtonClicked(view:View){

    }
}