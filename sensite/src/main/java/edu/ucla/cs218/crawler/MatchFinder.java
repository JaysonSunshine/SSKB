package edu.ucla.cs218.crawler;

import java.util.List;

/**
 *
 * @author Alvin
 */

/* 
*  This class takes a sentence as input and produces a list of possible
*  phenomenon or sensor matches as output.
*/ 
public class MatchFinder {
    
    public List<String> FindMatches(String text) {
        String splitOn = "[ ]+";                // Split on spaces
        String[] words = text.split(splitOn);   // Stores all tokenized words
        String currentWord;                     // Current word being parsed
        List<String> possibleMatches;        // Stores matches found by autocomplete
        List<String> matches;                // Stores found matches
        
        // Iterate through all words to find matches
        for(int i = 0; i < words.length; i++) {
            currentWord = words[i];
            //if(!isNoun(currentWord))
            //   continue;
            /*
            * if(getMatches(currentWord, possibleMatches)) {
            *   int pos = i+1;
            *   if(pos < words.length) {
            *     currentWord = currentWord + " " + words[pos];
            *     for(String pMatch : possibleMatches) {
            *       if(pMatch == currentWord)
            *           matches.add(currentWord);
            *     }
            *   }
            * }
            *               ALTERNATIVELY
            *
            * if(getMatches(currentWord, possibleMatches)) {
            *   for(String pMatch : possibleMatches) {
            *       if(text.contains(pMatch))
            *           matches.add(pMatch);
            *   }
            * }
            */
        }
        return matches;
    }
    
    private void getMatches(String word, List<String> matches) {
        /*      GOOGLE AUTOCOMPLETE CODE
        * TAKE FIRST 3 AUTOCOMPLETE WORDS FOR THE WORD INPUT AND ADD TO MATCHES
        * autocomplete(word, matches);
        *
        *       WORDNET MATCHES
        * USE MATCHES FOUND BY GOOGLE AUTOCOMPLETE AND ADD MATCHES FOUND BY
        * WORDNET USING THOSE MATCHES
        * wordnet(matches);
        */
    }
}


