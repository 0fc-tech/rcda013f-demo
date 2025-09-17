package com.example.mod2classe

data class Travail(
    val intitulePoste : String,
    val salaireAnnuel : Int,
    var isCadre : Boolean,
    var ville : String?
)
fun main() {
    val developpeurNantais = Travail(
        "Développeur(se)",
        34000, true, "Nantes")
    println("Le/la ${developpeurNantais.intitulePoste} travaille à ${developpeurNantais.ville}")
    val designerTeleTravail = Travail(
        "Designer(euse)",
        44000,true,null)
    println("Le/la ${designerTeleTravail.intitulePoste} travaille à ${designerTeleTravail.ville}")
    val dirigeantESN = Travail(
        "PDG",74000,true,"Paris")
    println("Le/la ${dirigeantESN.intitulePoste} travaille à ${dirigeantESN.ville}")

}

open class Personne{

    var firstname : String = ""

    constructor(prenom : String){
        this.firstname = prenom
    }

    open fun getTruc(){
        println("Truc")
    }
}

