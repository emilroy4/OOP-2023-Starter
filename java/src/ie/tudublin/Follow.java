//c21716601

package ie.tudublin;

public class Follow {
    private String word;
    private int count;

    public Follow(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void Word(String word) {
        this.word = word;
    }

    public void CountWord(int count) {
        this.count = count;
    }

    public void incrementCount() {
        this.count++;
    }


}
