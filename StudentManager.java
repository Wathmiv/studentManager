package studentManager;
import java.util.Scanner;

public class StudentManager {
    private static final int MAX_STUDENTS = 100;
    private static String[][] studentNames = new String[MAX_STUDENTS][2];
    private static int[][] studentMarks = new int[MAX_STUDENTS][3];
    private static boolean[] studentMarksAdded = new boolean[MAX_STUDENTS];
    private static int studentCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    -------------------------------------------------------------------------------
                    |                        Welcome to Student Manager                           |
                    -------------------------------------------------------------------------------
                    
                    [1] Add New Student                    [2] Add New Student With Marks
                    [3] Add Marks                          [4] Update Student Details 
                    [5] Update Marks                       [6] Delete Student
                    [7] Print Student Details              [8] Print Student Ranks
                    [9] Best in Programming Fundementals   [10] Best in Database Managemnt System
                    """);

            System.out.print("Enter an option to continue >");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent(scanner);
                    clearConsole();
                    break;
                case 2:
                    addStudentWithMarks(scanner);
                    break;
                case 3:
                    addMarks(scanner);
                    break;
                case 4:
                    updateStudentDetails(scanner);
                    break;
                case 5:
                    updateMarks(scanner);
                    break;
                case 6:
                    deleteStudent(scanner);
                    break;
                case 7:
                    //printStudentDetails(scanner);
                    break;
                case 8:
                    //System.exit(0);
                    break;
                case 9:
                    //System.exit(0);
                    break;
                case 10:
                    //System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public final static void clearConsole() { try 
        { 
        final String os = System.getProperty("os.name"); if 
        (os.contains("Windows")) { new ProcessBuilder("cmd", "/c", 
        "cls").inheritIO().start().waitFor(); 
        } else { 
        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
        } 
        } catch (final Exception e) { 
        e.printStackTrace(); 
        } 
        } 

    private static void addStudent(Scanner scanner) {
    while (true) {
        clearConsole();
        String id;
        while (true) {
            System.out.print("Enter student ID: ");
            id = scanner.next();
            boolean exists = false;
            for (int i = 0; i < studentCount; i++) {
                if (studentNames[i][0].equals(id)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                break;
            } else {
                System.out.println("This ID already exists.");
                System.out.println("");
            }
        }
        studentNames[studentCount][0] = id;
        System.out.print("Enter student name : ");
        String name = scanner.next();
        studentNames[studentCount][1] = name;
        studentCount++;
        System.out.println("Student added successfully. Do you want to add another student? (Y/n)");
        String choice = scanner.next();
        if (choice.equals("n")) {
            break;
        }
    }
        
    }

    private static void addStudentWithMarks(Scanner scanner) {
        while (true) {
            clearConsole();
            String id;
            while (true) {
                System.out.print("Enter student ID: ");
                id = scanner.next();
                boolean exists = false;
                for (int i = 0; i < studentCount; i++) {
                    if (studentNames[i][0].equals(id)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    break;
                } else {
                    System.out.println("This ID already exists.");
                    System.out.println("");
                }
            }
            studentNames[studentCount][0] = id;
            System.out.print("Enter student name : ");
            String name = scanner.next();
            studentNames[studentCount][1] = name;
            studentCount++;
            System.out.println("");
            while (true) {
                System.out.print("Programming Fundamental Marks : ");
                int marks = scanner.nextInt();
                if (marks >= 0 && marks <= 100) {
                    studentMarks[studentCount - 1][0] = marks;
                    break;
                } else {
                    System.out.println("Invalid marks. Please enter correct marks.");
                    System.out.println("");
                } 
            }
            while (true) {
                System.out.print("Database Management System Marks : ");
                int marks = scanner.nextInt();
                if (marks >= 0 && marks <= 100) {
                    studentMarks[studentCount - 1][1] = marks;
                    break;
                } else {
                    System.out.println("Invalid marks. Please enter correct marks.");
                    System.out.println("");
                } 
            }
            studentMarksAdded[studentCount - 1] = true;
            studentMarks[studentCount - 1][2] = studentMarks[studentCount - 1][0] + studentMarks[studentCount - 1][1];
            System.out.println("Student added successfully. Do you want to add another student? (Y/n)");
            String choice = scanner.next();
            if (choice.equals("n")) {
                break;
            }       
        }
    }

    private static void addMarks(Scanner scanner) {
        while (true) {
            clearConsole();
            String id;
            while (true) {
                int studentIndex = -1;
                System.out.print("Enter student ID: ");
                id = scanner.next();
                for (int i = 0; i < studentCount; i++) {
                    if (studentNames[i][0].equals(id)) {
                        studentIndex = i;
                        break;
                    }
                }
                if (studentIndex != -1) {
                    System.out.println("Student Name : " + studentNames[studentIndex][1]);
                    if (studentMarksAdded[studentIndex] == true) {
                        System.out.println("""
                        This student's marks have been already added.
                        If you want to update the marks, please use [4] Update Marks option

                        Do you want to add marks for another student? (Y/n)
                        """);
                        String choice = scanner.next();
                        if (choice.equals("n")) {
                            return;
                        }
                        else if (choice.equals("y")) {
                            break;
                        }
                        
                    }
                    while (true) {
                        System.out.print("Programming Fundamental Marks : ");
                        int marks = scanner.nextInt();
                        if (marks >= 0 && marks <= 100) {
                            studentMarks[studentIndex][0] = marks;
                            break;
                        } else {
                            System.out.println("Invalid marks. Please enter correct marks.");
                            System.out.println("");
                        } 
                    }
                    while (true) {
                        System.out.print("Database Management System Marks : ");
                        int marks = scanner.nextInt();
                        if (marks >= 0 && marks <= 100) {
                            studentMarks[studentIndex][1] = marks;
                            break;
                        } else {
                            System.out.println("Invalid marks. Please enter correct marks.");
                            System.out.println("");
                        } 
                    }
                    studentMarksAdded[studentIndex] = true;
                    studentMarks[studentIndex][2] = studentMarks[studentIndex][0] + studentMarks[studentIndex][1];
                    System.out.println("Marks added successfully. Do you want to add marks for another student? (Y/n)");
                    String choice = scanner.next();
                    if (choice.equals("n")) {
                        return;
                    }
                    else if (choice.equals("y")) {
                        break;
                    }
                    
                }
                if (studentIndex == -1) {
                    System.out.println("Invalid student ID. Do you want to search again? (Y/n)");
                    String choice = scanner.next();
                    if (choice.equals("y")) {
                        continue;
                    } else if (choice.equals("n")) {
                        return;
                    }          
                }
            }                    
        }
    }

    private static void updateStudentDetails(Scanner scanner) {
        while (true) {
            clearConsole();
            String id;
            while (true) {
                int studentIndex = -1;
                System.out.print("Enter student ID: ");
                id = scanner.next();
                for (int i = 0; i < studentCount; i++) {
                    if (studentNames[i][0].equals(id)) {
                        studentIndex = i;
                        break;
                    }
                }
                if (studentIndex != -1) {
                    System.out.println("Student Name : " + studentNames[studentIndex][1]);
                    System.out.println("Enter the new student name");
                    String name = scanner.next();
                    studentNames[studentIndex][1] = name;
                    System.out.println("Student details updated successfully. Do you want to update another student's detail? (Y/n)");
                    String choice = scanner.next();
                    if (choice.equals("n")) {
                        return;
                    }
                    else if (choice.equals("y")) {
                        break;
                    }
                }
                if (studentIndex == -1) {
                    System.out.println("Invalid student ID. Do you want to search again? (Y/n)");
                    String choice = scanner.next();
                    if (choice.equals("y")) {
                        continue;
                    } else if (choice.equals("n")) {
                        return;
                    }          
                }
            }
        }
    }

    private static void updateMarks(Scanner scanner) {
        while (true) {
            clearConsole();
            String id;
            while (true) {
                int studentIndex = -1;
                System.out.print("Enter student ID: ");
                id = scanner.next();
                for (int i = 0; i < studentCount; i++) {
                    if (studentNames[i][0].equals(id)) {
                        studentIndex = i;
                        break;
                    }
                }
                if (studentIndex != -1) {
                    System.out.println("Student Name : " + studentNames[studentIndex][1]);
                    if (studentMarksAdded[studentIndex] == true) {
                        System.out.println("""
                        This student's marks yet to be added.
                        Do you want to update marks of another student. (Y/n)""");
                        String choice = scanner.next();
                        if (choice.equals("n")) {
                            return;
                        }
                        else if (choice.equals("y")) {
                            break;
                        }
                        
                    }
                    System.out.println("Programming Fundamental Marks : " + studentMarks[studentIndex][0]);
                    System.out.println("Database Management System Marks : " + studentMarks[studentIndex][1]);
                    System.out.println("");
                    while (true) {
                        System.out.print("Enter new Programming Fundamental Marks : ");
                        int marks = scanner.nextInt();
                        if (marks >= 0 && marks <= 100) {
                            studentMarks[studentIndex][0] = marks;
                            break;
                        } else {
                            System.out.println("Invalid marks. Please enter correct marks.");
                            System.out.println("");
                        } 
                    }
                    while (true) {
                        System.out.print("Enter new Database Management System Marks : ");
                        int marks = scanner.nextInt();
                        if (marks >= 0 && marks <= 100) {
                            studentMarks[studentIndex][1] = marks;
                            break;
                        } else {
                            System.out.println("Invalid marks. Please enter correct marks.");
                            System.out.println("");
                        } 
                    }
                    studentMarks[studentIndex][2] = studentMarks[studentIndex][0] + studentMarks[studentIndex][1];
                    System.out.println("Marks updated successfully. Do you want to update marks for another student? (Y/n)");
                    String choice = scanner.next();
                    if (choice.equals("n")) {
                        return;
                    }
                    else if (choice.equals("y")) {
                        break;
                    }
                    
                }
                if (studentIndex == -1) {
                    System.out.println("Invalid student ID. Do you want to search again? (Y/n)");
                    String choice = scanner.next();
                    if (choice.equals("y")) {
                        continue;
                    } else if (choice.equals("n")) {
                        return;
                    }
                }
            }
        }
    }

    private static void deleteStudent(Scanner scanner) {
        while (true) {
            clearConsole();
            String id;
            while (true) {
                int studentIndex = -1;
                System.out.print("Enter student ID: ");
                id = scanner.next();
                for (int i = 0; i < studentCount; i++) {
                    if (studentNames[i][0].equals(id)) {
                        studentIndex = i;
                        break;
                    }
                }
                if (studentIndex != -1) {
                        for (int i = studentIndex; i < studentCount - 1; i++) {
                            studentNames[i][0] = studentNames[i + 1][0];
                            studentNames[i][1] = studentNames[i + 1][1];
                            studentMarks[i][0] = studentMarks[i + 1][0];
                            studentMarks[i][1] = studentMarks[i + 1][1];
                            studentMarksAdded[i] = studentMarksAdded[i + 1];
                        }
                        studentCount--;
                        System.out.println("Student deleted successfully. Do you want to delete another student? (Y/n)");
                        String choice = scanner.next();
                        if (choice.equals("n")) {
                            return;
                        }
                        else if (choice.equals("y")) {
                            break;
                        }
                }
                if (studentIndex == -1) {
                    System.out.println("Invalid student ID. Do you want to search again? (Y/n)");
                    String choice = scanner.next();
                    if (choice.equals("y")) {
                        continue;
                    } else if (choice.equals("n")) {
                        return;
                    }
                }
            }
        }
    }

    private static void printStudentDetails(Scanner scanner) {
        while (true) {
            clearConsole();
            String id;
            while (true) {
                int studentIndex = -1;
                System.out.print("Enter student ID: ");
                id = scanner.next();
                for (int i = 0; i < studentCount; i++) {
                    if (studentNames[i][0].equals(id)) {
                        studentIndex = i;
                        break;
                    }
                }
                if (studentIndex != -1) {
                    int totalMarks = studentMarks[studentIndex][0] + studentMarks[studentIndex][1];
                    float averageMarks = totalMarks / 2;
                    int rank = 1; 
                    for (int i = 0; i < studentCount; i++) {
                        if (i != studentIndex) {
                            int otherTotalMarks = studentMarks[i][2];
                            if (otherTotalMarks > totalMarks) {
                                rank++;
                            }
                        }
                    }
                    System.out.println("Student Name : " + studentNames[studentIndex][1]);
                    System.out.println("Programming Fundamental Marks : " + studentMarks[studentIndex][0]);
                    System.out.println("Database Management System Marks : " + studentMarks[studentIndex][1]);
                    System.out.println("Total : " + totalMarks);
                    System.out.println("Average : " + averageMarks);
                    System.out.println("Rank : " + rank);
                    System.out.println("Do you want to search for another student? (Y/n)");
                    String choice = scanner.next();
                    if (choice.equals("n")) {
                        return;
                    }
                    else if (choice.equals("y")) {
                        break;
                    }
                }
                if (studentIndex == -1) {
                    System.out.println("Invalid student ID. Do you want to search again? (Y/n)");
                    String choice = scanner.next();
                    if (choice.equals("y")) {
                        continue;
                    } else if (choice.equals("n")) {
                        return;
                    }
                }
            }
        }
    }
}
