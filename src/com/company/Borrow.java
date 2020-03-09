package com.company;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class Borrow {
    /**
     * @author Mina Beiki
     * @version 0.1
     */
    User borrower;
    Book borrowedBook;
    Date issuedDate;
    Date deadlineDate;

    /**
     * generates a new borrow which contains the borrower and borrowed book.
     * @param newFirstName first name of user who borrowed a book
     * @param newLastName last name of user who borrowed a book
     * @param newID ID of user who borrowed a book
     * @param newTitle Title of the borrowed book
     * @param newAuthor Author of the borrowed book
     */
    public Borrow(String newFirstName , String newLastName , String newID ,String newTitle , String newAuthor,int year,int month,int day , int hour,int minute,int second ){
        User borrower =new User(newFirstName,newLastName,newID);
        Book borrowedBook =new Book(newTitle,newAuthor);
        Date issuedDate = new Date();
        Calendar calendar =  new GregorianCalendar(year,month,day,hour,minute,second);
        Date deadlineDate= calendar.getTime();
    }

    /**
     * prints all data for each borrow : name of the borrower
     , ID , IssuedDate , DeadLine Date , Remaining time until deadline
     */
    public void print(){
        System.out.println("Borrower => Full Name: "+borrower.getFirstName()+" "+borrower.getLastName());
        System.out.println(" | ID: "+borrower.getIdNum());
        System.out.println("IssuedDate =>"+issuedDate);
        System.out.println("Deadline =>"+deadlineDate);
        System.out.print(getDateDiff(issuedDate,deadlineDate,TimeUnit.DAYS)+"Days"+getDateDiff(issuedDate,deadlineDate,TimeUnit.HOURS)+"Hours");
        System.out.println(getDateDiff(issuedDate,deadlineDate,TimeUnit.MINUTES)+"Minutes"+getDateDiff(issuedDate,deadlineDate,TimeUnit.SECONDS)+"Seconds");
    }

    /**
     * checks if the issued time is before the deadline
     * @return true if issued time is before deadline and false if the opposite
     */
    public boolean checkTime(){
        if (issuedDate.before(deadlineDate))
            return true;
        else
            return false;
    }

    /**
     *
     * @param newUser sets borrower
     */
    public void setBorrower(User newUser){
        borrower=newUser;
    }

    /**
     *
     * @param newBook sets borrowed book
     */
    public void setBorrowedBook(Book newBook){
        borrowedBook=newBook;
    }

    /**
     *
     * @return returns borrower
     */
    public User getBorrower(){
        return borrower;
    }

    /**
     *
     * @return returns borrowed book
     */
    public Book getBorrowedBook(){
        return borrowedBook;
    }

    /**
     * sets deadline date
     * @param year year of deadline date
     * @param month month of deadline date
     * @param day day of deadline date
     * @param hour hour of deadline date
     * @param minute minute of deadline date
     * @param second second of deadline date
     */
    public void setDeadlineDate(int year,int month , int day , int hour , int minute , int second ) {
        Calendar calendar =  new GregorianCalendar(year,month,day,hour,minute,second);
        Date deadlineDate= calendar.getTime();
    }

    /**
     * sets issued date
     */
    public void setIssuedDate(){
        issuedDate = new Date();
    }

    /**
     *
     * @return returns issued date
     */
    public Date getIssuedDate(){
        return issuedDate;
    }

    /**
     *
     * @return returns deadline date
     */
    public Date getDeadlineDate(){
        return deadlineDate;
    }

    /**
     * Get a diff between two dates
     * @param date1 the oldest date
     * @param date2 the newest date
     * @param timeUnit the unit in which you want the diff
     * @return the diff value, in the provided unit
     */
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
}
