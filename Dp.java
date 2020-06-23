import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.HashSet;
import java.util.ArrayList;

/*

Given a list of sets, find the set that should be excluded to maximize the size
of the intersection of the remaining sets

Given a list of arrays, find the array that should be excluded to maximize the
size of the product of the remaining arrays.

[[1,2,3,6], [3,6,7,5], [4,2,7,3], [5,8,2,3]]
     e
                i
                        j

left = [(), (), (), ()]
        0    1   2  3
right = [( [3,6,7,5], [4,2,7,3], [5,8,2,3]), ([4,2,7,3], [5,8,2,3]), ([5,8,2,3])]
right = intersection( [5,8,2,3])

for i in set_list
    build left at i
for i in set_list
    build right at i

for k set in list
    find len left[i] + right[i]

for each set in list
    find the intersection between left and right
    add current set to left
    remove current set from right

IDEA NUMERO UNO
TIME  = O(N^2 * however much finding the intesection costs)
SPACE = O(1)
for i 0 len
    for j 0 len
        if i is not j
            max = max or findIntersection()
*/

public class Dp {

    public static void printSet(Set<Integer> set) {
        for (Integer i : set) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static Set<Integer> findIntersection(Set<Integer> first, Set<Integer> second) {
        if (first.isEmpty()) return second;
        if (second.isEmpty()) return first;

        Set<Integer> result = new HashSet<>();
        for (Integer value : first) {
            if (second.contains(value)) {
                result.add(value);
            }
        }
        return result;
    }

    public static Set<Integer> findMaxIntersection(List<Set<Integer>> listOfSets) {
        int n = listOfSets.size() - 1;
        ArrayList<Set<Integer>> left = new ArrayList<Set<Integer>>();
        ArrayList<Set<Integer>> right = new ArrayList<Set<Integer>>();
        left.add(new HashSet<>());
        right.add(new HashSet<>());
        for (int i = 1; i <= n; i++) {
            left.add(findIntersection(left.get(i - 1), listOfSets.get(i - 1)));
            right.add(new HashSet<>());
        }
        for (int i = n - 1; i >= 0; i--) {
            right.set(i, findIntersection(right.get(i + 1), listOfSets.get(i + 1)));
        }
        int maxSize = findIntersection(left.get(0), right.get(0)).size();
        int maxIndex = 0;
        for (int i = 1; i <= n; i++) {
            int current = findIntersection(left.get(i), right.get(i)).size();
            if (current > maxSize) {
                maxSize = current;
                maxIndex = i;
            }
        }
        return listOfSets.get(maxIndex);
    }

    public static void main(String[] args) {
        Set<Integer> one = new HashSet<Integer>();
        one.add(1); one.add(2); one.add(3); one.add(6);

        Set<Integer> two = new HashSet<Integer>();
        two.add(8); two.add(6); two.add(5); two.add(7);

        Set<Integer> three = new HashSet<Integer>();
        three.add(4); three.add(2); three.add(9); three.add(7);

        Set<Integer> four = new HashSet<Integer>();
        four.add(5); four.add(2); four.add(3); four.add(8);

        List<Set<Integer>> list = new ArrayList<>();
        list.add(one); list.add(two); list.add(three); list.add(four);

        Set<Integer> result = findMaxIntersection(list);
        //Set<Integer> result = findIntersection(one, two);
        printSet(result); // 5678 --> two
    }
}
