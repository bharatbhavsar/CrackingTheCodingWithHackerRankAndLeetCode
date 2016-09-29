import java.awt.geom.Line2D;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Temp {

	public static void main(String[] args){

		sample s = new sample(10);
		change(s);
		System.out.println(s.value);
		
		
	}
	
	static void change(sample s){
		s.value+=2;
	}
	
	
}
class sample{
	int value;
	public sample(int value){
		this.value=value;
	}
}