package Song;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Song can be made configurable by setting the animals + their respective rhymes
 * 
 * @author heiko
 *
 */
class Song {
	
	/**
	 * All the verses as a list
	 */
	private List<String> verses;
	
	/**
	 * A list of animals for the song in the correct eating order
	 */
	private List<String> animals;
	
	/**
	 * map of animals to corresponding rhymes
	 */
	private Map<String, String> rhymes;
	
	/**
	 * 
	 */
	public Song() {
		super();
		verses  = new ArrayList<>();
		animals = new ArrayList<>();
		rhymes  = new HashMap<>();
	}

	/**
	 * Create a song for a list of animals
	 * 
	 * @param animals
	 * @return the actual song
	 * @throws Exception
	 */
    public String sing() throws Exception {
    	if (animals.isEmpty()) {
    		setDefaultAnimals();
    	}
    	if (rhymes.isEmpty()) {
    		setDefaultRhymes();
    	}
    	for (int animalIndex = 0; animalIndex < animals.size(); animalIndex++) {
			addVerse(createVerse(animalIndex));
		}
    	return toString();
    }
    
    /**
     * Creates an entire verse for a given animal
     * 
     * @param animalIndex
     * @return one verse for an animal
     * @throws Exception
     */
    private String createVerse(int animalIndex) throws Exception {
    	StringBuilder verse = new StringBuilder();
		String animal    	= animals.get(animalIndex);
		
		String endOfLine 	= isFirstVerse(animalIndex) ? "." : ";";
		endOfLine           = isLastVerse(animalIndex)  ? "..." : endOfLine;
		
		verse.append("There was an old lady who swallowed a " + animal + endOfLine);
		verse.append("\n");
		verse.append(getRhyme(animal));
		
		if (!isFirstVerse(animalIndex) && !isLastVerse(animalIndex)) {
			
			// add the list of eaten animals
			for (int eatingIndex = animalIndex; eatingIndex > 0; eatingIndex--) {
				verse.append("\n");
				verse.append("She swallowed the " + animals.get(eatingIndex) + " to catch the " + animals.get(eatingIndex - 1));
				verse.append(eatingIndex == 1 ? ";" : ",");
			}
			
			// add the rhyme of the first animal again
			verse.append("\n");
			verse.append(getRhyme(animals.get(0)));
		}
		
    	return verse.toString();
    }
    
    /**
     * Returns a rhyme for a given animal, if there is none an Exception is thrown
     * 
     * @param animal
     * @return
     * @throws Exception
     */
    private String getRhyme(String animal) throws Exception {
    	if (rhymes.containsKey(animal)) {
    		return rhymes.get(animal);
    	}
    	throw new Exception("The given animal has no corresponding rhyme: " + animal);
    }
    
    /**
     * @return a formatted song
     */
    public String toString() {
		StringBuilder song = new StringBuilder();
		for (int verseIndex = 0; verseIndex < verses.size(); verseIndex++) {
			song.append(verses.get(verseIndex));
			if (!isLastVerse(verseIndex)) {
				song.append("\n\n");
			}
		}
		return song.toString();
	}
    
    /**
     * Default animals 
     */
    private void setDefaultAnimals() {
    	animals.add("fly");
    	animals.add("spider");
    	animals.add("bird");
    	animals.add("cat");
    	animals.add("dog");
    	animals.add("cow");
    	animals.add("horse");
    }
    
    /**
     * Default rhymes
     */
    private void setDefaultRhymes() {
    	rhymes.put("fly", "I don't know why she swallowed a fly - perhaps she'll die!");
    	rhymes.put("spider", "That wriggled and wiggled and tickled inside her.");
    	rhymes.put("bird", "How absurd to swallow a bird.");
    	rhymes.put("cat", "Fancy that to swallow a cat!");
    	rhymes.put("dog", "What a hog, to swallow a dog!");
    	rhymes.put("cow", "I don't know how she swallowed a cow!");
    	rhymes.put("horse", "..She's dead of course!");
    }
    
	/**
	 * @param verse
	 */
	private void addVerse(String verse) {
		verses.add(verse);
	}
    
	/**
	 * @param animals
	 */
	public void setAnimals(List<String> animals) {
		this.animals = animals;
	}

	/**
	 * @param rhymes
	 */
	public void setRhymes(Map<String, String> rhymes) {
		this.rhymes = rhymes;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	private boolean isFirstVerse(int index) {
		return index == 0;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	private boolean isLastVerse(int index) {
		return index == (animals.size() -1);
	}
}