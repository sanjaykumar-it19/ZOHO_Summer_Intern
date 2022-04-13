package fileconcepts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class StudentDatabase {
    // Specifing the file where the output should be stored
    final static String outputFilePath = "sample.txt";
    HashMap<Integer,ReferDataBaseVariable> map= new HashMap<Integer,ReferDataBaseVariable>();
    // creating the hashmap with key value as roll number and value pair as referdatabasevariable class
    public StudentDatabase ()
    {   // invoking the creating using constructor
        HashMap<Integer,ReferDataBaseVariable> map= new HashMap<Integer,ReferDataBaseVariable>();
    }

    // inserting the data
    public void inserData(int num,String f_name,String l_name,String PhoneNum)
    {   // creating the object for getting the elements in the ReferDataBaseVariable class
        ReferDataBaseVariable stud1= new ReferDataBaseVariable(f_name,l_name,PhoneNum);
        // Pushing the roll number into the Hashmap and pasing the object of refer
        map.put(num,stud1);
        System.out.println("***********User Data inserted!!!***********");
    }
    // Editing the data which is inserted previously inside the map
    public void editData(int num)
    {   System.out.println("Enter the choice");
        System.out.println("Enter 1 to edit the name");
        System.out.println("Enter 2 to edit the Phone Number");
        Scanner scint = new Scanner(System.in);
        Scanner scstr = new Scanner(System.in);
        int choice = scint.nextInt();
        // if choice is 1 the we have to edit the name
        if(choice == 1)

        {   System.out.println("Enter the f_name");
            String f_name = scstr.nextLine();
            System.out.println("Enter the l_name");
            String l_name = scstr.nextLine();
            //ReferDataBaseVariable stud1= new ReferDataBaseVariable(f_name,l_name);
            //map.replace(num, stud1);
            // geting the object from the num and using that updating the value of f_name and l_name
            ReferDataBaseVariable stud1=map.get(num);
            stud1.update(f_name,l_name);
            //invoking the update function in referdatabasevariable class
            System.out.println("***********User Name Updated!!!***********");
        }
        else if(choice ==2)
        {
            System.out.println("Enter the Phone Number:");
            String phone_number = scstr.nextLine();
            // getting the phone number to edit
            ReferDataBaseVariable stud1=map.get(num);
            stud1.update(phone_number);
            System.out.println("***********User Ph.no Updated!!!***********");
        }
    }


    public void removeRecord(int rov)
    {   // remove record
        map.remove(rov);
        System.out.println("***********User Data Deleted!!!***********");
    }


    private int  sizeOfHash()
    {
        int si;
        si=map.size();
        return si;
        //returns size
    }

    public void save()
    {
        File file = new File(outputFilePath);

        BufferedWriter bf = null;

        try {

            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));

            // iterate map entries
            for(Map.Entry<Integer,ReferDataBaseVariable> entry : map.entrySet()){
                int num=entry.getKey();
                // put key and value separated by a colon
                ReferDataBaseVariable demo=entry.getValue();
                String [] details = new String [3];
                details = demo.getDetails();
                bf.write("Roll Number:"+num + " First Name:"
                        + details[0]+" "+details[1]+" Phone Number:"+details[2]);

                // new line
                bf.newLine();
            }

            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            try {

                // always close the writer
                bf.close();
            }
            catch (Exception e) {
            }
        }
    }


  public void viewData(int id)
  {   // viewing a data of a particular user
      if(sizeOfHash()==0)
      {  // checks for the database is empty or not
          System.out.println("The size of Database is empty");
      }
      else if(map.containsKey(id))
      {   // based on the key it is printing
          System.out.println("Roll Number           : "+ id);
          ReferDataBaseVariable demo=map.get(id);
          demo.getAllDetails(id);

      }
      else {
          // if the user enter the wrong roll number it will show an pop up like this
          System.out.println("The Data you are searching is not available !!");
      }
  }



    public void viewData()
    {  // helper function to view all the user data
        if(sizeOfHash()==0)
        {
            System.out.println("The size of Database is empty");
        }
        else
        {
            for(Map.Entry<Integer,ReferDataBaseVariable> entry : map.entrySet())
            {
                int num=entry.getKey();
                System.out.println("Roll Number           : "+num);
                ReferDataBaseVariable demo=entry.getValue();

                demo.getAllDetails();
                System.out.println("************************************************");
            }
        }
        // it will automatically save to a file after viewing all the data of the user
        save();
    }


}

