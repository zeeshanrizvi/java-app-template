package echo;

import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.Before;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class snmpTests {
   private String trigger;
   private String trap;
   
   // Each parameter should be placed as an argument here
   // Every time runner triggers, it will pass the arguments
   // from parameters we defined in primeNumbers() method
	
   public snmpTests(String trigger, String trap) {
      this.trigger = trigger;
      this.trap = trap;
   }

   @Parameterized.Parameters
   public static Collection snmptriggers() {
      return Arrays.asList(new Object[][] {
         { "trigger1", "trap1" },
         { "trigger2", "trap2" },
         { "trigger3", "trap3" },
      });
   }

   // This test will run 4 times since we have 5 parameters defined
   @Test
   public void testSnmpTraps() {
      System.out.println("Recieved " + trap + " for " + trigger );
   }
}