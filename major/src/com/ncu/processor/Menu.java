package com.ncu.processor;
import java.util.*;
import java.io.*;
public class Menu
{
    public void menu(String username)
    {
        int choice2;
        char choice3;
        Scanner input=new Scanner(System.in);
    do
    {
	System.out.println("\n**************************WELCOME TO YOUR TO-DO LIST******************************");
    System.out.println("Choose from the following operations....");
    System.out.println("1.Display your list");
    System.out.println("2.Add to your list");
    System.out.println("3.Update your list");
    System.out.println("4.Delete your list");
    System.out.print("enter your choice: ");
    choice2=input.nextInt();
    if(choice2==1)
    {
    	File f=null;
    	try{
    		String sr;
           f=new File("C:\\javaprograms\\git init\\FOCP II\\major\\files\\"+username+".txt");
           // f=new File(username+".txt");
            FileReader fin=new FileReader(f);
            BufferedReader bin=new BufferedReader(fin);
    		System.out.println("Your current list is...");
    		while((sr=bin.readLine())!=null)
    		{
    			System.out.println(sr);
    		} 
            } 
    	catch (Exception e)
 		{
 			e.printStackTrace();
 		}
    } 
    else if(choice2==2)
    {
       File f = null;
      try 
      {
            f = new File("C:\\javaprograms\\git init\\FOCP II\\major\\files\\"+username+".txt");
            //f=new File(username+".txt");
            FileWriter fout = new FileWriter(f,true);
            BufferedWriter bout= new BufferedWriter(fout);
         Scanner sc = new Scanner(System.in);
             System.out.print("\nEnter your to-do list --->");
         while(sc.hasNext())
        {
               bout.write(sc.nextLine());
               bout.newLine();
        }
            bout.close();
}         
    catch (Exception e) 
    {
         // if any I/O error occurs
         e.printStackTrace();
      }   
    }
     else if(choice2==3)
    {
        File inputFile=null;
        File tempFile=null;
 try
{
    Scanner in =new Scanner(System.in);
inputFile = new File("C:\\javaprograms\\git init\\FOCP II\\major\\files\\"+username+".txt");
tempFile = new File("C:\\javaprograms\\git init\\FOCP II\\major\\files\\temp.txt");
 //inputFile=new File(username+".txt");
 //tempFile=new File("temp.txt");
 BufferedReader reader = new BufferedReader(new FileReader(inputFile));
 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
 System.out.println("which line do you want to modify ?");
 String lineToRemove = in.nextLine();
 String currentLine;

while((currentLine = reader.readLine()) != null) 
{
    if(currentLine.equals(lineToRemove)) 
    {
        System.out.println("enter modification");
         writer.write(in.nextLine());
         writer.newLine();

    }
    else
    {
       writer.write(currentLine );
       writer.newLine();

    }
    }
writer.close(); 
reader.close(); 
boolean successful=inputFile.delete();
System.out.println("line removed= "+successful);
boolean successful1 = tempFile.renameTo(inputFile);
System.out.println("rename= "+successful1);
}
catch( Exception e)
{
    e.printStackTrace();
}
}
    else if(choice2==4)
     {
        File inputFile=null;
        File tempFile=null;
 try
{
 inputFile = new File("C:\\javaprograms\\git init\\FOCP II\\major\\files\\"+username+".txt");
 tempFile = new File("C:\\javaprograms\\git init\\FOCP II\\major\\files\\temp.txt");
 
 //inputFile=new File(username+".txt");
 //tempFile=new File("temp.txt");
 Scanner in =new Scanner(System.in);
 BufferedReader reader = new BufferedReader(new FileReader(inputFile));
 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
  System.out.println("which line do you want to delete?");
 String lineToRemove = in.nextLine();
 String currentLine;
while((currentLine = reader.readLine()) != null) 
{
    if(currentLine.equals(lineToRemove)) 
        continue;
    writer.write(currentLine );
    writer.newLine();
}
writer.close(); 
reader.close(); 
boolean successful2 = inputFile.delete();
boolean successful1 = tempFile.renameTo(inputFile);
}
catch( Exception e)
{
    e.printStackTrace();
}
}
    else 
    {
        System.out.println("sorry!!....wrong input");
    }
    Scanner inchoice=new Scanner(System.in);
System.out.print("Do you wish to continue??(enter y for yes and any other key to exit)");
choice3=inchoice.next().charAt(0);
}while(choice3=='y');
}
}