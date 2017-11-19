package Song;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class SongTest {

	private static Song song;
	private static String[] verses;
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		song = new Song();
		String songTxt  = song.sing();
		//System.out.println(songTxt);
		verses = songTxt.split("\n\n");
	}
	
	@Test
	public void testStructureFirstVerse() {
		String[] lines 	  = verses[0].split("\n");
		assertTrue(lines[0].matches("^There was an old lady who swallowed a ([a-z]+)\\.$"));
		assertEquals(lines.length, 2);
	}
	
	@Test
	public void testStructureLastVerse() {
		String[] lines 	  = verses[verses.length - 1].split("\n");
		assertTrue(lines[0].matches("^There was an old lady who swallowed a ([a-z]+)\\.\\.\\.$"));
		assertEquals(lines.length, 2);
	}
	
	@Test
	public void testStructureMiddleVerse() {
		if (verses.length > 2) {
			String firstRhyme = verses[0].split("\n")[1];
			for (int verseIndex = 1; verseIndex < verses.length - 1; verseIndex++) {
				String[] lines = verses[verseIndex].split("\n");
				assertTrue(lines[0].matches("There was an old lady who swallowed a ([a-z]+);"));
				// assert that listing of eaten animals is correct
				for (int lineIndex = 2; lineIndex < lines.length -1; lineIndex++) {
					assertTrue(lines[lineIndex].matches("^She swallowed the ([a-z]+) to catch the ([a-z]+)(,|;)$"));
				}
				// assert last line is equal to rhyme of first verse
				assertEquals(firstRhyme, lines[lines.length - 1]);
				// assert correct size
				assertEquals(verseIndex + 3 ,lines.length);
			}
		}
	}
}
