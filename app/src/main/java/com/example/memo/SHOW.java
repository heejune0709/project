package com.example.memo;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SHOW extends Activity {
    int current = 0;
    Cursor cursor;
    TextView date;
    TextView con;
    String memo_content;
    String memo_date;
    int number;

    @Override
    public void onCreate(Bundle save) {
        super.onCreate(save);
        setContentView(R.layout.show);

        date = (TextView) findViewById(R.id.date);
        con = (TextView) findViewById(R.id.t1);

        try {
            DATA dat0 = new DATA(this);
            SQLiteDatabase sdb = dat0.getReadableDatabase();
            cursor = sdb.query("memoTB", null, null, null, null, null, null);
            number = cursor.getCount();
            cursor.moveToFirst();
            if (number == 0) {
                current = 0;
            } else {
                current = 1;
            }
            if (cursor.getCount() > 0) {
                memo_content = cursor.getString(0);
                memo_date = cursor.getString(1);
            }
            cursor.close();
            dat0.close();

        } catch (SQLiteException exception) {

        }
        date.setText(memo_content);
        con.setText(memo_date);
    }

    public void previousData (View v) {
        try {
            DATA dat2 = new DATA(this);
            SQLiteDatabase sdb = dat2.getReadableDatabase();
            cursor = sdb.query("memoTB", null, null, null, null, null, null);
            if (number == 0) {
                current = 0;
            }
            if (cursor.getCount() > 0 && current > 1) {
                current -= 1;
                if (current <= number) {
                    current = 1;
                }
                cursor.moveToPosition(current - 1);

                memo_content = cursor.getString(0);
                memo_date = cursor.getString(1);
            }
            cursor.close();
            dat2.close();

        } catch (SQLiteException exception) {

        }
        date.setText(memo_content);
        con.setText(memo_date);

    }
    public void nextData (View v) {
        try {
            DATA dat = new DATA(this);
            SQLiteDatabase sdb = dat.getReadableDatabase();
            cursor = sdb.query("memoTB", null, null, null, null, null, null);
            if (number == 0) {
                current = 0;
            }
            if (cursor.getCount() > 0 && current <= number) {
                current += 1;
                if (current >= number) {
                    current = number;
                }
                cursor.moveToPosition(current - 1);

                memo_content = cursor.getString(0);
                memo_date = cursor.getString(1);
            }
            cursor.close();
            dat.close();

        } catch (SQLiteException exception) {

        }
        date.setText(memo_content);
        con.setText(memo_date);

    }

}
