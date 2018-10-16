import java.util.HashMap;
import java.util.Scanner;

public class MoiveApp {

    public static void main(String [] args){

        System.out.println("Enter the File Name");
        Scanner scanner = new Scanner(System.in);
        String review = scanner.nextLine();
        System.out.println(review);

        HashMap<String, Integer> db = AggregateTheReviewScore.aggregate();

        String[] reviewArray = review.split(" ");

        int avg = 0;

        for(String word : reviewArray) {
            if(db.containsKey(word)) {
                avg =+ db.get(word);
            }
        }

        avg = avg / review.length();

        System.out.println(avg);

    }
}
