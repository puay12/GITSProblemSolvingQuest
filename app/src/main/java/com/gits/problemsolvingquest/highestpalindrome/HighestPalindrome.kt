package com.gits.problemsolvingquest.highestpalindrome

fun main() {
    var givenString: String
    var k: Int
    var result: MutableList<Int>
    val distinctNumbers = hashSetOf<Int>()
    var quitAnswer: Boolean

    do {
        givenString = getGivenString()
        k = getK()
        givenString.forEach { it -> distinctNumbers.add(it.digitToInt()) }
        result = getPalindromeList(
            givenString.toInt(), givenString.toInt(), k,
            arrayListOf(), sortDistinctNums(distinctNumbers.toMutableList(),0))
        println("Highest Palindrome : ${getHighestNumber(result, 0, 0)}")
        quitAnswer = getQuitAnswer()
    } while (quitAnswer)
    sayGoodBye()
}

private fun getPalindromeList(
    givenNumber: Int,
    newNumTemp: Int,
    k: Int,
    collectedPalindromes: ArrayList<Int>,
    distinctNumbersTemp: MutableList<Int>
): MutableList<Int> {
    var newNum = newNumTemp

    if (newNum < 10) {
        collectedPalindromes.add(newNum)
    } else {
        val checkResultNum = isPalindrome(newNum, 0)
        if (checkResultNum == newNum) {
            collectedPalindromes.add(newNum)
        } else {
            newNum = changeNumber(givenNumber.toString(), k, distinctNumbersTemp[0])
            distinctNumbersTemp.remove(distinctNumbersTemp[0])
            getPalindromeList(givenNumber, newNum, k, collectedPalindromes, distinctNumbersTemp)
        }
    }

    if (collectedPalindromes.size <= 1) {
        if (newNum.toString().length == 1) {
            return collectedPalindromes
        } else if (distinctNumbersTemp.size > 0) {
            newNum = changeNumber(givenNumber.toString(), k, distinctNumbersTemp[0])
            distinctNumbersTemp.remove(distinctNumbersTemp[0])
            getPalindromeList(givenNumber, newNum, k, collectedPalindromes, distinctNumbersTemp)
        } else {
            collectedPalindromes.add(-1)
        }
    }

    return collectedPalindromes
}

private fun getHighestNumber(palindromes: MutableList<Int>, position: Int, resultTemp: Int) : Int {
    var result = resultTemp

    if (position == palindromes.size) {
        return result
    }

    if (palindromes[position] > result) {
        result = palindromes[position]
    }

    return getHighestNumber(palindromes, position+1, result)
}
private fun sortDistinctNums(numbers: MutableList<Int>, i: Int) : MutableList<Int> {
    val length = numbers.size

    if (i == length/2) {
        return numbers
    }

    val firstHalf: Int = numbers[i]

    numbers[i] = numbers[length-i-1]
    numbers[length-i-1] = firstHalf

    return sortDistinctNums(numbers, i+1)
}

private fun isPalindrome(number: Int, revertedTemp: Int) : Int {
    var reverted = revertedTemp

    if (number == 0) {
        return reverted
    }
    reverted = reverted * 10 + number % 10

    return isPalindrome(number/10, reverted)
}

private fun changeNumber(numString: String, k: Int, changers: Int) : Int {
    var newString = numString

    if (k > 0) {
        if (newString.get(1).digitToInt() > changers) {
            newString = newString.replace(newString.get(1), changers.digitToChar())
        } else {
            if (newString.get(newString.length-2).digitToInt() < changers) {
                newString = newString.replace(newString.get(newString.length-2), changers.digitToChar())
            }
        }

        changeNumber(newString, k-1, changers)
    }

    return newString.toInt()
}

private fun getGivenString() : String {
    var answer: String?

    do {
        print("\nMasukkan sebuah angka : ")
        answer = readlnOrNull()

        if (answer == null || answer == "") {
            println("Angka harus diisi!\n")
        }
    } while (answer == null || answer == "")

    return answer
}

private fun getK() : Int {
    var answer: String?

    do {
        print("Masukkan k (1 s/d length) : ")
        answer = readlnOrNull()

        if (answer == null || answer == "") {
            println("Nilai k harus diisi!\n")
        }
    } while (answer == null || answer == "")

    return answer.toInt()
}

private fun getQuitAnswer() : Boolean {
    print("\nMau lagi (y/n) ? ")
    val answer: String = readlnOrNull()!!

    return answer == "y" || answer == "Y"
}

private fun sayGoodBye(){
    println("Thank You! See you, Buddy! ლ(╹◡╹ლ)")
}

