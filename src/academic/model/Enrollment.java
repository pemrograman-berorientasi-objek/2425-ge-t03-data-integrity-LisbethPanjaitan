package academic.model; 

/**
 * @author 12S23041 - Lisbeth Panjaitan 
 * @author 12S23021 - Eunike Purba
 */

public class Enrollment {
    private String courseId;
    private String studentId;
    private String academicYear;
    private String semester;

    public Enrollment(String courseId, String studentId, String academicYear, String semester) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Enrollment enrollment = (Enrollment) obj;
        return courseId.equals(enrollment.courseId) && studentId.equals(enrollment.studentId);
    }

    @Override
    public int hashCode() {
        int result = courseId.hashCode();
        result = 31 * result + studentId.hashCode();
        return result;
    }
}