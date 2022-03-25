/**

* This program calculates the marks for 15 students that have an average of 75

* @author  Housein Shaib

* @version 1.0

* @since   2021-03-124 

*/

// import necessary packages
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;


public class ClassMarks {

  public static String[][] generateMarks(String[] arrayStu, String[] arrayAssign) {
    String[][] arrayFinal = new String[arrayStu.length][arrayAssign.length + 1];
    
    Random random = new Random();
    int counter = 0;
    
    for (String student : arrayStu) {
      String[] tempArray = new String[arrayAssign.length + 1];
      tempArray[0] = student;
      for (int i = 0; i < arrayAssign.length; i++) {
        tempArray[i + 1] = Double.toString(random.nextGaussian() * 10 + 75);
      }
      arrayFinal[counter] = tempArray;
      counter = counter + 1;
    }
    return (arrayFinal);
  }
  
  // to handle exceptions include throws
  public static void main(String[] args)
      throws IOException {
    // list that holds strings of a file
    List<String> listOfStudents
        = new ArrayList<String>();
    List<String> listOfAssignments
        = new ArrayList<String>();
   
    File myObj = new File("Assignments.txt");
    Scanner myReader = new Scanner(myObj);
    while (myReader.hasNextLine()) {
      String data = myReader.nextLine();
      listOfAssignments.add(data);
    }
    
    myObj = new File("Students.txt");
    myReader = new Scanner(myObj);
    while (myReader.hasNextLine()) {
      String data = myReader.nextLine();
      listOfStudents.add(data);
    }
   
    // storing the data in arraylist to array
    String[] arrayOfStudents
      = listOfStudents.toArray(new String[listOfStudents.size()]);
    String[] arrayOfAssignments
      = listOfAssignments.toArray(new String[listOfAssignments.size()]);
       
    String[][] finalArray = generateMarks(arrayOfStudents, arrayOfAssignments);
    for (String[] studentArray : finalArray) { 
      for (int i = 0; i < studentArray.length; i++) {
        System.out.print(studentArray[i] + ", ");
      }
    } 
  }
}