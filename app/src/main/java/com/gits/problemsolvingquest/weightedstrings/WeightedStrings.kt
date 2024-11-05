package com.gits.problemsolvingquest.weightedstrings

fun main() {
    var givenString: String
    var arrayQueries: ArrayList<Int>
    var quitAnswer: Boolean

    do {
        givenString = getGivenString()
        arrayQueries = getArrayQueries()
        findNumberStatus(givenString, arrayQueries)
        quitAnswer = getQuitAnswer()
    } while (quitAnswer)
    sayGoodBye()
}

private fun findNumberStatus(givenString: String, queries: ArrayList<Int>) {
    val collectedWeights = findWeightsAndPrint(givenString)
    val status = arrayListOf<String>()

    queries.forEach { item ->
        if (item in  collectedWeights) {
            status.add("Yes")
        } else {
            status.add("No")
        }
    }

    println("Query Numbers : $queries")
    println("Query Numbers Status : $status")
    collectedWeights.clear()
    status.clear()
}

private fun findWeightsAndPrint(givenString: String) : ArrayList<Int> {
    var sameString: String = givenString.lowercase().substring(0,1)
    var weight: Int
    val collectedWeights = arrayListOf<Int>()
    var count = 0
    val weightDict = getWeightDict()

    println("\nOUTPUT")
    givenString.lowercase().forEach { item ->
        weight = weightDict[item]!!

        if (sameString.contains(item) && count > 0) {
            sameString += item
            weight *= sameString.length
        } else {
            sameString = item.toString()
        }

        if (sameString.length > 1) {
            println("$sameString = $weight")
        } else {
            println("$item = $weight")
        }

        collectedWeights.add(weight)
        count+=1
    }

    return collectedWeights
}

private fun getWeightDict() : Map<Char, Int> {
    return mapOf<Char, Int>(
        'a' to 1,
        'b' to 2,
        'c' to 3,
        'd' to 4,
        'e' to 5,
        'f' to 6,
        'g' to 7,
        'h' to 8,
        'i' to 9,
        'j' to 10,
        'k' to 11,
        'l' to 12,
        'm' to 13,
        'n' to 14,
        'o' to 15,
        'p' to 16,
        'q' to 17,
        'r' to 18,
        's' to 19,
        't' to 20,
        'u' to 21,
        'v' to 22,
        'w' to 23,
        'x' to 24,
        'y' to 25,
        'z' to 26
    )
}

private fun getGivenString() : String {
    var answer: String?

    do {
        print("\nMasukkan sebuah kata TANPA spasi : ")
        answer = readlnOrNull()

        if (answer == null || answer == "") {
            println("Kata/kalimat harus diisi!")
        }
    } while (answer == null || answer == "")

    return answer
}

private fun getArrayQueries() : ArrayList<Int> {
    var queries: ArrayList<Int>
    var answer: String?

    println("\nQUERIES")
    println("1. Pisahkan tiap angka queries dengan koma TANPA spasi")
    println("2. Angka adalah bilangan positif minimal 1 dan tidak ada maksimal")
    println("Misalnya 1,2,3,5")

    do {
        print("\nMasukkan angka queries : ")
        answer = readlnOrNull()

        if (answer == null  || answer == "") {
            println("Queries harus diisi!")
        }
    } while (answer == null || answer == "")

    queries = answer.split(",").map { item -> item.toInt() } as ArrayList<Int>

    return queries
}

private fun getQuitAnswer() : Boolean {
    print("\nMau lagi (y/n) ? ")
    val answer: String = readlnOrNull()!!

    return answer == "y" || answer == "Y"
}

private fun sayGoodBye(){
    println("Thank You! See you, Buddy! ლ(╹◡╹ლ)")
}