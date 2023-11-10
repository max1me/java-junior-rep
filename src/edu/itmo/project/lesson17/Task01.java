package edu.itmo.project.lesson17;

import java.util.*;

public class Task01 {
    public static void main(String[] args) {
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";
        Collection<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("d");
        strings.add("d");
        strings.add("d");
        strings.add("e");
        //System.out.println(getWordCount(strings).toString());
        String[] strings1 = text.split("\\W");
        //System.out.println(Arrays.toString(strings1));
        //System.out.println(getWordCountInText("of", text).toString());
        //System.out.println(getWordLength(text).toString());
        getTopWords(text);
    }

    private static Map<String, Long> getWordCount(Collection<String> strings) {
        Objects.requireNonNull(strings);
        Map<String, Long> wordCount = new HashMap<>();
        Long count;
        for(String string: strings) {
            count = wordCount.getOrDefault(string, 0L);
            wordCount.put(string, ++count);
        }
        return wordCount;
    }
    private static ArrayList<String> getWordArray(String text) {
        if (text == null) throw new IllegalArgumentException("text не может быть null");
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(text.split("\\W")));
        return strings;
    }
    private static Map<String, Long> getWordCountInText(String word, String text) {
        if (word == null || text == null) throw new IllegalArgumentException("word и text не могут быть null");
        Map<String, Long> wordCount = new HashMap<>();
        ArrayList<String> strings = getWordArray(text);
        //System.out.println(strings.toString());
        wordCount.put(word, getWordCount(strings).get(word));
        return wordCount;
    }
    private static Map<Integer, List<String>> getWordLength(String text) {
        ArrayList<String> strings = getWordArray(text);
        Map<Integer, List<String>> words = new HashMap<>();
        Integer wordLength;
        for (String string : strings) {
            wordLength = string.length();
            if (words.get(wordLength) == null) {
                words.put(wordLength, new ArrayList<>());
                words.get(wordLength).add(string);
            } else {
                if (!words.get(wordLength).contains(string)) {
                words.get(wordLength).add(string);
                }
            }
        }
        return words;
    }
    private static void getTopWords(String text) {
        if (text == null) throw new IllegalArgumentException("text не может быть null");
        Map<String, Long> wordCount;
        ArrayList<String> strings = getWordArray(text);
        wordCount = getWordCount(strings);
        ArrayList<Map.Entry<String, Long>> wordList = new ArrayList<>(wordCount.entrySet());
        wordList.sort(Map.Entry.comparingByValue());
        for (int i = wordList.size() - 1; (wordList.size() <= 10 && i >= 0) || (wordList.size() > 10 && i > wordList.size() - 10); i--) {
            System.out.println(wordList.get(i));
        }
    }
}
