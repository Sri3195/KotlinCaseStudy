package com.axis.service

import com.axis.modal.Book

import com.axis.util.BookUtil

class BookService {

    var bookUtil=BookUtil()

    fun addBook(book: Book)
    {
        var result=bookUtil.addBook(book)
        if(result>0){
            println("Book insertion successful")
        }
        else{
            println("Book insertion failed")
        }
    }

    fun modifyBook(id:String,column:String,value:String){
        var result=bookUtil.modifyBook(id,column,value)
        println(result)
    }

    fun deleteBook(id:String){
        var result=bookUtil.deleteBook(id)
        if(result)
            println("deleted book successfully")
        else
            println("deletion failed")
    }

    fun displayAll(){
        var books=bookUtil.displayAll()
        println("------All Book Details-------")
        for(book in books){
            println(book)
        }
    }

    fun displaySpecificBook(id:String)
    {
        var books=bookUtil.displaySpecificBook(id)
        println("---------Book Details -------")
        for(book in books){
            println(book)
        }
    }

    fun searchByTitle(title:String){
        var books=bookUtil.searchByTitle(title)
        println("--------------Book Details ------------")
        for(book in books){
            println(book)
        }
    }

    fun searchByAuthor(author:String){
        var books=bookUtil.searchByAuthor(author)
        println("----------Book Details ---------")
        for(book in books){
            println(book)
        }
    }

    fun sortByPrice(){
        var books=bookUtil.sortByPrice()
        println("----------Book Details sorted by price ---------")
        for(book in books){
            println(book)
        }
    }

}