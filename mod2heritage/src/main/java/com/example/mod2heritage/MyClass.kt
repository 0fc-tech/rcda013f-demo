package com.example.mod2heritage


open class Cle() {
    open fun ouvrirPorte(){
        println("ouverture de porte")
    }
    fun fermerPorte(){
        println("fermerture de porte")
    }
}
class CleVoiture(): Cle(){
    override fun ouvrirPorte() {
        println("Ouverture centralisée")
    }
    fun ouvertureCoffre(){
        println("*Verins is Opening the coffre*")
    }
}