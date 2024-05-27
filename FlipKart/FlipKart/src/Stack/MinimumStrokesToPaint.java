package Stack;

import java.util.Stack;

public class MinimumStrokesToPaint {


    public int minStrokes(int[] height, int N) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for (int i = 0; i < N; i++) {
            while (!st.isEmpty() && st.peek() > height[i]) {
                ans += 1;
                st.pop();
            }
            if (st.size() == 0 || st.peek() != height[i])
                st.push(height[i]);
        }
        return ans + st.size();
    }
}
