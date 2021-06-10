package com.rick.bibliasagrada3

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoDeDados(context:Context) : SQLiteOpenHelper(context, DB_NAME, null, VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun selectToRecycler(codigo:Int): String? {

        val db:SQLiteDatabase = this.readableDatabase
        var cursor: Cursor?
        val selectionArgs = arrayOf(codigo.toString())
        cursor = db.query(TABELA_CLIENTE,
            arrayOf(COLUNA_LINHA, COLUNA_TESTAMENTO, COLUNA_LIVRO, COLUNA_CAPITULO, COLUNA_VERSICULO, COLUNA_PALAVRA),
            "$COLUNA_LINHA = ?",selectionArgs , null, null, null)

        if(cursor != null){
            cursor.moveToFirst()
        }

        var cliente = Linha(
            cursor.getInt(0),
            cursor.getString(1),
            cursor.getString(2),
            cursor.getInt(3),
            cursor.getInt(4),
            cursor.getString(5)
        )

        var linhaParaMostrar:String =  cursor.getInt(3).toString()+"/"+ cursor.getInt(4).toString() +"-"+ cursor.getString(5)

        /*var cliente = Linha(
            cursor.getString(0).toInt(),    // LINHA - INT
            cursor.getString(1),            // TESTAMENTO - STRING
            cursor.getString(2),            // LIVRO - STRING
            cursor.getString(3).toInt(),    // CAPÍTULO - INT
            cursor.getString(4).toInt(),    // VERSÍCULO - INT
            cursor.getString(5)             // PALAVRA - STRING
        )*/

        //return cliente.toString()
        //return cursor.getString(5)
        return linhaParaMostrar
    }

    fun selectToTitle(codigo:Int): String? {

        val db:SQLiteDatabase = this.readableDatabase
        var cursor: Cursor?
        val selectionArgs = arrayOf(codigo.toString())
        cursor = db.query(TABELA_CLIENTE,
            arrayOf(COLUNA_LINHA, COLUNA_TESTAMENTO, COLUNA_LIVRO, COLUNA_CAPITULO, COLUNA_VERSICULO, COLUNA_PALAVRA),
            "$COLUNA_LINHA = ?",selectionArgs , null, null, null)

        if(cursor != null){
            cursor.moveToFirst()
        }

        var cliente = Linha(
            cursor.getInt(0),
            cursor.getString(1),
            cursor.getString(2),
            cursor.getInt(3),
            cursor.getInt(4),
            cursor.getString(5)
        )

        var TitleToShow:String =  cursor.getString(1) +" - LIVRO: "+ cursor.getString(2) + " - CAPITULO: " + cursor.getInt(3)

        /*var cliente = Linha(
            cursor.getString(0).toInt(),    // LINHA - INT
            cursor.getString(1),            // TESTAMENTO - STRING
            cursor.getString(2),            // LIVRO - STRING
            cursor.getString(3).toInt(),    // CAPÍTULO - INT
            cursor.getString(4).toInt(),    // VERSÍCULO - INT
            cursor.getString(5)             // PALAVRA - STRING
        )*/

        //return cliente.toString()
        //return cursor.getString(5)
        return TitleToShow
    }

    companion object{
        const val DB_NAME = "biblia1"
        const val VERSION = 1
        @SuppressLint("SdCardPath")
        const val LOCALDB = "/data/data/com.rick.bibliasagrada3/databases/"

        const val TABELA_CLIENTE = "tbBiblia1"
        const val COLUNA_LINHA = "linha"
        const val COLUNA_TESTAMENTO = "testamento"
        const val COLUNA_LIVRO = "livro"
        const val COLUNA_CAPITULO = "capitulo"
        const val COLUNA_VERSICULO = "versiculo"
        const val COLUNA_PALAVRA = "palavra"

    }
}