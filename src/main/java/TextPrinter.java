package main.java;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ThreadLocalRandom;
import org.json.JSONArray;
import org.json.JSONObject;

public class TextPrinter {
    public static void main(String[] args) throws Exception {
        // Read JSON file from resources
        InputStreamReader reader = new InputStreamReader(
            TextPrinter.class.getClassLoader().getResourceAsStream("sentences.json"),
            StandardCharsets.UTF_8
        );
        StringBuilder content = new StringBuilder();
        int c;
        while ((c = reader.read()) != -1) {
            content.append((char) c);
        }
        reader.close();

        // Parse JSON and select random sentence
        JSONObject json = new JSONObject(content.toString());
        JSONArray sentences = json.getJSONArray("sentences");
        String text = sentences.getString(ThreadLocalRandom.current().nextInt(sentences.length()));

        // Print with typewriter effect
        System.out.println();
        System.out.print("\033[32m");
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(ThreadLocalRandom.current().nextInt(10, 150));
        }
        System.out.print("\033[0m");
        System.out.println();
        System.out.println();
    }
}