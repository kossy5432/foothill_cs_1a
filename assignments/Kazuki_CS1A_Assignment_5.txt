//CS 1A Word Processing Assignment_5 Kazuki Koshimizu

import java.text.*;
import java.util.*;

public class Foothill
{
   static final int minChar = 4;
   static final int maxChar = 100;
   static int count1, count2, keyCount;
   static String userIntString, userIntKey, maskedString, removedString;
   static boolean check = true;
   
   
   public static void main (String[] args)
   {
       getKeyCharacter(); 
       getString();
       maskCharacter();
       removeCharacter();
       countKey();
   }
   
   public static void getKeyCharacter()
   {
      while (check)
      {
         System.out.print("Type ONE character that you want to replace > ");
                  
         Scanner inputStream = new Scanner(System.in);
         userIntKey = inputStream.nextLine();
         
         int userIntKeyLength = userIntKey.length();
         if(userIntKeyLength == 1)
         {
          
            return;
         }
         
         check = true;
                  
      }
      
   }
   
   public static void getString()
   {
      
      
      while (check)
         {
            System.out.print("Type a sentence minimum " + minChar + " "
               + "characters and maximum " + maxChar + " characters > \n");                
            Scanner inputStream = new Scanner(System.in);
            userIntString = inputStream.nextLine();
            
            int userIntStrLength = userIntString.length();
            
            if(userIntStrLength >= minChar && userIntStrLength <= maxChar)
            {
               return;
            }
            
            check = true;
         
         }
   }
   
   public static void maskCharacter()
   {
      maskedString = userIntString.replaceAll(userIntKey, "\\$");
      System.out.println("\nString with " + userIntKey + "masked:");
      System.out.println(maskedString);
      return;
   }
   
   public static void removeCharacter()
   {
      removedString = userIntString.replaceAll(userIntKey, "");
      System.out.println("\nString with no " + userIntKey + ":");
      System.out.println(removedString);
      return;
   }
   
   public static void countKey()
   {
      count1 = userIntString.length();
      count2 = removedString.length();
      
      keyCount = count1 - count2;
      
      System.out.println("\n# of " + userIntKey + ":   " + keyCount);
      
   }
  
}




/* ------------ Paste of run from console window #1--------------
Type ONE character that you want to replace > a
Type a sentence minimum 4 characters and maximum 100 characters > 
kefma dlkjsoa  sodskfjsdlkfa      asldkalsa

String with amasked:
kefm$ dlkjso$  sodskfjsdlkf$      $sldk$ls$

String with no a:
kefm dlkjso  sodskfjsdlkf      sldkls

# of a:   6


-------------------------------------------------------------- */

/* ------------ Paste of run from console window #2--------------

Type ONE character that you want to replace > u
Type a sentence minimum 4 characters and maximum 100 characters > 
as
Type a sentence minimum 4 characters and maximum 100 characters > 
as
Type a sentence minimum 4 characters and maximum 100 characters > 
assuu

String with umasked:
ass$$

String with no u:
ass

# of u:   2


-------------------------------------------------------------- */

/* ------------ Paste of run from console window #3--------------

Type ONE character that you want to replace > auh
Type ONE character that you want to replace > kki
Type ONE character that you want to replace > )90
Type ONE character that you want to replace > a
Type a sentence minimum 4 characters and maximum 100 characters > 
ann
Type a sentence minimum 4 characters and maximum 100 characters > 
aaa bbb ccc ddd ee ff  gg

String with amasked:
$$$ bbb ccc ddd ee ff  gg

String with no a:
 bbb ccc ddd ee ff  gg

# of a:   3


-------------------------------------------------------------- */

/* ------------ Paste of run from console window #4--------------

Type ONE character that you want to replace > ajsld
Type ONE character that you want to replace > o
Type a sentence minimum 4 characters and maximum 100 characters > 
in the october, i went to oklahoma to eat octopas

String with omasked:
in the $ct$ber, i went t$ $klah$ma t$ eat $ct$pas

String with no o:
in the ctber, i went t klahma t eat ctpas

# of o:   8


-------------------------------------------------------------- */

