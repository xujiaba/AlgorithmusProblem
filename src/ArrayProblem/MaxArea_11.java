package ArrayProblem;

public class MaxArea_11 {

    // 1.暴力法
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }

    // 2.双指针法
    // 每次移动值较小的值所在的下标
    public int maxArea2(int[] height) {
        int maxArea = 0;
        int L = 0, R = height.length - 1;
        while (L < R) {
            maxArea = Math.max(maxArea, Math.min(height[L], height[R]) * (R - L));
            if (height[L]< height[R]){
                L++;
            } else {
                R--;
            }
        }
        return maxArea;
    }
}
