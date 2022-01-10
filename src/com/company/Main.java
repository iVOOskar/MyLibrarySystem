package com.company;





import java.util.Scanner;
import com.company.library.libraryFunctions;


public class Main {


        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            libraryFunctions.CreateUserFile();
            System.out.println("Do you want to login in or make a new user");
            System.out.println("1.login");
            System.out.println("2.Make new user");
            try{
                int choice = input.nextInt();
                if (choice == 1){
                    libraryFunctions.checkUserLogin();
                }else if (choice == 2) {
                    libraryFunctions.WriteToUserFile();
                }else{
                    System.out.println("This is not an option try again");
                }
            }catch (Exception e){
                System.out.println("error occurred "+e);
            }
        }
    }
