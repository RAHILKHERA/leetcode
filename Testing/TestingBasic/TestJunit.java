package Testing.TestingBasic;

import org.junit.Test;
import org.junit.Before;

import junit.framework.TestCase;

public class TestJunit extends TestCase {
	
   String message = "Hello World";	
   MessageUtil messageUtil = new MessageUtil(message);
   protected double fValue1;
   protected double fValue2;


   @Before 
   public void setUp() {
      fValue1 = 2.0;
      fValue2 = 3.0;
   }

   @Test
   public void testPrintMessage() {
        System.out.println("Testing print message");
      message = "Hello World";
      assertEquals(message,messageUtil.printMessage());
   }

   @Test
   public void testAdd() {

    System.out.println("Testing Add");
      //test data
      int num = 5;
      String temp = null;
      String str = "Junit is working fine";

      //check for equality
      assertEquals("Junit is working fine", str);
      
      //check for false condition
      assertFalse(num > 6);

      //check for not null value
      assertNull(temp);
   }

   @Test
   public void testFeatures() {

      System.out.println("Testing features");
     //count the number of test cases
     System.out.println("No of Test Case = "+ this.countTestCases());
		
     //test getName 
     String name = this.getName();
     System.out.println("Test Case Name = "+ name);

     //test setName
     this.setName("testNewAdd");
     String newName = this.getName();
     System.out.println("Updated Test Case Name = "+ newName);
   }

   public void tearDown(  ) {
}

}