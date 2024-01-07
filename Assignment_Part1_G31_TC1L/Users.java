public class Users {
    private String id;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private int[] courseCredits;
    private int totalCredit;
    private boolean passwordChangeRequired;

    public Users(String id, String password, String name, String email, String phoneNumber, int[] courseCredits, int totalCredit,boolean passwordChangeRequired) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.courseCredits = courseCredits;
        this.totalCredit = totalCredit;
        this.passwordChangeRequired = passwordChangeRequired;
    }

    // Getters and setters for fields (omitted for brevity)
        public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int[] getCourseCredits() {
        return courseCredits;
    }

    public int getTotalCredit() {
        return totalCredit;
    }

    public boolean authenticate(String id, String password) {
        if (this.id.equals(id) && this.password.equals(password)) {
            if (this.password.equals("0000")) {
                setPasswordChangeRequired(true);
            }
            return true;
        }
        return false;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public boolean isPasswordChangeRequired() {
        return passwordChangeRequired;
    }

    public void setPasswordChangeRequired(boolean passwordChangeRequired) {
        this.passwordChangeRequired = passwordChangeRequired;
    }
}