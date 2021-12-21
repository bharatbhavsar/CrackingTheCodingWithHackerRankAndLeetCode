package com.hackerRank;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TimeConversion {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String time = sc.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ssa", Locale.getDefault());
        SimpleDateFormat writeFormat = new SimpleDateFormat("HH:mm:ss");
        sc.close();
        Date date = null;
        try{
            date = format.parse(time);
            System.out.println(writeFormat.format(date));
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
