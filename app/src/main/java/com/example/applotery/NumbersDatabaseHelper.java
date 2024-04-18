package com.example.applotery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class NumbersDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "numbers_db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NUMBERS = "numeros";

    private static final String COLUMN_ID = "id";
    private static final String[] COLUMN_NUMBERS = {"n1", "n2", "n3", "n4", "n5", "n6"};

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NUMBERS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NUMBERS[0] + " INTEGER, " +
                    COLUMN_NUMBERS[1] + " INTEGER, " +
                    COLUMN_NUMBERS[2] + " INTEGER, " +
                    COLUMN_NUMBERS[3] + " INTEGER, " +
                    COLUMN_NUMBERS[4] + " INTEGER, " +
                    COLUMN_NUMBERS[5] + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NUMBERS;

    public NumbersDatabaseHelper(@NonNull Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void inserirNumeros(@NonNull Numbers numeros) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NUMBERS[0], numeros.getN1());
        values.put(COLUMN_NUMBERS[1], numeros.getN2());
        values.put(COLUMN_NUMBERS[2], numeros.getN3());
        values.put(COLUMN_NUMBERS[3], numeros.getN4());
        values.put(COLUMN_NUMBERS[4], numeros.getN5());
        values.put(COLUMN_NUMBERS[5], numeros.getN6());
        db.insert(TABLE_NUMBERS, null, values);
        db.close();
    }

    @NonNull
    public List<Numbers> recuperarTodosNumeros() {
        List<Numbers> numerosList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TABLE_NUMBERS, null, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex1 = cursor.getColumnIndex(COLUMN_NUMBERS[0]);
            int columnIndex2 = cursor.getColumnIndex(COLUMN_NUMBERS[1]);
            int columnIndex3 = cursor.getColumnIndex(COLUMN_NUMBERS[2]);
            int columnIndex4 = cursor.getColumnIndex(COLUMN_NUMBERS[3]);
            int columnIndex5 = cursor.getColumnIndex(COLUMN_NUMBERS[4]);
            int columnIndex6 = cursor.getColumnIndex(COLUMN_NUMBERS[5]);

            do {
                // Verificar se os índices são válidos
                if (columnIndex1 != -1 && columnIndex2 != -1 && columnIndex3 != -1 &&
                        columnIndex4 != -1 && columnIndex5 != -1 && columnIndex6 != -1) {
                    Numbers numeros = new Numbers();
                    numeros.setN1(cursor.getInt(columnIndex1));
                    numeros.setN2(cursor.getInt(columnIndex2));
                    numeros.setN3(cursor.getInt(columnIndex3));
                    numeros.setN4(cursor.getInt(columnIndex4));
                    numeros.setN5(cursor.getInt(columnIndex5));
                    numeros.setN6(cursor.getInt(columnIndex6));
                    numerosList.add(numeros);
                }
            } while (cursor.moveToNext());
            cursor.close();
        }
        return numerosList;
    }
}
