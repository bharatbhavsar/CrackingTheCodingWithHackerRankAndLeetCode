/*
 * HackerRank problem:
 * 
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
 */

package com.hackerRank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class ActivityNotification {
	
	/*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int activityNotifications(List<Integer> expenditure, int d) {
    // Write your code here
        int res = 0;
        int[] medianArray = new int[201];
        for(int i = 0; i < d; i++){
            medianArray[expenditure.get(i)]++;
        }
        for(int i = d; i < expenditure.size(); i++){
            double median = getMedian(medianArray, d);
            
            if(expenditure.get(i) >= (median*2)){
                res++;
            }
            medianArray[expenditure.get(i)]++;
            medianArray[expenditure.get(i-d)]--;
        }
        
        return res;

    }
    
    public static double getMedian(int[] medianArray, int d){
        double median = 0;
        if(d%2 == 0){
            Integer m1 = null;
            Integer m2 = null;
            int count = 0;
            for(int i = 0; i < medianArray.length; i++){
                count += medianArray[i];
                if(m1 == null && count >= d/2){
                    m1 = i;
                }
                if(m2 == null && count >= d/2 +1){
                    m2 = i;
                    break;
                }
            }
            median = (m1 + m2) / 2.0;
        }else{
            int count = 0;
            for(int i = 0; i < medianArray.length; i++){
                count += medianArray[i];
                if(count > d/2){
                    median = i;
                    break;   
                }
            }
        }
        return median;
    }

	
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = ActivityNotification.activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
