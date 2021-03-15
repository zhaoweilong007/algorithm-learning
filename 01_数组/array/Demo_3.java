package array;

/**
 * @author ZhaoWeiLong
 * @date 2021/3/11
 */
public class Demo_3 {
  public static void main(String[] args) {
    Integer[] prices = {7, 1, 5, 3, 6, 4};
    Integer[] prices2 = {1, 2, 3, 4, 5};
    Integer[] prices3 = {7, 6, 4, 3, 1};
    System.out.println(maxProfit(prices));
    System.out.println(maxProfit(prices2));
    System.out.println(maxProfit(prices3));
  }

  /**
   * 买卖股票最大利润
   * @param prices
   * @return
   */
  public static Integer maxProfit(Integer[] prices) {
    if (prices.length < 2) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i] < prices[i+1]) {
        count += prices[i + 1] - prices[i];
      }
    }
    return count;
  }
}
