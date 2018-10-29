package sample;

import java.io.*;
import java.util.Scanner;

import static java.util.Arrays.sort;

public class Hamstr {

    public static void main(String[] args) throws IOException {
        String inHamstr = args.length >= 2 ? args[0] : "hamstr.in";
        String outHamstr = args.length >= 2 ? args[1] : "hamstr.out";

        ReadFile input = reader(inHamstr);
        WriteToFile output = binarySearch(input);
        write(outHamstr, output);
    }

    private static ReadFile reader(String inHamstr) throws FileNotFoundException {
        File inputFile = new File(inHamstr);

        try (Scanner inputFileScanner = new Scanner(inputFile)) {
            long foodSupply = Long.parseLong(inputFileScanner.nextLine());
            int hamsters = Integer.parseInt(inputFileScanner.nextLine());

            Hamsters[] total_hamsters = new Hamsters[hamsters];
            for (int i = 0; i < hamsters; i++) {
                String[] lines = inputFileScanner.nextLine().split(" ");
                int hamsterDose = Integer.parseInt(lines[0]);
                int greed = Integer.parseInt(lines[1]);
                total_hamsters[i] = new Hamsters(hamsterDose, greed);
            }

            return new ReadFile(foodSupply, total_hamsters);
        }
    }

    private static WriteToFile binarySearch(ReadFile input) {

        int left = 0;
        int right = input.getTotalHamsters().length;

        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (!buyPossibility(mid, input.getTotalHamsters(), input.getFoodSupply())) {
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }

        int maxHamsters = right;
        return new WriteToFile(maxHamsters);
    }

    private static boolean buyPossibility(int p, Hamsters[] hamsters, long foodSupply) {
        long[] foodConsume = new long[hamsters.length];
        for (int i = 0; i < hamsters.length; i++) {
            foodConsume[i] = hamsters[i].getConsume(p - 1);
        }

        long foodForMaxHamsters = 0;
        sort(foodConsume);
        for (int i = 0; i < p; i++) {
            foodForMaxHamsters += foodConsume[i];
        }

        return foodForMaxHamsters <= foodSupply;
    }

    private static void write(String outHamstr, WriteToFile output) throws IOException {
        try (Writer outputFileWriter = new FileWriter(outHamstr)) {
            outputFileWriter.write(String.valueOf(output.getMaxHamsters()));
        }
    }
}