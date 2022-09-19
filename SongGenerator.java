import java.util.Scanner;

public class SongGenerator {
    
    private String input;

    public SongGenerator() {

        //taking the input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the title of the song in a form '30 bottles of rum' where quantity, product and container can be replaced.");
        System.out.println(">>");
        //assigning the user input to the input field
        this.input = scanner.nextLine();
        //closing the scanner object to avoid memory leak
        scanner.close();

    }

    //function that gets the number part of the user input
    public int getNumber() {
        int number = Integer.parseInt(input.split(" ")[0]);
        return number;
    }

    //function that gets the rest of the user input after the number part
    public String getWords() {
        String words = input.split(" ", 2)[1];
        return words;
    }

    //function that generates the song
    public void generateSong() {

        //variable that will be printed out at the end
        String song = "";

        //creating a singular form of container type used when the quantity is only 1
        String[] wordArray = getWords().split(" ", 2);
        String singular = wordArray[0].substring(0, wordArray[0].length()-1);
        String rest = wordArray[1];
       
        
        //loop creating verses of song based on the quantity
        for (int count = getNumber(); count > 1; count--) {
            song += count + " " + getWords() + " on the wall\n" +
                    count + " " + getWords() + "\n" +
                    "Take one down, pass it around\n" +
                    //asking whether quantity equals two or not
                    (count != 2 ? (count-1) + " " + getWords() : "One " + singular + " " + rest) + " on the wall\n\n";
        }

        //last verse of every song
        song += "One " + singular + " " + rest + " on the wall\n" +
                "One " + singular + " " + rest + "\n" +
                "Take one down, pass it around\n" +
                "No more " + getWords() + " on the wall";

        //printing the result into terminal
        System.out.println(song);
    }
}