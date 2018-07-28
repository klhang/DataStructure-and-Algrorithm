```java

import java.io.*;
import java.util.*;

class Solution {
  static String[][] wordCountEngine(String document) {
    List<String[]> res = new ArrayList<>();
    //doc to lower and regular expression to remove all non-alphabet charaters
    document = document.toLowerCase();
    document = document.replaceAll("[^a-z ]", "");
    //build map to do count
    HashMap<String, Integer> map = new HashMap<>();
    for (String str: document.split(" ")){
      map.put(str, map.getOrDefault(str, 0) + 1);
    }
    //conver map to List<String[]>
    for (String str: map.keySet()){
      String[] arr = new String[2];
      arr[0] = str;
      arr[1] = String.valueOf(map.get(str));
      res.add(arr);
    }
    //convert list to Array and sort

    String[][] finalres = new String[res.size()][];
    finalres = res.toArray();

    Arrays.sort(finalres, new Comparator<String[]>(){
      public int compare(String[] arr1, String[] arr2){
        if (Integer.valueOf(arr2[1]) == Integer.valueOf(arr1[1])){
          return arr2[0].length() - arr1[0].length();
        } else {
          return Integer.valueOf(arr2[1]) - Integer.valueOf(arr1[1]);
        }
      }
    });

    return finalres;
  }
}
```
