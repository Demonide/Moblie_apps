package club.plus1.widget;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Button;
import android.graphics.Color;

public class configActivity extends AppCompatActivity {

    int widgetId = AppWidgetManager.INVALID_APPWIDGET_ID;
    Intent resultValue;
    public final static String WIDGET_PREF = "WIDGET_PREF";
    public final static String WIDGET_TEXT = "WIDGET_TEXT";
    public final static String WIDGET_COLOR = "WIDGET_COLOR";
    public Button btn;

    @Override
    protected void onCreate(Bundle params) {
        super.onCreate(params);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            widgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        }
        if (widgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish();
        }

        resultValue = new Intent();
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);

        setResult(RESULT_CANCELED, resultValue);
        setContentView(R.layout.activity_config);
        btn = findViewById(R.id.confirm);
        btn.setText("Confirm");
    }

    public void onClick(View view) {
        EditText editText = findViewById(R.id.etText);
        RadioGroup radioGroup = findViewById(R.id.Color);
        int color = 0;
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.black:
                color = R.color.black;
                break;
            case R.id.green:
                color = R.color.green;
                break;
            case R.id.blue:
                color = R.color.blue;
                break;
            case R.id.red:
                color = R.color.red;
                break;
            default:
                color = R.color.black;
        }
        SharedPreferences pref = getSharedPreferences(WIDGET_PREF, MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        edit.putString(WIDGET_TEXT+widgetId, editText.getText().toString());
        edit.putInt(WIDGET_COLOR+widgetId, getResources().getColor(color));
        edit.commit();

        AppWidgetManager manager = AppWidgetManager.getInstance(this);
        MyWidget.updateWidget(this, manager, pref, widgetId);

        setResult(RESULT_OK, resultValue);
        finish();

    }


}
