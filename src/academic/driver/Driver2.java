package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author 12S23041 - Lisbeth Panjaitan 
 * @author 12S23021 - Eunike Purba
 */
public class Driver2 {

    public static void main(String[] _args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        String str;

        while (true) {
            str = input.nextLine();
            if (str.equals("---")) {
                break;
            } else {
                String[] tokens = str.split("#");
                String command = tokens[0];
                switch (command) {
                    case "course-add":
                        if (tokens.length == 5) {
                            String course_id = tokens[1];
                            String course_name = tokens[2];
                            int credit = Integer.parseInt(tokens[3]);
                            String passingGrade = tokens[4];
                            Course course = new Course(course_id, course_name, credit, passingGrade);
                            if (!courses.contains(course)) {
                                courses.add(course);
                            }
                        }
                        break;
                    case "student-add":
                        if (tokens.length == 5) {
                            String student_id = tokens[1];
                            String student_name = tokens[2];
                            int year = Integer.parseInt(tokens[3]);
                            String major = tokens[4];
                            Student student = new Student(student_id, student_name, year, major);
                            if (!students.contains(student)) {
                                students.add(student);
                            }
                        }
                        break;
                    case "enrollment-add":
                        if (tokens.length == 5) {
                            String course_id = tokens[1];
                            String student_id = tokens[2];
                            String academicYear = tokens[3];
                            String semester = tokens[4];

                            boolean courseExists = false;
                            boolean studentExists = false;

                            for (Course course : courses) {
                                if (course.getCode().equals(course_id)) {
                                    courseExists = true;
                                    break;
                                }
                            }

                            for (Student student : students) {
                                if (student.getId().equals(student_id)) {
                                    studentExists = true;
                                    break;
                                }
                            }

                            if (!courseExists) {
                                System.out.println("invalid course|" + course_id);
                            } else if (!studentExists) {
                                System.out.println("invalid student|" + student_id);
                            } else {
                                Enrollment enrollment = new Enrollment(course_id, student_id, academicYear, semester);
                                if (!enrollments.contains(enrollment)) {
                                    enrollments.add(enrollment);
                                }
                            }
                        }
                        break;
                }
            }
        }
        Collections.sort(courses,Comparator.comparing(Course::getCode));
        for (Course course : courses) {
            System.out.println(course.getCode() + "|" + course.getName() + "|" + course.getCredits() + "|" + course.getGrade());
        }
        

        for (Student student : students) {
            System.out.println(student.getId() + "|" + student.getName() + "|" + student.getYear() + "|" + student.getMajor());
        }


        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.getCourseId() + "|" + enrollment.getStudentId() + "|" + enrollment.getAcademicYear() + "|" + enrollment.getSemester() + "|None");
        }

        input.close();
    }
}