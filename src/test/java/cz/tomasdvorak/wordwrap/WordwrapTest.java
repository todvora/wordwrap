package cz.tomasdvorak.wordwrap;

import org.junit.Assert;
import org.junit.Test;

import static cz.tomasdvorak.wordwrap.Wordwrap.wordwrap;

/**
 * Tests based on and translated from https://github.com/SalzPUG/wordwrap/blob/master/test_wordwrap.py
 */
public class WordwrapTest {

    @Test
    public void test_empty() {
        String result = wordwrap("", 10);
        Assert.assertEquals("", result);

    }

    @Test
    public void test_shortword() {
        String result = wordwrap("einwort", 10);
        Assert.assertEquals("einwort", result);

    }

    @Test
    public void test_longword() {
        String result = wordwrap("einganzlangeswort", 10);
        Assert.assertEquals("einganzlangeswort", result);

    }

    @Test
    public void test_twowords() {
        String result = wordwrap("zwei woerter", 10);
        Assert.assertEquals("zwei\nwoerter", result);

    }

    @Test
    public void test_threewords() {
        String result = wordwrap("eins zwei drei", 10);
        Assert.assertEquals("eins zwei\ndrei", result);

    }

    @Test
    public void test_three_lines() {
        String result = wordwrap("eins zwei drei vier fuenf", 10);
        Assert.assertEquals("eins zwei\ndrei vier\nfuenf", result);

    }

    @Test
    public void test_ten_chars() {
        String result = wordwrap("0123456789", 10);
        Assert.assertEquals("0123456789", result);

    }

    @Test
    public void test_two_long_words() {
        String result = wordwrap("einganzlangeswort undnocheinesdazu", 10);
        Assert.assertEquals("einganzlangeswort\nundnocheinesdazu", result);

    }

    @Test
    public void test_single_chars() {
        String result = wordwrap("a b c d e f g h i j k", 10);
        Assert.assertEquals("a b c d e\nf g h i j\nk", result);

    }

    @Test
    public void test_blanks() {
        String result = wordwrap("                    ", 10);
        Assert.assertEquals("", result);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_text_none() {
        wordwrap(null, 10);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_negative() {
        wordwrap("test", -5);
    }

    @Test
    public void test_many_words() {
        String result = wordwrap("eins zwei drei view fuenf sechs sieben acht neun", 10);
        Assert.assertEquals("eins zwei\ndrei view\nfuenf\nsechs\nsieben\nacht neun", result);

    }

    @Test
    public void test_startwithblanks() {
        String result = wordwrap("     word", 10);
        Assert.assertEquals("word", result);

    }

    @Test
    public void test_endwithblanks() {
        String result = wordwrap("word          ", 10);
        Assert.assertEquals("word", result);

    }

    @Test
    public void test_specialchars() {
        String result = wordwrap("!\"§$%&/()=?#+* ~öäü", 10);
        Assert.assertEquals("!\"§$%&/()=?#+*\n~öäü", result);

    }

    @Test
    public void test_breaks() {
        String result = wordwrap("Ein Satz.\nUnd noch ein zweiter Satz.\nEnde.", 15);
        Assert.assertEquals("Ein Satz.\nUnd noch ein\nzweiter Satz.\nEnde.", result);

    }
}
