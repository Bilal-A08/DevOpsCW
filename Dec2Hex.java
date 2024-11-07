import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Level;
import java.util.logging.Logger;

class Dec2Hex
{
    public static int arg1;
	
    private static final Logger logger = Logger.getLogger(Dec2Hex.class.getName());

    public static void bilalEnablePlainLogging(Logger logger) {
 	 // Remove all existing handlers
	for (Handler handler : logger.getHandlers()) {
		logger.removeHandler(handler);
	}

	  // Add a custom ConsoleHandler with a simple Formatter
	  ConsoleHandler plainHandler = new ConsoleHandler();
	  plainHandler.setLevel(Level.ALL); // Log all levels
	  plainHandler.setFormatter(new Formatter() {
	    @Override
	    public String format(LogRecord record) {
	      return record.getMessage() + System.lineSeparator(); // Only print message
	    }
	  });

	  logger.addHandler(plainHandler);
	  logger.setUseParentHandlers(
	      false); // Prevent duplicate output from parent loggers
	}

    public static void main(String[] args)    {
	//bilalEnablePlainLogging(logger);

	//bilal's comment - check for missing input
	if(args.length == 0){
	   System.out.println("Error: No input provided. Please provide a valid number");
	   return;
	}

	//bilal's comment - validate that the input is an integer
	try{
	   arg1 = Integer.parseInt(args[0]);
	} catch(NumberFormatException e){
	   System.out.println("Error: Failed to convert non-integer input");
	   return;
	}

	char[] ch={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	int rem, num;
        num = arg1;
        String hexadecimal="";
        System.out.println("Converting the Decimal Value " + num + " to Hex...");


        while(num != 0)
        {
            rem=num%16;
            hexadecimal= ch[rem] + hexadecimal;
            num= num/16;
        }

        System.out.println("Hexadecimal representation is: " + hexadecimal);
    }
}
