package task6;

import java.util.*;


public class WordProcessor {
    public Set<String> dictionary;

    public WordProcessor(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    
    public List<String> checkSpelling(String input) {
        List<String> result = new ArrayList<>();
        String[] words = input.split("\\s+");
        for (String word : words) {
        	
            if (!dictionary.contains(word.toLowerCase())) {
                result.addAll(getSuggestions(word.toLowerCase()));
            } else {
                result.add(word);
            }
        }
        
        
        
        
        return result;
    }

    public List<String> getSuggestions(String word) {
        List<String> suggestions = new ArrayList<>();
        suggestions.addAll(getDeletions(word));
        suggestions.addAll(getInsertions(word));
        suggestions.addAll(getReplacements(word));
        return suggestions;
    }

    public Set<String> getDeletions(String word) {
        Set<String> deletions = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder(word);
            sb.deleteCharAt(i);
            deletions.add(sb.toString());
        }
        return deletions;
    }

    public Set<String> getInsertions(String word) {
        Set<String> insertions = new HashSet<>();
        for (int i = 0; i <= word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                StringBuilder sb = new StringBuilder(word);
                sb.insert(i, c);
                insertions.add(sb.toString());
            }
        }
        return insertions;
    }

    public Set<String> getReplacements(String word) {
        Set<String> replacements = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i, c);
                replacements.add(sb.toString());
            }
        }
        return replacements;
    }

    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>(Arrays.asList("good", "morning"));
        WordProcessor wordProcessor = new WordProcessor(dictionary);
        String input = "godo Marnong";
        List<String> result = wordProcessor.checkSpelling(input.toLowerCase());
        System.out.println("Original input: " + input);
        System.out.println("Corrected output: " + String.join(" ", result));
    }
}
