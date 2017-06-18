import org.junit.Assert;
import org.testng.annotations.Test;

import javax.xml.soap.Text;
import java.util.HashMap;

/**
 * Created by Zachary on 6/18/2017.
 */
public class Test_Text_Utilities {
    @Test
    public void Should_Reverse_String_When_GivenAnyString() {
        // Test the empty string
        String input_string = "";
        String expected_output = "";
        String actual_output = Text_Utilities.reverse(input_string);
        Assert.assertEquals(expected_output, actual_output);

        // Test odd length strings
        input_string = "abcde";
        expected_output = "edcba";
        actual_output = Text_Utilities.reverse(input_string);
        Assert.assertEquals(expected_output, actual_output);

        // Test even length strings
        input_string = "ababab";
        expected_output = "bababa";
        actual_output = Text_Utilities.reverse(input_string);
        Assert.assertEquals(expected_output, actual_output);
    }

    @Test
    public void Should_ReturnFalse_When_NotGivenPalindrome() {
        // Test odd length strings
        String input_string = "aaaba";
        Assert.assertFalse(Text_Utilities.isPalindrome(input_string));

        // Test even length strings
        input_string = "aabaaa";
        Assert.assertFalse(Text_Utilities.isPalindrome(input_string));
    }

    @Test
    public void Should_ReturnTrue_When_GivenPalindrome() {
        // Test the empty string
        String input_string = "";
        Assert.assertTrue(Text_Utilities.isPalindrome(input_string));

        // Test odd length strings
        input_string = "abababababa";
        Assert.assertTrue(Text_Utilities.isPalindrome(input_string));

        // Test even length strings
        input_string = "aaaaaabbaaaaaa";
        Assert.assertTrue(Text_Utilities.isPalindrome(input_string));
    }

    @Test
    public void Should_ReturnCharacterCounts_When_GivenString() {
        String input_string = "";
        HashMap<Character,Integer> expected_output = new HashMap<Character,Integer>();
        HashMap<Character,Integer> actual_output = Text_Utilities.countChars(input_string);
        Assert.assertEquals(expected_output, actual_output);

        input_string = "aaabbc";
        expected_output.clear();
        expected_output.put('a',3);
        expected_output.put('b',2);
        expected_output.put('c',1);
        actual_output = Text_Utilities.countChars(input_string);
        Assert.assertEquals(expected_output, actual_output);
    }

    @Test
    public void Should_ReturnWordCounts_When_GivenString() {
        String input_string = "";
        HashMap<String,Integer> expected_output = new HashMap<String, Integer>();
        HashMap<String,Integer> actual_output = Text_Utilities.countWords(input_string);
        Assert.assertEquals(expected_output, actual_output);

        input_string = "a ";
        expected_output.clear();
        expected_output.put("a",1);
        actual_output = Text_Utilities.countWords(input_string);
        Assert.assertEquals(expected_output, actual_output);

        input_string = "abc abc abc ad ad   a";
        expected_output.clear();
        expected_output.put("abc", 3);
        expected_output.put("ad",2);
        expected_output.put("a",1);
        actual_output = Text_Utilities.countWords(input_string);
        Assert.assertEquals(expected_output, actual_output);
    }

    @Test
    public void Should_ReturnTotalWords_When_GivenString() {
        String input_string = "";
        int expected_output = 0;
        int actual_output = Text_Utilities.totalWords(input_string);
        Assert.assertEquals(expected_output, actual_output);

        input_string = "a ";
        expected_output = 1;
        actual_output = Text_Utilities.totalWords(input_string);
        Assert.assertEquals(expected_output, actual_output);

        input_string = "abc abc abc ad ad    a ";
        expected_output = 6;
        actual_output = Text_Utilities.totalWords(input_string);
        Assert.assertEquals(expected_output, actual_output);
    }
}
