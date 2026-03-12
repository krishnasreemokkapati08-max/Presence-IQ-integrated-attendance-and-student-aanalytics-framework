import java.util.*;

class Student {

    String roll;
    String name;
    int attendance;
    int fee;
    double cgpa;

    Student(String roll,String name,int attendance,int fee,double cgpa){
        this.roll=roll;
        this.name=name;
        this.attendance=attendance;
        this.fee=fee;
        this.cgpa=cgpa;
    }

    void display(){

        System.out.println("\nRoll : "+roll);
        System.out.println("Name : "+name);
        System.out.println("Attendance : "+attendance+"%");
        System.out.println("Fee Due : ₹"+fee);
        System.out.println("CGPA : "+cgpa);

        if(attendance<85){
            System.out.println("⚠ Low Attendance");
        }

        if(fee>0){
            System.out.println("⚠ Fee Due");
        }

        if(cgpa<6){
            System.out.println("⚠ Fail - Student should prepare well for upcoming exams");
        }

    }
}

public class PresenceIQ {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addStudent(){

        System.out.print("Enter Roll Number: ");
        String roll = sc.next();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Attendance %: ");
        int attendance = sc.nextInt();

        System.out.print("Enter Fee Due: ");
        int fee = sc.nextInt();

        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();

        students.add(new Student(roll,name,attendance,fee,cgpa));

        System.out.println("Student Saved Successfully\n");
    }

    static void showStudents(){

        if(students.isEmpty()){
            System.out.println("No students found");
            return;
        }

        for(Student s:students){
            s.display();
        }

    }

    static void searchStudent(){

        System.out.print("Enter Roll Number: ");
        String roll=sc.next();

        for(Student s:students){

            if(s.roll.equals(roll)){
                s.display();
                return;
            }

        }

        System.out.println("Student Not Found");

    }

    static boolean login(){

        System.out.print("Username: ");
        String user=sc.next();

        System.out.print("Password: ");
        String pass=sc.next();

        if((user.equals("faculty") && pass.equals("1234")) || 
           (user.equals("parent") && pass.equals("1234"))){

            System.out.println("Login Successful\n");
            return true;
        }

        System.out.println("Invalid Login");
        return false;
    }

    public static void main(String[] args){

        while(true){

            System.out.println("\n===== PresenceIQ System =====");
            System.out.println("1. Student Entry");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice=sc.nextInt();

            switch(choice){

                case 1:
                    addStudent();
                    break;

                case 2:

                    if(login()){

                        int ch;

                        do{

                            System.out.println("\n--- Dashboard ---");
                            System.out.println("1. View Students");
                            System.out.println("2. Search Student");
                            System.out.println("3. Logout");

                            ch=sc.nextInt();

                            if(ch==1) showStudents();
                            else if(ch==2) searchStudent();

                        }while(ch!=3);

                    }

                    break;

                case 3:
                    System.exit(0);

            }

        }

    }

}