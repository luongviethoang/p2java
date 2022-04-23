package btjava1;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

 class Student{
    private String Name;
    private Integer Age;
    private int RollNo;
    private String Dob;
    private String Address;
    private String Email;
    private String Status;

    public Student(String Name, Integer Age, int RollNo, String Dob, String Address, String Email, String Status){
        this.Name=Name;
        this.Age=Age;
        this.RollNo=RollNo;
        this.Dob=Dob;
        this.Address=Address;
        this.Email=Email;
        this.Status= Status;
    }
    public String getName(){return Name;}
     public int getAge(){return Age;}
     public int getRollNo(){return RollNo;}
     public String getDob(){return Dob;}
     public String getAddress(){return Address;}
     public String getEmail(){return Email;}
     public String getStatus(){return Status;}

     public void setName(String Name){this.Name=Name;}
     public void setAge(int Age){this.Age=Age;}
     public void setRollNo(int Roll){this.RollNo=RollNo;}
     public void setDob(String Dob){this.Dob=Dob;}
     public  void setAddress(String Address){this.Address=Address;}

     public void setEmail(String email) {this.Email=Email;}
     public void SetStatus(String Status){this.Status=Status;}

     @Override
     public String toString(){
        return "{" + "RollNo=" +RollNo+" FullName= "+Name+" Age= "+Age+
                " Dob= "+Dob+" Email= "+Email+" Address= "+ Address+
                " Status: "+Status+"}";
     }
 }public class StudentArrayList {
     public static void main (String[] args){
         List<Student> Students = new ArrayList<>();
         Students.add(new Student("Luong viet hoang",18,1,"2003/9/28","Street123","hoangckhg123@gmail.com","normal"));
         Students.add(new Student("Nguyen Ba Kha",18,2,"2003/3/32","Street123","hoangckhg123@gmail.com","normal"));
         Students.add(new Student("Kien Manh Nguyen",18,3,"2003/23/2","Street123","hoangckhg123@gmail.com","normal"));
         Students.add(new Student("Luong viet Minh",18,4,"2003/5/2","Street123","hoangckhg123@gmail.com","normal"));
         Students.add(new Student("Dinh Quan Anh",18,5,"2003/4/23","Street123","hoangckhg123@gmail.com","normal"));
         Collections.sort(Students, Comparator.comparing(Student::getName));
         System.out.println(Students);
     }}


