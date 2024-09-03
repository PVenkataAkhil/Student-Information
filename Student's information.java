package g30;
import java.util.*;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
public class Student {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");//loaded driver
		System.out.println("Driver loaded");
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cse","root","tiger");
       System.out.println("connected to the database");
    
 	  int s1=1;
 	 
 	   while(s1==1)
 	   {
 		  System.out.println("Enter your choice 1. Insert\n 2.Update\n 3.Delete\n 4.Execute\n");
 	     int c = s.nextInt();
       switch (c) 
       {
   	          case 1:
               System.out.println("Enter student id:");
               int sno = s.nextInt();
               System.out.println("Enter student name");
               String sname = s.next();
               System.out.println("Enter subject1 marks ");
               int sub1 = s.nextInt();
               System.out.println("Enter subject2 marks");
               int sub2 = s.nextInt();
               System.out.println("Enter subject3 marks");
               int sub3 = s.nextInt();
               System.out.println("Enter subject4 marks");
               int sub4 = s.nextInt();
               System.out.println("Enter subject5 marks");
               int sub5 = s.nextInt();
               System.out.println("Enter subject6 marks");
               int sub6 = s.nextInt();
            
               PreparedStatement psInsert = con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?)");
               psInsert.setInt(1, sno);
               psInsert.setString(2, sname);
               psInsert.setInt(3, sub1);
               psInsert.setInt(4, sub2);
               psInsert.setInt(5, sub3);
               psInsert.setInt(6, sub4);
               psInsert.setInt(7, sub5);
               psInsert.setInt(8, sub6);
               psInsert.execute();
               System.out.println("Record Inserted");
               int total=(sub1+sub2+sub3+sub4+sub5+sub6)/600 *100;
               if(total>=90)
               {
            	   System.out.println("A+");
               }
               else if(total<90 && total>=80)
               {
            	   System.out.println("A");
               }
               else if(total<80 && total>=70)
               {
            	   System.out.println("B");
               }
               else if(total<70 && total>=60)
               {
            	   System.out.println("B+");
               }
               else
               {
            	   System.out.println("fail");
               }
               break;
           case 2:
        	 
        	   
        
                    System.out.println("Enter the id to update");
                    int uid = s.nextInt();
                    System.out.println("Enter updated subject1 marks ");
                    int u1 = s.nextInt();
                    System.out.println("Enter updated subject2 marks");
                    int u2 = s.nextInt();
                    System.out.println("Enter updated subject3 marks");
                    int u3 = s.nextInt();
                    System.out.println("Enter updated subject4 marks");
                    int u4 = s.nextInt();
                    System.out.println("Enter updated subject5 marks");
                    int u5 = s.nextInt();
                    System.out.println("Enter updated subject6 marks");
                    int u6 = s.nextInt();
                    PreparedStatement psu = con.prepareStatement("update student set sub1=?, sub2=?,sub3=?,sub4=?,sub5=?,sub6=? where sno=?");
                    psu.setInt(1, u1);
                    psu.setInt(2, u2);
                    psu.setInt(3, u3);
                    psu.setInt(4, u4);
                    psu.setInt(5, u5);
                    psu.setInt(6, u6);
                    psu.setInt(7, uid);
                    psu.executeUpdate();
                    System.out.println("Record Updated");
                    break;
           case 3:
        	    System.out.println("Enter the id to delete");
                int deleteId = s.nextInt();
                
               PreparedStatement psd = con.prepareStatement("delete from student where sno=?");
                psd.setInt(1, deleteId);
                psd.executeUpdate();
                System.out.println("Record Deleted");
                break;
           case 4:
               PreparedStatement pss = con.prepareStatement("select * from Student");
               ResultSet rs = pss.executeQuery();
               while (rs.next()) {
                   System.out.println("No: " + rs.getInt(1) + ", Name: " + rs.getString(2) + ", Subject1: " + rs.getInt(3) + ", Subject2: " + rs.getInt(4));
               }
               break;
           default:
               System.out.println("Something is missing / entered wrong ");
               break;
       }
       System.out.println("Do you want to continue? 1 or 0");
     s1=s.nextInt();
   }

    con.close();      

}
}
                
                    
        
