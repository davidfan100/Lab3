import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class Testing {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static int wordCount(final String url) {
        Scanner scan = new Scanner(urlToString(url));
        int count = 0;
        while(scan.hasNext()) {
            count++;
            scan.next();
        }
        return count;
    }
    public static int specificWord(final String url, String word) {
        Scanner scan1 = new Scanner(urlToString(url));
        int counter = 0;
        while (scan1.hasNext()) {
            String s = scan1.next();
            s = s.replaceAll(",?;", "");
            //Remove punctuation
            s = s.toLowerCase();
            if (s.equals(word)) {
                counter++;
            }
        }
        return counter;
    }
    public static void main(String[] args) {
      //  System.out.println(wordCount("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(specificWord("http://erdani.com/tdpl/hamlet.txt","prince"));
    }

}
