package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ReArrangeFiles {


    static public String[] fileReorder(String[] files) {

        Arrays.sort(files, new Comparator<String>() {
            public int compare(String s1, String s2) {

                String identifier1 = s1.substring(0, s1.indexOf(" "));
                String filecontents1 = s1.substring(s1.indexOf(" ") + 1);

                String identifier2 = s2.substring(0, s2.indexOf(" "));
                String filecontents2 = s2.substring(s2.indexOf(" ") + 1);

                // If both are digit files, no change in order
                // of their sequence
                if ((filecontents1.charAt(0) >= '0' && filecontents1.charAt(0) <= '9') &&
                        (filecontents2.charAt(0) >= '0' && filecontents2.charAt(0) <= '9'))
                    return 0;
                    // If s1 has digit files, s2 comes first
                else if (filecontents1.charAt(0) >= '0' && filecontents1.charAt(0) <= '9')
                    return 1;
                    // If s2 has digit files, s1 comes first
                else if (filecontents2.charAt(0) >= '0' && filecontents2.charAt(0) <= '9')
                    return -1;
                    // If both are letter-files
                else {
                    // If both filecontents are same, compare identifiers
                    if (filecontents1.equals(filecontents2)) {
                        return identifier1.compareTo(identifier2);
                    }

                    return filecontents1.compareTo(filecontents2);
                }

            }

        });

        return files;
    }


    public static void main(String[] args) {
        String[] files = {"file1", "1", "2", "3", "space2", "geeksforgeeks", "true1", "check",};


        fileReorder(files);
    }
}
