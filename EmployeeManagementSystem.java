import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<Employee>();

        int choice;

        do
        {
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    employees.add(new Employee(id, name, dept, salary));

                    System.out.println("Employee Added Successfully!");
                    break;

                case 2:
                    if(employees.isEmpty())
                    {
                        System.out.println("No Employees Found!");
                    }
                    else
                    {
                        for(Employee emp : employees)
                        {
                            emp.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for(Employee emp : employees)
                    {
                        if(emp.getId() == searchId)
                        {
                            emp.display();
                            found = true;
                            break;
                        }
                    }

                    if(!found)
                    {
                        System.out.println("Employee Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    found = false;

                    for(Employee emp : employees)
                    {
                        if(emp.getId() == updateId)
                        {
                            System.out.print("Enter New Name: ");
                            emp.setName(sc.nextLine());

                            System.out.print("Enter New Department: ");
                            emp.setDepartment(sc.nextLine());

                            System.out.print("Enter New Salary: ");
                            emp.setSalary(sc.nextDouble());

                            System.out.println("Employee Updated Successfully!");
                            found = true;
                            break;
                        }
                    }

                    if(!found)
                    {
                        System.out.println("Employee Not Found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Employee ID to Delete: ");
                    int deleteId = sc.nextInt();

                    found = false;

                    for(int i = 0; i < employees.size(); i++)
                    {
                        if(employees.get(i).getId() == deleteId)
                        {
                            employees.remove(i);
                            System.out.println("Employee Deleted Successfully!");
                            found = true;
                            break;
                        }
                    }

                    if(!found)
                    {
                        System.out.println("Employee Not Found!");
                    }
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while(choice != 6);

        sc.close();
    }
}