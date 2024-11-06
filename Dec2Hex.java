import java.util.logging.Level;
import java.util.logging.Logger;

class Dec2Hex
{
    public static int arg1;
	
    private static final Logger logger = Logger.getLogger(Dec2Hex.class.getName());

    public static void main(String[] args)    {
	//bilal's comment - check for missing input
	if(args.length == 0){
	   logger.log(Level.INFO, "Error: No input provided. Please provide a valid number");
	   return;
	}

	//bilal's comment - validate that the input is an integer
	try{
	   arg1 = Integer.parseInt(args[0]);
	} catch(NumberFormatException e){
	   logger.log(Level.INFO, "Error: Failed to convert non-integer input");
	   return;
	}

	char[] ch={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	int rem, num;
        num = arg1;
        String hexadecimal="";
        logger.log(Level.INFO, "Converting the Decimal Value " + num + " to Hex...");


        while(num != 0)
        {
            rem=num%16;
            hexadecimal= ch[rem] + hexadecimal;
            num= num/16;
        }

        logger.log(Level.INFO, "Hexadecimal representation is: " + hexadecimal);
    }
}
