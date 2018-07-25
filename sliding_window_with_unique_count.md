## LeetCode

### Description
Smallest Substring of All Characters
Given an array of unique characters arr and a string str, Implement a function getShortestUniqueSubstring that finds the smallest substring of str containing all the characters in arr. Return "" (empty string) if such a substring doesn’t exist.

Come up with an asymptotically optimal solution and analyze the time and space complexities.

Example:

input:  arr = ['x','y','z'], str = "xyyzyzyx"

output: "zyx"

### Thought


### Solution
```java
class Solution {

  static String getShortestUniqueSubstring(char[] arr, String str) {
    // your code goes here
    // two pointers: p1, p2
    // hashmap for count of characters
    // maintain a unique count, if == arr.length, move back pointer, else move front pointer
    HashMap<Character, Integer> map = new HashMap<>();

    String res = "";
    int p1 = 0;
    int unique = 0;

    for (int i = 0; i < arr.length; i++){
      map.put(arr[i], 0);
    }

    for (int i = 0; i < str.length(); i ++){
      char letter = str.charAt(i);
      if (map.containsKey(letter)){
        int temp = map.get(letter);
        map.put(letter, temp + 1);

        if (map.get(letter) == 1){
          unique ++;
        }
      }

      while (unique == arr.length){
        //update res

        String subres = str.substring(p1, i + 1);
        if (res.length() == 0 || res.length() > subres.length()){
          res = subres;
        }

        //move p1
        //update count in map
        //update unique if is key of map
        p1++;
        char letter2 = str.charAt(p1 - 1);

        if (map.containsKey(letter2)){
          int temp = map.get(letter2);
          map.put(letter2, temp-1);
          if (map.get(letter2) == 0){
            unique--;
          }
        }

      }
    }
    return res;
  }
```

### Takeaways
* sliding window + hashmap for count, use unique -> can be linear time
