import java.util.Arrays;

/**
 * @author ZhaoWeiLong
 * @date 2021/3/12
 */
public class Demo_5 {

  public static void main(String[] args) {
    int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
    System.out.println(removeElement(nums, 2));
    System.out.println(Arrays.toString(nums));
  }

  /**
   * 原地删除
   *
   * @param arr
   * @param val
   * @return
   */
  public static int removeElement(int[] arr, int val) {
    int cnt = 0;
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      if (arr[i] == val) {
        cnt++;
      } else {
        arr[i - cnt] = arr[i];
      }
    }
    return n - cnt;
  }
}
