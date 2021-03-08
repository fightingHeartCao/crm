import org.example.crm.utils.DateTimeUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {
    public static void main(String[] args) {
        //验证失效时间
        String expireTime = "2019-10-10 10:10:10";
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String str = sdf.format(date);
        //当前系统时间
        String currentTime = DateTimeUtil.getSysTime();
        int count = expireTime.compareTo(currentTime);
        System.out.println(count);

        String lockState = "0";
        if("0".equals(lockState)){
            System.out.println("账号已锁定");
        }
        String ip = "192.168.1.1";
        String allowIps = "192.168.1.1, 192.168.1.2";
        if(allowIps.contains(ip)) {
            System.out.println("有效的ip地址");
        }else{
            System.out.println("无效的ip地址");
        }


    }
}
