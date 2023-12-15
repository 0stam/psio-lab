package university;

public class Employee extends Person {
    private int salary;
    private int yearsOfExperience;

    public Employee() {
        salary = 0;
        yearsOfExperience = 0;
    }

    public Employee(String name, String surname, int age, int salary, int yearsOfExperience) {
        super(name, surname, age);
        this.salary = salary;
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String toString() {
        return super.toString() +
                ", salary: " + salary +
                ", yearsOfExperience: " + yearsOfExperience;
    }
}
