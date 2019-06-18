package Brelok.workshops;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class PopularWordInHeadlines {
    public static void main(String[] args) {
        List<String> listOfWords = new ArrayList<>();
        Path path = Paths.get("/Users/brelok/workspace/workshops/workshops_JAVA_01/src/Brelok/workshops/popular_words.txt");

        Connection connect = Jsoup.connect("https://www.onet.pl/");
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
                String[] strings = elem.text().split(" ");
                listOfWords.addAll(Arrays.asList(strings));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> finalWords = cleanList(listOfWords);
        System.out.println(frequencyOfPopularWordInHeadlines(finalWords));

        try {
            Files.write(path, finalWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> excludedWords() {
        List<String> excludedWords = new ArrayList<>();
        excludedWords.add("ponieważ");
        excludedWords.add("dlatego");
        excludedWords.add("oraz");
        excludedWords.add("poniekąd");
        excludedWords.add("gdyż");
        excludedWords.add("skąd");
        excludedWords.add("które");
        excludedWords.add("jest");
        excludedWords.add("tego");

        return excludedWords;
    }

    public static List<String> cleanList(List<String> list) {
        List<String> listWithoutWordsShorterThen3 = new ArrayList<>();
        for (String string : list) {
            String cleaned = string.replaceAll("[.,\"\\?!:;]", ""); //word without any diffrent signs
            if (cleaned.length() > 3) { //word more then 3 letters
                listWithoutWordsShorterThen3.add(cleaned);
            }
        }

        List<String> excludedWords = excludedWords();

        for (int i = 0; i < listWithoutWordsShorterThen3.size(); i++) {
            for (String excludedWord : excludedWords) {
                if (listWithoutWordsShorterThen3.get(i).equals(excludedWord)) {
                    listWithoutWordsShorterThen3.remove(i);
                }
            }
        }
        return listWithoutWordsShorterThen3;
    }

    public static TreeMap frequencyOfPopularWordInHeadlines(List<String> list) {

        TreeMap mapOfFrequency = new TreeMap();
        Set<String> listOf3Frequency = new HashSet<>();
        Set<String> listOf4Frequency = new HashSet<>();
        Set<String> listOf5Frequency = new HashSet<>();
        Set<String> listOf6Frequency = new HashSet<>();
        Set<String> listOf7Frequency = new HashSet<>();
        Set<String> listOf8Frequency = new HashSet<>();
        Set<String> listOf9Frequency = new HashSet<>();
        Set<String> listOf10Frequency = new HashSet<>();
        Set<String> listOf11Frequency = new HashSet<>();
        Set<String> listOf12Frequency = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {

            if (Collections.frequency(list, list.get(i)) == 12) {
                listOf12Frequency.add(list.get(i));
                mapOfFrequency.put(Collections.frequency(list, list.get(i)), listOf12Frequency);
            }
            if (Collections.frequency(list, list.get(i)) == 11) {
                listOf11Frequency.add(list.get(i));
                mapOfFrequency.put(Collections.frequency(list, list.get(i)), listOf11Frequency);
            }
            if (Collections.frequency(list, list.get(i)) == 10) {
                listOf10Frequency.add(list.get(i));
                mapOfFrequency.put(Collections.frequency(list, list.get(i)), listOf10Frequency);
            }
            if (Collections.frequency(list, list.get(i)) == 9) {
                listOf9Frequency.add(list.get(i));
                mapOfFrequency.put(Collections.frequency(list, list.get(i)), listOf9Frequency);
            }
            if (Collections.frequency(list, list.get(i)) == 8) {
                listOf8Frequency.add(list.get(i));
                mapOfFrequency.put(Collections.frequency(list, list.get(i)), listOf8Frequency);
            }
            if (Collections.frequency(list, list.get(i)) == 7) {
                listOf7Frequency.add(list.get(i));
                mapOfFrequency.put(Collections.frequency(list, list.get(i)), listOf7Frequency);
            }
            if (Collections.frequency(list, list.get(i)) == 6) {
                listOf6Frequency.add(list.get(i));
                mapOfFrequency.put(Collections.frequency(list, list.get(i)), listOf6Frequency);
            }
            if (Collections.frequency(list, list.get(i)) == 5) {
                listOf5Frequency.add(list.get(i));
                mapOfFrequency.put(Collections.frequency(list, list.get(i)), listOf5Frequency);
            }
            if (Collections.frequency(list, list.get(i)) == 4) {
                listOf4Frequency.add(list.get(i));
                mapOfFrequency.put(Collections.frequency(list, list.get(i)), listOf4Frequency);
            }
            if (Collections.frequency(list, list.get(i)) == 3) {
                listOf3Frequency.add(list.get(i));
                mapOfFrequency.put(Collections.frequency(list, list.get(i)), listOf3Frequency);
            }

        }
        return mapOfFrequency;
    }

    public static TreeMap map(List<String> list) { //dopracować pętlę
        TreeMap map = new TreeMap();
        for (int i = 0; i < list.size(); i++) {

            if (Collections.frequency(list, list.get(i)) == i) {
                Set<String> set = new HashSet<>();
                set.add(list.get(i));
                map.put(Collections.frequency(list, list.get(i)), set);
            }
        }
        return map;
    }
}

