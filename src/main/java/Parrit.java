import java.util.ArrayList;

public class Parrit {

    private static int SEEDVALUE = 0;

    private static void getPairMapping(int seedValue, RotationSequence rotationSequence) {
        rotationSequence.pair_1_A = (5 * seedValue + 7) % 4; // linear congruential random number generator
        rotationSequence.pair_1_B = (5 * (rotationSequence.pair_1_A) + 7) % 4;
        rotationSequence.pair_2_A = (5 * (rotationSequence.pair_1_B) + 7) % 4;
        rotationSequence.pair_2_B = (5 * (rotationSequence.pair_2_A) + 7) % 4;

        if (seedValue % 3 == 0) {
            rotationSequence.pair_1_B = rotationSequence.pair_1_B + rotationSequence.pair_2_A;
            rotationSequence.pair_2_A = rotationSequence.pair_1_B - rotationSequence.pair_2_A;
            rotationSequence.pair_1_B = rotationSequence.pair_1_B - rotationSequence.pair_2_A;
        }
    }

    public static void main(String[] args) {

        ArrayList<String> team = new ArrayList<>();
        team.add("thendral");
        team.add("karthik");
        team.add("arun");
        team.add("chandana");

        RotationSequence rotationSequence = new RotationSequence();

        for (int day = 1; day <= 9; day++) {
            //TODO: SEEDVALUE will be replaced with day of the month or week of the month based on rotation frequency.
            Parrit.SEEDVALUE++;
            Parrit.getPairMapping(SEEDVALUE, rotationSequence);
            System.out.println("TODAY'S PAIR, DAY-" + day);
            System.out.println("PAIR 1: " + team.get(rotationSequence.pair_1_A) + " & " + team.get(rotationSequence.pair_1_B));
            System.out.println("PAIR 2: " + team.get(rotationSequence.pair_2_A) + " & " + team.get(rotationSequence.pair_2_B));
            System.out.println();
        }

    }
}
