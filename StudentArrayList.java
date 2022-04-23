package btjava1;

import java.util.*;

 class Student{
    private String Name;
    private Integer Age;
    private int RollNo;
    private int Dob;
    private String Address;
    private String Email;
    private String Status;

    public Student(String Name, Integer Age, int RollNo, int Dob, String Address, String Email, String Status){
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
     public int getDob(){return Dob;}
     public String getAddress(){return Address;}
     public String getEmail(){return Email;}
     public String getStatus(){return Status;}

     public void setName(String Name){this.Name=Name;}
     public void setAge(int Age){this.Age=Age;}
     public void setRollNo(int Roll){this.RollNo=RollNo;}
     public void setDob(int Dob){this.Dob=Dob;}
     public  void setAddress(String Address){this.Address=Address;}

     public void setEmail(String email) {this.Email=Email;}
     public void SetStatus(String Status){this.Status=Status;}

     @Override
     public String toString(){
        return "{" + "RollNo= " +RollNo+" FullName= "+Name+" Age= "+Age+
                " Dob= "+Dob+" Email ="+Email+" Address= "+ Address+
                " Status: "+Status+"}";
     }
 }public class StudentArrayList {
     public static void main (String[] args){
         List<Student> Students = new ArrayList<>();
         Students.add(new Student("Luong viet hoang",18,1,28/9/2003,"Street123","hoangckhg123@gmail.com","normal"));
         Students.forEach(student -> {
             System.out.println(Students);
         });
     }}


