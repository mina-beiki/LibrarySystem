package com.company;

public class Book {
    /**
     *
     * This class represents one book in a library with a specified title & author .
     * @author Mina beiki
     * @version 0.1
     */
    private String title;
    private String author;

    public Book(String newTitle, String newAuthor) {
        //title = Name of the book
        title = newTitle;
        //author= Name of the author of the book
        author = newAuthor;
    }

    /**
     * gets the title of the book.
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * gets the author of the book.
     * @return author
     */

    public String getAuthor() {
        return author;
    }

    /**
     * prints all data for a book.
     */
    public void print() {
        System.out.println("Title: " + title + " | Author: " + author);
    }

    /**
     * Checks if 2 books are the same or not.
     * @param book1 first book to check
     * @param book2 second book to check
     * @return boolean if the same returns true and if not returns false ;
     */
    public boolean checkBooks (Book book1 , Book book2 ){
        if(book1.author==book2.author&&book1.title==book2.title)
            return true;
        else
            return false;
    }

}
