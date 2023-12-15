package main;

import university.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("coding", 2, true));
        courses.add(new Course("mathematical analysis", 1, false));
        courses.add(new Course("computer system organization", 2, false));

        List<Person> people = new ArrayList<>();

        people.add(new Student("Andrzej", "Matejko", 333, 12, 913042, false, courses));
        people.add(new Student("Ryszard", "Szczudło", 19, 1, 222333, true, courses));

        people.add(new AdministrativeEmployee("Maciej", "Adamecki", 66, 4500, 10, "receptionist", 2, true));
        people.add(new AdministrativeEmployee("Jakub", "Małolepszy", 30, 7000, 5, "receptionist", 0.2, false));
        people.add(new AdministrativeEmployee("Klaudia", "Pokrzywka", 44, 5000, 20, "accountant", 10, true));

        people.add(new ScientificEmployee("Marcin", "Tarkowski", 25, 25000, 20, 1.9, true));
        people.add(new ScientificEmployee("Andżelika", "Miłą", 33, 11000, 8, 0.5, false));
        people.add(new ScientificEmployee("Janusz", "Niemiły", 99, 1000, 1, 0.3, false));

        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.print("Select action [1-display all, 2-find by surname, 3-find by index number, 4-find by citations, 5-find by position, 6-save, 7-load]: ");
            String action = scn.nextLine();

            switch (action) {
                case "1":
                    printAll(people);
                    break;
                case "2":
                    System.out.print("Enter surname: ");
                    String surname = scn.next();
                    findSurname(people, surname);
                    break;
                case "3":
                    System.out.print("Enter index number: ");
                    int number = scn.nextInt();
                    findStudentByIndexNumber(people, number);
                    break;
                case "4":
                    System.out.print("Enter citations threshold: ");
                    double threshold = scn.nextDouble();
                    findEmployeeByCitations(people, threshold);
                    break;
                case "5":
                    System.out.print("Enter position: ");
                    String position = scn.next();
                    findEmployeeByPosition(people, position);
                    break;
                case "6":
                    save(people);
                    break;
                case "7":
                    people = load();
                    break;
                default:
                    System.out.println("Invalid command");
            }

            System.out.println();
        }
    }

    public static void printAll(List<Person> people) {
        for (Person p : people) {
            System.out.println(p);
        }
    }

    public static void findSurname(List<Person> people, String surname) {
        boolean found = false;

        for (Person p : people) {
            if (p.getSurname().equals(surname)) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Person not found");
        }
    }

    public static void findStudentByIndexNumber(List<Person> people, int number) {
        for (Person p : people) {
            if (p instanceof Student && ((Student) p).getIndexNumber() == number) {
                System.out.println(p);
                return;
            }
        }

        System.out.println("Student not found");
    }

    public static void findEmployeeByCitations(List<Person> people, double threshold) {
        boolean found = false;

        for (Person p : people) {
            if (p instanceof ScientificEmployee && ((ScientificEmployee) p).getCitations() >= threshold) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Employees not found");
        }
    }

    public static void findEmployeeByPosition(List<Person> people, String position) {
        boolean found = false;

        for (Person p : people) {
            if (p instanceof AdministrativeEmployee && ((AdministrativeEmployee) p).getPosition().equals(position)) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Employees not found");
        }
    }

    public static void save(List<Person> people) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.txt"))) {
            oos.writeObject(people);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Can't open file");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File error");
        }
    }

    public static List<Person> load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.txt"))) {
            Object readObject = ois.readObject();

            if(!(readObject instanceof List)) {
                System.out.println("Invalid file");
                return new ArrayList<Person>();
            }

            return (List<Person>) readObject;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Can't open file");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File error");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Invalid file");
        }

        return new ArrayList<Person>();
    }
}
