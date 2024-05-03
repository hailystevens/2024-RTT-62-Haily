package org.example.Classwork;

public class StringBufferExample {

    public static void main(String[] args) {
        //012345678901
        //filename.txt
        StringBuffer sb = new StringBuffer("filename.txt"); // Corrected variable name
        sb.insert(0, "new_");

        //0123456789012345
        //new_filename.txt
        System.out.println(sb);

        sb.replace(0, 4, "old_");
        System.out.println(sb);

        //0123456789012345
        //old_filename.txt
        System.out.println(sb);

        //the thing to memorize for kba... is... that...
        //replace is going first delete the items from 0 to 4 then insert the dtring at the positiom start
        sb.replace(0, 4, "very_old");

        //0123456789012345
        //old_filename.txt
        System.out.println(sb);

        sb.reverse();

        //0123456789012345
        //emanelif_dlo.txt
    }
}



