import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;


public class LoginExample {

    private static final String COURSES_FILE = "courses.txt";
    private static final String USER_FILE = "users.txt";
    private static final Map<Integer, String> COURSES = new HashMap<>();

    static {
        // Load courses from file
        loadCoursesFromFile();
        // checkFileExist(USERS_FILE);
    }

        public static void assigncourses(int id,int course,List<List<String>> data){
            String strId = Integer.toString(id);
            LoginExample finder = new LoginExample(); 
            int rowNumber = finder.findRowOfElement(data, strId); 
            if (rowNumber >= 0 && rowNumber < data.size()) {
              if (course==1)
                  data.get(rowNumber).set(5, "1");  
              else if (course==2)
                  data.get(rowNumber).set(6, "1");
              else if (course==3)
                  data.get(rowNumber).set(7, "1");
              else if (course==4)
                  data.get(rowNumber).set(8, "1");
              else if (course==5)
                  data.get(rowNumber).set(9, "1");
              else if (course==6)
                  data.get(rowNumber).set(10, "1");
              else if (course==7)
                  data.get(rowNumber).set(11, "1");
              else if (course==8)
                  data.get(rowNumber).set(12, "1");
            
            // for(List<String>d:data){
            //   System.out.println(d);
            // }
          }
        }

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
                    } else{
                        System.out.println("Ooops! Some of your registration failed. It did not match with the requirement, please refer to the Courses Table");
                }
                System.out.println("Total Credit Registered Before This Trimester: " + numCredit);
                System.out.println("Total Credit Registered This Trimester: " + tCredit);
                break;
                // if (tCredit < 3 || tCredit > 12){
                //     System.out.println("Your total credit hour is not match with the requirement.");
                //     tCredit = 0;
                //     c = askCourses();
                // }
                // else
                //     break;
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

        // ------------------TO CONVERT LIST TO FILE------------------
    public static void convertToFile(String filename, List<List<String>> data){
        try {
            FileWriter fileWriter = new FileWriter(filename);
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

    // ------------------TO CONVERT FILE TO LIST------------------
    public static List<List<String>> convertToList(String filename){
        String line;
        String delimeter = ",";
        List<List<String>> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            while ((line = br.readLine()) != null){
                String[] values = line.split(delimeter);
                data.add(Arrays.asList(values));
            }
        } catch (IOException e)
        {
            System.out.println(e);
        }

        return data;
    }
        public static void main(String[] args) {
            UserRepository userRepository = new UserRepository("users.txt");
            Scanner scanner = new Scanner(System.in);

            List<Lecturer> lecturers = new ArrayList<>();
            List<List<String>> studentsData = new ArrayList<>();
            List<List<String>> usersData = new ArrayList<>();

            // Read data from the "users.txt" file and populate studentsData
            String dataToRead = "users.txt";
            try (BufferedReader br = new BufferedReader(new FileReader(dataToRead))) {
                String line;
                while ((line = br.readLine()) != null) {
                    List<String> userData = Arrays.asList(line.split(","));
                    usersData.add(userData); // Add user data to usersData list
                    if (userData.get(0).startsWith("2")) {
                        studentsData.add(userData); // Add student data to studentsData list
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    
            System.out.print("Enter ID:");
            String inputId = scanner.nextLine();
    
            System.out.print("Enter password:");
            String inputPassword = scanner.nextLine();

            Users user = userRepository.getUser(inputId);
            if (user != null && user.authenticate(inputId, inputPassword)) {
                if (user.isPasswordChangeRequired()) {
                    System.out.println("Welcome, " + user.getName() + "! You are required to change your password. New password cannot be '0000'");
                    System.out.println("Enter your new password:");
                    String newPassword = scanner.nextLine();
                    user.setPassword(newPassword);
                    user.setPasswordChangeRequired(false); // Clear the flag
                    userRepository.updatePassword(inputId, newPassword); // Update the password in the repository and file
                    System.out.println("Password changed successfully. You can now log in with your new password.");
                } 
                else if (inputId.startsWith("2")) {
                    System.out.println("You are a student!");
                    System.out.println("Login successful! Welcome, " + user.getName());
                    // Add code here to proceed with the application after successful login
                    //String id = "2143789561";            //********* take note
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
                    List<List<String>> data = convertToList(dataToRead);
            
                    // Do the Registration process
                    courseRegistration(inputId,course,data);
                        
                    // Print Sucessfully Registered
                    System.out.println ("You have succesfully register the course");
            
                    // Masukkan balik dalam file users.txt
                    convertToFile(dataToRead,data);
                
                }
                else if (inputId.startsWith("1")){
                    //Lecturer part
                    System.out.println("You are a lecturer!");
                    Lecturer lecturer = new Lecturer(user.getId(),user.getPassword(), user.getName(), user.getEmail(), user.getPhoneNumber(),
                    false, false, false, false, false, false, false, false,false);
                    // Declare courseCode here and initialize it to an empty string
                    String courseCode = "";
                    lecturer.viewStudentsInCourse(studentsData, courseCode,usersData); // Pass studentsData to viewStudentsInCourse
                    
                    // Option to view all students
                    System.out.println("1. View all students in a course");

                    int option = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    switch (option) {
                        case 1:
                            // View all students in a course
                            System.out.print("Enter the course code: ");
                            courseCode = scanner.nextLine();
                            lecturer.viewStudentsInCourse(studentsData, courseCode, usersData);
                            break;
                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                }
                else if(inputId.startsWith("A")) {
                Scanner random;   
                //Admin part
                System.out.println("You are an Admin!");
                // Open and convert file to 2d List
                List<List<String>> data = convertToList(dataToRead);
                    //Scanner scanner = new Scanner(System.in);
                    Map<Integer, String> choices = new HashMap<>();

                    // Initialize ID counters
                    int studentIdCounter = 2000000000; // Example of 10-digit ID starting with 2
                    int lecturerIdCounter = 1000000000; // Example of 10-digit ID starting with 1

                    while (true) {
                        System.out.println("Choose an option:");
                        System.out.println("1. Add a student");
                        System.out.println("2. Add a lecturer");
                        System.out.println("3. Create courses");
                        System.out.println("4. Assign a course");
                        System.out.println("5. Display available courses");
                        System.out.println("6. View Students and Lecturers");
                        System.out.println("7. Exit");
                        System.out.print("Enter the number : ");

                        int choice = scanner.nextInt();
                        scanner.nextLine(); // consume newline left-over

                        switch (choice) {
                           // add student
                            case 1:
                                System.out.println("Enter student name:");
                                String studentName = scanner.nextLine();
                                System.out.println("Enter student phone number:");
                                String studentPhoneNumber = scanner.nextLine();
                                String studentId = "" + ++studentIdCounter;
                                // String studentId = Integer.toString(intStuId);
                                // register finder = new register();
                                // int rowNumber = finder.findRowOfElement(data, studentId);
                                
                                // while(data.get(rowNumber).get(0).equals(studentId)){
                                //     intStuId = studentIdCounter++ ;
                                //     studentId = Integer.toString(intStuId);
                                // }
                                    
                                String studentEmail = studentId + "@student.mmu.edu.my";
                                System.out.println("Student added: " + studentName + ", " + studentPhoneNumber + ", ID: " + studentId + ", Email: " + studentEmail);

                                // Write student information to users.txt
                                writeToFile("users.txt", studentId, studentName, studentPhoneNumber, studentEmail);
                                break;
                            // add lectures
                            case 2:
                                System.out.println("Enter lecturer name:");
                                String lecturerName = scanner.nextLine();
                                System.out.println("Enter lecturer phone number:");
                                String lecturerPhoneNumber = scanner.nextLine();
                                String lecturerId = "" + ++lecturerIdCounter;
                                String lecturerEmail = lecturerId + "@mmu.edu.my";
                                System.out.println("Lecturer added: " +lecturerName +", " + lecturerPhoneNumber + ", ID: " + lecturerId + ", Email: " + lecturerEmail);
                                writeToFile("users.txt",lecturerId,lecturerName,lecturerPhoneNumber,lecturerEmail);
                                break;
                            // // add courses
                            // case 1:
                            //     int randomStudentId = 200000000 + random.nextInt(800000000);
                            //     String studentId = "2" + randomStudentId;
                            //     System.out.println("Enter student name:");
                            //     String studentName = scanner.nextLine();
                            //     System.out.println("Enter student phone number:");
                            //     String studentPhoneNumber = scanner.nextLine();
                            //     String studentEmail = studentId + "@student.mmu.edu.my";
                            //     System.out.println(
                            //             "Student added: " +
                            //                     studentName +
                            //                     ", " +
                            //                     studentPhoneNumber +
                            //                     ", ID: " +
                            //                     studentId +
                            //                     ", Email: " +
                            //                     studentEmail);

                            //     writeToFile(
                            //             "users.txt",
                            //             studentId,
                            //             studentName,
                            //             studentPhoneNumber,
                            //             studentEmail);
                            //     break;
                            // case 2:
                            //     int randomLecturerId = 100000000 + random.nextInt(900000000);
                            //     String lecturerId = "1" + randomLecturerId;
                            //     System.out.println("Enter lecturer name:");
                            //     String lecturerName = scanner.nextLine();
                            //     System.out.println("Enter lecturer phone number:");
                            //     String lecturerPhoneNumber = scanner.nextLine();
                            //     String lecturerEmail = lecturerId + "@mmu.edu.my";
                            //     System.out.println(
                            //             "Lecturer added: " +
                            //                     lecturerName +
                            //                     ", " +
                            //                     lecturerPhoneNumber +
                            //                     ", ID: " +
                            //                     lecturerId +
                            //                     ", Email: " +
                            //                     lecturerEmail);
                            //     writeToFile(
                            //             "users.txt",
                            //             lecturerId,
                            //             lecturerName,
                            //             lecturerPhoneNumber,
                            //             lecturerEmail);
                            //     break;
                            case 3:
                                addCourse();
                                break;
                            // assign courses to lectures
                            case 4: 
                                System.out.println("Select a course:");
                                System.out.println("1. CS113");
                                System.out.println("2. CS123");
                                System.out.println("3. CS133");
                                System.out.println("4. CS143");
                                System.out.println("5. CS214");
                                System.out.println("6. CS224");
                                System.out.println("7. CS234");
                                System.out.println("8. CS316");
                                int courseChoice = scanner.nextInt();
                                System.out.println("Enter the ID of the individual:");
                                int id = scanner.nextInt();
                                assigncourses(id,courseChoice,data);
                                
                                
                                System.out.println("Course assigned.");
                                // Masukkan balik dalam file users.txt
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
                            } 
                            catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                                
                            // display available courses
                            case 5:
                                displayCoursesFromFile();
                            break;

                            // View Students and Lecturers
                            case 6:
                                Admin.viewStudentsAndLecturers(studentsData, usersData, lecturers); // Pass studentsData and lecturers and userDara to viewStudentsAndLecturers
                            break;

                            // Exit
                            case 7:
                                System.out.println("Exiting...");
                                return;
                            default:
                                System.out.println("Invalid choice!");
                        }
                    }
                // //Admin.viewStudentsAndLecturers(studentsData, usersData, lecturers); // Pass studentsData and lecturers and userDara to viewStudentsAndLecturers
                }
            } 
            else {
                System.out.println("Invalid ID or password. Please try again.");
            }
            scanner.close();
    }

    //-----------------Admin-------------------------------------------------
    // read initial courses file
    private static void loadCoursesFromFile() {
        try (Scanner fileScanner = new Scanner(new File(COURSES_FILE))) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                if (parts.length == 2) { // Ensure there are two parts (key and course)
                    int key = Integer.parseInt(parts[0]);
                    String course = parts[1];
                    COURSES.put(key, course);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Courses file not found. Creating a new one.");
            saveCoursesToFile();
        }
    }

    // create new courses file if not exist
    private static void saveCoursesToFile() {
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(COURSES_FILE))) {
            for (Map.Entry<Integer, String> entry : COURSES.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println(
                    "An error occurred while writing to the file: " + e.getMessage());
        }
    }

    // read from courses file to display
    private static void displayCoursesFromFile() {
        System.out.println("Courses from file:");
        try (Scanner fileScanner = new Scanner(new File(COURSES_FILE))) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Courses file not found.");
        }
    }

    
    // write users information into users.txt
    private static void writeToFile(String fileName, String id,String name,String phoneNumber,String email) {
        List<List<String>> data = convertToList(fileName);

        // Create a new inner List<String>
        List<String> innerList = new ArrayList<>();

        // Add elements to the inner list
        innerList.add(id);
        innerList.add("0000");
        innerList.add(name);
        innerList.add(phoneNumber);
        innerList.add(email);
        innerList.add("0");
        innerList.add("0");
        innerList.add("0");
        innerList.add("0");
        innerList.add("0");
        innerList.add("0");
        innerList.add("0");
        innerList.add("0");
        innerList.add("0");

        // Add the inner list to the outer list
        data.add(innerList);

        //Masukkan balik dalam file
        convertToFile(fileName,data);

    }

    // create new courses
    private static void addCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter course code:");
        String courseCode = scanner.nextLine();


        writeCourseToFile(COURSES_FILE, courseCode);
        System.out.println("Course added: " + courseCode);
    }

    //write courses to file
    private static void writeCourseToFile(String fileName, String courseCode) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(courseCode + ",");
            writer.newLine();
            System.out.println("Course information written to " + fileName);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}