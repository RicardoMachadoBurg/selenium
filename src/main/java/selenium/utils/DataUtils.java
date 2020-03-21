package selenium.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {

    public static Date getDateWithDiferenceDays(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }

    public static String getFormatDate(Date date) {
        DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        return format.format(date);
    }

}
