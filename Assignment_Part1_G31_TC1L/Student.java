public class Student extends Users {
    private String name;
    private String email;
    private String phoneNumber;
    private int[] courseCredits;

    public Student(String id, String password, String name, String email, String phoneNumber, int[] courseCredits, int totalCredit, boolean passwordChangeRequired) {
        super(id, password, name, email, phoneNumber, courseCredits, totalCredit, passwordChangeRequired);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.courseCredits = courseCredits;
    }
    
    // Getters for additional attributes (name, email, phoneNumber, courseCredits) can be added here
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getphoneNumber() {
        return phoneNumber;
    }
    public int[] getcourseCredits() {
        return courseCredits;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int[] getCourseCredits() {
        return courseCredits;
    }
}   

