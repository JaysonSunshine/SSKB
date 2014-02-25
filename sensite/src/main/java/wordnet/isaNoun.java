/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wordnet;

import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.*;

/**
 * Returns 0 if a noun, 1 if not a noun.
 * @author Jay
 */
public class isaNoun {
    
    public static int isaNoun(String word){
        //SynsetType object;
        
        WordNetDatabase database = WordNetDatabase.getFileInstance();
        Synset[] synsets = database.getSynsets(word, SynsetType.NOUN , false);
        
        System.out.println(synsets.length);
        if(synsets.length == 0){
            //System.out.println(test + " not a noun");
            return 1;
        }
        else{
            //System.out.println(test + " is a noun");
            return 0;
        }

        }
    
}
