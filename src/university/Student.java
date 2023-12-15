package university;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private int yearOfStudies;
    private int indexNumber;
    private boolean likesLearning;
    private List<Course> courses;

    public Student(String name, String surname, int age, int yearOfStudies, int indexNumber, boolean likesLearning, List<Course> courses) {
        super(name, surname, age);
        this.yearOfStudies = yearOfStudies;
        this.indexNumber = indexNumber;
        this.likesLearning = likesLearning;
        this.courses = courses;
    }

    public int getYearOfStudies() {
        return yearOfStudies;
    }

    public void setYearOfStudies(int yearOfStudies) {
        this.yearOfStudies = yearOfStudies;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    public boolean isLikesLearning() {
        return likesLearning;
    }

    public void setLikesLearning(boolean likesLearning) {
        this.likesLearning = likesLearning;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String toString() {
        return super.toString() +
                ", yearOfStudies: " + yearOfStudies +
                ", indexNumber: " + indexNumber +
                ", likesLearning: " + likesLearning +
                ", courses: " + courses;
    }

    public List<Course> getEngagingCourses() {
        List<Course> engaging = new ArrayList<>();

        for (Course course : courses) {
            if (course.isInteresting() || (likesLearning && course.getDuration() < 2)) {
                engaging.add(course);
            }
        }

        return engaging;
    }
}
