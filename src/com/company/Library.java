package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Library {
    private String name, address;
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Borrow> borrows = new ArrayList<Borrow>();

    public Library(String newAddress, String newName) {
        address = newAddress;
        name = newName;
    }
    public void setName(String newName){
        name=newName;
    }
    public void setAddress(String newAddress){
        name=newAddress;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public void addUser(User userToAdd) {
        users.add(userToAdd);
    }

    public void removeUser(User userToRemove) {
        users.remove(userToRemove);
    }

    public void addBook(Book bookToAdd) {
        books.add(bookToAdd);
    }

    public void removeBook(Book bookToRemove) {
        books.remove(bookToRemove);
    }

    public void borrowBook(Book bookToBorrow, User borrower, int year, int month, int day, int hour, int minute, int second) {
        int flag = 0;
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            if (book == bookToBorrow) { //if we have this book in the library we can lend it and if not we cannot lend it.
                Borrow newBorrow = new Borrow(borrower.getFirstName(), borrower.getLastName(), borrower.getIdNum(), bookToBorrow.getTitle(), bookToBorrow.getAuthor(), year, month, day, hour, minute, second);
                borrows.add(newBorrow);
                books.remove(bookToBorrow);
                flag = 1;
            }
        }
        if (flag == 0)
            System.out.println("Unfortunately We don't have this book !");
    }

    public void giveBackBook(Borrow borrow) {
        int flag = 0;
        Iterator<Borrow> it = borrows.iterator();
        while (it.hasNext()) {
            Borrow borrow1 = it.next();
            if (borrow1 == borrow) {
                borrows.remove(borrow);
                books.add(borrow.borrowedBook);
                flag = 1;
            }
        }
        if (flag == 0)//if there is no borrow with such info , send appropriate message.
            System.out.println("We don't have a borrow like this ! Try again .");

    }

    public void printPassedDeadlineBorrows() {
        Date now = new Date();
        Iterator<Borrow> it = borrows.iterator();
        while (it.hasNext()) {
            Borrow borrow = it.next();
            if (borrow.deadlineDate.before(now))
                System.out.println("Borrower => Full Name: " + borrow.borrower.getFirstName() + " " + borrow.borrower.getLastName());
                System.out.println(" | ID: " + borrow.borrower.getIdNum());
                System.out.println("IssuedDate =>" + borrow.getIssuedDate());
                System.out.println("Deadline =>" + borrow.getDeadlineDate());
        }
    }

}
