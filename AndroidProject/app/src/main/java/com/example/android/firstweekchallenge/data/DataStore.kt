package com.example.android.firstweekchallenge.data


//**                      **
//**      SINGLETON       **
//**                      **

public class DataStore private constructor(){

    init {
        println("Initialize account ... ")
    }

    companion object {
        var fullName:String?="";
        var email:String?="";
        var password:String?="";
        var phoneNumber:String?="";


        init{
            println("Account(email='$email', fullName='$fullName', password='$password')")
        }

    }

}
