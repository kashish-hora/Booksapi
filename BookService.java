package com.api.book.bootrestbook.services;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;
@Component
public class BookService {
   // private static List<Book> list=new ArrayList<>();
    //static{
       // list.add(new Book(12,"java refrence book","XYZ"));
       // list.add(new Book(36,"head first come to java","ABC"));
      // list.add(new Book(12963,"Things in java","LMN"));

   // }
   @Autowired
   private BookRepository bookRepository;
    //get all books
    public List<Book> getAllBooks(){
       List<Book> list =(List<Book>)this.bookRepository.findAll();
        return list;
    }
    //get single book by ID
    public Book getBookById(int id){
        Book book=null;
        try{
      //  book=list.stream().filter(e->e.getId()==id).findFirst().get();

      book= this.bookRepository.findById(id);

    }
    catch(Exception e){
        e.printStackTrace();
    }
    return book;
}
    //adding the book
    public Book addBook(Book b){
      //  list.add(b);
       // return b;
      Book result= this.bookRepository.save(b);
      return result;
    }

    //delete book-. yha pr client jis book ko delete krne k liye id bhejega vo bid mai aegi phir hum list mai se filter krlnge aur vhi books list mai rkhengie jiski id match nhi hogi
    public void DeleteBook(int bid){
        //list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
        this.bookRepository.deleteById(bid);
    }
    //update the book-> isme humare pass parameters mai new book hai aur id mai hum book book ki id ko search kr rhe hai jisko update krna hai phir hum map method ki help se ek ek book pr jayenge list ki aur id match kraenge agar book ki id match hogyi toh hum uss book mai new book ki jo details hai vo daal denge
   //filter se hum list flter krte hai
   //map se hum list mai ja k objects pr operations perform krte hai
    public void updateBook(Book book,int bookId){
      //  list=list.stream().map(b->{
            //if(b.getId()==bookId){
              //  b.setTitle(book.getTitle());
               // b.setAuthor(book.getAuthor());

           // }
           // return b;
       // }).collect(Collectors.toList());
       book.setId(bookId);
      
       bookRepository.save(book);

    }
}
