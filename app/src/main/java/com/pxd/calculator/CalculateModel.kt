package com.pxd.calculator

import android.util.Log

class CalculateModel {
    private var num1:Int = 0 //第一个运算数
    private var num2:Int = 0 //第二个运算数
    private var operation:String = "" //运算符
    private var isFirst = true //是不是在操作第一个运算数

    fun addNum(num:Int):Int{
        return if (isFirst){
            num1 = num1*10 + num
            num1
        }else{
            num2 = num2*10 + num
            num2
        }
    }

    fun setOperation(aOperation:String):Int{
        if (aOperation == EQUAL){
            Log.v("pxd","数字1:$num1 $operation $num2")
            //计算
            val result = calculate()
            operation = ""
            isFirst = true
            num1 = result
            num2 = 0
        }else{
            operation = aOperation
            isFirst = false
        }
        return num1
    }

    fun calculate():Int{
        return when(operation){
            ADD -> num1 + num2
            MINUS-> num1 - num2
            MULTIPLE -> num1 * num2
            DIVIDE -> num1 / num2
            else -> {0}
        }
    }
}