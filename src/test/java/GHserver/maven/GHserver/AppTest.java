package GHserver.maven.GHserver;

import daoImpl.userImpl;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import modal.user;
import oracle.jdbc.driver.OracleDriver;

/**
 * Unit test for simple App.
 */

public class AppTest {
	public void ver(){
		userImpl i=new userImpl();
		i.adduser(new user("123","zsh",1234,1));
	}

	
  
}
