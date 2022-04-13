package fileconcepts;
// creating a class for our student
public class ReferDataBaseVariable {
    String f_name;
    String l_name;
    String phoneNum="0";
    public ReferDataBaseVariable(String f_name,String l_name,String phone)
    { // updating the first name and lastname and phone number
        this.f_name=f_name;
        this.l_name = l_name;
        this.phoneNum=phone;
    }
    public void update(String f_name,String l_name)
    { // updating the first name and the last name
        this.f_name=f_name;
        this.l_name = l_name;
        //this.phoneNum="";
    }
    public void update(String phone)
    {  // updating the phone number only
        //this.name=name;
        this.phoneNum= phone;
    }
    public void getAllDetails()
    {  // geting all details of all users
        System.out.println("Name of the Student   :"+this.f_name+" "+this.l_name);
        if(this.phoneNum!="0")
        {
            System.out.println("Mobile Number         :"+this.phoneNum);
        }
    }
    public void getAllDetails(int id)
    { // getting all details of the particular user
        System.out.println("Name of the Student   :"+this.f_name+" "+this.l_name);
        if(this.phoneNum!="0")
        {
            System.out.println("Mobile Number         :"+this.phoneNum);
        }
    }
    public String[] getDetails()
    {   // splits the details for storing into the file
        String [] details = new String[3];
        details[0] = f_name;
        details[1] = l_name;
        details[2] = phoneNum;
        return details;
    }


}

