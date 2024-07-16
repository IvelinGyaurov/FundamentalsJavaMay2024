package TextProcessingExercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] array = scanner.nextLine().split(" ");
        String firstText = array[0];
        String secondText = array[1];

        int minText = Math.min(firstText.length(),secondText.length());
        int maxText = Math.max(firstText.length(),secondText.length());

        int totalSum = 0;
        for (int i = 0; i < minText ; i++) {
            char firstSymbol = firstText.charAt(i);
            char secondSymbol = secondText.charAt(i);

            int sum = firstSymbol * secondSymbol;
            totalSum += sum;


        }
        if (firstText == secondText){
            System.out.println(totalSum);
        } else if (firstText.length() > secondText.length()){
            String remainedText = firstText.substring(minText,maxText);
            for (char symbol : remainedText.toCharArray()){
                totalSum += symbol;
            }
            System.out.println(totalSum);
        } else {
            String remainedText = secondText.substring(minText,maxText);
            for (char symbol : remainedText.toCharArray()){
                totalSum += symbol;
            }
            System.out.println(totalSum);
        }

    }
}
