import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ZhaoWeiLong
 * @date 2021/3/11
 */
public class Demo_1 {

  public static void main(String[] args) {

    Integer[] num1 = new Integer[] {1, 2, 2, 1};
    Integer[] num2 = new Integer[] {2, 3, 7, 4};
    Integer[] num3 = new Integer[] {2, 3, 1, 4, 5, 8};

    System.out.println(Arrays.toString(intersection(num1, num2)));
    System.out.println(Arrays.toString(intersection2(num2, num3)));
  }

  /**
   * 求两数组交集
   *
   * @param num1
   * @param num2
   * @return
   */
  public static Integer[] intersection(Integer[] num1, Integer[] num2) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int v : num1) {
      if (map.containsKey(v)) {
        map.put(v, map.get(v) + 1);
      } else {
        map.put(v, 1);
      }
    }
    ArrayList<Integer> list = new ArrayList<>();
    for (int v : num2) {
      // 存在相同，将次数-1，
      if (map.containsKey(v)) {
        map.put(v, map.get(v) - 1);
        list.add(v);
      }
    }
    return list.toArray(new Integer[0]);
  }

  /**
   * 求两数组交集 排序优化版
   *
   * @param num1
   * @param num2
   * @return
   */
  public static Integer[] intersection2(Integer[] num1, Integer[] num2) {
    List<Integer> list1 = Arrays.stream(num1).sorted().collect(Collectors.toList());
    List<Integer> list2 = Arrays.stream(num2).sorted().collect(Collectors.toList());

    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
      Integer v1 = list1.get(i);
      Integer v2 = list2.get(j);

      if (v1 > v2) {
        j++;
      } else if (v1 < v2) {
        i++;
      } else {
        list.add(v1);
        i++;
        j++;
      }
    }
    return list.toArray(new Integer[0]);
  }
}
