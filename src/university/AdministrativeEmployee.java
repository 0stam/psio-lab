package university;

public class AdministrativeEmployee extends Employee {
    private String position;
    private double documentsPerSecond;
    private boolean needsSleep;

    public AdministrativeEmployee(String name, String surname, int age, int salary, int yearsOfExperience, String position, double documentsPerSecond, boolean needsSleep) {
        super(name, surname, age, salary, yearsOfExperience);
        this.position = position;
        this.documentsPerSecond = documentsPerSecond;
        this.needsSleep = needsSleep;
    }

    public double getDocumentsPerSecond() {
        return documentsPerSecond;
    }

    public void setDocumentsPerSecond(double documentsPerSecond) {
        this.documentsPerSecond = documentsPerSecond;
    }

    public boolean isNeedsSleep() {
        return needsSleep;
    }

    public void setNeedsSleep(boolean needsSleep) {
        this.needsSleep = needsSleep;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String toString() {
        return super.toString() +
                ", position: " + position +
                ", documentsPerSecond: " + documentsPerSecond +
                ", needsSleep: " + needsSleep;
    }
}
