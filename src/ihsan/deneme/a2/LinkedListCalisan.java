package ihsan.deneme.a2;

import ihsan.deneme.a1.Person;
import java.util.Scanner;

public class LinkedListCalisan {

    Scanner input = new Scanner(System.in);
    Person first;
    Person last;
    
    public void addEmployee(Person person) {
        if (first == null) {
            first = person;
        } else {
            last.next = person;
            person.prev = last;
        }
        last = person;
    }

    public void removeEmployee(int tc) {
        Person tmp = first;
        while (tmp != null) {
            if (tmp.tc.equals(tc)) {
                remove(tmp);
                System.out.println(tmp.name + " " + tmp.surname + " was deleted in the system.");
                return;
            }
            tmp = tmp.next;
        }
        System.out.println("ERROR --> tc: " + tc);
    }

    public void remove(Person person) {
        if (person == first) {
            if (first == last) {
                first = null;
                last = null;
            } else {
                first = first.next;
            }
        } else if (person == last) {
            last = last.prev;
        } else {
            Person back = person.prev;
            Person front = person.next;
            back.next = front;
            front.prev = back;
        }
    }

    public void updateEmployeeInformations(Person person) {
        System.out.println("1- name");
        System.out.println("2- surname");
        System.out.println("3- tc");
        System.out.println("4- tel no");
        System.out.println("5- salary");
        System.out.print("What do you want to change: ");
        int option = input.nextInt();
        switch (option) {
            case 0:
                break;
            case 1:
                System.out.print("Enter the new name: ");
                String newName = input.next();
                person.setName(newName);
                break;
            case 2:
                System.out.print("Enter the new surname: ");
                String newSurname = input.next();
                person.setSurname(newSurname);
                break;
            case 3:
                System.out.print("Enter the new tc: ");
                String newTC = input.next();
                person.setTc(newTC);
                break;
            case 4:
                System.out.print("Enter the new tel no: ");
                String newTelNo = input.next();
                person.setPhoneNumber(newTelNo);
                break;
            case 5:
                System.out.print("Enter the new salary: ");
                int newSalary = input.nextInt();
                person.setSalary(newSalary);
                break;
            default:
                System.out.println("");
                break;
        }
    }

    public void kisiGoruntule(Person person) {
        System.out.println("Employee: " + person.name + " " + person.surname);
        System.out.println("tc: " + person.tc);
        System.out.println("Phone no: " + person.phoneNumber);
        System.out.println("Salary: " + person.salary);
    }

    public void TumCalisanlariGoruntule() {
        System.out.println("----------------");
        Person tmp = first;
        if(tmp == null){
            System.out.println("There is no any employee.");
            System.out.println("----------------");
        }
        while (tmp != null) {
            kisiGoruntule(tmp);
            System.out.println("----------------");
            tmp = tmp.next;
        }
    }

    public Person search(String tc) {
        Person tmp = first;
        while (tmp != null) {

            if (tmp.tc.equals(tc)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }

}
