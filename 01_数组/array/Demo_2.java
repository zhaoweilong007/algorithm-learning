package array;

/**
 * @author ZhaoWeiLong
 * @date 2021/3/11
 */
public class Demo_2 {
  public static void main(String[] args) {
    String[] arr = {"flower", "flow", "flight"};
    System.out.println(longestPrefix(arr));
  }

  /**
   * 最长公共前缀
   *
   * @param arr
   * @return
   */
  public static String longestPrefix(String[] arr) {
    if (arr.length == 0) {
      return "";
    }
    String prefix = arr[0];
    for (String s : arr) {
      while (s.indexOf(prefix) != 0) {
        if (prefix.length() == 0) {
          return "";
        }
        prefix = prefix.substring(0, prefix.length() - 1);
      }
    }
    return prefix;
  }
}
