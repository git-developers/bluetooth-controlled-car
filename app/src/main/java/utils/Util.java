package utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;
import android.app.AlertDialog.Builder;

import com.tianos.car.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {

    private static Toast mainToast;

    public static void showDialog(  String message,
                                    String btnMessage,
                                    Context ctx,
                                    android.content.DialogInterface.OnClickListener listener) {

        Builder builder = new Builder(ctx);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(R.string.app_name);
        builder.setMessage(message);
        builder.setCancelable(false);

        if (btnMessage.isEmpty()) {
            btnMessage = ctx.getString(R.string.accept);
        }

        if (listener != null) {
            builder.setPositiveButton(btnMessage, listener);
        } else {
            builder.setPositiveButton(btnMessage, new android.content.DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialoginterface, int i) {

                }
            });
        }

        builder.show();
    }

    public static void showToast(Context context, String message) {
        if (mainToast != null) {
            mainToast.cancel();
        }

        mainToast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        mainToast.show();
    }

    public static int parseInt(String s){

        int out = 0;

        try {
            out = Integer.parseInt(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return out;
    }

    public static void showSnackbar(Context context, String text) {

        View parentLayout = ((Activity) context).findViewById(android.R.id.content);
        Snackbar.make(parentLayout, text, Snackbar.LENGTH_LONG)
            .setAction(R.string.close, new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            })
            .setActionTextColor(context.getResources().getColor(R.color.primary))
            .show();
    }

    public static String getProperty(String key, Context context) {

        String property = "";

        try {
            Properties properties = new Properties();
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open("config.properties");
            properties.load(inputStream);
            property = properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return property;
    }

}
