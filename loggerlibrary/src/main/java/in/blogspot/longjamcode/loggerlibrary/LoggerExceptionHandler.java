package in.blogspot.longjamcode.loggerlibrary;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by sumanta on 27/5/15.
 */
public class LoggerExceptionHandler implements Thread.UncaughtExceptionHandler {
    private Context context;
    private Intent intent;
    public LoggerExceptionHandler (Context context, Intent intent) {
        this.context = context;
        this.intent = intent;
    }
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        String error = Util.generateErrorReport(e);
        Log.e("Exception  :  ", error.toString());
        Util.sendLogsToLogger(context, error);
        context.startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}