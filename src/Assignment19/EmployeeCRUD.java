package Assignment19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeCRUD {

    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {

        Scanner sc = new Scanner(System.in);
        Connection con = Database.getConnection();

        int choice;

        do {
            System.out.println("\n--- EMPLOYEE CRUD ---");
            System.out.println("1. Insert Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    String insert =
                            "INSERT INTO employees " +
                            "(employee_id, name, department, salary) " +
                            "VALUES (?, ?, ?, ?)";

                    PreparedStatement insertPS =
                            con.prepareStatement(insert);

                    insertPS.setInt(1, id);
                    insertPS.setString(2, name);
                    insertPS.setString(3, department);
                    insertPS.setDouble(4, salary);

                    insertPS.executeUpdate();

                    System.out.println("Employee inserted successfully.");
                    break;

                case 2:
                    String select =
                            "SELECT * FROM employees";

                    PreparedStatement selectPS =
                            con.prepareStatement(select);

                    ResultSet rs = selectPS.executeQuery();

                    System.out.println(
                            "\nID\tName\tDepartment\tSalary"
                    );

                    while (rs.next()) {
                        System.out.println(
                                rs.getInt("employee_id") + "\t" +
                                rs.getString("name") + "\t" +
                                rs.getString("department") + "\t\t" +
                                rs.getDouble("salary")
                        );
                    }

                    break;

                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter new salary: ");
                    double newSalary = sc.nextDouble();

                    String update =
                            "UPDATE employees " +
                            "SET salary = ? " +
                            "WHERE employee_id = ?";

                    PreparedStatement updatePS =
                            con.prepareStatement(update);

                    updatePS.setDouble(1, newSalary);
                    updatePS.setInt(2, updateId);

                    updatePS.executeUpdate();

                    System.out.println("Employee updated successfully.");
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = sc.nextInt();

                    String delete =
                            "DELETE FROM employees " +
                            "WHERE employee_id = ?";

                    PreparedStatement deletePS =
                            con.prepareStatement(delete);

                    deletePS.setInt(1, deleteId);

                    deletePS.executeUpdate();

                    System.out.println("Employee deleted successfully.");
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