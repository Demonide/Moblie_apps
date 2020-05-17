package club.plus1.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.content.SharedPreferences;
import android.widget.RemoteViews;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.graphics.Color;
import android.os.Bundle;

public class MyWidget extends AppWidgetProvider {



    @Override
    public void onEnabled(Context context){
        super.onEnabled(context);
        Log.d("mywi", "onEnabled");
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        SharedPreferences pref = context.getSharedPreferences(configActivity.WIDGET_PREF, Context.MODE_PRIVATE);
        for (int id: appWidgetIds){
            updateWidget(context, appWidgetManager,pref,id);
        }
        Log.e("mywi", "onUpdate");
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds){
        super.onDeleted(context, appWidgetIds);

        SharedPreferences.Editor edit = context.getSharedPreferences(configActivity.WIDGET_TEXT, Context.MODE_PRIVATE).edit();
        for (int id: appWidgetIds){
            edit.remove(configActivity.WIDGET_TEXT + id);
            edit.remove(configActivity.WIDGET_COLOR + id);
        }
        edit.commit();
        Log.i("mywi", "onDeleted");
    }

    @Override
    public void onDisabled(Context context){
        super.onDisabled(context);
        Log.v("mywi", "onDisabled");
    }

    static void updateWidget(Context context, AppWidgetManager manager, SharedPreferences pref, int widgetID){
        String text = pref.getString(configActivity.WIDGET_TEXT + widgetID, null);
        if (text == null)
            return;
        int color = pref.getInt(configActivity.WIDGET_COLOR +widgetID, 0);

        RemoteViews view =  new RemoteViews(context.getPackageName(), R.layout.widget);
        view.setTextViewText(R.id.textView, text);
        view.setInt(R.id.textView, "setBackgroundColor", color);

        manager.updateAppWidget(widgetID, view);
    }
}
