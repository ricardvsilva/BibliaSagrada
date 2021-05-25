package com.rick.bibliasagrada3

class Linha(var capitulo:Int, var versiculo:Int, var palavra:String) {

    constructor (
                    linha: Int,
                    testamento: String,
                    livro: String,
                    capitulo: Int,
                    versiculo: Int,
                    palavra: String): this(capitulo, versiculo,palavra)

}



/*
data class Linha(
    val linha:Int,
    val testamento:String,
    val livro:String,
    val capitulo:Int,
    val versiculo:Int,
    val palavra:String)

    constructor(capitulo:Int, versiculo:Int, palavra:String) :
            this(capitulo2 = capitulo, versiculo2 = versiculo,palavra2 = palavra)
*/

