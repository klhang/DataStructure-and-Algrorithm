```java
Given an array arr of unique nonnegative integers, implement a function getDifferentNumber that finds the smallest nonnegative integer that is NOT in the array.

Even if your programming language of choice doesn’t have that restriction (like Python), assume that the maximum value an integer can have is MAX_INT = 2^31-1. So, for instance, the operation MAX_INT + 1 would be undefined in our case.

Your algorithm should be efficient, both from a time and a space complexity perspectives.

Solve first for the case when you’re NOT allowed to modify the input arr. If successful and still have time, see if you can come up with an algorithm with an improved space complexity when modifying arr is allowed. Do so without trading off the time complexity.

Analyze the time and space complexities of your algorithm.

Example:

input:  arr = [0, 1, 2, 3]

output: 4


class Solution I {
  static int getDifferentNumber(int[] arr) {
    // iterate and mark element of arr[arr[i]] to -, if arr[i] is in range
    // edge case is when the element of index == 0, then save the special num

    // after reseting the arr, do another for loop, check (arr[i] == -int), (arr[i] == 0) -> check special num to see (i = num), otherwise return i; return arr + 1;
    int special = -1;

    for (int i = 0; i < arr.length; i++){
      int idx = Math.abs(arr[i]);
      if (idx < arr.length){
        if (arr[idx] == 0){
          special = idx;
        } else {
          arr[idx] *= -1;
        }
      }
    }

    for (int i =0; i < arr.length; i++){
      if (arr[i] == 0){
        if (i != special){
          return i;
        }
      } else if (arr[i] == Math.abs(arr[i])){
        return i;
      }
    }

    return arr.length;
  }
}

function getDifferentNumber(arr):
    n = arr.length
    temp = 0

    # put each number in its corresponding index, kicking out
    # the original number, until the target index is out of range.
    for i from 0 to n-1:
        temp = arr[i]
        while (temp < n AND arr[temp] != temp):
            swap(temp, arr[temp])

    for i from 0 to n - 1:
        if (arr[i] != i):
            return i  # i isn’t in arr, hence we can return it

    # we got here since every number from 0 to n-1 is in arr.
    # By definition then, n isn’t in arr. Otherwise, the size of arr
    # would have been n+1 and not n.
    return n
Time Complexity: at first glance, one might think that due to the two nested loops (a while loop inside a for loop) that we use to sort the array, the time complexity is O(N^2). However, this is incorrect. The actual time complexity of the two nested loops is linear. The reason is that every number is at most moved once. For those already in their target indices, the while loop will end immediately since the condition arr[temp] != temp isn’t met. In the second part of the code we have another loop whose time complexity is linear. The total time complexity is therefore O(N).

```


### Takeaways
1. 跟找duplucate 一样， 占坑法（mark）， 归位法（swap回原来位置）， set去重法，本质就是第二次for loop 找第一 arr[i] != i 。
