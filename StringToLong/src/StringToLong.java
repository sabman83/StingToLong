public class StringToLong {
    
    private static long pow(long base, long exp)
    {
        long result = 1;
        
        while(exp > 0)
        {
            if( (exp & 1) == 1)
            {
                result = result*base;
            }
            exp = exp>>1;
            
            base =  base* base;
        }
        
        return result;
    }
    
    private static long stringToLong(String input)
    {
        long result = 0;
        
        char[] inputArray = input.toCharArray();
        
        int n = inputArray.length;
        
        int minIndex = 0;
        boolean isNegative = false;
        if(inputArray[0] == '-')
        {
            isNegative = true;
            minIndex = 1;
        }
        
        for(int i = n-1; i >=minIndex ; i--)
        {
            result = result + pow(10,n-i-1) * Character.getNumericValue(inputArray[i]);
        }
        
        if(isNegative)
            result = -1 * result;
        return result;
    }
    
	public static void main( String[] args)
	{
		long result = stringToLong("4356745674567657235");
		
		long temp = Long.parseLong("4356745674567657235");
		
		if(result == temp)
		{
		    System.out.println(true);
		}
		else
		{
		    System.out.println(false);
		}
	}
}
