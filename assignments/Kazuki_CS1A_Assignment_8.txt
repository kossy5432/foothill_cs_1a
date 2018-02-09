//CS1A Assignment 8 Computer Dating - by Kazuki Koshimizu

import java.lang.Math;


public class Foothill
{
   
   public static void main(String[] args)
   {
      
      //declare 4 members
      DateProfile Sarah, Steve, Jane, Helen;

      Sarah = new DateProfile('F', 'M', 5, 2, 4, "Sarah Somebody");
      Steve = new DateProfile('M', 'F', 5, 2, 4, "Steve Somebody");
      Jane = new DateProfile('F', 'M', 6, 9, 3, "Jane Somebody");
      Helen = new DateProfile('F', 'F', 1, 2, 3, "Helen Somebody");
      
      //putting these members into arrays
      DateProfile[] profile = new DateProfile[4];
      
      //naming arrays
      profile[0] = Sarah;
      profile[1] = Steve;
      profile[2] = Jane;
      profile[3] = Helen;
      
      //displaying results for each combinations
      for (int i = 0; i < 4; i++)   
      {
         for (int n = 0; n < 4; n++)
         {
            displayTwoProfiles(profile[i], profile[n]);
         }
         System.out.println("");
      }
   
   
      //invalid value test============================================
      if (!Sarah.setGender('D'))
      {
         System.out.println("D is invalid char for gender!");
      }
      
      if (!Steve.setFinance(123092302))
      {
         System.out.println("Steve is too greedy to money!");
      }
      
      if (!Jane.setRomance(-290))
      {
         System.out.println("Jane does not want a partner!");
      }
      
      if (!Helen.setName("Helen Adams Keller (June 27, 1880 – June 1, 1968) was an "
            + "American author, political activist, and lecturer. She was the first "
            + "deaf-blind person to earn a bachelor of arts degree."))
      {
         System.out.println("Put valid name, not career info on wikipedia!");
      }
   
   }
   
   //displaying results
   public static void displayTwoProfiles(DateProfile profile1, DateProfile profile2)
   {
      System.out.println("Fit between " + profile1.getName() + " and " 
            + profile2.getName() + " is:\t" + profile1.fitValue(profile2));
   }

}

class DateProfile
{
   
   //members======================================
   char gender, searchGender;
   int romance, finance, distance;
   String name;
   
   //range limits==================================
   public static final int MIN_ROMANCE = 1;
   public static final int MAX_ROMANCE = 10;
   public static final int MIN_FINANCE = 1;
   public static final int MAX_FINANCE = 10;
   public static final int MIN_DISTANCE = 1;
   public static final int MAX_DISTANCE = 10;
   public static final int MIN_NAME_LEN = 1;
   public static final int MAX_NAME_LEN = 30;
  
   //default value=================================
   public static char DEFAULT_GEN = 'M';
   public static char DEFAULT_SEARCH_GEN = 'M';
   public static int DEFAULT_ROMANCE = 5;
   public static int DEFAULT_FINANCE = 5;
   public static int DEFAULT_DISTANCE = 5;
   public static String DEFAULT_NAME = "(undefined)";
  
      
   //setting all mutator
   public void setAll(char gen, char scgen, int fin, int rom, int dis, String name)
   {
      setGender(gen);
      setSearchGender(scgen);
      setFinance(fin);
      setRomance(rom);
      setDistance(dis);
      setName(name);
   }
   
   //default set
   public void setDefaults()
   {
      gender = DEFAULT_GEN;
      searchGender = DEFAULT_SEARCH_GEN;
      romance = DEFAULT_ROMANCE;
      finance = DEFAULT_ROMANCE;
      distance = DEFAULT_DISTANCE;
      name = DEFAULT_NAME;
   }
   
   //default constructor==========================
   DateProfile()
   {
      setGender(DEFAULT_GEN);
      setSearchGender(DEFAULT_SEARCH_GEN);
      setRomance(DEFAULT_ROMANCE);
      setFinance(DEFAULT_FINANCE);
      setDistance(DEFAULT_DISTANCE);
      setName(DEFAULT_NAME);
   }
   
   //member constructor===========================
   DateProfile(char char1, char char2, int int1, int int2, int int3, String str)
   {
      if (charCheck(char1))
      {
         this.gender = char1;
      }
      else
      {
         this.gender = DEFAULT_GEN;
      }
      
      if (charCheck(char2))
      {
         this.searchGender = char2;
      } 
      else
      {
         this.searchGender = DEFAULT_SEARCH_GEN;
      }
      if (romanceCheck(int1)) 
      {
         this.romance = int1;
      } 
      else
      {
         this.romance = DEFAULT_ROMANCE;
      }
      if (financeCheck(int2)) 
      {
         this.finance = int2;
      }
      else
      {
         this.finance = DEFAULT_FINANCE;
      }
      if (distanceChecek(int3))
      {
         this.distance = int3;
      }
      else
      {
         this.distance = DEFAULT_DISTANCE;
      }
      
      if (nameCheck(str))
      {
         this.name = str;
      }
      else
      {
         this.name = DEFAULT_NAME;
      }
   }

   //mutators gender==================================
   public boolean setGender (char setGender)
   {
      if (charCheck(setGender))
      {
         gender = setGender;
         return true;
      }
      else
      {
         return false;
      }
   }
  
   public boolean setSearchGender (char setSearchGender)
   {
      if (charCheck(setSearchGender))
      {
         searchGender = setSearchGender;
         return true;
      }
      else
      {
         return false;
      }
   }
  
   public boolean setRomance (int setRomance)
   {
      if (romanceCheck(setRomance))
      {
         romance = setRomance;
         return true;
      }
      else
      {
         return false;
      }
   }
  
   public boolean setFinance (int setFinance)
   {
      if (financeCheck(setFinance))
      {
         finance = setFinance;
         return true;
      }
      else
      {
         return false;
      }
   }
  
   public boolean setDistance (int setDistance)
   {
      if (distanceChecek(setDistance))
      {
         finance = setDistance;
        return true;
      }   
      else
      {
         return false;
      }
   }
   
   public boolean setName (String setName)
   {
      if (nameCheck(setName))
      {
         name = setName;
         return true;
      }
     else
     {
        return false;
     }
   }

   //access get
   public char getGender()
   {
      return gender;
   }
   
   public char getSearchGender()
   {
      return searchGender;
   }
   
   public int getRomance()
   {
      return romance;
   }
   
   public int getFinance()
   {
      return finance;
   }
   
   public int getDistance()
   {
      return distance;
   }
   
   public String getName()
   {
      return name;
   }
   
   //legal checker=====================================
   private boolean charCheck (char charCheck)
   {
      if ((charCheck == 'M') || (charCheck == 'F'))
      {
         return true;
      }
      else
      {
         return false;
      }      
   }
  
   private boolean romanceCheck (int rmchk)
   {
      if ((rmchk < MIN_ROMANCE) || (rmchk > MAX_ROMANCE))
      {
         return false;
      }
      else
      {
         return true;
      }
   }
   
   private boolean financeCheck (int fnchk)
   {
      if ((fnchk < MIN_FINANCE) || (fnchk > MAX_FINANCE))
      {
         return false;
         }
      else
      {
         return true;
      }
   }
   
   private boolean distanceChecek (int dtchk)
   {
      if ((dtchk < MIN_DISTANCE) || (dtchk > MAX_DISTANCE))
      {
         return false;
      }
      else
      {
         return true;
      }
   }
   
   private boolean nameCheck (String nmchk)
   {
      if ((nmchk.length() < MIN_NAME_LEN) || (nmchk.length() > MAX_NAME_LEN) || (nmchk == null))
      {
         return false;
      }
      else
      {
         return true;
      }
   }
   
   //calculating fitValue==============================
   public double fitValue(DateProfile profile)
   {
      return Math.round((determineGenderFit(profile) * determineRomanceFit(profile) * determineFinanceFit(profile) * determineDistanceFit(profile)) * 100.0) / 100.0;
   }
   
   private double determineGenderFit(DateProfile profile) 
   {
      if (profile.getGender() == this.getSearchGender() && profile.getSearchGender() == this.getGender()) {
         return 1.0;
      }
      return 0.0;
   }
   
   private double determineRomanceFit (DateProfile partner)
   {
      return 1.0 - abs(partner.getRomance() - this.getRomance()) / 10.0;
   }
   
   private double determineFinanceFit (DateProfile partner) 
   {
      return 1.0 - abs(partner.getFinance() - this.getFinance()) / 10.0;
   }
   
   private double determineDistanceFit (DateProfile partner)
   {
      return 1.0 - abs(partner.getDistance() - this.getDistance()) / 10.0;
   }
  
}


/* ------------ Paste of run from console window --------------
Fit between Sarah Somebody and Sarah Somebody is:	0.0
Fit between Sarah Somebody and Steve Somebody is:	1.0
Fit between Sarah Somebody and Jane Somebody is:	0.0
Fit between Sarah Somebody and Helen Somebody is:	0.0

Fit between Steve Somebody and Sarah Somebody is:	1.0
Fit between Steve Somebody and Steve Somebody is:	0.0
Fit between Steve Somebody and Jane Somebody is:	0.24
Fit between Steve Somebody and Helen Somebody is:	0.0

Fit between Jane Somebody and Sarah Somebody is:	0.0
Fit between Jane Somebody and Steve Somebody is:	0.24
Fit between Jane Somebody and Jane Somebody is:	0.0
Fit between Jane Somebody and Helen Somebody is:	0.0

Fit between Helen Somebody and Sarah Somebody is:	0.0
Fit between Helen Somebody and Steve Somebody is:	0.0
Fit between Helen Somebody and Jane Somebody is:	0.0
Fit between Helen Somebody and Helen Somebody is:	1.0

D is invalid char for gender!
Steve is too greedy to money!
Jane does not want a partner!
Put valid name, not career info on wikipedia!

-------------------------------------------------------------- */