package com.axis.util

import com.axis.modal.Book

class BookUtil {

    var bookDBConnection=BookDBConnection()
    var connection=bookDBConnection.connect()

    /*init{
        var connect=connection.createStatement()
        var stmt=connect.executeUpdate("insert into books values('B123','Vendor of Sweets','R.K.Narayan','Others',250)")
        var stmt1=connect.executeUpdate("insert into books values('B124','The Village by the Sea','R.K.Narayan','Others',250)")
        var stmt2=connect.executeUpdate("insert into books values('B125','The Guide','R.K.Narayan','Others',250)")

    }*/
    fun addBook(book: Book):Int
    {
        var stmt=connection.prepareStatement("insert into books values(?,?,?,?,?)")
        stmt.setString(1,book.bookID)
        stmt.setString(2,book.title)
        stmt.setString(3,book.author)
        stmt.setString(4,book.category)
        stmt.setFloat(5,book.price)
        var result=stmt.executeUpdate()
        return result


    }

    fun modifyBook(id:String,column:String,value:String):String{
        var message=""
        if(column=="title"){
            val prestmt1=connection.prepareStatement("update books set title=? where bookId=?")
            prestmt1.setString(1,value)
            prestmt1.setString(2,id)
            val result1=prestmt1.executeUpdate()
            if(result1>0)
                message="title modified"

        }
        else if(column=="author"){
            val prestmt1=connection.prepareStatement("update books set author=? where bookId=?")
            prestmt1.setString(1,value)
            prestmt1.setString(2,id)
            val result1=prestmt1.executeUpdate()
            if(result1>0)
                message="author modified"
        }
        else if(column=="category"){
            val prestmt1=connection.prepareStatement("update books set category=? where bookId=?")
            prestmt1.setString(1,value)
            prestmt1.setString(2,id)
            val result1=prestmt1.executeUpdate()
            if(result1>0)
                message="category modified"
        }
        else if(column=="price"){
            val prestmt1=connection.prepareStatement("update books set price=? where bookId=?")
            prestmt1.setFloat(1,value.toFloat())
            prestmt1.setString(2, id)
            val result1=prestmt1.executeUpdate()
            if(result1>0)
                message="price modified"
        }
        else{
            message="book not found"
        }
        return message
    }

    fun deleteBook(id:String):Boolean{
        val prestmt=connection.prepareStatement("select * from books where bookId=?")
        prestmt.setString(1,id)
        val result=prestmt.executeQuery()
        //val books= mutableListOf<Book>()
        var flag=false
        while(result.next()){
            val prestmt1=connection.prepareStatement("delete from books where bookId=?")
            prestmt1.setString(1,id)
            val result1=prestmt1.executeUpdate()
            if(result1>0)
                flag=true
        }
        return flag
    }

    fun displayAll():MutableList<Book>{
        val prestmt=connection.prepareStatement("select * from books")
        val result=prestmt.executeQuery()
        val books= mutableListOf<Book>()
        while(result.next()){
            val bookId=result.getString("bookId")
            val title=result.getString("title")
            val author=result.getString("author")
            val category=result.getString("category")
            val price=result.getFloat("price")
            books.add(Book(bookId,title,author,category,price))
        }
        return books
    }

    fun displaySpecificBook(id:String):MutableList<Book>
    {
        val prestmt=connection.prepareStatement("select * from books where bookId=? ")
        prestmt.setString(1,id)
        val result=prestmt.executeQuery()
        val books= mutableListOf<Book>()
        while(result.next()){
            val bookId=result.getString("bookId")
            val title=result.getString("title")
            val author=result.getString("author")
            val category=result.getString("category")
            val price=result.getFloat("price")
            books.add(Book(bookId,title,author,category,price))
        }
        return books
    }

    fun searchByTitle(title:String):MutableList<Book>{
        val prestmt=connection.prepareStatement("select * from books where title=?")
        prestmt.setString(1,title)
        val result=prestmt.executeQuery()
        val books= mutableListOf<Book>()
        while(result.next()){
            val bookId=result.getString("bookId")
            val title=result.getString("title")
            val author=result.getString("author")
            val category=result.getString("category")
            val price=result.getFloat("price")
            books.add(Book(bookId,title,author,category,price))
        }
        return books
    }

    fun searchByAuthor(author:String):MutableList<Book>{
        val prestmt=connection.prepareStatement("select * from books where author=?")
        prestmt.setString(1,author)
        val result=prestmt.executeQuery()
        val books= mutableListOf<Book>()
        while(result.next()){
            val bookId=result.getString("bookId")
            val title=result.getString("title")
            val author=result.getString("author")
            val category=result.getString("category")
            val price=result.getFloat("price")
            books.add(Book(bookId,title,author,category,price))
        }
        return books
    }

    fun sortByPrice():MutableList<Book>{
        val prestmt=connection.prepareStatement("select * from books order by price")
        val result=prestmt.executeQuery()
        val books= mutableListOf<Book>()
        while(result.next()){
            val bookId=result.getString("bookId")
            val title=result.getString("title")
            val author=result.getString("author")
            val category=result.getString("category")
            val price=result.getFloat("price")
            books.add(Book(bookId,title,author,category,price))
        }
        return books
    }
}