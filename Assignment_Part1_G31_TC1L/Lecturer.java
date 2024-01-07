import java.util.List;

public class Lecturer extends Users {
    private boolean cs113;
    private boolean cs123;
    private boolean cs133;
    private boolean cs143;
    private boolean cs214;
    private boolean cs224;
    private boolean cs234;
    private boolean cs316;
    private boolean totalCredit;


    public Lecturer(String id, String name,String password, String email, String phoneNumber,
                    boolean cs113, boolean cs123, boolean cs133, boolean cs143,
                    boolean cs214, boolean cs224, boolean cs234, boolean cs316,boolean totalCredit) {
        super(id, "", name, email, phoneNumber, null, 0, false);
        this.cs113 = cs113;
        this.cs123 = cs123;
        this.cs133 = cs133;
        this.cs143 = cs143;
        this.cs214 = cs214;
        this.cs224 = cs224;
        this.cs234 = cs234;
        this.cs316 = cs316;
        this.totalCredit = totalCredit;
    }

    // Getter methods for each course attribute
    public boolean isCs113() {
        return cs113;
    }

    public boolean isCs123() {
        return cs123;
    }

    public boolean isCs133() {
        return cs133;
    }

    public boolean isCs143() {
        return cs143;
    }

    public boolean isCs214() {
        return cs214;
    }

    public boolean isCs224() {
        return cs224;
    }

    public boolean isCs234() {
        return cs234;
    }

    public boolean isCs316() {
        return cs316;
    }

    public boolean istotalCredit() {
        return totalCredit;
    }

    // Method to check if the lecturer teaches a specific course
    public boolean teachesCourse(String courseCode) {
        switch (courseCode) {
            case "CS113":
                return isCs113();
            case "CS123":
                return isCs123();
            case "CS133":
                return isCs133();
            case "CS143":
                return isCs143();
            case "CS214":
                return isCs214();
            case "CS224":
                return isCs224();
            case "CS234":
                return isCs234();
            case "CS316":
                return isCs316();
            default:
                return false; // Course not found
        }
    }

    public void viewStudentsInCourse(List<List<String>> studentsData, String courseCode, List<List<String>> usersData) {
        System.out.println("Students enrolled in course " + courseCode + ":");
        int courseIndex = getCourseIndex(courseCode);

        if (courseIndex == -1) {
            //System.out.println("Invalid course code: " + courseCode);
            return;
        }

        for (List<String> student : studentsData) {
            String studentName = student.get(2);
            String lecturerCourseStatus = student.get(courseIndex);

            if (isLecturerTeaching(lecturerCourseStatus)) {
                //System.out.println("Students enrolled in course " + courseCode + ":");
                //System.out.println("Course Code: " + courseCode);
                System.out.println("Student Name: " + studentName);
                //System.out.println("lecturerCourseStatus: " + lecturerCourseStatus);
            }
        }
    }

    
    private boolean isLecturerTeaching(String lecturerCourseStatus) {
        return "1".equals(lecturerCourseStatus);

    }

    private int getCourseIndex(String courseCode) {
        // Assuming the course codes are in columns 5 to 12 in the data structure
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
                return -1; // Course code not found
        }
    }


}


//  kene letak ni jugak selepas main method    List<List<String>> studentsData = new ArrayList<>();
// nanti delete ni untuk letak kat main method tu
//Lecturer lecturer = new Lecturer(user.getId(), user.getName(), user.getEmail(), user.getPhoneNumber(),
//                        false, false, false, false, false, false, true, false);

//                // Option to view all students
//                System.out.println("1. View all students in a course");/

//                int option = scanner.nextInt();
//                scanner.nextLine(); // Consume the newline character

//                switch (option) {
//                    case 1:
//                        // View all students in a course
//                        System.out.print("Enter the course code: ");
//                        String courseCode = scanner.nextLine();
//                        lecturer.viewStudentsInCourse(studentsData, courseCode);
//                        break;
//                    default:
//                        System.out.println("Invalid option.");
//                        break;
//                }