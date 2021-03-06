package in.blogspot.longjamcode.loggerlibrary;

import android.content.Context;
import android.content.Intent;
import android.os.Build;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sumanta on 27/5/15.
 */
public class Util {
    public static String generateErrorReport(Throwable e) {
        StringWriter stackTrace = new StringWriter();
        e.printStackTrace(new PrintWriter(stackTrace));
        String timestamp = formatDate(new Date(),"MM/dd/yyyy HH:mm:ss");

        StringBuilder errorReport = new StringBuilder();
        errorReport.append("Time: "+timestamp+"\n\n");
        errorReport.append("CAUSE OF ERROR\n\n");
        errorReport.append(stackTrace.toString()+"\n\n");
        errorReport.append("DEVICE INFORMATION\n\n");
        errorReport.append("Brand: ");
        errorReport.append(Build.BRAND+"\n");
        errorReport.append("Device: ");
        errorReport.append(Build.DEVICE+"\n");
        errorReport.append("Model: ");
        errorReport.append(Build.MODEL+"\n");
        errorReport.append("Id: ");
        errorReport.append(Build.ID+"\n");
        errorReport.append("Product: ");
        errorReport.append(Build.PRODUCT+"\n");
        errorReport.append("SDK: ");
        errorReport.append(Build.VERSION.SDK+"\n");
        errorReport.append("Release: ");
        errorReport.append(Build.VERSION.RELEASE+"\n");

        return errorReport.toString();
    }
    public static void sendLogsToLogger(Context context, String loggerData){
        Intent sendIntent = new Intent();
        sendIntent.setAction("in.blogspot.longjamcode.LOGGER_INTENT");
        sendIntent.putExtra("LOGGER_DATA", loggerData);
        context.sendBroadcast(sendIntent);
    }
    public static  String formatDate(Date date, String pattern){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
}
