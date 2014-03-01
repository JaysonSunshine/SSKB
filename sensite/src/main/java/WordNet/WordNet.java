/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WordNet;

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;
import edu.smu.tspell.wordnet.*;
import java.io.File;
import java.io.IOException;
import java.lang.System.*;

/**
 * Returns 0 if a noun, 1 if not a noun.
 *
 * @author Jay
 */

public class WordNet {
    
    public static void main(String[] args) throws IOException{
        System.setProperty("wordnet.database.dir", "C:\\Program Files (x86)\\WordNet\\2.1\\dict"); 
        WordNet test = new WordNet();
        test.isaNoun("is");
        test.isaNoun("dog");
        test.isaNoun("explode");
        test.isaNoun("run");
        test.isaNoun("radiation");

    }
    
    //
    
    public boolean isaNoun(String word) throws IOException{
        //SynsetType object;
        //System.out.println("#############");

        //File file = new File("index.sense");
        //System.out.println(file.getCanonicalPath());
        WordNetDatabase database = WordNetDatabase.getFileInstance();
        Synset[] synsets = database.getSynsets(word, SynsetType.NOUN , false);
        
        //System.out.println(synsets.length);
        if(synsets.length == 0){
            System.out.println(word + " not a noun");
            return false;
        }
        else{
            System.out.println(word + " is a noun");
            return true;
        }

        }
    
}
