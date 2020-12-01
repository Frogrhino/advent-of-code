import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class report_repair {
  public static void main(String args[]) {
    int[] report_array;

    // Reading report numbers out of text file
    report_array = ReadFile("report_repair/report.txt"); 
    
    // Part One
    for(int i = 0; i <= report_array.length-1; i++){
      for(int j = 0; j <= report_array.length-1; j++){
        if(report_array[i] + report_array[j] == 2020){          
          System.out.println("Two numbers multiplied who added together equals 2020:");
          System.out.println(report_array[i] * report_array[j]);
          j = report_array.length;
          i = report_array.length;
        }
      }
    }

    // Part Two
    for(int i = 0; i <= report_array.length-1; i++){
      for(int j = 0; j <= report_array.length-1; j++){
        for(int k = 0; k <= report_array.length-1; k++){
          if(report_array[i] + report_array[j] + report_array[k] == 2020){
            System.out.println("Three numbers multiplied who added together equals 2020:");
            System.out.println(report_array[i] * report_array[j] * report_array[k]);
            j = report_array.length;
            i = report_array.length;
            k = report_array.length;
          }
        }
      }
    }
  }

  public static int[] ReadFile(String reporttxt) {
    int length_data = 0;
    int start = 0;
    File myObj = new File(reporttxt);

    try {
      Scanner myReader = new Scanner(myObj);

      while (myReader.hasNextLine()) {
        myReader.nextLine();
        length_data++;
      }

      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    int[] report = new int[length_data];

    try {
      Scanner myReader2 = new Scanner(myObj);
      while (start < length_data) {
        int data = Integer.parseInt(myReader2.nextLine());
        report[start] = data;
        start++;
      }

      myReader2.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return report;
  }
}