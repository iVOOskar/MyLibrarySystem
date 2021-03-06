package com.company.library;


import com.company.objects.books;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class libraryFunctions {
    private static File bookInfo = new File("libraryBooks.txt");
    private static File userInfo = new File("userLogins.txt");

    private static ArrayList<String> bookNames = new ArrayList<>();
    private static ArrayList <String> isbnNumbers = new ArrayList<>();
    private static ArrayList <String> authors = new ArrayList<>();
    private static ArrayList <String> genres = new ArrayList<>();

    public static void CreateBookFile() {
        try {
            if (bookInfo.createNewFile()) {
                System.out.println("File created: " + bookInfo.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void CreateUserFile() {
        try {
            if (userInfo.createNewFile()) {
                System.out.println("File created: " + userInfo.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void enterBooks(){
        try{
            Scanner input = new Scanner(System.in);
            boolean i = true;
            while (i){
                System.out.println("enter the name of the book, ISBN number, author, genre");
                //user enters the info
                String bookName = input.next();
                bookNames.add(bookName);
                String ISBN = input.next();
                isbnNumbers.add(ISBN);
                String author = input.next();
                authors.add(author);
                String genre = input.next();
                genres.add(genre);

                //books book1 = new books(bookName, ISBN, author, genre);

                System.out.println("Do you want to add another book: y/n");
                String anotherBook = input.next();
                if(anotherBook.equals("y")){

                }else{
                    break;
                }
            }
        }catch (Exception e) {
            System.out.println("there was an error" + e);
        }
    }
    public static void WriteToUserFile() {
        Scanner input = new Scanner(System.in);
        try {
            FileWriter myWriter = new FileWriter(userInfo.getName(), true);
            System.out.println("enter your new username(email) and password, it must contain an upper case, a number, be 10 digits or more and have no spaces");
            String userName = input.next();
            String password = input.next();
            boolean capitalFlag = false;
            boolean numberFlag = false;
            boolean spaceFlag = true;
            boolean atFlag = false;
            if (password.length()>9) {
                char ch;
                for (int i = 0; i < password.length(); i++) {
                    ch = password.charAt(i);
                    if (Character.isUpperCase(ch)) {
                        capitalFlag = true;
                    } else if (Character.isDigit(ch)) {
                        numberFlag = true;
                    } else if (ch == ' ') {
                        spaceFlag = false;
                    }
                }
                for (int i = 0; i < userName.length(); i++) {
                    ch = userName.charAt(i);
                    if (ch == '@') {
                        atFlag = true;
                    }

                }
            }
            if (capitalFlag && numberFlag && spaceFlag && atFlag){
                myWriter.write(userName+"/"+password.hashCode()+"\n");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            }else{
                System.out.println("this password or username is not valid");
            }
        } catch (Exception e) {
            System.out.println("An error occurred "+e);
        }
    }
    public static void WriteToBookFile(){
        try {
            FileWriter myWriter = new FileWriter(bookInfo.getName(), true);
            int arrayLength = bookNames.size();
            for (int i = 0; i < arrayLength; i++) {
                //writes each book to the file
                myWriter.write(bookNames.get(i)+",");
                myWriter.write(isbnNumbers.get(i)+",");
                myWriter.write(authors.get(i)+",");
                myWriter.write(genres.get(i)+"\n");
            }
            myWriter.close();
        }catch(Exception e){
            System.out.println("An error occurred "+e);
        }
    }
    public static void DeleteBookFile() {
        if (bookInfo.delete()) {
            System.out.println("Deleted the file: " + bookInfo.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
    public static void ReadBookFile() {
        try {

            Scanner myReader = new Scanner(bookInfo);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void checkUserLogin() {

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("enter you login details");
            System.out.print("Username:");
            String userName = input.next();
            System.out.print("Password:");
            String password = input.next();
            String hashPass = Integer.toString(password.hashCode());
            String userPlusPass = userName+"/"+hashPass;
            Scanner myReader = new Scanner(userInfo);
            boolean correctPass = false;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals(userPlusPass)){
                    correctPass = true;
                    boolean i = true;
                    while (i) {
                        MainMenu();
                        System.out.println("do you want to return to the main menu:y/n");
                        String menuChoice = input.next();
                        if (menuChoice.equals("y")){

                        }else{
                            break;
                        }
                    }
                }
            }
            if (correctPass){
            }else{
                System.out.println("Incorrect username or password");
            }
            myReader.close();
        }catch(Exception e){
            System.out.println("an error occurred "+e);
        }
    }
    public static void DeleteBook(){
        File tempFile = new File("MyTempFile.txt");
        Scanner input = new Scanner(System.in);
        try {
            Scanner myReader = new Scanner(bookInfo);
            FileWriter myWriter = new FileWriter(tempFile.getName(), false);
            System.out.println("Enter the the info of the book you want to remove in this format:");
            System.out.println("Name,ISBN Number,Author,Genre");
            String lineToRemove = input.next();

            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                if (data.equals(lineToRemove)) continue;
                myWriter.write(data +'\n' );
            }
            myWriter.close();
            myReader.close();

            FileWriter myWriterBooks = new FileWriter(bookInfo.getName(), false);
            Scanner myReaderTempFile = new Scanner(tempFile);
            while (myReaderTempFile.hasNextLine()) {

                String data = myReaderTempFile.nextLine();
                myWriterBooks.write(data +'\n' );
            }
            tempFile.delete();

        }catch(Exception e){
        System.out.println("an error occurred "+e);
        }
    }

    public static void MainMenu() {
        System.out.println("Do you want to add a book, read the file, delete the file or delete a book: 1 or 2 or 3 or 4");
        System.out.println("1. Add a book");
        System.out.println("2. Read File");
        System.out.println("3. Delete File");
        System.out.println("4. Delete a Book");
        Scanner input = new Scanner(System.in);
        try {
            int choice = input.nextInt();
            if (choice == 1) {
                CreateBookFile();
                enterBooks();
                WriteToBookFile();
            } else if (choice == 3) {
                DeleteBookFile();
            } else if (choice == 2) {
                CreateBookFile();
                ReadBookFile();
            }
            else if(choice == 4){
                DeleteBook();
            }
            else {
                System.out.println("This is not an option try again");
            }
        } catch (Exception e) {
            System.out.println("error occurred " + e);
        }
    }
}
