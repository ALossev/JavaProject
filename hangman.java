/*
 * Alek Lossev 03/13/24
 * Simplified Hangman game wher user guesses letters and is 
 * restricted upon using a singular letter, with testing as well.
 */

import java.util.Scanner;
import java.util.Random;

public class hangman {
    private static final String[] WORDS = {"hangman", "computer", "programming", "language", "openai", "intelligence", "algorithm", "developer", "challenge", "community"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String wordToGuess = WORDS[random.nextInt(WORDS.length)];
        StringBuilder guessedLetters = new StringBuilder();
        int maxAttempts = 6;
        int wrongGuessCount = 0;

        System.out.println("Welcome to Hangman!");
        System.out.println("Guess the word:");

        while (wrongGuessCount < maxAttempts) {
            if (isWordGuessed(wordToGuess, guessedLetters.toString())) {
                System.out.println("Congratulations! You guessed the word: " + wordToGuess);
                return;
            }

            System.out.println();
            displayHangman(wrongGuessCount);
            System.out.println("Word: " + getHiddenWord(wordToGuess, guessedLetters.toString()));
            System.out.println("Guessed Letters: " + guessedLetters.toString());

            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);

            if (isGuessCorrect(wordToGuess, guess)) {
                System.out.println("Correct guess!");
            } else {
                System.out.println("Incorrect guess!");
                wrongGuessCount++;
            }

            guessedLetters.append(guess);
        }

        System.out.println();
        displayHangman(wrongGuessCount);
        System.out.println("Sorry, you've run out of attempts. The word was: " + wordToGuess);
    }

    private static boolean isWordGuessed(String word, String guessedLetters) {
        for (char letter : word.toCharArray()) {
            if (!guessedLetters.contains(Character.toString(letter))) {
                return false;
            }
        }
        return true;
    }

    private static String getHiddenWord(String word, String guessedLetters) {
        StringBuilder hiddenWord = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
            if (!guessedLetters.contains(Character.toString(word.charAt(i)))) {
                hiddenWord.setCharAt(i, '_');
            }
        }
        return hiddenWord.toString();
    }

    private static boolean isGuessCorrect(String word, char guess) {
        return word.indexOf(guess) != -1;
    }

    private static void displayHangman(int wrongGuessCount) {
        switch (wrongGuessCount) {
            case 0:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 1:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 2:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 3:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 4:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 5:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" /    |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 6:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" / \\  |");
                System.out.println("      |");
                System.out.println("=========");
                break;
        }
    }
}
