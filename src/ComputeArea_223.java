public class ComputeArea_223 {
    /*
     * 223. 矩形面积
     * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。

     * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
     *    示例:
     *
     *   输入: -3, 0, 3, 4, 0, -1, 9, 2
     *   输出: 45
     *   说明: 假设矩形面积不会超出 int 的范围。
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = Math.abs(C - A) * Math.abs(D - B);
        int area2 = Math.abs(G - E) * Math.abs(H - F);
        int x1 = Math.max(A, E), y1 = Math.max(B, F);
        int x2 = Math.min(C, G), y2 = Math.min(D, H);
        if (x1 >= x2 || y1 >= y2) {
            return area1 + area2;
        } else {
            return area1 - (x2 - x1) * (y2 - y1) + area2;
        }
    }
}
