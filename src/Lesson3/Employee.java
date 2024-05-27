package Lesson3;

public class Employee {

    private String fullName;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Employee(String fullName, String position, String email, String phone, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возрасть: " + age);
    }


    public static void main(String[] args) {

        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "89211232512", 230000, 30);
        employees[1] = new Employee("Petrov Petr", "Manager", "petrov@mailbox.com", "89111231323", 150000, 35);
        employees[2] = new Employee("Sidorov Sidr", "Developer", "sidorov@mailbox.com", "89271235414", 320000, 28);
        employees[3] = new Employee("Smirnov Alex", "Designer", "smirnov@mailbox.com", "89211231554", 170000, 32);
        employees[4] = new Employee("Koroleva Vera", "Tester", "koroleva@mailbox.com", "89817409503", 180000, 25);

        for (Employee emp : employees) {
            emp.printInfo();
            System.out.println();
        }
    }
}





