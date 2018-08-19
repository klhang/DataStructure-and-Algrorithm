```java

! all about map
clear()
Removes all of the mappings from this map (optional operation).

containsKey(Object key)
Returns true if this map contains a mapping for the specified key.

containsValue(Object value)
Returns true if this map maps one or more keys to the specified value.

entrySet()
Returns a Set view of the mappings contained in this map.

equals(Object o)
Compares the specified object with this map for equality.

get(Object key)
Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.

hashCode()
Returns the hash code value for this map.

isEmpty()
Returns true if this map contains no key-value mappings.

Set<K>	keySet()
Returns a Set view of the keys contained in this map.

put(K key, V value)
Associates the specified value with the specified key in this map (optional operation).

putAll(Map<? extends K,? extends V> m)
Copies all of the mappings from the specified map to this map (optional operation).

remove(Object key)
Removes the mapping for a key from this map if it is present (optional operation).

size()
Returns the number of key-value mappings in this map.

values()
Returns a Collection view of the values contained in this map.
/////////////////

! total += Integer.parseInt(s);

! Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

! sum path problems -> String ,Integer, Boolean pass by value, List<Integer> path pass by reference, so need to backtracking by path.remove(path.size() -1);  

! dfs + backtracking 模板

!Set<Integer> skp = new HashSet<>(Arrays.asList(1,2,2,3,4,6));
!map of <Integer, List> or map of <Integer, Set>    ->>> Map.get(0).add(1);   map of <Integer, Integer> ->>> map.put(0, map.get(0) + 1);

! lc403 map of list, map of set, 优先用set，可以去重，可以iterate，add，size， contains, remove

! lc384 Random rand = new Random(); int pos = rand.nextInt(arr.length - i) + i;

! String.valueOf(int)
! String.toLowerCase()
! String.replaceAll("[^a-z ]", "");
! map.put(str, map.getOrDefault(str, 0) + 1);
! list.toArray(); -> Object[]
! Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
! Arrays.sort(arr, new Comparetor<int[]>(){
    public int compare(int[] a, int[] b){
      if (a[0] == b[0]){
        return a[1] - b[1];
      } else {
        return a[0] - b[0];
      }
    }
  })

  Arrays.sort(arr, new BothElComparator());
  Class BothElComparator implements Comparator<int[]>{
    @override
    public int compare(int[] a, int[] b){
      if (a[0] == b[0]){
        return b[1] - a[1];
      } else {
        return a[0] - b[0];
      }
    }
  }


! Tree prblems
- 1. top-dwon (4 order recursive & iterative) + 往下传参（参数不断更新，+node.val, +1， min-max), 经典题validate-bst, print-pathsum
- 1.5. 如果是自上而下，做的事情要放在两次递归调用之前。而且递归函数往往是void，不需要返回值。
- 2. bottom - up : 往上传参; code里先求 l & r, 向上传 maxOrmin(l,r)
- 3. combination : 先top down， 再bottom up
- 4. back tracking（for primitive type, pass by value-vs-reference

- topDown vs bottomUp
-a. 掌握好buttom-up的常⻅模版，“先递归再做事”:
    public int buttomUp(TreeNode root) {
      if (root == null) return 0; // stop here
      // first calculate left and right by recursion
      int left = buttomUp(root.left);
      int right = buttomUp(root.right);
      // do something after the recursion
    }
-b. 与之对比是top-down的常⻅模版，“先做事再递归”:
  // Type1: intermediate result
  // Type2: the final result (or result set)
    public void topDown(TreeNode root, Type1 item, Type2 res) {
      if (root == null) return; // stop here
      // do something first
      if (root.left == null && root.right == null) {
        doSomething(item, root.val);
      }
      // then do recursion for left and right
      topDown(root.left, item, res);
      topDown(root.right, item, res);






! Preacessor and successor of bst
- while loop 左右，保留res，发现新的reset res
- while loop 本身就是 recursive call，不要在while loop里再 call

！Diameter of bt
- bottom up to return depth
- maintain a global max

！ 字符串常见操作：
- trim();
- split(“,”)
- joint(“,” , stack)
the Character.toString(char ) method of the Character class.
the String.valueOf(char ) method of the String Class.



!All about Heap
- build a min || max heap of unsorted arr.
1. find idx of the last internal node: idx = A.length/2 -2
2. perform heapify back backwards, starting from idx:  while (idx > 0), heapify(i)
3. heapify(idx):  get L and R from idx, smallest = L or R; swap arr[idx] and arr[smallest], recursively heapify(smallest)
4. time:o(n) ; space:o(1)

- heap sort (max-heap to sort inorderly, min-heap to sort reversely)
1. build heap with heapifyHelper()
2. for (i = n -1) {swap (root, last), and heapify(arr, i, 0)
3. time: O(nlogn), space:O(1)
```
