import java.util.Scanner;

public class SongGenerator {
    
    private String input;

    public SongGenerator() {

        Scanner scanner = new Scanner(System.in);

        this.input = scanner.nextLine();

        scanner.close();
    }

    public int getNumber() {
        int number = Integer.parseInt(input.split(" ")[0]);
        return number;
    }

    public String getWords() {
        String words = input.split(" ", 2)[1];
        return words;
    }

    public void generateSong() {



        String song = "";
        String[] wordArray = getWords().split(" ", 2);
        String singular = wordArray[0].substring(0, wordArray[0].length()-1);
        String rest = wordArray[1];
       
        
        for (int count = getNumber(); count > 1; count--) {
            song += count + " " + getWords() + " on the wall\n" +
                    count + " " + getWords() + "\n" +
                    "Take one down, pass it around\n" +
                    (count != 2 ? (count-1) + " " + getWords() : "One " + singular + " " + rest) + " on the wall\n\n";
        }

        song += "One " + singular + " " + rest + " on the wall\n" +
                "One " + singular + " " + rest + "\n" +
                "Take one down, pass it around\n" +
                "No more " + getWords() + " on the wall";

        System.out.println(song);
    }
}