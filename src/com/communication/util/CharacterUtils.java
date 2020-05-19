package com.communication.util;

import java.util.Random;  

public class CharacterUtils {  
  
    public static String getRandomString(int length){  
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  
        Random random = new Random();  
        StringBuffer sb = new StringBuffer();  
          
        for(int i = 0 ; i < length; ++i){  
            int number = random.nextInt(62);//[0,62)  
              
            sb.append(str.charAt(number));  
        }  
        return sb.toString();  
    } 
    
    public static String getRandomCode(int length){  
        String str="0123456789";  
        Random random = new Random();  
        StringBuffer sb = new StringBuffer();  
        for(int i = 0 ; i < length; ++i){  
            int number = random.nextInt(10);//[0,10)  
            sb.append(str.charAt(number));  
        }  
        return sb.toString();  
    }  
    
    public static void main(String[] args){  
        System.out.println(getRandomCode(6));    
    }  
}  