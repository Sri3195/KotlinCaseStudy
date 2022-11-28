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
            println("Book not found")
    }

    fun displayAll(){
        var books=bookUtil.displayAll()
        println("------All Book Details-------")
        if(books.isNotEmpty()){
        for(book in books){
            println(book)
        }}
        else{
            println("No books to display")
            }
    }

    fun displaySpecificBook(id:String)
    {
        var books=bookUtil.displaySpecificBook(id)
        println("---------Book Details -------")
        if(books.isNotEmpty()){
        for(book in books){
            println(book)
        }}
        else{
            println("Book not found")
        }
    }

    fun searchByTitle(title:String){
        var books=bookUtil.searchByTitle(title)
        println("--------------Book Details ------------")
        if(books.isNotEmpty()){
        for(book in books){
            println(book)
        }}
        else{
            println("Book not found")
        }
    }

    fun searchByAuthor(author:String){
        var books=bookUtil.searchByAuthor(author)
        println("----------Book Details ---------")
        if(books.isNotEmpty()){
        for(book in books){
            println(book)
        }}
        else{
            println("Book not found")
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