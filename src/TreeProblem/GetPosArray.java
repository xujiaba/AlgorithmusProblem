package TreeProblem;

import com.sun.org.apache.xerces.internal.xs.XSTerm;

import java.util.HashMap;

public class GetPosArray {
    //给出一棵二叉树的先序和中序数组，通过这两个数组直接生成正确的后序数组。

    public int[] getPosArray(int[] pre, int[] in) {
        if (pre == null || in == null || in.length != pre.length) {
            return null;
        }
        int len = pre.length;
        int[] pos = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(in[i], i);
        }
        setPos(pre, 0, len - 1, in, 0, len - 1, pos, len - 1, map);
        return pos;

    }

    // 从右往左一次填好后序数组 pos
    // posR 为后序数组 pos 该填的位置
    // 返回值 pos 该填的下一个位置
    private int setPos(int[] pre, int pL, int pR, int[] in, int iL, int iR, int[] pos, int posR, HashMap<Integer, Integer> map) {
        if (pL > pR)
            return posR;
        pos[posR--] = pre[pL];
        int i = map.get(pre[pL]);
        posR = setPos(pre, pR - iR + i + 1, pR, in, i + 1, iR, pos, posR, map);
        return setPos(pre, pL + 1, pR + i - iL, in, iL, i - 1, pos, posR, map);
    }

}
