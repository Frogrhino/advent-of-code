import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class password_philosophy {
    public static void main(String args[]) {
        String[] data;
        int[] correct_password;

        data = ReadFile("password_philosophy/password.txt");
        correct_password = check_password(data);
        System.out.println(correct_password[0]);
        System.out.println(correct_password[1]);

    } 

    public static String[] ReadFile(String reporttxt) {
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
    
        String[] password = new String[length_data];
    
        try {
          Scanner myReader2 = new Scanner(myObj);
          while (start < length_data) {
            String data = myReader2.nextLine();
            password[start] = data;
            start++;
          }
    
          myReader2.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        return password;
      }

      public static int[] check_password(String[] data) {
        String[] range_one;
        int[] range_int = new int[2];
        int start = 0;
        int counter = 0;
        int char_counter = 0;
        int[] volume_password = new int[2];
        String[] placeholder_string;

        String[] range = new String[data.length];
        String[] test_char = new String[data.length];
        String[] password = new String[data.length];

        for(int field = start; field <= data.length-1; field++){
            StringTokenizer st = new StringTokenizer(data[field]);
            while (st.hasMoreTokens()) {
                if(counter == 0){
                    range[field] = st.nextToken();
                }                
                else if(counter == 1){
                    test_char[field] = st.nextToken();
                    test_char[field] = test_char[field].replaceAll(":", "");
                }
                else if(counter == 2){
                    password[field] = st.nextToken();
                }
                counter++;
            }
            counter = 0;
            range_one = range[field].split("-");
            range_int[0] = Integer.parseInt(range_one[0]);
            range_int[1] = Integer.parseInt(range_one[1]);
            placeholder_string = password[field].split(""); 

            //check part one
            if(password[field].length() >= range_int[0]){                
                for(int field_password = start; field_password <= placeholder_string.length-1; field_password++){
                    if(placeholder_string[field_password].charAt(0) == test_char[field].charAt(0)){
                        char_counter++;
                    }
                }
                
                if(char_counter >= range_int[0] && char_counter <= range_int[1]){
                    volume_password[0]++;
                }
            }
            char_counter = 0;

            // check part two
            if(password[field].length() >= range_int[1]){
                if(placeholder_string[range_int[0]-1].charAt(0) == test_char[field].charAt(0) 
                ^ placeholder_string[range_int[1]-1].charAt(0) == test_char[field].charAt(0)){
                    volume_password[1]++;
                }
            }

        }


        return volume_password;
      }
}
