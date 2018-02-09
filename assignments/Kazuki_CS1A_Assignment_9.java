//CS1A Assignment 9 Kazuki Koshimizu

public class Foothill
{
   public static void main (String[] args)
   {   
      Student[] cs1a = { new Student("smith","fred", 95), 
            new Student("bauer","jack",123),
            new Student("jacobs","carrie", 195), 
            new Student("renquist","abe",148),
            new Student("3ackson","trevor", 108), 
            new Student("perry","fred",225),
            new Student("loceff","fred", 44), 
            new Student("stollings","pamela",452),
            new Student("charters","rodney", 295), 
            new Student("cassar","john",321),
            new Student("carter","james",234),
            new Student("regan","ronald",135),
            new Student("bush","george",198),
            new Student("clinton","william",312),
            new Student("obama","barack",299),
            new Student("trump","donald",10)
      };
      
      System.out.println("Before Sorting #1========");
      StudentArrayUtilities.toString(cs1a);
      
      System.out.println("sorting by default========");         
      StudentArrayUtilities.arraySort(cs1a);
      StudentArrayUtilities.toString(cs1a);
      
      System.out.println("sorting by first========");      
      Student.setSortKey(Student.SORT_BY_FIRST);      
      StudentArrayUtilities.arraySort(cs1a);
      StudentArrayUtilities.toString(cs1a);
      
      System.out.println("sorting by point========");      
      Student.setSortKey(Student.SORT_BY_POINTS);      
      StudentArrayUtilities.arraySort(cs1a);
      StudentArrayUtilities.toString(cs1a);
      
      Student.setSortKey(Student.SORT_BY_FIRST);
      System.out.println("Median of cs1a: " + StudentArrayUtilities.getMedianDestructive(cs1a));
      
      if (Student.getSortKey() == Student.SORT_BY_FIRST)
      {
         System.out.println("Successfully preserved sort key.\n");
      }
      else
      {
         System.out.println("Something went wrong.\n");
      }
      
      System.out.println("cs1b class has 15 odd-numbered students");
      
      Student[] cs1b = { new Student("smith","fred", 95), 
            new Student("bauer","jack",123),
            new Student("jacobs","carrie", 195), 
            new Student("renquist","abe",148),
            new Student("3ackson","trevor", 108), 
            new Student("perry","fred",225),
            new Student("loceff","fred", 44), 
            new Student("stollings","pamela",452),
            new Student("charters","rodney", 295), 
            new Student("cassar","john",321),
            new Student("carter","james",234),
            new Student("regan","ronald",135),
            new Student("bush","george",198),
            new Student("clinton","william",312),
            new Student("obama","barack",299),
      };
      
      System.out.println("Median of cs1b: " + StudentArrayUtilities.getMedianDestructive(cs1b) + "\n");
      
      System.out.println("cs1c class has only one students");
      Student[] cs1c = { new Student("smith","fred", 95)};
      
      System.out.println("Median of cs1c: " + StudentArrayUtilities.getMedianDestructive(cs1c) + "\n");
      
      System.out.println("cs1s has no student");
      Student[] cs1d = null;
      
      System.out.println("Median of cs1d: " + StudentArrayUtilities.getMedianDestructive(cs1d) + "\n");
      
   }
}

class Student
{
  
   private String lastName;
   private String firstName;
   private int totalPoints;
   
   public static final String DEFAULT_NAME = "zz-error";
   public static final int DEFAULT_POINTS = 0;
   public static final int MAX_POINTS = 1000;
   public static final int SORT_BY_FIRST = 88;
   public static final int SORT_BY_LAST = 98;
   public static final int SORT_BY_POINTS = 108;

   private static int sortKey;
   
   // constructor requires parameters - no default supplied
   public Student( String last, String first, int points)
   {
      if ( !setLastName(last) )
         lastName = DEFAULT_NAME;
      if ( !setFirstName(first) )
         firstName = DEFAULT_NAME;
      if ( !setPoints(points) )
         totalPoints = DEFAULT_POINTS;    
   }

   String getLastName() { return lastName; }
   String getFirstName() { return firstName; } 
   int getTotalPoints() { return totalPoints; }
   
   public static int getSortKey() 
   { 
      return sortKey; 
   }

   boolean setLastName(String last)
   {
      if ( !validString(last) )
         return false;
      lastName = last;
      return true;
   }

   boolean setFirstName(String first)
   {
      if ( !validString(first) )
         return false;
      firstName = first;
      return true;
   }

   boolean setPoints(int pts)
   {
      if ( !validPoints(pts) )
         return false;
      totalPoints = pts;
      return true;
   }

   public static boolean setSortKey( int key)
   {
      if ( !validSortKey(key))
         return false;
      sortKey = key;
      return true; 
   }
   
   // could be an instance method and, if so, would take one parameter
   static int compareTwoStudents( Student firstStud, Student secondStud )
   {
      int result;
      
      //sorting by default (default makes sortKey empty, so it skips switch description below!!!
      result = firstStud.lastName.compareToIgnoreCase(secondStud.lastName);
      
      switch (sortKey)
      {
         case SORT_BY_FIRST:
         {
            result = firstStud.firstName.compareToIgnoreCase(secondStud.firstName);
            break;
         }
            
         case SORT_BY_LAST:
         {
            result = firstStud.lastName.compareToIgnoreCase(secondStud.lastName);
            break;
         }
            
         case SORT_BY_POINTS:
         {
            result = firstStud.totalPoints - secondStud.totalPoints;
            break;
         }
      }
         
      return result;
   }
   
   public String toString()
   {
      String resultString;

      resultString = " "+ lastName 
         + ", " + firstName
         + " points: " + totalPoints
         + "\n";
      return resultString;
   }

   private static boolean validString( String testStr )
   {
      if (testStr != null && Character.isLetter(testStr.charAt(0)))
         return true;
      return false;
   }

   private static boolean validPoints( int testPoints )
   {
      if (testPoints >= 0 && testPoints <= MAX_POINTS)
         return true;
      return false;
   }
   
   private static boolean validSortKey( int testKey)
   {
      if (testKey == SORT_BY_FIRST || testKey == SORT_BY_LAST || testKey == SORT_BY_POINTS)
         return true;
      return false;
   }
}


//==============================================================================================
class StudentArrayUtilities
{
   // print the array with string as a title for the message box
   // this is somewhat controversial - we may or may not want an I/O
   // methods in this class.  we'll accept it today
   public static void toString(Student[] data)
   {
      String output = "";

      // build the output string from the individual Students:
      for (int k = 0; k < data.length; k++)
         output += " "+ data[k].toString();

      // now put it in a console window
      System.out.println(output);
   }

   // returns true if a modification was made to the array
   private static boolean floatLargestToTop(Student[] data, int top)
   {
      boolean changed = false;
      Student temp;

      // compare with client call to see where the loop stops
      for (int k = 0; k < top; k++)
         if ( Student.compareTwoStudents(data[k], data[k + 1]) > 0 )
         {
            temp = data[k];
            data[k] = data[k + 1];
            data[k + 1] = temp;
            changed = true;
         }
      return changed;
   }

   // public callable arraySort() - assumes Student class has a compareTo()
   public static void arraySort(Student[] array)
   {
      for (int k = 0; k < array.length; k++)
         // compare with method def to see where inner loop stops
         if ( !floatLargestToTop(array, array.length - 1 - k) )
            return;
   }
   
   //returns the median of the total scores of all the students in the array
   public static double getMedianDestructive(Student[] array)

   {
      double median = 0.0;
      int midObjectNum;
      int tempSortKey;
      
      if (array == null)
      {
         return 0.0;
      }
      else
      {
         //get client sort key and store
         tempSortKey = Student.getSortKey();
         
         
         //sort by points
         Student.setSortKey(Student.SORT_BY_POINTS);
         StudentArrayUtilities.arraySort(array);
         
         midObjectNum = (array.length) / 2;
         
         switch (array.length % 2)
         {
            case 0:
            {
               median = ((double)(array[midObjectNum].getTotalPoints())
                     + (double)(array[ midObjectNum - 1].getTotalPoints())) / 2;
               break;
            }
            
            case 1:
            {
               median = (array[midObjectNum].getTotalPoints());
               break;
            }
         }
         
         //recover original sortKey
         Student.setSortKey(tempSortKey);
         StudentArrayUtilities.arraySort(array);
         
         return median;
      }
   }
}

/* ------------ Paste of run from console window --------------
Before Sorting #1========
  smith, fred points: 95
  bauer, jack points: 123
  jacobs, carrie points: 195
  renquist, abe points: 148
  zz-error, trevor points: 108
  perry, fred points: 225
  loceff, fred points: 44
  stollings, pamela points: 452
  charters, rodney points: 295
  cassar, john points: 321
  carter, james points: 234
  regan, ronald points: 135
  bush, george points: 198
  clinton, william points: 312
  obama, barack points: 299
  trump, donald points: 10

sorting by default========
  bauer, jack points: 123
  bush, george points: 198
  carter, james points: 234
  cassar, john points: 321
  charters, rodney points: 295
  clinton, william points: 312
  jacobs, carrie points: 195
  loceff, fred points: 44
  obama, barack points: 299
  perry, fred points: 225
  regan, ronald points: 135
  renquist, abe points: 148
  smith, fred points: 95
  stollings, pamela points: 452
  trump, donald points: 10
  zz-error, trevor points: 108

sorting by first========
  renquist, abe points: 148
  obama, barack points: 299
  jacobs, carrie points: 195
  trump, donald points: 10
  loceff, fred points: 44
  perry, fred points: 225
  smith, fred points: 95
  bush, george points: 198
  bauer, jack points: 123
  carter, james points: 234
  cassar, john points: 321
  stollings, pamela points: 452
  charters, rodney points: 295
  regan, ronald points: 135
  zz-error, trevor points: 108
  clinton, william points: 312

sorting by point========
  trump, donald points: 10
  loceff, fred points: 44
  smith, fred points: 95
  zz-error, trevor points: 108
  bauer, jack points: 123
  regan, ronald points: 135
  renquist, abe points: 148
  jacobs, carrie points: 195
  bush, george points: 198
  perry, fred points: 225
  carter, james points: 234
  charters, rodney points: 295
  obama, barack points: 299
  clinton, william points: 312
  cassar, john points: 321
  stollings, pamela points: 452

Median of cs1a: 196.5
Successfully preserved sort key.

cs1b class has 15 odd-numbered students
Median of cs1b: 198.0

cs1c class has only one students
Median of cs1c: 95.0

cs1s has no student
Median of cs1d: 0.0

-------------------------------------------------------------- */