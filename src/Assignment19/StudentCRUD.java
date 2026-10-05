package Assignment19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentCRUD {

    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {

        Scanner sc = new Scanner(System.in);
        Connection con = Database.getConnection();

        int choice;

        do {
            System.out.println("\n--- STUDENT CRUD ---");
            System.out.println("1. Insert Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll Number: ");
                    int rollNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    String insert =
                            "INSERT INTO crud_students " +
                            "(roll_no, name, course, marks) " +
                            "VALUES (?, ?, ?, ?)";

                    PreparedStatement insertPS =
                            con.prepareStatement(insert);

                    insertPS.setInt(1, rollNo);
                    insertPS.setString(2, name);
                    insertPS.setString(3, course);
                    insertPS.setInt(4, marks);

                    insertPS.executeUpdate();

                    System.out.println("Student inserted successfully.");
                    break;

                case 2:
                    String select =
                            "SELECT * FROM crud_students";

                    PreparedStatement selectPS =
                            con.prepareStatement(select);

                    ResultSet rs = selectPS.executeQuery();

                    System.out.println(
                            "\nRoll No\tName\tCourse\tMarks"
                    );

                    while (rs.next()) {
                        System.out.println(
                                rs.getInt("roll_no") + "\t" +
                                rs.getString("name") + "\t" +
                                rs.getString("course") + "\t" +
                                rs.getInt("marks")
                        );
                    }

                    break;

                case 3:
                    System.out.print("Enter Roll Number to update: ");
                    int updateRoll = sc.nextInt();

                    System.out.print("Enter new marks: ");
                    int newMarks = sc.nextInt();

                    String update =
                            "UPDATE crud_students " +
                            "SET marks = ? " +
                            "WHERE roll_no = ?";

                    PreparedStatement updatePS =
                            con.prepareStatement(update);

                    updatePS.setInt(1, newMarks);
                    updatePS.setInt(2, updateRoll);

                    updatePS.executeUpdate();

                    System.out.println("Student updated successfully.");
                    break;

                case 4:
                    System.out.print("Enter Roll Number to delete: ");
                    int deleteRoll = sc.nextInt();

                    String delete =
                            "DELETE FROM crud_students " +
                            "WHERE roll_no = ?";

                    PreparedStatement deletePS =
                            con.prepareStatement(delete);

                    deletePS.setInt(1, deleteRoll);

                    deletePS.executeUpdate();

                    System.out.println("Student deleted successfully.");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
        con.close();
    }
}