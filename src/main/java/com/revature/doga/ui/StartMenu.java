package com.revature.doga.ui;
import com.revature.doga.models.User;
import com.revature.doga.services.UserService;

import java.util.*;
public class StartMenu implements IMenu{

    private final UserService userService = new UserService();

    @Override
    public void start(){
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Doga!\n");

        exit:{


            while(true){
                displayMessage();
                System.out.print("Enter: ");
                switch(in.nextLine()){
                    case "1":
                        login();
                        break;
                    case "2":
                        signUp();
                        break;
                    case "3":
                        break exit;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        }
    }

    private void displayMessage(){
        System.out.println("[1] Login");
        System.out.println("[2] Signup");
        System.out.println("[3] Exit");
        System.out.println();
    }

    private void login(){
        System.out.println("Needs implementation");
    }

    private void signUp(){
        Scanner in = new Scanner(System.in);
        String username = "";
        String password = "";
        System.out.println("\nCreating Account...");

        while (true) {
            System.out.print("\nUsername: ");
            username = in.nextLine();

            if(userService.isValidUsername(username)){
                System.out.println("Strong username.");
                break;
            }else
                System.out.println("Invalid username.");
        }

        while(true){
            System.out.print("\nPassword: ");
            password = in.nextLine();

            if(userService.isValidPassword(password))
                break;
            else
                System.out.println("Invalid Password.");

            System.out.print("\nConfirm Password: ");
            String confirmPassword = in.nextLine();

            if(password.equals(confirmPassword))
                break;
            else
                System.out.println("Password do not match");
        }

        confirmExit:{
            while(true){
                System.out.println("\nPlease confirm your credentials (Y/N)");
                System.out.println("\nUsername: "+username);
                System.out.println("\nPassword: "+password);
                System.out.print(">>");
                switch(in.nextLine()){
                    case "Y":
                        User user = new User(username, password);
                        break confirmExit;
                    case "N":
                        break confirmExit;
                    default:
                        System.out.println("Invalid Input");
                        break;
                }
            }
        }

    }
}
