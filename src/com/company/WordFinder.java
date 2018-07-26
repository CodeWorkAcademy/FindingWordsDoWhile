package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class WordFinder {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String word = "";
        boolean found = false;
        int i = 0;

        do {
            System.out.println("Please enter a word to lookup: ");
            word = keyboard.next();
        } while (word.length() == 0);

        try{
            File file = new File("/usr/share/dict/words");

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while( (line = br.readLine()) != null)
            {
                i++;
                if (line.equals(word))
                {
                    System.out.println(word + " found at position #" + i );
                    found = true;
                    break;
                }
            }

            if (!found)
            {
                System.out.println(
                        "After checking " + i + " words, your word was not found");
            }
            br.close();
        }
        catch(Exception e) {
            System.out.println("Oops! An error occurred.");
        } finally {
            keyboard.close();
        }
    }
}
