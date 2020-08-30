package com.hfad.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{
        //TODO  FIX ME!!!
        if (fullName == "null" || fullName == "" || fullName == " ") return null to null

        var parts : List<String>? = fullName?.split(" ")
        if (parts?.size == 1) return parts?.get(0) to null
        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        return firstName to lastName
    }

    fun fillDict(split: String):HashMap<String,String>{
        var dict: HashMap<String,String> = HashMap()
        dict.put("а","a")
        dict.put("а","a")
        dict.put("б","b")
        dict.put("в","v")
        dict.put("г","g")
        dict.put("д","d")
        dict.put("е","e")
        dict.put("ё","e")
        dict.put("ж","zh")
        dict.put("з","z")
        dict.put("и","i")
        dict.put("й","i")
        dict.put("к","k")
        dict.put("л","l")
        dict.put("м","m")
        dict.put("н","n")
        dict.put("о","o")
        dict.put("п","p")
        dict.put("р","r")
        dict.put("с","s")
        dict.put("т","t")
        dict.put("у","u")
        dict.put("ф","f")
        dict.put("х","h")
        dict.put("ц","c")
        dict.put("ч","ch")
        dict.put("ш","sh")
        dict.put("щ","sh'")
        dict.put("ъ","")
        dict.put("ы","i")
        dict.put("ь","")
        dict.put("э","e")
        dict.put("ю","yu")
        dict.put("я","ya")
        dict.put(" ",split)
        return dict
    }

    fun transliteration(payload: String, divider: String=" "): String {
        var dict: HashMap<String,String> = fillDict(divider)
        var res: String=""

        for (i in payload){
            var nextLetter = dict.get(i.toString())
            if (i.isUpperCase()){
                nextLetter = dict.get(i.toString().toLowerCase())
                nextLetter = nextLetter?.get(0).toString().toUpperCase() + nextLetter?.substring(1)
            }
            if (i !in 'а'..'я' && i !in 'А'..'Я' && i != ' ')
                nextLetter = i.toString()
            res+= nextLetter
        }
        return res

        TODO("not implemented")
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var myFirstName: String? = firstName
        var myLastName: String? = lastName
        if (myFirstName == "") myFirstName = null
        if (myLastName == "") myLastName = null

        var initial1 = myFirstName?.get(0)?.toUpperCase()
        var initial2 = myLastName?.get(0)?.toUpperCase()
        var initials: String? = initial1.toString() + initial2.toString()
        initials = initials?.replace("null","")
        if (initials?.trim() == "") return null
        return initials
    }
}