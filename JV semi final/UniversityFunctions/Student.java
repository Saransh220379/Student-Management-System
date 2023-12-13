

package UniversityFunctions;

public class Student extends Person {
    private int studentID;
    private int grade;
    private Course course1;
    private Course course2;
    private Course course3;

    public Student(String name, int age, int studentID, int grade, Course course1, Course course2, Course course3) {
        super(name, age);
        this.studentID = studentID;
        this.grade = grade;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getGrade() {
        return grade;
    }

    public Course getCourse1() {
        return course1;
    }

    public Course getCourse2() {
        return course2;
    }

    public Course getCourse3() {
        return course3;
    }

    public void updateStudentDetails(String newName, int newAge, int newGrade, Course newCourses[]) {
        setName(newName);
        setAge(newAge);
        grade = newGrade;
        course1 = newCourses[0];
        course2 = newCourses[1];
        course3 = newCourses[2];
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setCourse1(Course course) {
        this.course1 = course;
    }

    public void setCourse2(Course course) {
        this.course2 = course;
    }

    public void setCourse3(Course course) {
        this.course3 = course;
    }

    public void displayDetails() {
        System.out.println("Name\t| Age\t| Student ID\t| Rank\t| Courses");
        System.out.println("-----------------------------------------------------------");

        System.out.print(getName() + "\t| " + getAge() + "\t| " + studentID + "\t\t| " + grade + "\t| ");

        if (course1 != null) {
            System.out.print("Course 1: " + course1.getCourseName() + " (ID: " + course1.getCourseID() + ")");
        }
        if (course2 != null) {
            System.out.print(", Course 2: " + course2.getCourseName() + " (ID: " + course2.getCourseID() + ")");
        }
        if (course3 != null) {
            System.out.print(", Course 3: " + course3.getCourseName() + " (ID: " + course3.getCourseID() + ")");
        }
        System.out.println();
    }
}


