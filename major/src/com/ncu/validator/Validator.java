package com.ncu.validator;
import com.ncu.exception.*;
import java.util.regex.Pattern;  
import java.io.*;               
import java.util.*;             
import org.apache.log4j.Logger; 
import org.apache.log4j.PropertyConfigurator; 
public class Validator
{
	public boolean upValidator(String username,String password)
	{
	 System.out.println("username is : "+username+" Password is:"+password);
 		Properties prop = new Properties();
		FileInputStream input=null; 
		Logger logger = Logger.getLogger(Validator.class);
		PropertyConfigurator.configure("C:\\javaprograms\\git init\\FOCP II\\major\\config\\logger\\logger.properties");
		try    
		{
			input = new FileInputStream("C:\\javaprograms\\git init\\FOCP II\\major\\config\\constants\\exceptions.properties");
			prop.load(input); 
            usernameLength(username);
            space(username);
            emptyUsername(username);
            emptyPassword(password);
			passwordLength(password);
			number(password);
			specialCharacter(password);
			return true;
	    }
	    catch(UsernameLengthException e)
	    {
	    logger.error("\n \n"+e+prop.getProperty("userLengthMessage")+"\n");
	    return false;
	    }
	    catch(SpaceException e)
	    {
	    logger.error("\n \n"+e+prop.getProperty("spaceMessage")+"\n");
	    return false;
	    }
	    catch(EmptyUsernameException e)
	    {
	    logger.error("\n \n"+e+prop.getProperty("emptyNameMessage")+"\n");
	    return false;
	    }
	    catch(EmptyPasswordException e)
	    {
	    logger.error("\n \n"+e+prop.getProperty("emptyPassMessage")+"\n");
	    return false;
	    }
	    catch(PasswordLengthException e)
	    {
	    logger.error("\n \n"+e+prop.getProperty("passLengthMessage")+"\n");
	    return false;
	    }
	    catch (NumberException e)
	    {
	    logger.error("\n \n"+e+prop.getProperty("numberMessage")+"\n");
	    return false;
	    }
	    catch(SpecialCharacterException e)
	    {
	    logger.error("\n \n"+e+prop.getProperty("specialMessage")+"\n");
	    return false;
	    }
	    catch(Exception e)
	    {
	    logger.error("\n \n"+e+"\n");
	    return false;
	    }
	    finally
	    {
	    System.out.println("Done!");
	    }
	}
	void emptyUsername(String username)throws EmptyUsernameException
	{
		if (username=="")
		{
			throw new EmptyUsernameException(" ");
		}
	}
	void passwordLength(String password)throws PasswordLengthException 
	{
     if(password.length()<8||password.length()>20)
     {
     throw new PasswordLengthException(" ");
     }
	}
	void usernameLength(String username)throws UsernameLengthException
	{
	if(username.length()<8||username.length()>20)
	throw new UsernameLengthException(" ");
	}
    void space(String username)throws SpaceException
    {
    boolean finalValue=Pattern.matches(".*[ ].*",username);
    if(finalValue==true)
    throw new SpaceException(" ");
    }
    void emptyPassword(String password)throws EmptyPasswordException
	{
		if (password=="")
		{
			throw new EmptyPasswordException(" ");
		}
	}
    void number(String password)throws NumberException
	{
	     boolean finalValue=Pattern.matches(".*[0123456789].*",password);
         if(finalValue==false)
         {
             throw new NumberException("Number Exception");
         }
	}
	void specialCharacter(String password) throws SpecialCharacterException
	{
	
		boolean finalValue=Pattern.matches(".*[@#$%^&(,)_].*",password);
		if (finalValue == false)
		{
			throw new SpecialCharacterException("Special Character Exception");
		}
	}
}