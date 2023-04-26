//c21716601

package ie.tudublin;

public class Follow {
    private String word;
    private int count;

    public Follow(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {//gets a random word
        return word;
    }

    public int getCount() {//get count 
        return count;
    }

    public void Word(String word) {//sets the word
        this.word = word;
    }

    public void CountWord(int count) {//sets word count
        this.count = count;
    }

    public void incrementCount() {//increments the count value by 1
        this.count++;
    }


}
