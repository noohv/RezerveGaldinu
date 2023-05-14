package com.example.rezervegaldinu
//
//import android.content.ContentValues
//import android.content.Context
//import android.database.Cursor
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteOpenHelper
//
//class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
//    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
//
//    override fun onCreate(db: SQLiteDatabase) {
//
//        val query = ("CREATE TABLE " + TABLE_NAME + " ("
//                + ID_COL + " INTEGER PRIMARY KEY, " +
//                NAME_COl + " TEXT," +
//                EMAIL_COL + " TEXT," +
//                PHONE_COL + " TEXT," +
//                PASSWORD_COL + " TEXT" + ")")
//
//        db.execSQL(query)
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
//        // this method is to check if table already exists
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
//        onCreate(db)
//    }
//
//    // This method is for adding data in our database
//    fun addUser(name : String, email : String, phone: String, password : String ){
//
//        val values = ContentValues()
//
//        values.put(NAME_COL, name)
//        values.put(EMAIL_COL, email)
//        values.put(PHONE_COL, phone)
//        values.put(PASSWORD_COL, password)
//
//        val db = this.writableDatabase
//
//        // all values are inserted into database
//        db.insert(TABLE_NAME, null, values)
//
//        // at last we are
//        // closing our database
//        db.close()
//    }
//
//
//    fun getUser(email : String) {
//
//        val db = this.readableDatabase
//
//        return db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $EMAIL_COL = ?", arrayOf(email)).use {
//            if (it.moveToFirst()) {
//                return it.getString(it.getColumnIndex(NAME_COL))
//            }
//        }
//        return null
//
//    }
//
//    companion object{
//        private val DATABASE_NAME = "RezerveGaldinu"
//
//        private val DATABASE_VERSION = 1
//
//        val TABLE_NAME = "user"
//
//        val ID_COL = "id"
//
//        val NAME_COL = "name"
//
//        val EMAIL_COL = "email"
//
//        val PHONE_COL = "phone"
//
//        val PASSWORD_COL = "password"
//    }
//}