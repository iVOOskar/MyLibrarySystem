package com.company;


import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
    //you can use a 2d array list with: ArrayList<ArrayList<String>> = new ArrayList<>();
// use commas or another deliminator between title, isbn, author and genre
    public class Main {

        private static File bookInfo = new File("libraryBooks.txt");
        private static  ArrayList<String> bookNames = new ArrayList<>();
        private static ArrayList <String> isbnNumbers = new ArrayList<>();
        private static ArrayList <String> authors = new ArrayList<>();
        private static ArrayList <String> genres = new ArrayList<>();

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
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
        public static void CreateFile() {
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
        public static void WriteToFile(){
            try {
                FileWriter myWriter = new FileWriter(bookInfo.getName(), true);
                int arrayLength = bookNames.size();
                for (int i = 0; i < arrayLength; i++) {
                    //writes each book to the file
                    myWriter.write(bookNames.get(i)+", ");
                    myWriter.write(isbnNumbers.get(i)+", ");
                    myWriter.write(authors.get(i)+", ");
                    myWriter.write(genres.get(i)+"\n");
                }
                myWriter.close();
            }catch(Exception e){
                System.out.println("An error occurred "+e);
            }
        }
        public static void DeleteFile() {
            if (bookInfo.delete()) {
                System.out.println("Deleted the file: " + bookInfo.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }
        }
        public static void ReadFile() {
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
        public static void DeleteBook(){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the ISBN number of the book you want to remove");
            String ISBNUnwanted = input.next();
            try {
                Scanner myReader = new Scanner(bookInfo);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    if (data.contains(ISBNUnwanted)) {

                    } else {
                        ArrayList<String> tempArray = new ArrayList<>();
                        tempArray.add(data);
                        FileWriter myWriter = new FileWriter(bookInfo.getName(), false);
                        int tempLength = tempArray.size();
                        for (int i = 0; i < tempLength; i++) {
                            myWriter.write(tempArray.get(i) +"\n");
                        }

                    }
                }

            } catch(Exception e){
                        System.out.println("An error occurred "+e);
                    }
            myWriter.close();
            myReader.close();
                }
        public static void MainMenu() {
            System.out.println("Do you want to write to the file or delete the file: 1 or 2 or 3");
            System.out.println("1. Write");
            System.out.println("2. Read File");
            System.out.println("3. Delete File");
            System.out.println("4. Delete a Book");
            Scanner input = new Scanner(System.in);
            try{
                int choice = input.nextInt();
                if (choice == 1){
                    CreateFile();
                    enterBooks();
                    WriteToFile();
                }else if (choice == 3){
                    DeleteFile();
                }else if (choice == 2){
                    CreateFile();
                    ReadFile();
                }else if(choice == 4){
                    DeleteBook();
                }
                else{
                    System.out.println("This is not an option try again");
                }
            }catch (Exception e){
                System.out.println("error occurred "+e);
            }
        }
    }
