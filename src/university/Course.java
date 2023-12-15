package university;

import java.io.Serializable;

public class Course implements Serializable {
    private String subject;
    private int duration;
    private boolean interesting;

    public Course(String subject, int duration, boolean interesting) {
        this.subject = subject;
        this.duration = duration;
        this.interesting = interesting;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isInteresting() {
        return interesting;
    }

    public void setInteresting(boolean interesting) {
        this.interesting = interesting;
    }

    public String toString() {
        return "subject: " + subject +
                ", duration: " + duration +
                ", interesting: " + interesting;
    }
}
