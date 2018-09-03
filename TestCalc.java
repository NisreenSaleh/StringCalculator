import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCalc {

	public static void main(String[] args) {
		System.out.println("Test: "+Add(""));
		System.out.println("Test1: "+Add("2"));
		System.out.println("Test2: "+Add("1,2"));
		System.out.println("Test3: "+Add("1,2,3"));
		System.out.println("Test4: "+Add("1\\n2,3"));
		System.out.println("Test5: "+Add("//;\\n1;2"));
		//System.out.println("Test6: "+Add("1,-2,-3"));
		//System.out.println("Test7: "+ Add("1,1001"));	
		//System.out.println("Test8: "Add("//[;]\\n1;2**;-3"));
	}
	public static int Add(String number) {
		if(number.equals("")) {return 0;}
		int sum=0;
		int dilimeterStart=number.indexOf('[');
		int dilimeterEnd = number.indexOf(']');
		String str[];
		String delimeter;

		String modifiedStr = number.replaceAll("[^\\d-]","");	 
		if(dilimeterEnd == dilimeterStart) {
			str = modifiedStr.split("");		
		}
		else {
			delimeter=number.substring(dilimeterStart, dilimeterEnd);
			String pattern=String.format("[^\\d-%s]", delimeter);
			Pattern r= Pattern.compile(pattern);
			Matcher m= r.matcher(number);
			if(m.find()) {
				m.group();
				}
			str = modifiedStr.split(delimeter);	
			
			}
		for(String s:str) {	
			sum=sum+ Integer.parseInt(s);	
		}
		return sum;
	}
}
