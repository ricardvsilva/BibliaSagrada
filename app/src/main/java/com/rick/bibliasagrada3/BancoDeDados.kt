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

    fun seleciona(codigo:Int): String? {

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
            cursor.getString(0).toInt(),
            cursor.getString(1),
            cursor.getString(2),
            cursor.getString(3).toInt(),
            cursor.getString(4).toInt(),
            cursor.getString(5),
        )
        return cursor.getString(5)
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