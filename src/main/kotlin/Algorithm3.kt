object GroupAnagram {
    // Write a function that takes in an array of strings and returns a list of
    // groups of anagrams. Anagrams are strings made up of exactly the same letters,
    // where order doesn't matter. For example, "cinema" and "iceman" are anagrams;
    // similarly, "foo" and "ofo" are anagrams. Note that the groups of anagrams don't
    // need to be ordered in any particular way.
            /* Space and Time Complexity Analysis*/
    // O(w * n * log(n)) time | O(wn) space - where w is the number of words and
    //# n is the length of the longest word
    fun groupAnagram(words: Array<String>): List<List<String>> {
         var hashMap = hashMapOf<String, MutableList<String>>()

        for (word in words){
            var currentWord = word.toCharArray().sorted().joinToString("")
            if (hashMap.containsKey(currentWord)){
                hashMap[currentWord]?.add(word)
            }else{
                hashMap[currentWord] = mutableListOf(word)
            }
        }
        return hashMap.map { it.value }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var words1 = arrayOf("zxc", "asd", "weq", "sda", "qwe", "xcz")
        var expected1 = listOf(listOf("zxc", "xcz"), listOf("asd", "sda"), listOf("qwe", "weq"))
        var words = arrayOf("yo", "act", "flop", "tac", "cat", "oy", "olfp")
        println(groupAnagram(words1))
    }
}