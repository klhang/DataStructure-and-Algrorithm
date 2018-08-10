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
```

! Tree prblems
- 1. top-dwon (4 order recursive & iterative) + 往下传参（参数不断更新，+node.val, +1， min-max), 经典题validate-bst, print-pathsum
- 2. bottom - up : 往上传参; code里先求 l & r, 向上传 maxOrmin(l,r)
- 3. combination : 先top down， 再bottom up
- 4. back tracking（for primitive type, pass by value-vs-reference

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
