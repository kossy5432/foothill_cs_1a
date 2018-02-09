public class Foothill
{
   public static void main(String[] args)
   {
      System.out.println("My first name is Kazuki");
      System.out.println("My Student ID is 20276081");
      System.out.println("The number of characters in my first name is 6");
      int myId;
      int numLet;
      myId = 20276081;
      numLet = 6;
      int intresult;
      intresult = myId % 17;
      System.out.println("Expression #1 --> "  + intresult);
      intresult = (numLet + 17) % 11;
      System.out.println("Expression #2 --> " + intresult);
      double doubleresult;
      doubleresult = (double)myId / (numLet + 800);
      System.out.println("Expression #3 --> " + doubleresult);
      intresult = 1 + 2 + 3 + 4 + 5 + numLet;
      System.out.println("Expression #4 --> " + intresult);
      doubleresult = (double)15000 / (80 + ((myId - 123456)/((numLet + 20) * (numLet + 20))));
      System.out.println("Expression #5 --> " + doubleresult);
   }
}

/* ------------ Paste of run from console window --------------

My first name is Kazuki
My Student ID is 20276081
The number of characters in my first name is 6
Expression #1 --> 11
Expression #2 --> 1
Expression #3 --> 25156.428039702234
Expression #4 --> 21
Expression #5 --> 0.5018232912916931


-------------------------------------------------------------- */