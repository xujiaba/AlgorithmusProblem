package ByteDance;

public class IPUtil {
    ///给定一个IP地址的字符串,现在实现一个函数,用一个int表示这个IP地址,并且可以通过
    /**
     *  * ip地址转成long型数字
     *  * 将IP地址转化成整数的方法如下：
     *  * 1、通过String的split方法按.分隔得到4个长度的数组
     *  * 2、通过左移位操作（<<）给每一段的数字加权，
     * 第一段的权为 2 的 24 次方，第二段的权为 2 的 16次方，第三段的权为 2 的 8 次方，最后一段的权为1
     **/

    public static long ipToLong(String ipStr) {
        String[] ip = ipStr.split("\\.");
        long res = (Long.parseLong(ip[0]) << 24)
                + (Long.parseLong(ip[1]) << 16)
                + (Long.parseLong(ip[2]) << 8)
                + Long.parseLong(ip[3]);
        return res;
    }

    public static String LongToIp(long longIp) {
        StringBuilder sb = new StringBuilder();
        // 直接右移24位
        sb.append(String.valueOf(longIp >>> 24) + ".");
        // 将高8位置0，然后右移16位
        sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16)+ ".");
        // 将高16位置0，然后右移8位
        sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8)+ ".");
        // 将高24位置0
        sb.append(String.valueOf((longIp & 0x000000FF)));
        return sb.toString();
    }

    public static void main(String[] args) {
        IPUtil ipInt = new IPUtil();
        System.out.println(ipInt.ipToLong("172.168.0.1"));
        System.out.println(ipInt.LongToIp((ipInt.ipToLong("192.168.0.1"))));
    }
}
