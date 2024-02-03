import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    public void removeDepartment(Department department) {
        this.departments.remove(department);
    }

    public Employee findEmployeeByName(String fullName) {
        for (Department department : departments) {
            for (Employee employee : department.getEmployees()) {
                if (employee.getFullName().equals(fullName)) {
                    return employee;
                }
            }
        }
        return null;
    }
}

class Department {
    private String name;
    private Company company;
    private List<Employee> employees;

    public Department(String name, Company company) {
        this.name = name;
        this.company = company;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
    }

    public int getNumberOfEmployees() {
        return this.employees.size();
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public String getName() {
        return name;
    }
}

class Employee {
    private String fullName;
    private String position;

    public Employee(String fullName, String position) {
        this.fullName = fullName;
        this.position = position;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }
}
public class Main {
    public static void main(String[] args) {
        Company company = new Company("StudioX");

        Department department1 = new Department("Director", company);
        Department department2 = new Department("Chief", company);

        company.addDepartment(department1);
        company.addDepartment(department2);

        Employee employee1 = new Employee("Erasyl", "Director (general director, manager) of the enterprise");
        Employee employee2 = new Employee("Erdaulet", "Financial Director (Deputy Director for Finance)");
        Employee employee3 = new Employee("Arman", "Chief Accountant");
        Employee employee4 = new Employee("Imran", "Chief dispatcher");
        Employee employee5 = new Employee("Amir", "Chief Engineer");
        Employee employee6 = new Employee("Islam", "Chief designer");

        department1.addEmployee(employee1);
        department1.addEmployee(employee2);
        department2.addEmployee(employee3);
        department2.addEmployee(employee4);
        department2.addEmployee(employee5);
        department2.addEmployee(employee6);
        System.out.println("Number of employees in Director Department: " + department1.getNumberOfEmployees());
        System.out.println("Employees in Director Department:");
        for (Employee employee : department1.getEmployees()) {
            System.out.println(employee.getFullName() + " - " + employee.getPosition());
        }

        System.out.println("Number of employees in Chief Department: " + department2.getNumberOfEmployees());
        System.out.println("Employees in Chief Department:");
        for (Employee employee : department2.getEmployees()) {
            System.out.println(employee.getFullName() + " - " + employee.getPosition());
        }



        Scanner scanner = new Scanner(System.in);

        System.out.print("Employee: ");
        String searchFullName = scanner.nextLine();

        Employee foundEmployee = company.findEmployeeByName(searchFullName);

        if (foundEmployee != null) {
            System.out.println("Employee found: " + foundEmploy