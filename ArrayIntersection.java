import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class ArrayIntersection {

  public static ArrayList<Integer> findIntersection(int[] arr1, int[] arr2) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    int p1 = 0;
    int p2 = 0;

    while (p1 < arr1.length && p2 < arr2.length) {
      if (arr1[p1] == arr2[p2]) {
        result.add(arr1[p1]);
        p1++;
        p2++;
      } else if (arr1[p1] > arr2[p2]) {
        while (p2 < arr2.length && arr2[p2] < arr1[p1]) {
          p2++;
        }
      } else {
        while (p1 < arr1.length && arr1[p1] < arr2[p2]) {
          p1++;
        }
      }
    }
    return result;
  }


  public static ArrayList<Integer> firstPass(int[] arr1, int[] arr2) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();

    for (int i = 0; i < arr1.length; i++) {
      if (counts.containsKey(arr1[i])) {
        counts.replace(arr1[i], counts.get(arr1[i]) + 1);
      } else {
        counts.put(arr1[i], 1);
      }
    }

    for (int i = 0; i < arr2.length; i++) {
      if (counts.containsKey(arr2[i]) && counts.get(arr2[i]) > 0) {
        result.add(arr2[i]);
        counts.replace(arr2[i], counts.get(arr2[i]) - 1);
      }
    }

    return result;

  }


  public static ArrayList<Integer> firstTry(int[] arr1, int[] arr2) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
    int[] copyArr2 = Arrays.copyOf(arr2, arr2.length);
    int arr2Index;

    for (int i = 0; i < arr1.length; i++) {
      for (int a : copyArr2) {
        System.out.print(a);
        System.out.print(",");
      }
      arr2Index = binarySearch(copyArr2, arr1[i]);
      //System.out.println(arr2Index);
      if (arr2Index != -1) {

        result.add(arr1[i]);
      }
    }
    return result;
	}

  public static int binarySearch(int[] arr, int target) {
    int left = -1;
    int right = arr.length;
    int mid;

    while (left < right) {
      mid = (left + right) / 2;
      if (arr[mid] <= target) {
        left = mid;
      } else {
        right = mid + 1;
      }
    }
    return -1;
  }

  public static void printArray(ArrayList<Integer> arr, String answer) {
    for (int i : arr) {
      System.out.print(i);
      System.out.print(", ");
    }
    System.out.println(answer);
  }


	public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5};
    int[] b = {1, 2, 3, 4, 5};
    ArrayList<Integer> test = findIntersection(a, b);
    printArray(test, "--> 1, 2, 3, 4, 5");

    int[] c = {1, 2, 3, 4, 5};
    int[] d = {6, 7, 8, 9};
    test = findIntersection(c, d);
    printArray(test, "--> ");

    int[] e = {};
    int[] f = {};
    test = findIntersection(e, f);
    printArray(test, "--> ");

    int[] g = {1,2,3,3,3,3};
    int[] h = {3,3,4};
    test = findIntersection(g, h);
    printArray(test, "--> 3, 3");




	}

}
