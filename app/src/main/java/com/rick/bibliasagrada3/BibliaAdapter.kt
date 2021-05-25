package com.rick.bibliasagrada3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BibliaAdapter(private val line: ArrayList<Linha>) : RecyclerView.Adapter<BibliaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.oneline,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val linha:Linha = line[position]
        //holder.txtRcvLinha.text = linha.linha.toString()
        //holder.txtRcvTestamento.text = linha.testamento
        //holder.txtRcvLivro.text = linha.livro
        //holder.txtRcvCapitulo.text = linha.capitulo.toString()
        //holder.txtRcvVersiculo.text = linha.versiculo.toString()
        holder.txtRcvPalavra.text = linha.palavra
    }

    override fun getItemCount(): Int {
        return line.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //val txtRcvLinha = itemView.findViewById(R.id.txtLinha) as TextView
        //val txtRcvTestamento = itemView.findViewById(R.id.txtTestamento) as TextView
        //val txtRcvLivro = itemView.findViewById(R.id.txtLivro) as TextView
        //val txtRcvCapitulo = itemView.findViewById(R.id.txtCapitulo) as TextView
        //val txtRcvVersiculo = itemView.findViewById(R.id.txtVersiculo) as TextView
        val txtRcvPalavra = itemView.findViewById(R.id.txtPalavra) as TextView
    }

}