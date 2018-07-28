import java.util.*;

public class test {


    public static void main(String[] args) {
      List<Integer> res = new ArrayList<>();
      res.add(1);
      res.add(2);
      res.add(3);
      res.add(4);

      Object[] res2 = new Object[res.size()];
      res2 = res.toArray();

      System.out.println(res2[2]);
    }
  }
