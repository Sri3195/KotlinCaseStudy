package com.axis.util

import java.sql.Connection
import java.sql.DriverManager

class BookDBConnection {

    fun connect():Connection{
        val myurl="jdbc:mysql://localhost:3306/kotlindb"
        val connection=DriverManager.getConnection(myurl,"root","Sri@cse1")
        return connection
    }
}