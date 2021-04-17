import java.io.*;
import java.util.*;

class RabinKarp {

  static int hashIt(String s) {

    // lets just take the ascii value of the chars 
    char[] chars = s.toCharArray();
    int hash = 0;
    for (char c: chars) {
      int i = (int) c;

      hash = hash + i;
    }
    return hash % 31;
  }
  public static void main(String[] args) {
    // i am assuming that all are lowercase.
    String s = "hoiw world, how are you?";
    String t = "ow";
    int hashT = hashIt(t);
    char[] sArray = s.toCharArray();
    int length = t.length();
    int hash = 0, i = 0;
    for (i = 0; i < length; i++) {
      hash = hash + (int) sArray[i];

    }

    int hashLocalHash = hash % 31;
    boolean matchFound = false;
    int startIndex = 0;
    while (startIndex < s.length()) {
      if (hashLocalHash == hashT) {
        String foundString = s.substring(startIndex, startIndex + length);
        System.out.println("Matches***********" + foundString);
        if (foundString.equals(t)) {
          System.out.println("Found match at index " + startIndex);
          return;
        } else {
          System.out.println("Dint find!, lets try some more");
        }
      }

      if (startIndex + length + 1 < s.length()) {
        hash = hash - ((int) sArray[startIndex]) + (int) sArray[startIndex + length];
        hashLocalHash = hash % 31;
        startIndex++;
      } else {
        System.out.println("Not found");
        return;
      }
    }
  }
}