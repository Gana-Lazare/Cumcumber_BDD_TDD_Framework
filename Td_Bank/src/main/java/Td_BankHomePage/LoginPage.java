package Td_BankHomePage;

import common.WebAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoginPage extends WebAPI {
    private  String userName=null;
    private String password=null;


    public LoginPage(String userName,String password){
        this.userName=userName;
        this.password=password;
    }

    public String getUserName(){
        return this.userName;
    }
    public String getPassword(){
        return this.password;
    }

   // public HashMap<String,String> logINCredentials(){}
    public List<String>  getuserNameList(){
        List<String> userNameList=new ArrayList<>();
        userNameList.add("123test1");
        userNameList.add("123test2");
        userNameList.add("123test3");
        return userNameList;
    }
    public List<String>  getuserPasswordList(){
        List<String> userPasswordList=new ArrayList<>();
        userPasswordList.add("test1");
        userPasswordList.add("test2");
        userPasswordList.add("test3");
        return userPasswordList;
    }

}
