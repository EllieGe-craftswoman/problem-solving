
//Second Attempt - Converting Numbers to Words

fun main() {
    println("Test 1: "+ testNumberConvertor_oneDigit_returnNumberWordWithoutDashes())
    println("Test 2: "+ testNumberConvertor_multipleDigits_returnNumberWordWithDashes())
    println("Test 3: "+ testNumberConvertor_repeatingDigits_returnNumberWordWithDashes())
    println("Test 4: "+ testNumberConvertor_negative_returnNumberWordWithMinusInTheBeginning())
	println("Test 5: "+ testNumberConvertor_changeSeparatorToAsterik_returnNumberInWordsWithNewSeparator())
    println("Test 6: "+ testNumbersConvertor_passGermanLanguage_returnTheNumberWordInGerman())
// println(convertNumberToWords(number = 209, lang = Language.GERMAN))


   // println(Number.findByValue("nine"))
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

fun Char.getNumberName(lang: Language = Language.ENGLISH) : String {
    var deducedNumber = when(this) {
    		'0' -> Number.ZERO
    		'1' -> Number.ONE
    		'2' -> Number.TWO
    		'3' -> Number.THREE
    		'4' -> Number.FOUR
    		'5' -> Number.FIVE
    		'6' -> Number.SIX
    		'7' -> Number.SEVEN
    		'8' -> Number.EIGHT
    		'9' -> Number.NINE
    		'-' -> Number.MINUS
    		else -> null
		}
    if(deducedNumber != null){
        return deducedNumber.getName(lang) ?: ""
    } else {
        return ""
    }
}

enum class Number{
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
        this.charNumber = charNumber
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

    fun getNumber(name: String, nameLang: Language): String? {
         if(nameLang == Language.ENGLISH){
             return enName
         } else if (nameLang == Language.GERMAN){
             return gerName
         } else {
             return charNumber.toString()
         }
    }
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
