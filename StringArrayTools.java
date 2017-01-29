/** The class StringArrayTools implements a variety of basic array tasks
  * using an array of Strings.
  * 
  * The array has a fixed length MAX_NUMS but the actual number of elements
  * that are used can vary.
  */

import java.util.Scanner;

public class StringArrayTools
{
  
  private String[] arrayData;
  private int arrayCount;
  public final int MAX_NUMS = 100;
  
  // ------------------ CONSTRUCTOR ----------------------------
  /** The contsructor merely creates the array.
    * It does not fill it with any data.  That is left up to 
    * the fillRandom or fillKeyboard methods.
    */
  public StringArrayTools ()
  {
    arrayData = new String[MAX_NUMS];
    arrayCount = 0;
  }
  
  /** Returns the number of objects in the array.
    * @return the count of items in the array. */
  public int getCount ()
  {
    return arrayCount;
  }
  
  // ------------------- METHODS TO FILL THE ARRAY -------------------------
  /** Adds an element to the end of the array. 
    * @param n The element to add
    * @return whether the element was successfully added
    */
  public boolean addItem (String n)
  {
    if (arrayCount < MAX_NUMS)
    {
      arrayData[arrayCount] = n;
      arrayCount++;
      return true;
    }
    else
      return false;
  }
  
    /** Fills the array nums with integers from 1 to n
    * @param n Upper bound for numbers with which to fill the array.
    * @param count the array to fill.  Returns a modified array.
    */
  
  /*
  public void fillRandom (int n, int count)
  {
    if (count > MAX_NUMS)       // check that it's not too many items
      count = MAX_NUMS;
    for (int i = 0; i < count; i++)
      addItem((int)(Math.random() * n) + 1);
  }
  */
  
  /** Fills the array with Strings entered by the user
    * @param nums the array to fill.  Returns a modified array.
    */
  public void fillKeyboard ()
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println ("Please enter one String per line.");
    System.out.println ("Enter a blank String to signal the end of the list.");
    
    arrayCount = 0;
    String n = keyboard.nextLine();
    while (n.length() != 0)                 // stop input when user enters a blank string
    {
      addItem(n);
      n = keyboard.nextLine();
    }
      keyboard.close();
  }
  
  // -------------------- METHODS TO WORK WITH THE ARRAY --------------------------
  /** Prints the array, lines between Strings.
    */
  public void printArray ()
  {
    for (int i = 0; i < arrayCount; i++)
      System.out.println (arrayData[i]);
    System.out.println();
  }
  
  /** Find the sum of the letters of a String array
    * @return the sum of the letters in the array
    */
  public int sumArray ()
  {
    int sum = 0;
    for (int i = 0; i < arrayCount; i++)
      sum = sum + arrayData[i].length();
    return sum;
  }
  
  /** Find the largest String of the String array
    * @return the largest String
    */
  public int getMax()
  {
    int max = arrayData[0].length();
    
    for(int i = 1; i < arrayCount; i++)
    {
     if (arrayData[i].length() > max)
       max = arrayData[i].length();
    }
    return max;
  }
  
  /** Find the index of the largest String of the String array
    * @return the index of the largest String
    */
  public int getMaxIndex()
  {
    int max = arrayData[0].length();
    int n = 0;
    
    for(int i = 1; i < arrayCount; i++)
    {
     if (arrayData[i].length() > max)
     {
       max = arrayData[i].length();
       n = i;
     }
    }
    return n;
  }
  
  /** Find the smallest String of the String array
    * @return the smallest String
    */
  public int getMin()
  {
    int min = arrayData[0].length();
    
    for(int i = 1; i < arrayCount; i++)
    {
     if (arrayData[i].length() < min)
       min = arrayData[i].length();
    }
    return min;    
  }
  
  /** Find the index of the smallest String of the String array
    * @return the index of the smallest String
    */

  public int getMinIndex()
  {
    int min = arrayData[0].length();
    int n = 0;
    
    for(int i = 1; i < arrayCount; i++)
    {
     if (arrayData[i].length() < min)
     {
       min = arrayData[i].length();
       n = i;
     }
    }
    return n;    
  }
  
  /** Find the index of the smallest String of the String array
    * @param start the starting position
    * @return the index of the smallest String
    */
  public int getMinIndex(int start)
  {
   int pos = start;
   
   for (int i = start; i < arrayCount; i++)
     if (arrayData[i].compareToIgnoreCase(arrayData[pos]) < 0)
       pos = i;
   
   return pos;
  }
  
  /** Sorts the String array in alphabetical order and prints each pass*/
  public void sort()
  {
   for(int pos = 0; pos < arrayCount - 1; pos++)
   {
    int min = getMinIndex(pos);
    String temp = arrayData[min];
    arrayData[min] = arrayData[pos];
    arrayData[pos] = temp;
    
    System.out.println("Pass number " + pos);
    printArray();
    System.out.println();
   }
  }

  
  /** Tests the various array tools */
  public static void main (String[] args)
  {
    StringArrayTools myArray = new StringArrayTools();
    //myArray.fillRandom(100, 12);
    myArray.fillKeyboard ();
    myArray.printArray ();
    System.out.println ("There are " + myArray.getCount() + " Strings in the array.");
    System.out.println ("The sum of the letters are " + myArray.sumArray());
    
    // Un-comment these lines one at a time after you have written the appropriate code
    System.out.println ("The largest String is " + myArray.getMax() + " letters"); 
    System.out.println ("The largest String is at index " + myArray.getMaxIndex());

    System.out.println ("The smallest String is " + myArray.getMin() );
    System.out.println ("The smallest String is at index " + myArray.getMinIndex());
    
    myArray.sort();
  }
}