package com.revature.doga.services;

public class UserService {
    public boolean isValidUsername(String username){
        return username.matches("^(?!.*[-_]{2,})(?=^[^-_].*[^-_]$)[\\w\\s-]{3,9}$");
    }
    public boolean isValidPassword(String password){
        //                              digit      lowercase  uppercase  special char    no spaces 8 characters long
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    }
}
