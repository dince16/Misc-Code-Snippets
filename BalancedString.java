import java.lang.StringBuilder;
import java.util.ArrayList;

public class BalancedString {


	public static String balance(String word) {
    String[] characters = word.split("");
    ArrayList<Integer> open = new ArrayList<Integer>();
    ArrayList<Integer> close = new ArrayList<Integer>();
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < characters.length; i++) {
      if (characters[i].equals("(")) {
        open.add(i);
      } else if (characters[i].equals(")")) {
        if (open.size() == 0) {
          close.add(i);
        } else {
          open.remove(open.size() - 1);
        }
      }
    }
    for (int i = 0; i < characters.length; i++) {
      if (!open.contains(i) && !close.contains(i)) {
        result.append(characters[i]);
      }
    }

    return result.toString();

	}

	public static void main(String[] args) {
    System.out.print("blah( --> ");
		System.out.println(balance("blah("));

    System.out.print("(blah( --> ");
    System.out.println(balance("(blah("));

    System.out.print("(b)(lah()( --> ");
    System.out.println(balance("(b)(lah()"));

    System.out.print(")(())( --> ");
    System.out.println(balance(")(())("));

    System.out.print("(())()) --> ");
    System.out.println(balance("(())())"));
	}
}
