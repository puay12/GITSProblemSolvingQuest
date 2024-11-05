package com.gits.problemsolvingquest.balancedbracket

fun main() {
    var givenString: String
    var quitAnswer: Boolean

    do {
        givenString = getGivenString()
        println("Output : ${identifyBrackets(givenString)}")
        quitAnswer = getQuitAnswer()
    } while (quitAnswer)
    sayGoodBye()
}

private fun identifyBrackets(givenString: String) : String {
    val openingBrackets = arrayOf<Char>('(', '[', '{')
    val closingBrackets = arrayOf<Char>(')', ']', '}')
    val bracketPairs = mapOf<Char,Char>(
        '(' to ')',
        '[' to ']',
        '{' to '}'
    )
    var prevBracket: Char = ' '
    var countOpening = 0
    var countClosing = 0

    givenString.forEach { item ->
        println("prevBracket $prevBracket")
        println("item $item")
        if (item in openingBrackets) {
            countOpening += 1
        } else if (item in closingBrackets) {
            countClosing += 1
        }

        if (countClosing > 0 && item != ' ') {
            if (prevBracket in openingBrackets) {
                if (bracketPairs[prevBracket]!! != item) {
                    return "NO"
                }
            }
        }

        if (item != ' ') {
            prevBracket = item
        }
    }

    return if (countOpening == countClosing) {
        "YES"
    } else {
        "NO"
    }
}

private fun getGivenString() : String {
    var answer: String?

    do {
        println("Brackets dapat terdiri dari : ( , ), [, ], {, atau }")
        println("Contoh input seperti {[()]}")
        print("\nMasukkan brackets (bisa dengan/tanpa spasi): ")
        answer = readlnOrNull()

        if (answer == null || answer == "") {
            println("Brackets harus diisi!\n")
        }
    } while (answer == null || answer == "")

    return answer
}

private fun getQuitAnswer() : Boolean {
    print("\nMau lagi (y/n) ? ")
    val answer: String = readlnOrNull()!!

    return answer == "y" || answer == "Y"
}

private fun sayGoodBye(){
    println("Thank You! See you, Buddy! ლ(╹◡╹ლ)")
}