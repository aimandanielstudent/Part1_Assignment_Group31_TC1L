import java.io.*;
import java.util.*;

public class UserRepository {
    private Map<String, Users> users;
    private String filename; // Add filename attribute to store the filename

    public UserRepository(String filename) {
        this.filename = filename;
        this.users = loadUsersFromFile(filename);
    }

    //descending order
    private Map<String, Users> loadUsersFromFile(String filename) {
        Map<String, Users> users = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            // Read the header line
            String header = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length >= 14) { // Updated condition based on the new format
                    String id = userData[0];
                    String password = userData[1];
                    String name = userData[2];
                    String email = userData[3];
                    String phoneNumber = userData[4];
                    int[] courseCredits = new int[6];
                    for (int i = 0; i < 6; i++) {
                        courseCredits[i] = Integer.parseInt(userData[i + 5]);
                    }
                    int totalCredit = Integer.parseInt(userData[13]); // Updated index for total_credit
                    users.put(id, new Users(id, password, name, email, phoneNumber, courseCredits, totalCredit, false));
                } else {
                    System.err.println("Invalid line in the user database file: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading user database file: " + e.getMessage());
        }
        return users; // Return the populated map
    }
    
    // Get user by ID (unchanged)
    public Users getUser(String id) {
        return users.get(id);
    }

    // Update user's password in the repository and file
    public void updatePassword(String userId, String newPassword) {
        Users user = users.get(userId);
        if (user != null) {
            user.setPassword(newPassword);
            users.put(userId, user);
            updateFile(); // Update the file after modifying the user
        } 
        else {
            System.out.println("User with ID " + userId + " not found.");
        }
    }

    private void updateFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("id,password,name,email,num_phone,CS113,CS123,CS133,CS143,CS214,CS224,CS234,CS316,total_credit"); // Updated header
            for (Users u : users.values()) {
                StringBuilder sb = new StringBuilder();
                sb.append(u.getId()).append(",")
                        .append(u.getPassword()).append(",")
                        .append(u.getName()).append(",")
                        .append(u.getEmail()).append(",")
                        .append(u.getPhoneNumber()).append(",")
                        .append(u.getCourseCredits()[0]).append(",")
                        .append(u.getCourseCredits()[1]).append(",")
                        .append(u.getCourseCredits()[2]).append(",")
                        .append(u.getCourseCredits().length >= 4 ? u.getCourseCredits()[3] : 0).append(",") // CS143
                        .append(u.getCourseCredits().length >= 5 ? u.getCourseCredits()[4] : 0).append(",") // CS214
                        .append(u.getCourseCredits().length >= 6 ? u.getCourseCredits()[5] : 0).append(",") // CS224
                        .append(u.getCourseCredits().length >= 7 ? u.getCourseCredits()[6] : 0).append(",") // CS234
                        .append(u.getCourseCredits().length >= 8 ? u.getCourseCredits()[7] : 0).append(",") // CS316
                        .append(u.getTotalCredit()); // Updated index for total_credit
                writer.println(sb.toString());
            }
        } catch (IOException e) {
            System.err.println("Error updating user database file: " + e.getMessage());
        }
    }
                        
}