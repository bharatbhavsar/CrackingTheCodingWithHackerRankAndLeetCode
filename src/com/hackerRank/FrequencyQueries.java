package com.hackerRank;

import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<int[]> queries) {
        // List<Integer> res = new ArrayList<Integer>();
        // Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        // Map<Integer, Integer> myFreq = new HashMap<Integer, Integer>();
        // for(int[] q: queries){
        //     if(q[0] == 1){
        //         myMap.put(q[1], myMap.getOrDefault(q[1], 0) + 1);
        //         myFreq.put(myMap.get(q[1]), myFreq.getOrDefault(myMap.get(q[1]), 0) + 1);
        //         if(myFreq.containsKey(myMap.get(q[1]) - 1)){
        //             myFreq.put(myMap.get(q[1]) - 1, myFreq.get(myMap.get(q[1]) - 1) - 1);
        //             if(myFreq.get(myMap.get(q[1]) - 1) == 0){
        //                 myFreq.remove(myMap.get(q[1]) - 1);
        //             }
        //         }
        //     }
        //     if(q[0] == 2){
        //         if(myMap.containsKey(q[1])){
        //             int oldFreq = myMap.get(q[1]);
        //             myMap.put(q[1], oldFreq - 1);
        //             if(myMap.get(q[1]) == 0){
        //                 myMap.remove(q[1]);
        //             }
        //             myFreq.put(oldFreq, myFreq.get(oldFreq) - 1);
        //             if(myFreq.get(oldFreq) == 0){
        //                 myFreq.remove(oldFreq);
        //             }
        //             if(myFreq.containsKey(oldFreq - 1)){
        //                 myFreq.put(oldFreq - 1, myFreq.get(oldFreq - 1) + 1);
        //             }
        //         }
        //     }
        //     if(q[0] == 3){
        //         if(myFreq.containsKey(q[1])){
        //             res.add(1);
        //         }else{
        //             res.add(0);
        //         }
        //     }
        // }
        // return res;
        final Map<Integer, Integer> valueToFreq = new HashMap<>();
        final Map<Integer, Integer> freqToOccurrence = new HashMap<>();
        final List<Integer> frequencies = new ArrayList<>();

        int key;
        int value;
        Integer oldFreq;
        Integer newFreq;
        Integer oldOccurrence;
        Integer newOccurrence;
        for (int[] query : queries) {
            key = query[0];
            value = query[1];
            if (key == 3) {
                frequencies.add(freqToOccurrence.get(value) == null ? 0 : 1);
            } else {
                oldFreq = valueToFreq.get(value);
                oldFreq = oldFreq == null ? 0 : oldFreq;
                oldOccurrence = freqToOccurrence.get(oldFreq);
                oldOccurrence = oldOccurrence == null ? 0 : oldOccurrence;

                if (key == 1) {
                    newFreq = oldFreq + 1;
                } else {
                    newFreq = oldFreq - 1;
                }
                newOccurrence = freqToOccurrence.get(newFreq);
                newOccurrence = newOccurrence == null ? 0 : newOccurrence;

                if (newFreq < 1) {
                    valueToFreq.remove(value);
                } else {
                    valueToFreq.put(value, newFreq);
                }

                if ((oldOccurrence - 1) < 1) {
                    freqToOccurrence.remove(oldFreq);
                } else {
                    freqToOccurrence.put(oldFreq, oldOccurrence - 1);
                }
                freqToOccurrence.put(newFreq, newOccurrence + 1);
            }
        }
        return frequencies;
        
    }

    public static void main(String[] args) throws IOException {
    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
      int q = Integer.parseInt(bufferedReader.readLine().trim());
      List<int[]> queries = new ArrayList<>(q);
      Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
      for (int i = 0; i < q; i++) {
        int[] query = new int[2];
        Matcher m = p.matcher(bufferedReader.readLine());
        if (m.matches()) {
          query[0] = Integer.parseInt(m.group(1));
          query[1] = Integer.parseInt(m.group(2));
          queries.add(query);
        }
      }
      List<Integer> ans = freqQuery(queries);
      try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");
      }
    }
  }
}

