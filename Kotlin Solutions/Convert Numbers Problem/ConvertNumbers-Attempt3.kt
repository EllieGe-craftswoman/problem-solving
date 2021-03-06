
//Third Attempt - Converting Numbers to Words

fun main() {
    println("Test 1: "+ testNumberConvertor_oneDigit_returnNumberWordWithoutDashes())
    println("Test 2: "+ testNumberConvertor_multipleDigits_returnNumberWordWithDashes())
    println("Test 3: "+ testNumberConvertor_repeatingDigits_returnNumberWordWithDashes())
    println("Test 4: "+ testNumberConvertor_negative_returnNumberWordWithMinusInTheBeginning())
	println("Test 5: "+ testNumberConvertor_changeSeparatorToAsterik_returnNumberInWordsWithNewSeparator())
    println("Test 6: "+ testNumbersConvertor_passGermanLanguage_returnTheNumberWordInGerman())
	println("Test 7: "+ testNumbersConvertor_passEnglishOneDigitWordNumber_returnDigitNumber())
    println("Test 8: "+ testNumbersConvertor_passEnglishMultipleDigitWordNumber_returnDigitNumber())
    println("Test 9: "+ testNumbersConvertor_passEnglishMultipleDigitWordNumberWithCustomSeparator_returnDigitNumber())
    println("Test 10: "+ testNumbersConvertor_passNegativeEnglishWordNumber_returnDigitNumber())
    println("Test 11: " +testNumbersConvertor_passGermanOneDigitWordNumber_returnDigitNumber())
    println("Test 12: " +testNumbersConvertor_passGermanMultipleDigitWordNumber_returnDigitNumber())
    println("Test 13: " +testNumbersConvertor_passGermanMultipleDigitWordNumberWithCustomSeparator_returnDigitNumber())
    println("Test 14: " +testNumbersConvertor_passNegativeGermanWordNumber_returnDigitNumber())
}

fun convertNumber(number: Int, separator: Char = '-', lang: Language = Language.ENGLISH) : String {
    var stringBuilder = StringBuilder()

    for (digit in number.toString().toCharArray()){
        stringBuilder.append(digit.getNumberName(lang) + separator)
    }
    //the last separator isn't required
    stringBuilder.setLength(stringBuilder.length - 1)

    return stringBuilder.toString()
}

fun convertNumber(number: String, separator: Char = '-', lang: Language = Language.ENGLISH) : Int {
    var stringBuilder = StringBuilder()

    for(wordNumber in number.split(separator).toTypedArray()){
        stringBuilder.append(wordNumber.getDigitNumber(lang))
    }
    return stringBuilder.toString().toInt()
}

fun Char.getNumberName(lang: Language = Language.ENGLISH)
= Number.values().find {it.getNumber() == this}?.getName(lang) ?: ""

fun String.getDigitNumber(lang: Language = Language.ENGLISH)
= Number.values().find {it.getName(lang) == this}?.getNumber() ?: ""

enum class Number {
    ZERO('0', "zero", "null"),
    ONE('1', "one", "eins"),
    TWO('2', "two", "zwei"),
    THREE('3', "three", "drei"),
    FOUR('4', "four", "vier"),
    FIVE('5', "five", "funf"),
    SIX('6', "six", "sechs"),
    SEVEN('7', "seven", "sieben"),
    EIGHT('8', "eight", "acht"),
    NINE('9', "nine", "neun"),
    MINUS('-', "minus", "minus");

    var charNumber: Char? = null
    var enName: String? = null
	var gerName: String? = null

    constructor()

    constructor(
    	charNum: Char,
        enName: String,
        gerName: String
    ){
        this.charNumber = charNum
        this.enName = enName
        this.gerName = gerName
    }

    fun getName(nameLang: Language): String? {
         if(nameLang == Language.ENGLISH){
             return enName
         } else if (nameLang == Language.GERMAN){
             return gerName
         } else {
             return charNumber.toString()
         }
    }

    fun getNumber(): Char? {
         return charNumber
    }
}

enum class Language {
    ENGLISH, GERMAN
}

fun testNumberConvertor_oneDigit_returnNumberWordWithoutDashes() = "five" == convertNumber(5)
fun testNumberConvertor_multipleDigits_returnNumberWordWithDashes() = "five-six-one-two" == convertNumber(5612)
fun testNumberConvertor_repeatingDigits_returnNumberWordWithDashes() = "five-six-one-two-five-six-one-two" == convertNumber(56125612)
fun testNumberConvertor_negative_returnNumberWordWithMinusInTheBeginning() = "minus-five-six" == convertNumber(-56)
fun testNumberConvertor_changeSeparatorToAsterik_returnNumberInWordsWithNewSeparator() = "six*three*four" == convertNumber(634, '*')
fun testNumbersConvertor_passGermanLanguage_returnTheNumberWordInGerman()= "zwei-null-neun" == convertNumber(number = 209, lang = Language.GERMAN)
fun testNumbersConvertor_passEnglishOneDigitWordNumber_returnDigitNumber() = 5 == convertNumber("five")
fun testNumbersConvertor_passEnglishMultipleDigitWordNumber_returnDigitNumber() = 56 == convertNumber("five-six")
fun testNumbersConvertor_passEnglishMultipleDigitWordNumberWithCustomSeparator_returnDigitNumber() = 365 == convertNumber(number = "three/six/five", separator = '/')
fun testNumbersConvertor_passNegativeEnglishWordNumber_returnDigitNumber() = -922 == convertNumber("minus-nine-two-two")
fun testNumbersConvertor_passGermanOneDigitWordNumber_returnDigitNumber() = 3 == convertNumber(number = "drei", lang = Language.GERMAN)
fun testNumbersConvertor_passGermanMultipleDigitWordNumber_returnDigitNumber() = 92 == convertNumber(number = "neun-zwei", lang = Language.GERMAN)
fun testNumbersConvertor_passGermanMultipleDigitWordNumberWithCustomSeparator_returnDigitNumber() = 728 == convertNumber(number = "sieben:zwei:acht", separator = ':', lang = Language.GERMAN)
fun testNumbersConvertor_passNegativeGermanWordNumber_returnDigitNumber() = -610 == convertNumber(number = "minus-sechs-eins-null", lang = Language.GERMAN)
