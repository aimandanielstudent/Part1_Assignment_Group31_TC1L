import java.util.List;
import java.util.Scanner;

public class Admin {
    public static void viewStudentsAndLecturers(List<List<String>> studentsData,List<List<String>> usersData, List<Lecturer> lecturers) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the course code to view students and lecturers: ");
        String courseCode = scanner.nextLine();

        // View students
        System.out.println("Students in course " + courseCode + ":");
        for (List<String> user : usersData) {
            String userType = user.get(0).substring(0, 1); // Assuming the user type is the first character of the ID
            if ("2".equals(userType)) { // Assuming '1' indicates a student
                if ("1".equals(user.get(getCourseIndex(courseCode)))) {
                    System.out.println("Student name: " + user.get(2));
                    // Add more information about the student if needed
                }
            }
        }

        // View lecturers
        System.out.println("\nLecturers in course " + courseCode + ":");
        for (List<String> user : usersData) {
            String userType = user.get(0).substring(0, 1); // Assuming the user type is the first character of the ID
            if ("1".equals(userType)) { // Assuming '1' indicates a student
                if ("1".equals(user.get(getCourseIndex(courseCode)))) {
                    System.out.println("Lecturer name: " + user.get(2));
                    // Add more information about the student if needed
                }
            }
        }
    }

    private static int getCourseIndex(String courseCode) {
        // Map course code to the corresponding index in the data structure
        // Adjust this based on the actual structure of your data
        switch (courseCode) {
            case "CS113":
                return 5;
            case "CS123":
                return 6;
            case "CS133":
                return 7;
            case "CS143":
                return 8;
            case "CS214":
                return 9;
            case "CS224":
                return 10;
            case "CS234":
                return 11;
            case "CS316":
                return 12;
            default:
                return -1; // Course not found
        }
    }

    
}





// and kene letak ni jugak kat main method List<Lecturer> lecturers = new ArrayList<>();
// nanti delete ni untuk letak kat main method tu 
// Admin part
//                System.out.println("You are an Admin!");
//                Admin admin = new Admin();

//                Admin.viewStudentsAndLecturers(studentsData, lecturers);

            