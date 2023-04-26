//c21716601
package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;

public class DANI extends PApplet {
	ArrayList<Word> model = new ArrayList<>();
	String[] sonnet;

	public void settings() {
		size(1000, 1000);
		// fullScreen(SPAN);
	}

	// generates the sonnet
	public String[] writeSonnet() {
		String[] sonnet = new String[14];
		for (int i = 0; i < 14; i++) {
			sonnet[i] = writeLine();
		}
		return sonnet;
	}

	// Add words to the line until either 8 words are added or there is no next word

	public String writeLine() {
		StringBuilder sb = new StringBuilder();
		int wordCount = 0;
		Word currentWord = model.get((int) random(model.size()));

		while (currentWord != null && wordCount < 8) {
			sb.append(currentWord.getWord()).append(" ");
			currentWord = pickRandomFollow(currentWord);
			wordCount++;
		}

		return sb.toString().trim();
	}

	//pick a random word from the txt file
	public Word pickRandomFollow(Word word) {
		if (word.getFollows().size() == 0) {
			return null;
		}

		String randomFollowWord = word.getFollows().get((int) random(word.getFollows().size())).getWord();
		return findWord(randomFollowWord);
	}

	public void initializeModel(String filename) {
		loadFile(filename);
	}

	public void setup() {
		colorMode(HSB);
		initializeModel("shakespere.txt");//load the shakespeare file
		sonnet = writeSonnet();//generate sonnet
		for (String line : sonnet) {
			println(line);
		}
	}

	// spacebar changes sonnet
	public void keyPressed() {
		if (key == ' ') {
			sonnet = writeSonnet();
		}
	}

	float off = 0;

	public void draw() {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
		textAlign(CENTER, CENTER);

		float lineHeight = height / 18;
		float yOffset = (height - lineHeight * sonnet.length) / 2;

		for (int i = 0; i < sonnet.length; i++) {
			text(sonnet[i], width / 2, yOffset + (i * lineHeight));
		}
	}

	public void loadFile(String filename) {
		String[] lines = loadStrings(filename);
		String prevWord = null;

		for (String line : lines) {
			String[] words = split(line, ' ');

			for (String w : words) {
				w = w.replaceAll("[^\\w\\s]", "").toLowerCase();

				if (prevWord != null) {
					Word wordObj = findWord(prevWord);
					if (wordObj == null) {
						wordObj = new Word(prevWord);
						model.add(wordObj);
					}

					Follow followObj = wordObj.findFollow(w);
					if (followObj == null) {
						wordObj.addFollow(new Follow(w, 1));
					} else {
						followObj.incrementCount();
					}
				}
				prevWord = w;
			}
		}
	}
	//if the word matches it returns, if not it will return null
	public Word findWord(String str) {
		for (Word wordObj : model) {
			if (wordObj.getWord().equals(str)) {
				return wordObj;
			}
		}
		return null;
	}

	// prints to terminal
	public void printModel() {
		for (Word wordObj : model) {
			println(wordObj.toString());
		}
	}

}