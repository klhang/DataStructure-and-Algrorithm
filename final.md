```java

1.
// given an integer array, find the most k largest elements in it. duplicates numbers will be counted once.
// 	eg.  [1, 0, 19, 7, 7, 8]  k = 3  →     19, 8, 7
// 	eg. [8, 7, 6, 9, 8, 3, 4, 1]  k = 2  → 9, 8
// 	eg. [8 7 4 9 1 8]   k = 3   --->  9 8 7
public int[] getTopk(int[] nums, int k){
  //set + priority queue
  Set<Integer> set = new HashSet<Integer>();
  PriorityQuee<Integer> pq  = new PriorityQuee<>();

  for (int num: nums){
    if (!set.contains(num)){
      set.add(num);
    }

    pq.offer(num);
    if (pq.size() > k){
      pq.poll();
    }
  }

  int[] res = new int[k];
  int idx = 0;
  while (!pq.isEmpty()){
    res[idx] = pq.poll();
    idx ++;
  }

  return res;
}




2.
//given a 2D (N*M) integer array, find the first column that contains 1. Notice that for each row, if [i, j] = 1 then every element afterwards in the same row will be 1. like [i, j+ 1] [i, j + 2], [i, j + 3]...
// Need to solve this in O(N + M)
// eg.
// [[0 0 0 1 1 1]
//  [0 0 1 1 1 1]
//  [0 0 0 0 0 1]]
// The first column that contains 1 is 3rd column. return 3
//
// [[0 0 1 1]
//  [1 1 1 1]
//  [0 0 0 1]]
//
// The first column that contains 1 will be 1st column.  return 1

public int getFirstColumnContainsOne(int[][] nums){
  //b-search for n times : O nlogm
  int min = nums[0].length;
  for (int[] arr : nums){
    min = Math.min(bs(arr));
  }

  return min;
}

public int bs(int[] nums){
  int start = 0;
  int end = nums.length - 1;

  while (start < end){
    int mid = ((end - start) + start) / 2;
    if (nums[mid] == 0){
      start = mid + 1;
    } else {
      end = mid;
    }
  }

  return start;
}




3.
//given an unsorted array, traverse all subsets. And calculate the amount of “perfect subset”. Assume there is no duplicate in the array.
// “perfect subset” means the largest number in it equals to the sum of other numbers .
// [2 3 1 6] --  >  2 + 3 + 1 = 6  This is perfect
// [3 1 4] ---> 3  + 1 = 4   This is perfect.
// [1 2]   → 1 != 2 This is not perfect.
//
// eg. intput: [ 2 7 1 3 5]
// perfet subsets will be [1, 2, 3], [2, 3, 5], [2, 5, 7]  so the return value will be 3.

public int getPerfectCount(int[] nums){
  //brute force - nested for loop O n^2 * (n-2) = n^3
  //sorted, [1,  2,       3,             7,             5]
          // 1   2,3    3/4/5/6,   7/8/9/10/10/11/12/13
  //O n^2
  Arrays.sort(nums);
  Set<Integer> set = new HashSet<>();
  for (int num: nums){
    set.add(num);
  }

  int res = 0;
  HashMap<Integer, > map = new HashMap<>();

  for (int i = 0; i < nums.length; i++){
    for (int j = 0; j <= i; j++){
      for (int num: map.get(nums[j])){
        int sum = nums[i] + num;
        map.put(nums[i]).add(sum);
        if (set.contains(sum)){
          res ++;
        }
      }
    }
  }
  return res;
}




4.
// Imagine you have a special keyboard with the following keys:
// Key 1: (A): Print one 'A' on screen.
// Key 2: (Ctrl-A): Select the whole screen.
// Key 3: (Ctrl-C): Copy selection to buffer.
// Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.
// Now, you can only press the keyboard for N times (with the above four keys), find out the maximum numbers of 'A' you can print on screen.
// Example_1 :
// Input: N = 3
// Output: 3
// Explanation:
// We can at most get 3 A's on screen by pressing following key sequence:
// A, A, A
// Example_2 :
// Input: N = 7
// Output: 9
// Explanation:
// We can at most get 9 A's on screen by pressing following key sequence:
//   A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
//   A, A,Ctrl A, Ctrl C, Ctrl V, Ctrl V,Ctrl V

public int maxA(int N) {
  //2 + 2*(7-2-2) = 10
  //3 + 3*(7-2-3) = 9
  // x  + x*(n-2-x)

  int max = 0;
  for (int i = 0; i < n; i++){
    max = Math.max(i + i * (n-2-i));
  }
  return max;
}




5.
// Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.
// Left boundary is defined as the collection of nodes, each of which is the leftmost node of the same level(depth) in the binary tree. Right boundary is defined as the collection of nodes, each of which is the rightmost node of the same level(depth) in the binary tree
// Example_1:
// ____1_____
//    /          \
//   2            3
//    \          /
//     5        6
//    / \      / \
//   7   8    9  10
//
// Ouput:
// [1,2,5,7,8,9,10,6,3]
//
// Explanation:
// The left boundary are node 1,2,5,7.
// The leaves are node 7,8,9,10.
// The right boundary are node 1,3,6,10..
// So order them in anti-clockwise without duplicate nodes we have [1,2,5,7,8,9,10,6,3].
//
// Example_2 :
// Input:
//   1
//    \
//     2
//    / \
//   3   4
//
// Ouput:
// [1, 2, 3, 4]
// Example_1:
// Explanation:
// The left boundary are node 1,2,3.
// The leaves are node 3 and 4.
// The right boundary are node 1,2,4.
// Note the anti-clockwise direction means you should output reversed right boundary.
// So order them in anti-clockwise without duplicates and we have [1,2,3,4].

public List<Integer> boundaryOfBinaryTree(TreeNode root) {
  //1. pushallleft in stack, pop
  //2. level order traversal, last level
  //3. pushallright in stack, pop
  List<Integer> res = new ArrayList<>();
  Set<Integer> set = new HashSet<>();

  Deque<TreeNode> deque = new ArrayDeque<>();
  //1.get all left nodes
  pushLeftNodes(deque, root);
  while(!deque.isEmpty()){
    TreeNode curr = deque.removeFirst();
    set.add(curr.val);
    res.add(0, curr.val);
  }

  //2.level-order traversal to get bottom nodes, only need last level
  Queue<TreeNode> queue = new LinkedList<>();
  List<Integer> levelRes = new ArrayList<>();

  queue.add(root);
  while (!queue.isEmpty()){
    int size = queue.size();

    for (int i = 0; i <= size; i++){
      TreeNode curr = queue.poll();
      levelRes.add(curr.val);

      if (curr.left != null){
        queue.offer(curr.left);
        levelRes = new ArrayList<>();
      }
      if (curr.right != null){
        queue.offer(curr.right);
        levelRes = new ArrayList<>();
      }
    }
  }
  //add to res List
  for (int i = 0; i < levelRes.size(); i++){
    res.add(levelRes.get(i));
  }

  //3.get all right nodes; when pushing right node, check with set to skip
  pushRightNodes(deque, root);
  while(!deque.isEmpty()){
    TreeNode curr = deque.removeFirst();
    if (set.contains(curr.val)){
      continue;
    } else {
      res.add(curr.val);
    }
  }

  return res;
}

//helper function
private pushLeftNodes(Deque<Integer> deque, TreeNode root){
  while (root != null){
    deque.addLast(root);
    root = root.left;
  }
}

//helper function
private pushRightNodes(Deque<Integer> deque, TreeNode root){
  while (root != null){
    deque.addLast(root);
    root = root.right;
  }
}

```
