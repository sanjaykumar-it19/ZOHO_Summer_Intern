package fileconcepts;

import java.util.*;


public class MainStudent {
    public static void main(String[] args)
    {   //Entering into the student Dashboard
        System.out.println("Welcome to Student DashBoard");
        // Creating a object for Student db class
        StudentDatabase db = new StudentDatabase();
        // Creating scanner class for getting input
        Scanner sc= new Scanner(System.in);// for integer input
        Scanner scString= new Scanner(System.in);//for string input

        // for user choice of preference in the db hashmap
        do
        {
            System.out.println("---------------------------------------------------");
            System.out.println("1.Insert Data");
            System.out.println("2.View all Data");
            System.out.println("3.Remove Data");
            System.out.println("4.Edit the data");
            System.out.println("5.view Data");
            System.out.println("6.To save data into a file");
            System.out.println("0.Exit,Enter the choice");
            System.out.println("---------------------------------------------------");

            int choiceOfUser=sc.nextInt();

            if(choiceOfUser==0)
            {   System.out.println("***********Program Terminated!!!***********");
                // if the user enters zero then the program should be terminated
                System.exit(0);
            }
            else if(choiceOfUser==1)
            {
                System.out.println("Enter the Roll Number");
                int rollNum=sc.nextInt();

                System.out.println("Enter the f_Name");
                String f_name =scString.nextLine();

                System.out.println("Enter the l_Name");
                String l_name=scString.nextLine();

                System.out.println("Enter the Mobile Number");
                String mobileNumber=scString.nextLine();
                // inserting the received to db for insertion into the hashmap
                db.inserData(rollNum, f_name,l_name,mobileNumber);

            }
            else if(choiceOfUser==2)
            {
                System.out.println("************************************************");
                db.viewData();
            // used for viewing the data
            }
            else if(choiceOfUser==3)
            {
                System.out.println("Enter the number need to remove:");
                int rovNum=sc.nextInt();
                db.removeRecord(rovNum);
                // used for removing the data
            }
            else if(choiceOfUser == 4)
            {
                System.out.println("Enter the Student Id need to edit:");
                int rovNum=sc.nextInt();
                db.editData(rovNum);
                // used to edit the user data already present in the hashmap


            }
            else if(choiceOfUser == 5)
            {
                System.out.println("Enter the Student Id need to view:");
                int rovNum=sc.nextInt();
                db.viewData(rovNum);
            }
            else if(choiceOfUser == 6)
            {   // file saved in the same folder
                db.save();
                System.out.println("DB  Saved!!");
            }


        }while(true);// it will get input from the user unless the user want to terminate the program


//		db.viewData();
    }
}

