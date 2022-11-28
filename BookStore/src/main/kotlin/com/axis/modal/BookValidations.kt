package com.axis.modal

class BookValidations {
    fun validateBookId(bookId:String):Boolean
    {
        var flag=false
        var ch=bookId.get(0)
        var length=bookId.length
        if(ch=='B' && length>=4){
            flag=true

        }
        else{
            throw BookException("Book id should start with B and length must not be less than 4")
        }
        return flag
    }

    fun validateCategory(category:String):Boolean
    {
        var flag=false
        if((category=="Science") || (category=="Fiction") || (category=="Technology") || (category=="Others")){
            flag=true

        }
        else{
            throw BookException("Category must be either Science or Fiction or Technology or Others")
        }
        return flag
    }

    fun validatePrice(price:Float):Boolean
    {
        var flag=false
        if(price>0) {
            flag = true
        }
        else{
            throw BookException("Price must not be negative")
        }
        return flag
    }
}