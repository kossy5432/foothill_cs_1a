//CS 1A Assignment 7 Kazuki Koshimizu


import java.util.Scanner;

public class Foothill
{
   public static void main(String []args)
   {
      //variables
      int bet, multi, win;
      TripleString casino;
      
      //main process
      while(true)
      {
         bet = getBet();
         if (bet == 0)
         {
            System.out.println("End Slot");
            break;
         }
         casino = pull();
         multi = getPayMultiplier(casino);
         win = bet * multi;
         display(casino, win);        
      }  
   }
   

   public static int getBet()
   {
      int userInt;
      System.out.println("How much would you like to bet (1 - 50) or 0 to quit? ");
      Scanner inputStream = new Scanner(System.in);
      userInt = inputStream.nextInt();
      while ( userInt < 0 || userInt > 50)
      {
         System.out.println("How much would you like to bet (1 - 50) or 0 to quit? ");
         userInt = inputStream.nextInt(); 
      }
      return userInt;     
   }
   
   public static TripleString pull()
   {
      TripleString drum = new TripleString();
      System.out.println("Whirrrrrr");
      drum.setString1(randString());
      drum.setString2(randString());
      drum.setString3(randString());
      return drum;
   }
   
   //random calculaion
   private static String randString()
   {
      double rand;
      rand = Math.random();
      if (rand >= 0 && rand < 0.38)
         return "BAR";
      else if (rand >= 0.38 && rand < 0.78)
         return "cherries";
      else if (rand >= 0.78 && rand < 0.85)
         return "space";
      else
         return "7";
   }
   
   
   //get multiplier calculation
   public static int getPayMultiplier(TripleString thePull)
   {
      if (thePull.getString1() == "7" && thePull.getString2() == "7" && thePull.getString3() == "7")
      {
         return 100;
      }
      
      else if (thePull.getString1() == "BAR" && thePull.getString2() == "BAR" && thePull.getString3() == "BAR")
      {
         return 50;
      }
      
      else if (thePull.getString1() == "cherries" && thePull.getString2() == "cherries" && thePull.getString3() == "cherries")
      {
         return 30;
      }
      
      else if (thePull.getString1() == "cherries" && thePull.getString2() == "cherries")
      {
         return 15;
      }
      
      else if (thePull.getString1() == "cherries")
      {
         return 5;
      }
      
      else
      {
         return 0;
      }
   }
   
   
      
   public static void display(TripleString thePull, int win)
   {
      String display;
      display = thePull.getString1() + " " + thePull.getString2() + " " + thePull.getString3();
      System.out.println(display);
      
      if (win == 0)
      {
         System.out.println("Sorry. you lost.\n");
      }
      else
      {
         System.out.println("Congraturation! You won " + win +"\n");
      }
   }
}
   
   
//TripleString class===========================================================
class TripleString
{
 //declare final variables
 public static final int MAX_LEN = 50;
 public static final int MIN_LEN = 1;
 public static final String DEFAULT_STRING = "(undefined)";
 
 //members in the class
 private String string1, string2, string3;
 
 
 //instantiate process
 //default constractor
 TripleString()
 {
    this.string1 = DEFAULT_STRING;
    this.string2 = DEFAULT_STRING;
    this.string3 = DEFAULT_STRING;
 }
 
 //constractor with legal check
 TripleString(String str1, String str2, String str3)
 { 
    if ( !setString1(str1))
       this.string1 = DEFAULT_STRING;
    if ( !setString2(str2))
       this.string2 = DEFAULT_STRING;
    if ( !setString3(str3))
       this.string3 = DEFAULT_STRING;
 }
 
 //Legal or illegal checker=====================================
 private static boolean validString(String str)
 {
    if (str.length() < MIN_LEN || str.length() > MAX_LEN || str == null)
    {
       return false;
    }
    else
    {
    return true;
    }
 }
    
 //Mutator (setter)============================================
 //mutator for string1
 public boolean setString1(String str1)
 {
    if (validString(str1))
    {
       //if legal
       string1 = str1;
       return true;
    }
    return false;
 }
 
 //mutator for string2
 public boolean setString2(String str2)
 {
    if (validString(str2))
    {
       //if legal
       string2 = str2;
       return true;
    }
    return false;
 }
 
 //mutator for string3
 public boolean setString3(String str3)
 {
    if (validString(str3))
    {
       //if legal
       string3 = str3;
       return true;
    }
    return false;
 }
 
 //Accessor (getter)==============================================
 public String getString1()
 {
    return string1;
 }
 
 public String getString2()
 {
    return string2;
 }
 
public String getString3()
{
   return string3;
}

//toString method=================================================
 public String toString()
 {
    return "strings inside this object->" + this.string1 + ":" + this.string2 + ":"+ this.string3;
 }   
}

   







/* ------------ Paste of run from console window --------------


How much would you like to bet (1 - 50) or 0 to quit? 
123
How much would you like to bet (1 - 50) or 0 to quit? 
123
How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR cherries cherries
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR cherries BAR
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR 7 BAR
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR BAR cherries
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries cherries cherries
Congraturation! You won 60

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries BAR cherries
Congraturation! You won 10

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
7 7 7
Congraturation! You won 200

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries BAR BAR
Congraturation! You won 10

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries cherries BAR
Congraturation! You won 30

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
7 7 7
Congraturation! You won 200

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR space BAR
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR cherries cherries
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR 7 cherries
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
7 cherries 7
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR BAR BAR
Congraturation! You won 100

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
7 space BAR
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries space cherries
Congraturation! You won 10

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
7 cherries 7
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR cherries BAR
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
7 cherries cherries
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
7 BAR BAR
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries 7 BAR
Congraturation! You won 10

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries cherries cherries
Congraturation! You won 60

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries 7 cherries
Congraturation! You won 10

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries 7 space
Congraturation! You won 10

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries 7 cherries
Congraturation! You won 10

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries 7 cherries
Congraturation! You won 10

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries cherries cherries
Congraturation! You won 60

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries 7 BAR
Congraturation! You won 10

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR cherries cherries
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries BAR space
Congraturation! You won 10

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR BAR BAR
Congraturation! You won 100

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR BAR BAR
Congraturation! You won 100

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR cherries 7
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR space BAR
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries cherries BAR
Congraturation! You won 30

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR 7 space
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR cherries cherries
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries cherries BAR
Congraturation! You won 30

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR cherries BAR
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries BAR cherries
Congraturation! You won 10

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR cherries space
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR 7 cherries
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR space 7
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries BAR 7
Congraturation! You won 10

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR BAR cherries
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries cherries BAR
Congraturation! You won 30

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries cherries space
Congraturation! You won 30

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
BAR cherries cherries
Sorry. you lost.

How much would you like to bet (1 - 50) or 0 to quit? 
2
Whirrrrrr
cherries 7 BAR
Congraturation! You won 10

How much would you like to bet (1 - 50) or 0 to quit? 
0
End Slot



-------------------------------------------------------------- */