/* Zadanie 31
Napisz program, który policzy wystąpienia każdego słowa w pliku tekstowym
a następnie wyniki zapisze w formie tabelki w nowym pliku.
 */
package com.dkoncewicz;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise31 {
    // Key concepts : working with NIO package, read all lines to the buffer,
    public void show() throws IOException {
        String path = "Assets/";
        String fileName= "SDAexample.txt";


        // Java classical approach
        var file = new File(fileName);

        List<String> lines = Files.readAllLines(
                Path.of(path + fileName), StandardCharsets.UTF_8);

        Map<String, Integer> wordOccurrences = new HashMap<String, Integer>();

        // for each line in file
        for (String line : lines) {

            String[] words = line.split("[ ,.!?\r\n]");

            // for every word in file
            for (String word : words) {

                word = word.replace(".", "");

                if (!word.trim().isEmpty()) {
                    if (wordOccurrences.containsKey(word)) {
                        int count = wordOccurrences.get(word).intValue();
                        wordOccurrences.put(word, new Integer(count + 1));
                    } else {
                        wordOccurrences.put(word, new Integer(1));
                    }
                }
            }
        }

        System.out.println(wordOccurrences);
        System.out.println("Word counter : "+wordsCount(path+fileName) );
        System.out.println("Sum of word in file : "+wordsSum(path+fileName));
    }

    private Map<String,Long> wordsCount(String fileName) throws IOException {
        var result = Files.lines(Paths.get(fileName))
                .flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return result;
    }

    private long wordsSum(String file) throws IOException {
        var sum = Files.lines(Paths.get(file))
                .flatMap(str-> Stream.of(str.split("[ ,.!?\r\n]")))
                .filter(s->s.length()>0).count();
        return sum;
    }
}

// See: https://stackoverflow.com/questions/4094119/counting-number-of-words-in-a-file
// See: https://stackoverflow.com/questions/47594679/how-to-count-words-in-a-text-file-java-8-style
// Sample file: https://github.com/leveluplunch/levelup-java-examples/blob/master/src/test/resources/com/levelup/java/io/word-occurrences-in-file.txt
