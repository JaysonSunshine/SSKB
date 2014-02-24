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
    
    public String[] FindMatches(String text) {
        String splitOn = "[ ]+";                // Split on spaces
        String[] words = text.split(splitOn);   // Stores all tokenized words
        String currentWord;                     // Current word being parsed
        String[] possibleMatches;        // Stores matches found by autocomplete
        List<String> matches;                // Stores found matches
        
        // Iterate through all words to find matches
        for(int i = 0; i < words.length; i++) {
            currentWord = words[i];
            /*
            * if(getMatches(currentWord, possibleMatches)){
            *   int pos = i+1;
            *   if(pos < words.length) {
            *     currentWord = currentWord + " " + words[pos];
            *     for(String pMatch : possibleMatches) {
                    if(pMatch == currentWord)
                        matches.add(currentWord);
            *     }
            *   }
            * }
            */
        }
        return matches;
    }
}
