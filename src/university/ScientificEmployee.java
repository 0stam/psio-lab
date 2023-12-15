package university;

public class ScientificEmployee extends Employee {
    private double citations;
    private boolean leadsScientificClub;

    public ScientificEmployee(String name, String surname, int age, int salary, int yearsOfExperience, double citations, boolean leadsScientificClub) {
        super(name, surname, age, salary, yearsOfExperience);
        this.citations = citations;
        this.leadsScientificClub = leadsScientificClub;
    }

    public double getCitations() {
        return citations;
    }

    public void setCitations(double citations) {
        this.citations = citations;
    }

    public boolean isLeadsScientificClub() {
        return leadsScientificClub;
    }

    public void setLeadsScientificClub(boolean leadsScientificClub) {
        this.leadsScientificClub = leadsScientificClub;
    }

    public String toString() {
        return super.toString() +
                ", citations: " + citations +
                ", leadsScientificClub: " + leadsScientificClub;
    }
}
