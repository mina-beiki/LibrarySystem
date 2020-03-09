package com.company;

public class User {
    /**
     * This class represents a user with full name & ID who borrows a book .
     * @author Mina Beiki
     * @version 0.1
     */
    private String firstName;
    private String lastName;
    private String idNum;

    /**
     * generates a new user
     * @param newFirstName first name of a user
     * @param newLastName last name of a user
     * @param newID ID of a user
     */
    public User(String newFirstName, String newLastName, String newID) {
        firstName = newFirstName;
        lastName = newLastName;
        idNum = newID;
    }

    /**
     * gets the first name of user
     * @return firstname
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * gets the last name of user
     * @return lastname
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * gets the ID of user
     * @return idNum
     */
    public String getIdNum() {
        return idNum;
    }

    /**
     * prints the data of a user.
     */
    public void print() {
        System.out.println("Full Name: " + firstName + " " + lastName + " | ID: " + idNum);//Full Name: firstName lastName | ID: idNumber
    }

    /**
     * Checks if 2 users have the same ID or not .
     * @param user1 first user to check
     * @param user2 second user to check
     * @return boolean if the same returns true and if not returns false
     */
    public boolean checkUsers(User user1,User user2){
        if(user1.idNum==user2.idNum)
            return true ;
        else
            return false;
    }
}
