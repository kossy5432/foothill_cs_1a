//CS1A Assignment 10 Kazuki Koshimizu

public class Foothill
{
   public static void main (String[] args)
   {   
      int k;
      Student student;
      
      Student[] myClass = { new Student("smith","fred", 95), 
         new Student("bauer","jack",123),
         new Student("jacobs","carrie", 195), 
         new Student("renquist","abe",148),
         new Student("3ackson","trevor", 108), 
         new Student("perry","fred",225),
         new Student("loceff","fred", 44), 
         new Student("stollings","pamela",452),
         new Student("charters","rodney", 295), 
         new Student("cassar","john",21),
      };
      
      // instantiate a StudArrUtilObject
      StudentArrayUtilities myStuds = new StudentArrayUtilities();
      
      // we can add stdunts manually and individually
      myStuds.addStudent( new Student("bartman", "petra", 102) );
      myStuds.addStudent( new Student("charters","rodney", 295));
      
      // if we happen to have an array available, we can add students in loop.
      for (k = 0; k < myClass.length; k++)
         myStuds.addStudent( myClass[k] );

      System.out.println( myStuds.toString("Before: "));
      
      
      myStuds.arraySort();
      System.out.println( myStuds.toString("Sorting by default: "));
      
      Student.setSortKey(Student.SORT_BY_FIRST);
      myStuds.arraySort();
      System.out.println( myStuds.toString("Sorting by first name: "));
      
      Student.setSortKey(Student.SORT_BY_POINTS);
      myStuds.arraySort();
      System.out.println( myStuds.toString("Sorting by total points: "));
      
      // test median
      System.out.println("Median of evenClass = "
         +  myStuds.getMedianDestructive() + "\n");
      
      //test remove
      myStuds.removeStudent();
      System.out.println(myStuds.toString("\nrtest removing one student"));
      
      //removing too many students
      for (k = 0; k < 100; k++)
      {
         if ( (student = myStuds.removeStudent()) != null)
            System.out.println("Removed " + student);
         else
         {
            System.out.println("Empty after " + k + " removes.");
            break;
         }
      }
      
      System.out.println(myStuds.toString("\n After lots of removing===="));
      System.out.println("Median of evenClass = "
            +  myStuds.getMedianDestructive() + "\n");
      
      
      //testing adding too many students
      for (k = 0; k < 100; k++)
      {
         if (!myStuds.addStudent(new Student("first", "last", 22)))
         {
            System.out.println("Full after " + k + " adds.");
            break;
         }
      }
      
      System.out.println(myStuds.toString("\nAfter lots of adding======"));
      
      
    
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
   public static int compareTwoStudents( Student firstStud, Student secondStud )
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
   
   public final static int MAX_STUDENT = 20;
   private static Student[] theArray = new Student[MAX_STUDENT];
   private int numStudents = 0;
   
   // print the array with string as a title for the message box
   // this is somewhat controversial - we may or may not want an I/O
   // methods in this class.  we'll accept it today
   public String toString(String title)
   {
      String output = title + "\n";
 
      // build the output string from the individual Students:
      for (int k = 0; k < theArray.length; k++)
         output += " "+ theArray[k];

      // now put it in a console window
      return output + "\n";
   }
   
   
      
   // returns true if a modification was made to the array
   private static boolean floatLargestToTop(Student[] data, int top)
   {
      boolean changed = false;
      Student temp;

      // compare with client call to see where the loop stops
      for (int j = 0; j < top - 1; j++)
         //if ( Student.compareTwoStudents(data[j], data[j + 1]) > 0 )
         if (Student.compareTwoStudents(theArray[j], theArray[j + 1]) > 0)
         {
            temp = data[j];
            data[j] = data[j + 1];
            data[j + 1] = temp;
            changed = true;
         }
      return changed;
   }

   // public callable arraySort() - assumes Student class has a compareTo()
   public void arraySort()
   {
      for (int k = 0; k < numStudents; k++)
         // compare with method def to see where inner loop stops
         if ( !floatLargestToTop(theArray, numStudents - k) )
            return;
   }
   
   //returns the median of the total scores of all the students in the array
   public double getMedianDestructive()

   {
      double median = 0.0;
      int midObjectNum;
      int tempSortKey;
      
      if (theArray[0] == null)
      {
         return 0.0;
      }
      else
      {
         //get client sort key and store
         tempSortKey = Student.getSortKey();
         
         //sort by points
         Student.setSortKey(Student.SORT_BY_POINTS);
         arraySort();
         
         midObjectNum = (theArray.length) / 2;
         
         switch (theArray.length % 2)
         {
            case 0:
            {
               median = ((double)(theArray[midObjectNum].getTotalPoints())
                     + (double)(theArray[ midObjectNum - 1].getTotalPoints())) / 2;
               break;
            }
            
            case 1:
            {
               median = (theArray[midObjectNum].getTotalPoints());
               break;
            }
         }
         
         //recover original sortKey
         Student.setSortKey(tempSortKey);
         arraySort();
         
         return median;
      }
   }
   
   public boolean addStudent(Student stud)
   {
      if ((stud == null)||(numStudents == MAX_STUDENT))
      {
         return false;
      }
      else
      {
         theArray[numStudents] = stud;
         numStudents ++;
         return true;
      }
   }
   
   public Student removeStudent()
   {
      if(numStudents == 0)
      {
         theArray[numStudents] = null;
         return null;
      }
      else
      {    
         theArray[numStudents] = null;
         numStudents --;
      }
      return theArray[numStudents];
   }  
}

/* ------------ Paste of run from console window --------------
Before: 
  bartman, petra points: 102
  charters, rodney points: 295
  smith, fred points: 95
  bauer, jack points: 123
  jacobs, carrie points: 195
  renquist, abe points: 148
  zz-error, trevor points: 108
  perry, fred points: 225
  loceff, fred points: 44
  stollings, pamela points: 452
  charters, rodney points: 295
  cassar, john points: 21
 null null null null null null null null

Sorting by default: 
  bartman, petra points: 102
  bauer, jack points: 123
  cassar, john points: 21
  charters, rodney points: 295
  charters, rodney points: 295
  jacobs, carrie points: 195
  loceff, fred points: 44
  perry, fred points: 225
  renquist, abe points: 148
  smith, fred points: 95
  stollings, pamela points: 452
  zz-error, trevor points: 108
 null null null null null null null null

Sorting by first name: 
  renquist, abe points: 148
  jacobs, carrie points: 195
  loceff, fred points: 44
  perry, fred points: 225
  smith, fred points: 95
  bauer, jack points: 123
  cassar, john points: 21
  stollings, pamela points: 452
  bartman, petra points: 102
  charters, rodney points: 295
  charters, rodney points: 295
  zz-error, trevor points: 108
 null null null null null null null null

Sorting by total points: 
  cassar, john points: 21
  loceff, fred points: 44
  smith, fred points: 95
  bartman, petra points: 102
  zz-error, trevor points: 108
  bauer, jack points: 123
  renquist, abe points: 148
  jacobs, carrie points: 195
  perry, fred points: 225
  charters, rodney points: 295
  charters, rodney points: 295
  stollings, pamela points: 452
 null null null null null null null null

Median of evenClass = 295.0


rtest removing one student
  cassar, john points: 21
  loceff, fred points: 44
  smith, fred points: 95
  bartman, petra points: 102
  zz-error, trevor points: 108
  bauer, jack points: 123
  renquist, abe points: 148
  jacobs, carrie points: 195
  perry, fred points: 225
  charters, rodney points: 295
  charters, rodney points: 295
  stollings, pamela points: 452
 null null null null null null null null

Removed  charters, rodney points: 295

Removed  charters, rodney points: 295

Removed  perry, fred points: 225

Removed  jacobs, carrie points: 195

Removed  renquist, abe points: 148

Removed  bauer, jack points: 123

Removed  zz-error, trevor points: 108

Removed  bartman, petra points: 102

Removed  smith, fred points: 95

Removed  loceff, fred points: 44

Removed  cassar, john points: 21

Empty after 11 removes.

 After lots of removing====
 null null null null null null null null null null null null null null null null
 null null null null

Median of evenClass = 0.0

Full after 20 adds.

After lots of adding======
  first, last points: 22
  first, last points: 22
  first, last points: 22
  first, last points: 22
  first, last points: 22
  first, last points: 22
  first, last points: 22
  first, last points: 22
  first, last points: 22
  first, last points: 22
  first, last points: 22
  first, last points: 22
  first, last points: 22
  first, last points: 22
  first, last points: 22
  first, last points: 22
  first, last points: 22
  first, last points: 22
  first, last points: 22
  first, last points: 22



-------------------------------------------------------------- */