```java
import java.util.Arrays;

// Data structure for Min Heap
class ConvertHeap
{
    // return left child of A[i]
    private static int LEFT(int i) {
        return (2 * i + 1);
    }

    // return right child of A[i]
    private static int RIGHT(int i) {
        return (2 * i + 2);
    }

    // Utility function to swap two indices in the array
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // Recursive Heapify-down algorithm. The node at index i and
    // its two direct children violates the heap property
    private static void Heapify(int[] A, int i, int size)
    {
        // get left and right child of node at index i
        int left = LEFT(i);
        int right = RIGHT(i);

        int smallest = i;

        // compare A[i] with its left and right child
        // and find smallest value
        if (left < size && A[left] < A[i]) {
            smallest = left;
        }

        if (right < size && A[right] < A[smallest]) {
            smallest = right;
        }

        // swap with child having lesser value and
        // call heapify-down on the child
        if (smallest != i) {
            swap(A, i, smallest);
            Heapify(A, smallest, size);
        }
    }

    // Constructor (Build-Heap)
    public static void Convert(int[] A)
    {
        // call heapify starting from last internal node all the
        // way upto the root node
        int i = (A.length - 2) / 2;
        while (i >= 0) {
            Heapify(A, i--, A.length);
        }
    }


    public static void main(String[] args)
    {

    /*
               9

          4         7

        1   -2   6      5

    */
        // array representing max heap
        int[] A = { 9, 4, 7, 1, -2, 6, 5 };

        // build a min heap by initializing it by given array
        Convert(A);

        // print the Min Heap
    /*
               -2

           1         5

        9     4   6     7     */

        System.out.println(Arrays.toString(A));
    }
}
```



BUILD-HEAP(A)
    heapsize := size(A);
    for i := floor(heapsize/2) downto 1
        do HEAPIFY(A, i);
    end for
END

* A quick look over the above algorithm suggests that the running time is O(nlg(n)), since each call to Heapify costs O(lg(n)) and Build-Heap makes O(n) such calls.
This upper bound, though correct, is not asymptotically tight.

We can derive a tighter bound by observing that the running time of Heapify depends on the height of the tree ‘h’ (which is equal to lg(n), where n is number of nodes) and the heights of most sub-trees are small.
