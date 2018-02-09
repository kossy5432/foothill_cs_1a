//CS 1A Software System - Assignment 4 "Yog(h)urt Purchase System"
//Kazuki Koshimizu

import java.util.Scanner;
public class Foothill
{
   //declare point settings
   static final int YOGURT_POINT = 7;
   
   //setting the store name;
   static final String NAME = "Foothill Fro-Yo, LCC";

   //declare often used word
   static final String LINE = "-----------";
   static final String MENU = "Main Menu (Select P or S)\n    Process Purchase (P)\n    Shut down System (S)";
   static final String FINAL = "Your Total Transaction Today";
    
   public static void main(String args [])
   {
      //initialize variable
      String userStrMenu, userStrCoupon;
      int userIntBuy, cart = 0, stamp = 0, correct_3 = 0;
      boolean correct_1 = false;
      
      System.out.println(LINE +"Foothill Fro-Yo, LLC, Yogurt Purchace System" + LINE );
      
      //do same process again and again
      while ( !correct_1)
      {
         //display current info and main menu command
         System.out.println("\nYour Current cart:  " + cart + "yogurts");
         System.out.println("Your current stamp: " + stamp + "stamps");
         System.out.println( "\n" + MENU + "\n");
         
         
         // declare an object for userStrMenu that can be used for console input
         Scanner inputStream = new Scanner(System.in);
         
         //ask user
         System.out.print("Your Command > ");
         userStrMenu = inputStream.nextLine();
         
         //if user select purchase (P)
         if ((userStrMenu.charAt(0) == 'p') || (userStrMenu.charAt(0) == 'P'))
         {
            //ask how many user buy
            System.out.print("\nHow many yogurt you want? > ");
            userIntBuy = inputStream.nextInt();
            cart = cart + userIntBuy;
            stamp = stamp + userIntBuy;
            ++correct_3;   //to avoid free yogurt gift for first purchase
                              
              
            //check credit availability
            if ((stamp >= YOGURT_POINT) && (correct_3 >= 2))
            {
                  
               System.out.print("Now you have "  + stamp + " stamps.\nDo you want to use 7 stamps to get one free yogurt? (Y/N) > ");   
               Scanner inputStreamSecond = new Scanner(System.in);
               userStrCoupon = inputStreamSecond.nextLine();
                     
               //free yogurt process
               if ((userStrCoupon.charAt(0) == 'y') || (userStrCoupon.charAt(0) == 'Y'))
               {
                  stamp = stamp - YOGURT_POINT; //substract yogurt points from "stamp"
                  cart = cart + 1;  //add one yogurt
                  System.out.print("You used 7 stamps to added one yogurt to your cart.");
                   correct_3 = 2; // if user get free yogurt, the user is no longer qualify
                        
               }
               
               else if ((userStrCoupon.charAt(0) == 'n') || (userStrCoupon.charAt(0) == 'N'))
               {
                  System.out.println("You still have " + stamp + " stamps for free yogurts.");
                  --correct_3; // if user opts out for free gift, the program give chance for free gift   
               }
               
               else
               {
                  System.out.println("******Error******\nUse Y or N to answer!");
                  --correct_3;      
               }
                     
            }
            
         }
      
         //when user selects "S"
         else if ((userStrMenu.charAt(0) == 's') || (userStrMenu.charAt(0) == 'S'))
         {
            System.out.println("System is Terminated");
            break;
         }
         
         //when user type wrong letter
         else
         {
            System.out.println("\n******Error******\nUse P or S to answer!");
         }
      
      }
      
      // showing final results
      System.out.println("\n" + LINE + FINAL + LINE);
      System.out.println("\n     Yogurt: " + cart);
      System.out.println("\nThank you for shopping at " + NAME + " today!");
   }
}


/* ------------ Paste of run from console window --------------

-----------Foothill Fro-Yo, LLC, Yogurt Purchace System-----------

Your Current cart:  0yogurts
Your current stamp: 0stamps

Main Menu (Select P or S)
    Process Purchase (P)
    Shut down System (S)

Your Command > wrongtype

******Error******
Use P or S to answer!

Your Current cart:  0yogurts
Your current stamp: 0stamps

Main Menu (Select P or S)
    Process Purchase (P)
    Shut down System (S)

Your Command > p

How many yogurt you want? > 3

Your Current cart:  3yogurts
Your current stamp: 3stamps

Main Menu (Select P or S)
    Process Purchase (P)
    Shut down System (S)

Your Command > purchase

How many yogurt you want? > 4
Now you have 7 stamps.
Do you want to use 7 stamps to get one free yogurt? (Y/N) > y
You used 7 stamps to added one yogurt to your cart.
Your Current cart:  8yogurts
Your current stamp: 0stamps

Main Menu (Select P or S)
    Process Purchase (P)
    Shut down System (S)

Your Command > p

How many yogurt you want? > 6

Your Current cart:  14yogurts
Your current stamp: 6stamps

Main Menu (Select P or S)
    Process Purchase (P)
    Shut down System (S)

Your Command > p

How many yogurt you want? > 4
Now you have 10 stamps.
Do you want to use 7 stamps to get one free yogurt? (Y/N) > no
You still have 10 stamps for free yogurts.

Your Current cart:  18yogurts
Your current stamp: 10stamps

Main Menu (Select P or S)
    Process Purchase (P)
    Shut down System (S)

Your Command > p

How many yogurt you want? > 2
Now you have 12 stamps.
Do you want to use 7 stamps to get one free yogurt? (Y/N) > wrongtype
******Error******
Use Y or N to answer!

Your Current cart:  20yogurts
Your current stamp: 12stamps

Main Menu (Select P or S)
    Process Purchase (P)
    Shut down System (S)

Your Command > p

How many yogurt you want? > 13
Now you have 25 stamps.
Do you want to use 7 stamps to get one free yogurt? (Y/N) > idontknow
******Error******
Use Y or N to answer!

Your Current cart:  33yogurts
Your current stamp: 25stamps

Main Menu (Select P or S)
    Process Purchase (P)
    Shut down System (S)

Your Command > p

How many yogurt you want? > 4
Now you have 29 stamps.
Do you want to use 7 stamps to get one free yogurt? (Y/N) > yes
You used 7 stamps to added one yogurt to your cart.
Your Current cart:  38yogurts
Your current stamp: 22stamps

Main Menu (Select P or S)
    Process Purchase (P)
    Shut down System (S)

Your Command > s
System is Terminated

-----------Your Total Transaction Today-----------

     Yogurt: 38

Thank you for shopping at Foothill Fro-Yo, LCC today!

-------------------------------------------------------------- */

