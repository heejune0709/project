package com.example.memo;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class WriteMemoActivity extends Activity {
    private DBManager data;

    @Override
    public void onCreate(Bundle save) {
        super.onCreate(save);
        setContentView(R.layout.writememo);

        Button but = (Button)findViewById(R.id.button_store);

    }

    public void saveData(View v) {
        EditText name = (EditText)findViewById(R.id.edit_date);
        String memo_date = name.getText().toString();
        EditText name2 = (EditText)findViewById(R.id.edit_memo);
        String memo_content = name2.getText().toString();
        try {
            data = new DBManager(this);
            SQLiteDatabase base;
            base=data.getWritableDatabase();
            base.execSQL("insert into memoTB values ('" + memo_date + "','" + memo_content + "');");
        } catch (SQLiteException error) {

        }
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
        finish();
    }
}
