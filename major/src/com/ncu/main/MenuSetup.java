package com.ncu.main;
import java.util.*;
import java.io.*;
import com.ncu.exception.*;
import com.ncu.validator.*;
import com.ncu.processor.*;
public class MenuSetup
{
	public static void main(String args[])
	{
   Scanner input= new Scanner(System.in);
   int choice1;
   boolean b=false;
   boolean check=true;
   String sr;
   String username,password;
   System.out.println("\t\t\t***************************************************");
   System.out.println("\t\t\t    ___   __     ____   __         .  __  ___");
   System.out.println("\t\t\t     |   |  | -   |  | |  |    |   | |__   | ");
   System.out.println("\t\t\t     |   |__|    _|__| |__|    |__ |  __|  | ");
   System.out.println("\n\t\t\t***************************************************");
   System.out.println("SIGN-UP OR LOG-IN ?");
   System.out.println("enter '1' to SIGN-UP ");
   System.out.println("enter '2' to LOG-IN ");
   System.out.print("enter your choice ---> ");
   choice1=input.nextInt();
   User user=new User();
   Menu menuObj=new Menu();
   if(choice1==1)
    {
    System.out.println("\t\t\t\t\t*************************************************************");
    System.out.println("\t\t\t\t\t          ____  .   _____                      ____");
    System.out.println("\t\t\t\t\t         |      |  |       |\\   |     |   |  |    |");
    System.out.println("\t\t\t\t\t         |___   |  |   __  | \\  |  _  |   |  |____|");
    System.out.println("\t\t\t\t\t             |  |  |  |  | |  \\ |     |   |  |     ");
    System.out.println("\t\t\t\t\t         ____|  |  |__|  | |   \\|     |___|  |     ");
    System.out.println("\n");
    System.out.println("\t\t\t\t\t*************************************************************\n"); 
    Scanner scan=new Scanner(System.in);
    System.out.print("ENTER USERNAME: ");
    username=scan.nextLine();
    File f1=null;
    try
      {
        f1=new File("C:\\javaprograms\\git init\\FOCP II\\major\\files\\details.txt");
        //File f1=null;
        //f1=new File("details.txt");
        FileReader fin=new FileReader(f1);
        BufferedReader bin=new BufferedReader(fin);
        while((sr=bin.readLine())!=null)
        {
          String names[]=sr.split(",");
          if(names[0].equals(username))
          {
            check=false;
          }
        }
        bin.close();
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
        if(check==true)
        {
          System.out.print("ENTER PASSWORD: ");
          password=scan.nextLine();
          b=user.signup(username,password);
          if(b==true)
          {
             menuObj.menu(username);
          }
        }
        else
          System.out.println("Username already exists!!");
  }
    if(choice1==2)
    {
      System.out.println("\t\t\t\t\t*************************************************************");
      System.out.println("\t\t\t\t\t               ___   ______      .        ");  
      System.out.println("\t\t\t\t\t         |    |   | |            | |\\   |");
      System.out.println("\t\t\t\t\t         |    |   | |    __   _  | | \\  |");
      System.out.println("\t\t\t\t\t         |    |   | |   |  |     | |  \\ |");
      System.out.println("\t\t\t\t\t         |___ |___| |___|  |     | |   \\|");
      System.out.println("\n");
      System.out.println("\t\t\t\t\t*************************************************************");
      Scanner in=new Scanner(System.in);
      System.out.print("ENTER USERNAME: ");
      username=in.nextLine();
      b=user.login(username);
      if(b==true)
      {
        menuObj.menu(username);
      }
    }
    else 
      System.out.println("Error!!!invalid choice!!!");
   if(b==false)
   {
    System.out.println("DOES NOT EXIST!!!");
   }
}
}