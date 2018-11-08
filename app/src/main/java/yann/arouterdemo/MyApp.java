package yann.arouterdemo;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;

import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;
import org.acra.collector.CrashReportData;
import org.acra.sender.EmailIntentSender;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;

import yann.module.base.BaseApplication;
import yann.module.utils.Utils;

/**
 * Created by yayun.xia on 2018/11/8
 */
@ReportsCrashes(
        mailTo = "465425854@qq.com",
        mode = ReportingInteractionMode.DIALOG,
        customReportContent = {
                ReportField.APP_VERSION_NAME,
                ReportField.ANDROID_VERSION,
                ReportField.PHONE_MODEL,
                ReportField.CUSTOM_DATA,
                ReportField.BRAND,
                ReportField.STACK_TRACE,
                ReportField.LOGCAT,
                ReportField.USER_COMMENT},
        resToastText = R.string.crash_toast_text,
        resDialogText = R.string.crash_dialog_text,
        resDialogTitle = R.string.crash_dialog_title)
public class MyApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        if (Utils.isAppDebug()) {
            //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
        //崩溃日志记录初始化
        ACRA.init(this);
        ACRA.getErrorReporter().removeAllReportSenders();
        ACRA.getErrorReporter().setReportSender(new CrashReportSender());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // dex突破65535的限制
        MultiDex.install(this);
    }

    /**
     * 发送崩溃日志
     */
    private class CrashReportSender implements ReportSender {
        CrashReportSender() {
            ACRA.getErrorReporter().putCustomData("PLATFORM", "ANDROID");
            ACRA.getErrorReporter().putCustomData("BUILD_ID", android.os.Build.ID);
            ACRA.getErrorReporter().putCustomData("DEVICE_NAME", android.os.Build.PRODUCT);
        }

        @Override
        public void send(Context context, CrashReportData crashReportData) throws ReportSenderException {
            EmailIntentSender emailSender = new EmailIntentSender(getApplicationContext());
            emailSender.send(context, crashReportData);
        }
    }

}