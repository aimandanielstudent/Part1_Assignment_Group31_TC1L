import java.io.*;
import java.util.*;

public class Main {

    private static final String COURSES_FILE = "courses.txt";
    private static final String USER_FILE = "users.txt";
    private static final Map<Integer, String> COURSES = new HashMap<>();

    static {
        // Load courses from file
        loadCoursesFromFile();
        // checkFileExist(USERS_FILE);
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
    public static void assigncourses(int id,int course,List<List<String>> data){
      String strId = Integer.toString(id);
      Main finder = new Main(); 
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
      
      for(List<String>d:data){
        System.out.println(d);
      }
    }

    }
    public static void main(String[] args) {
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
        Scanner scanner = new Scanner(System.in);
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
            System.out.println("6. Exit");

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
                    String studentEmail = studentId + "@student.mmu.edu.my";
                    System.out.println(
                            "Student added: " +
                                    studentName +
                                    ", " +
                                    studentPhoneNumber +
                                    ", ID: " +
                                    studentId +
                                    ", Email: " +
                                    studentEmail);

                    // Write student information to users.txt
                    writeToFile(
                            "users.txt",
                            studentId,
                            studentName,
                            studentPhoneNumber,
                            studentEmail);
                    break;
                // add lectures
                case 2:
                    System.out.println("Enter lecturer name:");
                    String lecturerName = scanner.nextLine();
                    System.out.println("Enter lecturer phone number:");
                    String lecturerPhoneNumber = scanner.nextLine();
                    String lecturerId = "" + ++lecturerIdCounter;
                    String lecturerEmail = lecturerId + "@mmu.edu.my";
                    System.out.println(
                            "Lecturer added: " +
                                    lecturerName +
                                    ", " +
                                    lecturerPhoneNumber +
                                    ", ID: " +
                                    lecturerId +
                                    ", Email: " +
                                    lecturerEmail);
                    writeToFile(
                            "users.txt",
                            lecturerId,
                            lecturerName,
                            lecturerPhoneNumber,
                            lecturerEmail);
                    break;
                // add courses
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
                    break;
                // display available courses
                case 5:
                    displayCoursesFromFile();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

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
    private static void writeToFile(
            String fileName,
            String id,
            String name,
            String phoneNumber,
            String email) {
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                  writer.write(id + "," +"0000"+","+ name + "," + phoneNumber + "," + email + ","+"0"+ ","+"0"+ ","+"0"+ ","+"0"+ ","+"0"+ ","+"0"+ ","+"0"+ ","+"0"+","+"0");
            writer.newLine();
            System.out.println("User information written to " + fileName);
        } catch (IOException e) {
            System.err.println(
                    "An error occurred while writing to the file: " + e.getMessage());
        }
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