package com.axis.modal

import com.axis.exception.BookValidations

data class Book(var bookID:String, var title:String, var author:String, var category:String, var price:Float)
{
    var bookValidations= BookValidations()
    fun validations():Boolean{
        var flag1=bookValidations.validateBookId(bookID)
        var flag2=bookValidations.validateCategory(category)
        var flag3=bookValidations.validatePrice(price)
        if((flag1==true) && (flag2 == true) && (flag3 == true)){
            return true
        }
        else
             return false
    }
}