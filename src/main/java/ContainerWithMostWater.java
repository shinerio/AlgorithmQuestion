import org.junit.Test;

public class ContainerWithMostWater {


    @Test
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = (height.length - 1) * Math.min(height[l], height[r]);
        // 划分子集问题
        while (r - l > 1) {
            int tmp;
            if (height[l] < height[r]) {
                l++;
                tmp = (r - l) * Math.min(height[l], height[r]);
            }else{
                r--;
                tmp = (r - l) * Math.min(height[l], height[r]);
            }
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }
}
