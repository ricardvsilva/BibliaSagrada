package com.rick.bibliasagrada3

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.*

class MainActivity : AppCompatActivity() {

    private var mBancoDeDados: BancoDeDados? = null
    val context:Context = this
    var db = BancoDeDados(context)

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun iniciaRcvBiblia(){
        val recyclerView = findViewById<RecyclerView>(R.id.rcvBiblia)
        recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        val user = ArrayList<Linha>()

        var i=1

        while(i<=50){
            val palavra1:String = db.seleciona(i).toString()
            user.add(Linha(1,1," ${palavra1}"))
            i++
        }
        val adapter = BibliaAdapter(user)
        recyclerView.adapter = adapter
    }

    private fun iniciaBancoDeDados() {
        mBancoDeDados = BancoDeDados(this)
        val database: File = applicationContext.getDatabasePath(BancoDeDados.DB_NAME)
        if (!database.exists()) {
            mBancoDeDados!!.readableDatabase
            if (copiaBanco(this)) {
                alert("Banco copiado com sucesso")
            } else {
                alert("Erro ao copiar o banco de dados")
            }
        }
    }

    private fun copiaBanco(context: Context): Boolean {
        return try {
            // inp recebe endereço banco externo
            val inputStream = context.assets.open(BancoDeDados.DB_NAME)
            // out onde ficará o banco e nome do banco
            val outFile: String = BancoDeDados.LOCALDB + BancoDeDados.DB_NAME
            // outstream aponta para o endereço externo do arquivo.
            val outputStream: OutputStream = FileOutputStream(outFile)
            // cria a variável buff e configura ela como byte Array de 1 K byte
            val buff = ByteArray(1024)
            // cria variável largura como inteira e zera ela
            var length: Int
            // LOOP
            while (inputStream.read(buff).also { length = it } > 0) {
                outputStream.write(buff, 0, length)
            }
            outputStream.flush()
            outputStream.close()
            true
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            false
        } catch (e: IOException) {
            e.printStackTrace()
            false
        }
    }

    private fun alert(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show()
    }

    fun AcaoBotao(view: View) {
        iniciaBancoDeDados()
        Toast.makeText(this, "Apertado",Toast.LENGTH_SHORT).show()
    }

    fun SelectAndShow(view: View) {
        /*val txtBanco:TextView = findViewById(R.id.txtBanco)
        txtBanco.text = db.seleciona(33)*/
        iniciaRcvBiblia()
    }

}