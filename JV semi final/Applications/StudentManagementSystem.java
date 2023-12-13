package Applications;


import UniversityFunctions.Person;
import UniversityFunctions.Student;
import UniversityFunctions.Course;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) {
        final int MAX_STUDENTS = 100;
        Student[] studentRecords = new Student[MAX_STUDENTS];
        int studentCount = 0;
        Scanner scanner = new Scanner(System.in);




        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student Record");
            System.out.println("2. Edit Student Record");
            System.out.println("3. Display Student Records");
            System.out.println("4. Search Student Record (by ID)");
            System.out.println("5. Remove Student Record");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
		int choice =0;
		do{
            try{
                choice=Integer.parseInt(scanner.nextLine());
	        //scanner.nextLine(); // Consume newline character
		}
		catch(Exception e){
		System.out.println("Invalid Input");
		choice=Integer.parseInt(scanner.nextLine());
		//scanner.nextLine();
		
	}
		}while(choice>7||choice<0);
            if (choice == 1) {
                // Add Student Record Logic
                if (studentCount < MAX_STUDENTS) {
                    System.out.print("Enter student ID: ");
			        int studentID;
                    try {
                        studentID = Integer.parseInt(scanner.nextLine());
                    //scanner.nextLine();
                    }
                    catch(Exception e){
                        System.out.println("Invalid Input");
                        studentID=Integer.parseInt(scanner.nextLine());
                    }
			for(int i=0;i<studentCount;i++){
				if(studentID==studentRecords[i].getStudentID()){
				System.out.println("Student Already Exists");
				break;					
}
			}
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age;
                    try {
                        age = Integer.parseInt(scanner.nextLine());
                        //scanner.nextLine();
                    }
                    catch (Exception e){
                        System.out.println("Invalid Input");
                        age=Integer.parseInt(scanner.nextLine());
                    }
                    System.out.print("Enter student grade: ");
                    int grade;
                    try {
                        grade = Integer.parseInt(scanner.nextLine());
                        //scanner.nextLine();
                    }
                    catch (Exception e){
                        System.out.println("Invalid Input");
                        grade=Integer.parseInt(scanner.nextLine());
                    }
                    System.out.println("Enter up to 3 courses for the student:");
                    Course[] courses = new Course[3];

                    for (int i = 0; i < 3; i++) {
                        System.out.print("Enter course name for course " + (i + 1) + ": ");
                        String courseName = scanner.nextLine();
                        System.out.print("Enter course ID for course " + (i + 1) + ": ");
                        int courseID = scanner.nextInt();
                        scanner.nextLine();
                        courses[i] = new Course(courseName, courseID);
                    }
			

                    studentRecords[studentCount] = new Student(name, age, studentID, grade, courses[0], courses[1], courses[2]);
                    studentCount++;
                    System.out.println("Student record added successfully.");
			choice=Integer.parseInt(scanner.nextLine());
                } else {
                    System.out.println("Cannot add more students. Limit reached.");
                }

            } else if (choice == 2) {
                // Edit Student Record Logic
                System.out.print("Enter student ID to edit: ");
                int editID;
                try {
                    editID = Integer.parseInt(scanner.nextLine());
                }
                catch (Exception e){
                    System.out.println("Invalid Input");
                    editID=Integer.parseInt(scanner.nextLine());
                }
                //scanner.nextLine();
                boolean found = false;

                for (int i = 0; i < studentCount; i++) {
                    if (studentRecords[i].getStudentID() == editID) {
                        System.out.println("What would you like to edit?");
                        System.out.println("1. Name");
                        System.out.println("2. Age");
                        System.out.println("3. Grade");
                        System.out.println("4. Course 1");
                        System.out.println("5. Course 2");
                        System.out.println("6. Course 3");
                        System.out.println("7. Exit Edit Menu");
                        System.out.print("Enter your choice: ");
                        int editChoice;
                        try {
 
                            editChoice = Integer.parseInt(scanner.nextLine());

                            scanner.nextLine(); // Consume newline character
                        }
                        catch (Exception e){
                            System.out.println("Invalid Input");
                            editChoice=Integer.parseInt(scanner.nextLine());
                        }
                        switch (editChoice) {
                            case 1:
                                System.out.print("Enter new name: ");
                                String newName = scanner.nextLine();
                                studentRecords[i].setName(newName);
                                break;
                            case 2:
                                System.out.print("Enter new age: ");
                                int newAge;
                                try {
                                    newAge=Integer.parseInt(scanner.nextLine());
                                }
                                catch (Exception e){
                                    System.out.println("Invalid Input");
                                    newAge=Integer.parseInt(scanner.nextLine());
                                }
                                //scanner.nextLine();
                                studentRecords[i].setAge(newAge);
                                break;
                            case 3:
                                System.out.print("Enter new grade: ");
                                int newGrade;
                                try {
                                    newGrade =Integer.parseInt(scanner.nextLine());
                                }
                                catch (Exception e){
                                    System.out.println("Invalid Input");
                                    newGrade =Integer.parseInt(scanner.nextLine());
                                }
                                scanner.nextLine();
                                studentRecords[i].setGrade(newGrade);
                                break;
                            case 4:
                                System.out.println("Enter new course details for Course 1:");
                                Course newCourse1 = inputCourseDetails(scanner);
                                studentRecords[i].setCourse1(newCourse1);
                                break;
                            case 5:
                                System.out.println("Enter new course details for Course 2:");
                                Course newCourse2 = inputCourseDetails(scanner);
                                studentRecords[i].setCourse2(newCourse2);
                                break;
                            case 6:
                                System.out.println("Enter new course details for Course 3:");
                                Course newCourse3 = inputCourseDetails(scanner);
                                studentRecords[i].setCourse3(newCourse3);
                                break;
                            case 7:
                                System.out.println("Exiting edit menu.");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student ID not found.");
                }

            } else if (choice == 3) {
                // Display Student Records Logic
                if (studentCount == 0) {
                    System.out.println("No student records found.");
                } else {
                    System.out.println("Student Records:");
                    for (int i = 0; i < studentCount; i++) {
                        studentRecords[i].displayDetails();
                        System.out.println();
                    }
                }

            } else if (choice == 4) {
                // Search Student Record Logic
                System.out.print("Enter student ID to search: ");
                int searchID;
                try {
                    searchID=Integer.parseInt(scanner.nextLine());
                }
                catch (Exception e){
                    System.out.println("Invalid Input");
                    searchID=Integer.parseInt(scanner.nextLine());
                }
                //scanner.nextLine();
                boolean found = false;

                for (int i = 0; i < studentCount; i++) {
                    if (studentRecords[i].getStudentID() == searchID) {
                        System.out.println("Student Record Found:");
                        studentRecords[i].displayDetails();
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student ID not found.");
                }

            } else if (choice == 5) {
                // Remove Student Record Logic
                System.out.print("Enter student ID to remove: ");
                int removeID;
                try {
                    removeID=Integer.parseInt(scanner.nextLine());
                }
                catch (Exception e){
                    System.out.println("Invalid Input");
                    removeID=Integer.parseInt(scanner.nextLine());
                }
                scanner.nextLine();
                boolean removed = false;

                for (int i = 0; i < studentCount; i++) {
                    if (studentRecords[i].getStudentID() == removeID) {
                        for (int j = i; j < studentCount - 1; j++) {
                            studentRecords[j] = studentRecords[j + 1];
                        }
                        studentCount--;
                        System.out.println("Student record removed successfully.");
                        removed = true;
                        break;
                    }
                }

                if (!removed) {
                    System.out.println("Student ID not found.");
                }

            } else if (choice == 6) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Helper method to input course details
    private static Course inputCourseDetails(Scanner scanner) {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter course ID: ");
        int courseID = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        return new Course(courseName, courseID);
    }
}

