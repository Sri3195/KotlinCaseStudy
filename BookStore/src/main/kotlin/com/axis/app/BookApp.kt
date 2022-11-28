package com.axis.app
import com.axis.service.BookService
import com.axis.modal.Book
import java.util.Scanner


fun main(){
    var scanner=Scanner(System.`in`)
    var bookService = BookService()



    while(true){
        println("================================")
        println("1.Add Book")
        println("2.Modify Book Details")
        println("3.Delete Book")
        println("4.Display All Books")
        println("5.Display Specific Book")
        println("6.Search Book by Title")
        println("7.Search Book by Author")
        println("8.Sort Book By Price")

        println("Enter your choice")
        var choice=scanner.nextInt()
<<<<<<< HEAD
        scanner.nextLine()
=======
        sc.nextLine()
>>>>>>> 26eaabb99cd79633a36ed07c1131a5b473e6c9d7

        when(choice){

            1->{
                println("Enter book Id")
                var bookId=scanner.nextLine()

                println("Enter book title")
                var title=scanner.nextLine()
                println("Enter book author")
                var author=scanner.nextLine()
                println("Enter book category")
                var category=scanner.nextLine()
                println("Enter book price")
                var price=scanner.nextFloat()

                var book=Book(bookId,title,author,category,price)
                var result=book.validations()
                if(result) {
                    bookService.addBook(book)
                }
                else{
                    println("Validations Failed")
                }
            }

            2->{
                println("Enter book Id to modify")
                var id=scanner.nextLine()
                println("Enter which column you want to edit")
                var column=scanner.nextLine()
                println("Enter which the value to be updated")
                var value=scanner.nextLine()

                bookService.modifyBook(id,column,value)
            }

            3->{
                println("Enter book id to delete")
                var id=scanner.nextLine()
                bookService.deleteBook(id)
            }

            4->{
                bookService.displayAll()
            }

            5->{
                println("Enter book Id to display")
                var id=scanner.nextLine()
                bookService.displaySpecificBook(id)
            }

            6->{
                println("Enter book title to search")
                var title=scanner.nextLine()
                bookService.searchByTitle(title)
            }

            7->{
                println("Enter book author to search")
                var author=scanner.nextLine()
                bookService.searchByAuthor(author)
            }
            8->{
                bookService.sortByPrice()
            }

            else->{
                println("Sorry! Enter correct choice")
                break
            }
        }

    }
}
