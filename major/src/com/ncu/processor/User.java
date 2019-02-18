package com.ncu.processor;
import java.util.*;
import java.io.*;
import com.ncu.exception.*;
import com.ncu.processor.*;
import com.ncu.validator.*;
public class User
{
	public static boolean signup(String username,String password)
	{
	Scanner scan=new Scanner(System.in);
    Validator object=new Validator();
    boolean checkValidator=object.upValidator(username,password);
    if(checkValidator==true)
    	{
        File f=null;
        try
        {
      	    f=new File("C:\\javaprograms\\git init\\FOCP II\\major\\files\\details.txt");
 		    //f=new File("details.txt");
            FileWriter fout=new FileWriter(f,true);
 			BufferedWriter bout=new BufferedWriter(fout);
 		    bout.write(username+","+password);
 			bout.newLine();
 		    bout.close();
 		}
         catch (Exception e)
 		{
 			e.printStackTrace();
 		}
    }
    return checkValidator;
}
public static boolean login(String username)
{ 
    File f1=null;
    String sr,password;
    Scanner scan=new Scanner(System.in);
    	try
    	{
    		f1=new File("C:\\javaprograms\\git init\\FOCP II\\major\\files\\details.txt");
    		//f1=new File("details.txt");
            FileReader fin=new FileReader(f1);
    		BufferedReader bin=new BufferedReader(fin);
    		while((sr=bin.readLine())!=null)
    		{
    		  String names[]=sr.split(",");
    		  if(names[0].equals(username))
    		  {
    		  	System.out.print("ENTER PASSWORD: ");
                password=scan.nextLine();
    		  	if(names[1].equals(password))
    		  	{
    		  		System.out.println("############# SUCCESSFULLY LOGGED-IN #############");
                    return true;
    		  	}
    		  }
    		} 
    		bin.close();
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
        return false;
}
}