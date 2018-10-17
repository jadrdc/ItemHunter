package agustinreinoso.altice.com.itemhunter.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
    public static  String getPictureName() {
        SimpleDateFormat tst = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = tst.format(new Date());
        return timestamp + ".png";
    }
}
