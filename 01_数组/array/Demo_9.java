package array;

import java.util.Arrays;

/**
 * @author ZhaoWeiLong
 * @date 2021/3/15
 */
public class Demo_9 {

  public static void main(String[] args) {

    System.out.println(tranform("LEETCODEISHIRING", 3));
    System.out.println(tranform("LEETCODEISHIRING", 4));
  }

  /**
   * Z字形转换
   *
   * @param str
   * @return
   */
  public static String tranform(String str, int numRow) {
    if (numRow < 1) {
      return str;
    }
    String[] arr = new String[numRow];
    Arrays.fill(arr, "");
    int period = numRow * 2 - 2;
    for (int i = 0; i < str.length(); i++) {
      int mod = i % period;
      if (mod < numRow) {
        arr[mod] += str.charAt(i);
      } else {
        arr[period - mod] += str.charAt(i);
      }
    }
    return String.join("", arr);
  }
}
