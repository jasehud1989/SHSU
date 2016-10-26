/** 
   A driver that demonstrates the class ArraySorter.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public class Driver
{
   private static final Name[] items =
   {
           new Name("Zeke",  "Clayton"), new Name("Bob",   "Clayton"), new Name("Rob",   "Smith"),
           new Name("Ali",   "Babba"),   new Name("Jamie", "Perfect"), new Name("Jody",  "Perfect"),
           new Name("Jim",   "Smith"),   new Name("John",  "Clayton"), new Name("Bill",  "Smith"),
           new Name("Jamie", "Perfect"), new Name("Zeke",  "Clayton")
   };

  public static void main(String[] args)
  {
    for (int count = 11; count > 0; count = count - 5)
    {
      System.out.println(count + " items in array.");
      
      testSort(1, true, "selection sort", count);
      testSort(2, true, "selection sort 2", count);
      testSort(3, false, "insertion sort", count);
      testSort(4, false, "insertion sort 2", count);
      testSort(5, false, "bubble sort", count);
      testSort(6, false, "merge sort", count);
      testSort(7, false, "quick sort", count);
    } // end for
  }  // end main

   public static void testSort(int sort, boolean print, String name, int n)
   {
      System.out.println("\nTesting " + name + ":");
      
      Name[] array = new Name[25];
      copyArray(array, items);
      System.out.println("\nBefore sort:");
      display(array, n);
      
      if (print)
      {
         System.out.println("\n--------------------");
         display(array, n);
      } // end if
      
      switch (sort)
      {
         case 1: ArraySorter.selectionSort(array, n); break;
         case 2: ArraySorter.selectionSort2(array, n); break;
         case 3: ArraySorter.insertionSort(array, n); break;
         case 4: ArraySorter.insertionSort2(array, n); break;
         case 5: ArraySorter.recursiveBubbleSort(array, n); break;
         case 6: ArraySorter.mergeSort(array, n); break;
         case 7: ArraySorter.quickSort(array, n); break;
      } // end switch
      
      if (print)
      {
         System.out.println("After sort:");
         display(array, n);
      } // end if
      
      check(array, n);
   } // end testSort
  
  public static void display(Object[] array, int n)
  {
    for (int index = 0; index < n; index++)
      System.out.println(array[index]);
    System.out.println();
  } // end display

  public static void copyArray(Object[] copy, Object[] array)
  {
    for (int index = 0; index < array.length; index++)
      copy[index] = array[index];
  } // end copyArray
  
  public static void check(Name[] array, int n)
  {
    if (isSorted(array, n))
      System.out.println("Method works.\n");
    else
      System.out.println("Method DOES NOT work!!!!!!!!!!!!!!!!!!!!!!!!\n");   
  } // end check
  
  public static boolean isSorted(Name[] array, int n)
  {
    boolean sorted = true;
    for (int index = 0; sorted && (index < n - 1); index++)
    {
      if (array[index].compareTo(array[index + 1]) > 0)
        sorted = false;
    } // end for
    
    return sorted;
  } // end isSorted
}  // end Driver

/*
 11 items in array.
 
 Testing selection sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 Jim Smith
 John Clayton
 Bill Smith
 Jamie Perfect
 Zeke Clayton
 
 Method works.
 
 
 Testing selection sort 2:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 Jim Smith
 John Clayton
 Bill Smith
 Jamie Perfect
 Zeke Clayton
 
 Method works.
 
 
 Testing insertion sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 Jim Smith
 John Clayton
 Bill Smith
 Jamie Perfect
 Zeke Clayton
 
 Method works.
 
 
 Testing insertion sort 2:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 Jim Smith
 John Clayton
 Bill Smith
 Jamie Perfect
 Zeke Clayton
 
 Method works.
 
 
 Testing bubble sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 Jim Smith
 John Clayton
 Bill Smith
 Jamie Perfect
 Zeke Clayton
 
 Method works.
 
 
 Testing merge sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 Jim Smith
 John Clayton
 Bill Smith
 Jamie Perfect
 Zeke Clayton
 
 Method works.
 
 
 Testing quick sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 Jim Smith
 John Clayton
 Bill Smith
 Jamie Perfect
 Zeke Clayton
 
 Method works.
 
 6 items in array.
 
 Testing selection sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 
 Method works.
 
 
 Testing selection sort 2:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 
 Method works.
 
 
 Testing insertion sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 
 Method works.
 
 
 Testing insertion sort 2:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 
 Method works.
 
 
 Testing bubble sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 
 Method works.
 
 
 Testing merge sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 
 Method works.
 
 
 Testing quick sort:
 
 Before sort:
 Zeke Clayton
 Bob Clayton
 Rob Smith
 Ali Babba
 Jamie Perfect
 Jody Perfect
 
 Method works.
 
 1 items in array.
 
 Testing selection sort:
 
 Before sort:
 Zeke Clayton
 
 Method works.
 
 
 Testing selection sort 2:
 
 Before sort:
 Zeke Clayton
 
 Method works.
 
 
 Testing insertion sort:
 
 Before sort:
 Zeke Clayton
 
 Method works.
 
 
 Testing insertion sort 2:
 
 Before sort:
 Zeke Clayton
 
 Method works.
 
 
 Testing bubble sort:
 
 Before sort:
 Zeke Clayton
 
 Method works.
 
 
 Testing merge sort:
 
 Before sort:
 Zeke Clayton
 
 Method works.
 
 
 Testing quick sort:
 
 Before sort:
 Zeke Clayton
 
 Method works.
 

*/
