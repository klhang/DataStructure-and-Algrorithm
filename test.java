import java.util.*;

public class test {
    public static void main(String[] args) {
      int[] test = new int[]{1,2,3};

      System.out.println(IntStream.of(test).max());
    }
  }
