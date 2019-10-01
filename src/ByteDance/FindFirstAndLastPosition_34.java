package ByteDance;

public class FindFirstAndLastPosition_34 {
    // 在排序数组中查找元素的第一个和最后一个位置
    // 暴力法
    // 首先，我们对 nums 数组从左到右做线性遍历，当遇到 target 时中止。
    // 如果我们没有中止过，那么 target 不存在，我们可以返回“错误代码” [-1, -1] 。
    // 如果我们找到了有效的左端点坐标，我们可以坐第二遍线性扫描，但这次从右往左进行。
    // 这一次，第一个遇到的 target 将是最右边的一个（因为最左边的一个存在，所以一定会有一个最右边的 target）。
    // 我们接下来只需要返回这两个坐标。

    public int[] searchRange1(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        // 从左往右找到第一次出现的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                targetRange[0] = i;
                break;
            }
        }
        // 如果不存在
        if (targetRange[0] == -1) {
            return targetRange;
        }
        // 从右往左找到最后一次出现的位置
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] == target) {
                targetRange[1] = j;
                break;
            }
        }
        return targetRange;
    }

    // 二分查找
    //首先，为了找到最左边（或者最右边）包含 target 的下标（而不是找到的话就返回 true ），
    // 所以算法在我们找到一个 target 后不能马上停止。我们需要继续搜索，直到 low == high 且它们在某个 target 值处下标相同。
    //另一个改变是 left 参数的引入，它是一个 boolean 类型的变量，指示我们在遇到 target == nums[mid] 时应该做什么。
    // 如果 left 为 true ，那么我们递归查询左区间，否则递归右区间。
    // 考虑如果我们在下标为 i 处遇到了 target ，最左边的 target 一定不会出现在下标大于 i 的位置，
    // 所以我们永远不需要考虑右子区间。当求最右下标时，道理同样适用。

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        int leftIdx = extremeInsertionIndex(nums, target, true);

        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;
    }

    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


}
