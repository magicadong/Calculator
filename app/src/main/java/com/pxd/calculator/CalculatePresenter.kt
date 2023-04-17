package com.pxd.calculator

/**
 * MainActivity->Presenter  -> model
 *   显示结果   <-       结果 <-
 */
class CalculatePresenter(val target:ICalculateView) {
    private val model = CalculateModel()

    fun generateNum(num:Int){
        val result = model.addNum(num)
        target.showResult("$result")
    }

    fun setOperation(operation:String){
        val result = model.setOperation(operation)
        target.showResult("$result")
    }
    fun clear(){

    }
}