/* CS 1A LAB Assignment 3 -----Kazuki Koshimizu-----
   This program ask users what he or she is cooking, calculate total calories, fat, carbon, and protein,
   and tell them.  */

import java.util.Scanner;
public class Foothill
{
   //food #1 info (ingredients per 100 grams)
   static final String FOOD_1_NAME = "cheese";
   static final int FOOD_1_CAL = 215;
   static final double FOOD_1_FAT = 10;
   static final double FOOD_1_CARB = 16;
   static final double FOOD_1_PROTEIN = 16;
   
   //food #2 info (ingredients per 100 grams)
   static final String FOOD_2_NAME = "tomato";
   static final int FOOD_2_CAL = 17;
   static final double FOOD_2_FAT = 0.2;
   static final double FOOD_2_CARB = 3.9;
   static final double FOOD_2_PROTEIN = 0.9;
   
   //food #3 info (ingredients per 100 grams)
   static final String FOOD_3_NAME = "beef patties";
   static final int FOOD_3_CAL = 246;
   static final double FOOD_3_FAT = 17;
   static final double FOOD_3_CARB = 8;
   static final double FOOD_3_PROTEIN = 16;
   
   //food #4 info (ingredients per 100 grams)
   static final String FOOD_4_NAME = "green leaf";
   static final int FOOD_4_CAL = 14;
   static final double FOOD_4_FAT = 0.2;
   static final double FOOD_4_CARB = 2.9;
   static final double FOOD_4_PROTEIN = 1.4;
   
   //food #2 info (ingredients per 100 grams)
   static final String FOOD_5_NAME = "buns";
   static final int FOOD_5_CAL = 228;
   static final double FOOD_5_FAT = 3.6;
   static final double FOOD_5_CARB = 40.8;
   static final double FOOD_5_PROTEIN = 8.1;
   
   //define line breakers
   static final String LINE = "---------------";
   static final String NEW_LINE = "\n";
   static final String VARIABLE_ERROR_INGREDIENTS = "Please put double variables between 0 and 1500!!";
   static final String VARIABLE_ERROR_SERVINGS = "Please put double variables between 1 and 15!!";
   
   public static void main(String[] args)
   {
      //declare variables
      String receipeName;
      int servings;
      double userGrams, totalCal, totalFat, totalCarb, totalProtein;
      
      //initialize double variables
      servings = 0;
      userGrams = 0;
      totalCal = 0;
      totalFat = 0;
      totalCarb = 0;
      totalProtein = 0;
      
      //print available ingredients
      System.out.println(LINE + "Available Ingredients" + LINE);
      System.out.println(FOOD_1_NAME);
      System.out.println(FOOD_2_NAME);
      System.out.println(FOOD_3_NAME);
      System.out.println(FOOD_4_NAME);
      System.out.println(FOOD_5_NAME + NEW_LINE);
      
      // declare an object that can be used for console input
      Scanner inputStream = new Scanner(System.in);
      
      //asking user name of meal
      System.out.print("What is the name of your meal! >");
      receipeName = inputStream.nextLine();
      
      //food #1 calculation
      System.out.print("How many grams of " + FOOD_1_NAME +"? >");
      userGrams = inputStream.nextDouble();
      if ((userGrams < 0) || (userGrams > 1500))
         {
            System.out.println(VARIABLE_ERROR_INGREDIENTS);
            return;
         }
      totalCal +=  userGrams * (FOOD_1_CAL)/100;
      totalFat +=  userGrams * (FOOD_1_FAT)/100;
      totalCarb +=  userGrams * (FOOD_1_CARB)/100;
      totalProtein += userGrams * (FOOD_1_PROTEIN)/100;
           
      //food #2 calculation
      System.out.print("How many grams of " + FOOD_2_NAME +"? >");
      userGrams = inputStream.nextDouble();
      if ((userGrams < 0) || (userGrams > 1500))
         {
            System.out.println(VARIABLE_ERROR_INGREDIENTS);
            return;
         }
      totalCal +=  userGrams * (FOOD_2_CAL)/100;
      totalFat +=  userGrams * (FOOD_2_FAT)/100;
      totalCarb +=  userGrams * (FOOD_2_CARB)/100;
      totalProtein += userGrams * (FOOD_2_PROTEIN)/100;
            
      //food #3 calculation
      System.out.print("How many grams of " + FOOD_3_NAME +"? >");
      userGrams = inputStream.nextDouble();
      if ((userGrams < 0) || (userGrams > 1500))
         {
            System.out.println(VARIABLE_ERROR_INGREDIENTS);
            return;
         }
      totalCal +=  userGrams * (FOOD_3_CAL)/100;
      totalFat +=  userGrams * (FOOD_3_FAT)/100;
      totalCarb +=  userGrams * (FOOD_3_CARB)/100;
      totalProtein += userGrams * (FOOD_3_PROTEIN)/100;
       
      //food #4 calculation
      System.out.print("How many grams of " + FOOD_4_NAME +"? >");
      userGrams = inputStream.nextDouble();
      if ((userGrams < 0) || (userGrams > 1500))
         {
            System.out.println(VARIABLE_ERROR_INGREDIENTS);
            return;
         }
      totalCal +=  userGrams * (FOOD_4_CAL)/100;
      totalFat +=  userGrams * (FOOD_4_FAT)/100;
      totalCarb +=  userGrams * (FOOD_4_CARB)/100;
      totalProtein += userGrams * (FOOD_4_PROTEIN)/100;
            
      //food #5 calculation
      System.out.print("How many grams of " + FOOD_5_NAME +"? >");
      userGrams = inputStream.nextDouble();
      if ((userGrams < 0) || (userGrams > 1500))
      {
         System.out.println(VARIABLE_ERROR_INGREDIENTS);
         return;
      }
      totalCal +=  userGrams * (FOOD_5_CAL)/100;
      totalFat +=  userGrams * (FOOD_5_FAT)/100;
      totalCarb +=  userGrams * (FOOD_5_CARB)/100;
      totalProtein += userGrams * (FOOD_5_PROTEIN)/100;
      
       //process; how many servings?
       System.out.print("How many do you serve " + receipeName + "? >");
       servings = inputStream.nextInt();
       if((servings > 15) || (servings < 1))
       {
          System.out.println(VARIABLE_ERROR_SERVINGS);
          return;
       }
       totalCal = totalCal * servings;
       totalFat = totalFat * servings;
       totalCarb = totalCarb * servings;
       totalProtein = totalProtein * servings;
             
      //output final result
      System.out.println ( NEW_LINE + LINE + "Nutrition Facts of "
            + receipeName + " ("+ servings + " servings)" + LINE + NEW_LINE);
      System.out.println("Total calories: " + totalCal + "[cal]");
      System.out.println("Grams of total fat: " + totalFat + "[g]");
      System.out.println("Grams of total carbon: " + totalCarb + "[g]");
      System.out.println("Grams of total protein: " + totalProtein + "[g]");
   }
}

/* ------------ Paste of run from console window --------------

---------------Available Ingredients---------------
cheese
tomato
beef patties
green leaf
buns

What is the name of your meal! >vegetarian burger
How many grams of cheese? >20
How many grams of tomato? >200
How many grams of beef patties? >0
How many grams of green leaf? >200
How many grams of buns? >200
How many do you serve vegetarian burger? >1

---------------Nutrition Facts of vegetarian burger (1 servings)---------------

Total calories: 561.0[cal]
Grams of total fat: 10.0[g]
Grams of total carbon: 98.39999999999999[g]
Grams of total protein: 24.0[g]


-------------------------------------------------------------- */

