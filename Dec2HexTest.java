import java.io.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Dec2HexTest{

	public Dec2HexTest(){
	}

	private String captureOutput(String[] args){
	   ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	   PrintStream originalOut = System.out;
	   System.setOut(new PrintStream(outContent));

	   try {
		Dec2Hex.main(args);
	   } finally {
		System.setOut(originalOut);
	   }

	   return outContent.toString().trim();
	}


	@Test
	public void testValidDecimalToHex(){
	   String output = captureOutput(new String[]{"11"});
	   String expectedOutput = "Converting the Decimal Value 11 to Hex...\nHexadecimal representation is: B";
	   assertEquals(expectedOutput, output);
	}

	@Test
	public void testNonIntegerArgument(){
	   String output = captureOutput(new String[]{"B"});
	   String expectedOutput = "Error: Failed to convert non-integer input";
	   assertEquals(expectedOutput, output);
	}
}
