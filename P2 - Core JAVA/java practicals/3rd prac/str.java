// Write a Java program to demonstrate the use of String methods

public class str {
    public static void main(String[] args){
        System.out.println("----Using the String Class----");

        char ch[]={'J','A','Y','E','S','H',' ','V','E','R','M','A'};

        String s1 = "Jayesh Verma";
        String s2 = "Jayesh Verma";
        String s3 = new String("Jayesh R. Verma");
        String s4 = new String(ch);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

        System.out.println("\n----Formatted String----");
        String name = "Jayesh";

        String sf1 = String.format("Name is %s",name);
        String sf2 = String.format("Value is %f",12039.124);
        String sf3 = String.format("Value is %20.7f",9720.3533);

        System.out.println(sf1);
        System.out.println(sf2);
        System.out.println(sf3);

        String sf4 = String.format("%d",101);
        String sf5 = String.format("%s","Jayesh Verma");
        String sf6 = String.format("%f",101.00);
        String sf7 = String.format("%x",105);
        String sf8 = String.format("%c",'J');

        System.out.println(sf4);
        System.out.println(sf5);
        System.out.println(sf6);
        System.out.println(sf7);
        System.out.println(sf8);

        System.out.println("\n----Integer Formatting----");

        String si1 = String.format("%d",101);
        String si2 = String.format("|%10d|",101);
        String si3 = String.format("|%-10d|",101);
        String si4 = String.format("|%d|",101);
        String si5 = String.format("|%010d|",101);

        System.out.println(si1);
        System.out.println(si2);
        System.out.println(si3);
        System.out.println(si4);
        System.out.println(si5);

        System.out.println("\n----Substring Demo----");
        String ss1 = "Jayesh R. Verma";
        String substr1 = ss1.substring(+2);
        System.out.println("Fetching the substring starting with index 2: "+substr1);
        
        String substr2 = ss1.substring(3, 13);
        System.out.println("Fetching the substring starting with index 3 and ending to index 13: "+substr2);

        System.out.println("The length of string: "+ss1.length());
        System.out.println("String contains(. V)?: "+ss1.contains(". V"));
        System.out.println("Character at index 7: "+ss1.charAt(7));

        String se1 = "Jayesh";
        String se2 = "jayesh";
        String se3 = "Jayesh";
        
        System.out.println("\nString 1: "+se1);
        System.out.println("String 2: "+se2);
        System.out.println("String 3: "+se3);
        System.out.println("\n----Case Sensetive----");
        
        
        System.out.println("String1 is equal to string2?: "+se1.equals(se2));
        System.out.println("String1 is equal to string3?: "+se1.equals(se3));
        
        System.out.println("\n----Case Insensetive----");
        System.out.println("String1 is equal to string2 ?: "+se1.equalsIgnoreCase(se2));
        System.out.println("String1 is equal to string3 ?: "+se1.equalsIgnoreCase(se3));

        System.out.println("\n----Concat----");
        String fn = "Jayesh";
        String ln = " Verma";
        System.out.println(fn.concat(ln));

        System.out.println("\n----Replace----");
        System.out.println("Replacin 'Jay' with 'Jiv': "+fn.replace("Jay", "Jiv"));
        System.out.println("Index of V in last name is "+ln.indexOf("V"));
        System.out.println("Surname is lower case"+ln.toLowerCase());
        System.out.println("Surname is upper case"+ln.toUpperCase());

        String strg = "    It's 1:28pm now, Are you tired??    ";
        System.out.println("Before trim: "+strg);
        System.out.println("After trim: "+strg.trim());

    }
}
