package String;

public class MinimumtoMakeAnagram {


    static int minToAnagram(String a, String b) {


        int[] freqA = new int[256];

        int[] freqB = new int[256];

        for (int i = 0; i < a.length(); i++) {
            freqA[a.charAt(i)]++;
        }
        for (int i = 0; i < b.length(); i++) {
            freqB[b.charAt(i)]++;
        }


        int res = 0;


        for (int i = 0; i < 256; i++) {
            res += Math.abs(freqA[i] - freqB[i]);

        }
        return res;
    }

    public static void main(String[] args) {
        String a = "basgadhbfgvhads";
        String b = "sjdhgvbjdsbhvbvd";
        int res = minToAnagram(a, b);
        System.out.println(res);
    }
}
