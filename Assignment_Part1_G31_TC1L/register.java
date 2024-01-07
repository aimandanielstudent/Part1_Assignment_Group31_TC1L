import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;


public class register {

    // ------------------FIND POSITION OF THE ELEMENT----------------------
    public static int findPosition(List<List<String>> array, String targetValue) {
        for (int row_index = 0; row_index < array.size(); row_index++) {
          List<String> row = array.get(row_index);
          if (row.contains(targetValue)) {
            return row_index;
          }
        }
        return -1;  // Target not found
      }


    // ------------------REGISTRATION PROCESS------------------
    public static void courseRegistration(String id, String[] c, List<List<String>> data){ 
        int tCredit = 0;
        register finder = new register();
        int rowNumber = finder.findRowOfElement(data, id);
        int numCredit = Integer.parseInt(data.get(rowNumber).get(13));
        
        //Check Credit Hour
        while (tCredit < 3 || tCredit > 12){
            for (String courseValue : c)
                if ("1".equals(courseValue)) {
                        tCredit += 3;
                } else if ("2".equals(courseValue)) {
                        tCredit += 3;
                } else if ("3".equals(courseValue)) {
                        tCredit += 3;
                } else if ("4".equals(courseValue)) {
                        tCredit += 3;
                } else if ("5".equals(courseValue) && data.get(rowNumber).get(5).equals("1")) {
                        tCredit += 4;
                } else if ("6".equals(courseValue) && data.get(rowNumber).get(6).equals("1")) {
                        tCredit += 4;
                } else if ("7".equals(courseValue)) {
                        tCredit += 4;
                } else if ("8".equals(courseValue) && data.get(rowNumber).get(7).equals("1") && data.get(rowNumber).get(9).equals("1") && numCredit >= 15) {
                        tCredit += 6;
                }
            System.out.println("Total Credit Registered Before This Trimester: " + numCredit);
            System.out.println("Total Credit Registered This Trimester: " + tCredit);
            if (tCredit < 3 || tCredit > 12){
                System.out.println("Your total credit hour is not match with the requirement.");
                tCredit = 0;
                c = askCourses();
            }
            else
                break;
        }
        
        // Register Course
        for (String courseValue : c){
            if ("1".equals(courseValue)) {
                data.get(rowNumber).set(5, "1");
            } else if ("2".equals(courseValue)) {
                data.get(rowNumber).set(6, "1");
            } else if ("3".equals(courseValue)) {
                data.get(rowNumber).set(7, "1");
            } else if ("4".equals(courseValue)) {
                data.get(rowNumber).set(8, "1");
            } else if ("5".equals(courseValue) && data.get(rowNumber).get(5).equals("1")) {
                    data.get(rowNumber).set(9, "1");
            } else if ("6".equals(courseValue) && data.get(rowNumber).get(6).equals("1")) {
                data.get(rowNumber).set(10, "1");
            } else if ("7".equals(courseValue)) {
                data.get(rowNumber).set(11, "1");
            } else if ("8".equals(courseValue) && data.get(rowNumber).get(7).equals("1") && data.get(rowNumber).get(9).equals("1")  && numCredit >= 15) {
                data.get(rowNumber).set(12, "1");
            }
        }

        // Letak total registered credit hour
        int intCredit = tCredit + numCredit;
        String credit = Integer.toString(intCredit);
        data.get(rowNumber).set(13,credit);     
    }


    // ------------------PRINT ALL COURSES THEY ARE ABLE TO TAKE ACCORDING TO THEIR TRIMESTER------------------
    public static void printSelectedData(String[][] data, int input) {
        int numRows = data.length;
        int numCols = (numRows > 0) ? data[0].length : 0;

        if (numRows == 0 || numCols == 0 || input < 1 || input > numCols) {
            System.out.println("Invalid input or no data to print.");
            return;
        }

        // Print the selected data
        int startIndex = 1;
        int endIndex = 0;

        switch (input) {
            case 1:
                endIndex = Math.min(startIndex + 3, numRows);
                break;
            case 2:
                endIndex = Math.min(startIndex + 6, numRows);
                break;
            case 3:
                endIndex = Math.min(startIndex + 7, numRows);
                break;
            default:
                System.out.println("Invalid input.");
                return;
        }

        System.out.println("Courses available for your trimester");


        for (int row = startIndex; row <= endIndex; row++) {
            System.out.print(row + ") ");
            System.out.println(data[row][1]);

        }
    }


    // ------------------PRINT TABLE FOR ALL COURSES------------------ 
    public static void printTable(String[][] data) {
        System.out.println("THESE ARE THE COURSES THAT AVAILABLE");
        System.out.println("----------------------------------------");
        int numRows = data.length;
        int numCols = (numRows > 0) ? data[0].length : 0;

        if (numRows == 0 || numCols == 0) {
            System.out.println("No data to print.");
            return;
        }

        // Calculate the maximum width for each column
        int[] colWidths = new int[numCols];
        for (int col = 0; col < numCols; col++) {
            for (int row = 0; row < numRows; row++) {
                int cellWidth = data[row][col].length();
                colWidths[col] = Math.max(colWidths[col], cellWidth);
            }
        }

        // Print the table
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                String cellValue = data[row][col];
                System.out.print(padRight(cellValue, colWidths[col] + 2));
            }
            System.out.println();
        }
    }

    private static String padRight(String s, int width) {
        return String.format("%-" + width + "s", s);
    }


    // ------------------TO FIND NUMBER OF ROW OD THE ELEMENT------------------
    public int findRowOfElement(List<List<String>> data, String targetElement) {
        for (int rowIndex = 0; rowIndex < data.size(); rowIndex++) {
            List<String> row = data.get(rowIndex);
            if (row.contains(targetElement)) {
                return rowIndex; // Found the element, return its row number
            }
        }
        return -1; // Element not found
    }


    // ------------------TO ASK STUDENT INSERT THEIR COURSES------------------
    public static String[] askCourses(){
        Scanner rScanner = new Scanner(System.in);
        System.out.print("Enter number to register the subject (format : 1,2,3,4) : ");
        String courseNum = rScanner.nextLine();
        String[] course = courseNum.split(",");             //********* take note
        rScanner.close();
        return course;
    }

    public static void main(String[] args) {
        String id = "2143789561";            //********* take note
        String[][] courseTable = {
            {"Course Credit", "Course Code", "Pre-requisite"},
            {"3 Credits", "CS113", "-"},
            {"3 Credits", "CS123", "-"},
            {"3 Credits", "CS133", "-"},
            {"3 Credits", "CS143", "-"},
            {"4 Credits", "CS214", "CS113"},
            {"4 Credits", "CS224", "CS123"},
            {"4 Credits", "CS234", "-"},
            {"6 Credits", "CS316", "CS133, CS214 & 15 credits completed"},
        };
        
        // Calling printtable function to print 
        printTable(courseTable);
        System.out.println();

        // Ask user what trimester theyre in
        Scanner tScanner = new Scanner(System.in);
        System.out.print("What trimester are you (1/2/3) : ");
        int trimester = tScanner.nextInt();         //********* take note
        printSelectedData(courseTable, trimester);

        // Ask user what courses they want to register
        String[] course = askCourses();

        // Open and convert file to 2d List
        String dataToRead = "users.txt";
        String line;
        String delimeter = ",";
        List<List<String>> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dataToRead))){
            while ((line = br.readLine()) != null){
                String[] values = line.split(delimeter);
                data.add(Arrays.asList(values));
            }
        } catch (IOException e)
        {
            System.out.println(e);
        }

        // Do the Registration process
        courseRegistration(id,course,data);
            
        // Print Sucessfully Registered
        System.out.println ("You have succesfully register the course");

        // Masukkan balik dalam file
        try {
            FileWriter fileWriter = new FileWriter(dataToRead);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (List<String> innerList : data) {
                for (String element : innerList) {
                    bufferedWriter.write(element);
                    bufferedWriter.write(",");
                }
                // Add a newline after each inner list
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}