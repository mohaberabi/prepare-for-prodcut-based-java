package String;

public class NumberToEnglishWords {


    String toEnglish(long n) {

        long limit = 1000000000000L;
        long currentHundered = 0;


        long t = 0;


        if (n == 0) {
            return "Zero";
        }
        String[] multiplier = {"", "Trillion", "Billion", "Million", "Thousands"};

        String[] twenty = {
                "", "One", "Two", "Three",
                "Four", "Five", "Six", "Seven",
                "Eight", "Nine", "Ten", "Eleven",
                "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };
        String tens[] = {"", "Twenty", "Thirty",
                "Forty", "Fifty", "Sixty",
                "Seventy", "Eighty", "Ninety"};


        if (n < 20L) {
            return twenty[(int) n];
        }


        String ans = "";
        for (long i = n; i > 0; i %= limit, limit /= 1000) {

            currentHundered = i / limit;

            while (currentHundered == 0) {

                i %= limit;
                limit /= 1000;
                currentHundered = i / limit;

                ++t;
            }

            if (currentHundered > 99) {
                ans += twenty[(int) currentHundered / 100] + "Hundered";
            }
            currentHundered = currentHundered % 100;
            if (currentHundered > 0 && currentHundered < 20) {
                ans += twenty[(int) currentHundered] + "";
            } else if (currentHundered % 10 == 0 && currentHundered != 0) {
                ans += tens[(int) currentHundered / 10 - 1] + "";
            } else if (currentHundered > 20) {
                ans += tens[(int) currentHundered / 10 - 1] + "" + twenty[(int) currentHundered % 10];
            }

            if (t < 4) {
                ans += multiplier[(int) ++t];
            }

        }

        return ans;


    }

    public static String numToWords(int n, String s) {

        // strings at index 0 is not used to make array indexing simple
        String one[] = {"", "one ", "two ", "three ", "four ",
                "five ", "six ", "seven ", "eight ",
                "nine ", "ten ", "eleven ", "twelve ",
                "thirteen ", "fourteen ", "fifteen ",
                "sixteen ", "seventeen ", "eighteen ",
                "nineteen "
        };

        // strings at index 0 and 1 are not used to make array indexing simple
        String ten[] = {"", "", "twenty ", "thirty ", "forty ",
                "fifty ", "sixty ", "seventy ", "eighty ",
                "ninety "
        };

        String str = "";
        // if n is more than 19, divide it
        if (n > 19)
            str += ten[n / 10] + one[n % 10];
        else
            str += one[n];

        // if n is non-zero
        if (n != 0)
            str += s;
        return str;
    }

    // Function to print a given number in words
    public String convertToWords(int n) {

        // stores word representation of given number n
        String out = "";

        // handles digits at crore and ten crore
        out += numToWords((n / 10000000), "crore ");

        // handles digits at lakh and ten lakh
        out += numToWords(((n / 100000) % 100), "lakh ");

        // handles digits at thousand and ten thousand
        out += numToWords(((n / 1000) % 100), "thousand ");

        // handles digit at hundreds places (if any)
        out += numToWords(((n / 100) % 10), "hundred ");

        if (n > 100 && n % 100 != 0)
            out += "and ";

        // handles digits at ones and tens places (if any)
        out += numToWords((n % 100), "");
        return out;
    }
}
