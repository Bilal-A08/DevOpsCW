class Dec2Hex
{
    public static void main(String[] args)    {
	//bilal's comment - made arg1 non static since it's only being used here
	int arg1;

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
	int rem;
	int num;
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
