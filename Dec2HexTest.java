import java.io.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Dec2HexTest{

	public Dec2HexTest(){
	}

	private String captureOutput(String[] args){
	   //create a stream to capture the printed output
	   ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	   //save the original System.out to restore
	   PrintStream originalOut = System.out;

	   //redirect System.out to the custom output stream
	   System.setOut(new PrintStream(outContent));

	   try {
		//call the main method of Dec2Hex with provided arguments
		Dec2Hex.main(args);
	   } finally {
		//restore the original System.out after saving the output
		System.setOut(originalOut);
	   }

	   //return the captured output
	   return outContent.toString().trim();
	}


	//test case checks for a valid decimal to hexadecimal conversion
	@Test
	public void testValidDecimalToHex(){
	   String output = captureOutput(new String[]{"11"});
	   String expectedOutput = "Converting the Decimal Value 11 to Hex...\nHexadecimal representation is: B";
	   assertEquals(expectedOutput, output);
	}

	//test case checks for a non integer argument
	@Test
	public void testNonIntegerArgument(){
	   String output = captureOutput(new String[]{"B"});
	   String expectedOutput = "Error: Failed to convert non-integer input";
	   assertEquals(expectedOutput, output);
	}
}
