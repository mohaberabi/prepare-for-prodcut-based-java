package DP;

import java.util.ArrayList;

public class StockBuyAndSell {


    int maxProfit(int[] price) {
        int n = price.length;

        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (price[i] > price[i - 1]) {
                profit += (price[i] - price[i - 1]);
            }
        }
        return profit;
    }

    static ArrayList<ArrayList<Integer>> stockBuySell(int arr[], int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (n < 2) {
            return ans;
        }

        int buyDay = 0;
        for (int sellDay = 1; sellDay < n; sellDay++) {
            if (arr[sellDay] > arr[buyDay]) {
                ArrayList<Integer> transaction = new ArrayList<>();
                transaction.add(buyDay);
                transaction.add(sellDay);
                ans.add(transaction);
            }
            buyDay = sellDay;
        }

        return ans;
    }

    static ArrayList<ArrayList<Integer>> stockButAndSellForEachDay(int[] price) {
        int n = price.length;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();


        int buyDay = 0;
        for (int sellDay = 1; sellDay < n; sellDay++) {
            if (price[sellDay] > price[buyDay]) {
                ArrayList<Integer> txn = new ArrayList<>();
                txn.add(buyDay);
                txn.add(sellDay);
                al.add(txn);
            }
            buyDay = sellDay;
        }
        return al;

    }

    static ArrayList<ArrayList<Integer>> stockButAndSellForEachDay2(int[] price) {
        int n = price.length;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();


        for (int i = 1; i < n; i++) {
            if (price[i] > price[i - 1]) {
                ArrayList<Integer> txn = new ArrayList<>();
                txn.add(i - 1);
                txn.add(i);
                al.add(txn);
            }
        }
        return al;

    }

    public static void main(String[] args) {
        int[] price = {100, 180, 260, 310, 40, 535, 695};

        ArrayList<ArrayList<Integer>> stocks = stockBuySell(price, price.length);

        for (ArrayList<Integer> s : stocks) {
            for (int i : s) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
