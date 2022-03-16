
//First Attempt - Converting Numbers to Words

fun main() {
    println("Test 1: "+ testNumberConvertor_oneDigit_returnNumberWordWithoutDashes())
    println("Test 2: "+ testNumberConvertor_multipleDigits_returnNumberWordWithDashes())
    println("Test 3: "+ testNumberConvertor_repeatingDigits_returnNumberWordWithDashes())
    println("Test 4: "+ testNumberConvertor_negative_returnNumberWordWithMinusInTheBeginning())
    println("Test 5: "+ testNumberConvertor_changeSeparatorToAsterik_returnNumberInWordsWithNewSeparator())
    println("Test 6: "+ testNumbersConvertor_passGermanLanguage_returnTheNumberWordInGerman())
// println(convertNumberToWords(-1))
}

fun convertNumberToWords(number: Int, separator: Char = '-', lang: Language = Language.ENGLISH) : String {
    var stringBuilder = StringBuilder()

    for (digit in number.toString().toCharArray()){
        stringBuilder.append(digit.getNumberName(lang) + separator)
    }
    //the last dash isn't required
    stringBuilder.setLength(stringBuilder.length - 1)

    return stringBuilder.toString()
}

fun Char.getNumberName(lang: Language = Language.ENGLISH) : String = when(this) {
    '0' -> if(lang == Language.GERMAN) "null" else "zero"
    '1' -> if(lang == Language.GERMAN) "eins" else "one"
    '2' -> if(lang == Language.GERMAN) "zwei" else "two"
    '3' -> if(lang == Language.GERMAN) "drei" else "three"
    '4' -> if(lang == Language.GERMAN) "vier" else "four"
    '5' -> if(lang == Language.GERMAN) "funf" else "five"
    '6' -> if(lang == Language.GERMAN) "sechs" else "six"
    '7' -> if(lang == Language.GERMAN) "sieben" else "seven"
    '8' -> if(lang == Language.GERMAN) "acht" else "eight"
    '9' -> if(lang == Language.GERMAN) "neun" else "nine"
    '-' -> "minus"
    else -> ""
}



enum class Language {
    ENGLISH, GERMAN
}



// test cases:
//one number - return without dashes
fun testNumberConvertor_oneDigit_returnNumberWordWithoutDashes() : Boolean = "five" == convertNumberToWords(5)
//3 digit number - return with dashes in between
fun testNumberConvertor_multipleDigits_returnNumberWordWithDashes() : Boolean = "five-six-one-two" == convertNumberToWords(5612)
////repeating number - return normally with dashes
fun testNumberConvertor_repeatingDigits_returnNumberWordWithDashes() : Boolean = "five-six-one-two-five-six-one-two" == convertNumberToWords(56125612)
//negative number - write minus
fun testNumberConvertor_negative_returnNumberWordWithMinusInTheBeginning() : Boolean = "minus-five-six" == convertNumberToWords(-56)
// changing the default separator to *
fun testNumberConvertor_changeSeparatorToAsterik_returnNumberInWordsWithNewSeparator(): Boolean = "six*three*four" == convertNumberToWords(634, '*')
// Changing default language to german
fun testNumbersConvertor_passGermanLanguage_returnTheNumberWordInGerman() : Boolean = "zwei-null-neun" == convertNumberToWords(number = 209, lang = Language.GERMAN)
