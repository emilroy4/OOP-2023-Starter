//c21716601

package ie.tudublin;

import java.util.ArrayList;

public class Word {//represents a word in the model that is used to generate sonnets
    private String word;
    private ArrayList<Follow> follows;

    //constuctor
    public Word(String word) {
        this.word = word;
        follows = new ArrayList<>();
    }

    public String getWord() {
        return word;
    }

    public ArrayList<Follow> getFollows() {
        return follows;
    }
    //sets the word to the string that is used to generate sonnets
    public void SetWord(String word) {
        this.word = word;
    }
//adds a follow object to the arraylist
    public void addFollow(Follow follow) {
        follows.add(follow);
    }
    //a method that returns null if there is no match
    public Follow findFollow(String str) {
        for (Follow follow : follows) { 
            if (follow.getWord().equals(str)) {
                return follow;
            }
        }
        return null;
    }

 
}