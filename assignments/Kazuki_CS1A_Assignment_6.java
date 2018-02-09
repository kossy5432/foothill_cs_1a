//CS1A Assignment_6 Kazuki Koshimizu


import java.util.*;
public class Foothill
{
   public static void main(String[] args)
   { 
      //declare the reference
      TripleString apple, banana, berry, lemon;
      
      //instantiate 4 kinds of fruits
      apple = new TripleString("apple", "red", "sweet");
        
      banana = new TripleString("banana", "yellow", "");
           
      berry = new TripleString("american canadian mexican british french chinese japanese "
            + "african small tiny big sweet bitter sour berry", "purple", "small"); 
            
      lemon = new TripleString("lemon", "yello pink black orange green red purple brown "
            + "fox jumps over the lazy dog ", "round");
      
      //1st try
      System.out.println("\n===========1st try=========\n");
      System.out.println(apple);
      System.out.println(banana);
      System.out.println(berry);
      System.out.println(lemon);
      
      //mutate
      apple.setString1("green");
      banana.setString3("long shape");
      berry.setString1("american canadian berry");
      lemon.setString3("");
      
      //2nd try
      System.out.println("\n===========2nd try=========\n");
      System.out.println(apple);
      System.out.println(banana);
      System.out.println(berry);
      System.out.println(lemon);
            
      //check mutator works
      System.out.println("\n===========mutator working test=========\n");
      if(banana.setString1("banana_is_banana"))
      {
         System.out.println("It's legal! Mutator successed!\n" + banana);
      }
      else
      {
         System.out.println("It's illegal. Nothing changed\n" + banana);
      }
      
      if(lemon.setString1("The lemon, Citrus limon (L.) Osbeck, is a species "
            + "of small evergreen tree in the flowering plant family Rutaceae, native to Asia."))
      {
         System.out.println("Mutator successed!\n" + lemon);
      }
      else
      {
         System.out.println("Something wrong...Nothing changed\n" + lemon);
      }
            
      //accessor call
      System.out.println("\n===========Accessor try=========\n");
      System.out.println(apple.getString1());
      System.out.println(lemon.getString3());   
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


===========1st try=========

strings inside this object->apple:red:sweet
strings inside this object->banana:yellow:(undefined)
strings inside this object->(undefined):purple:small
strings inside this object->lemon:(undefined):round

===========2nd try=========

strings inside this object->green:red:sweet
strings inside this object->banana:yellow:long shape
strings inside this object->american canadian berry:purple:small
strings inside this object->lemon:(undefined):round

===========mutator working test=========

It's legal! Mutator successed!
strings inside this object->banana_is_banana:yellow:long shape
Something wrong...Nothing changed
strings inside this object->lemon:(undefined):round

===========Accessor try=========

green
round

-------------------------------------------------------------- */