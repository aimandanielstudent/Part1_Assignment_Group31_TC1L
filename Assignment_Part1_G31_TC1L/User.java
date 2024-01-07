class User {
    private String id;
    private String password;
    private String name;
    private String email;
    private String numPhone;

    public User(String id, String password, String name, String email, String numPhone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.numPhone = numPhone;
    }

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

    public String getNumPhone() {
        return numPhone;
    }

    // Add toFileString method
    public String toFileString() {
        return String.format("%s,%s,%s,%s,%s", id, password, name, email, numPhone);
    }
}