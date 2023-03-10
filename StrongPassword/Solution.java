import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

   static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
      String numbers = "0123456789";
      String lower_case = "abcdefghijklmnopqrstuvwxyz";
      String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String special_characters = "!@#$%^&*()-+";
        int count = 0;
      if (!contains(password, numbers)) count++;
      if (!contains(password, lower_case)) count++;
      if (!contains(password, upper_case)) count++;
      if (!contains(password, special_characters)) count++;
      int delta = Math.max(0, 6 - count - password.length());
      count += delta;
      return count;
    }
  
    private static boolean contains(String s, String oneOf) {
      for (char c: oneOf.toCharArray()) {
        if (s.indexOf(c) != -1) {
          return true;
        }
      }
      return false;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
