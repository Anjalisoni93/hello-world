import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AggregateTheReviewScore {

    public static HashMap<String,Integer> aggregate(){
        System.out.println("Enter input ");
        Scanner myScanner = new Scanner(System.in);
        String userInput = myScanner.nextLine();

        ArrayList<String> stringList = getFileArray(userInput);

        boolean foundFile = false;

        while(!foundFile) {


            if(stringList != null) {
                foundFile = true;
            }
        }

        while (!isFileValid(stringList)){
            System.out.println("Invalid File");
            System.exit(0);
        }

        myScanner.close();

        HashMap<String,ArrayList<Integer>> database = new HashMap<>();

        for (int x = 0 ; x < stringList.size() ; x++){
            String[] getValueOfString = getValues(stringList.get(x));

            for (int y = 2 ; y < getValueOfString.length ; y++){
                if (database.containsKey(y)){

                    ArrayList<Integer> currentList = database.get(getValueOfString[y]);
                    currentList.add(Integer.parseInt(getValueOfString[0]));
                    database.put(getValueOfString[y], currentList);

                } else {
                    database.put(getValueOfString[y], new ArrayList<Integer>());

                    ArrayList<Integer> currentList = database.get(getValueOfString[y]);
                    currentList.add(Integer.parseInt(getValueOfString[0]));
                    database.put(getValueOfString[y], currentList);
                }
            }
        }

        HashMap<String, Integer> finalDB = new HashMap<>();

        for(String key : database.keySet()) {

            int avg = 0;

            for(int placeholder : database.get(key)) {
                avg =+ placeholder;
            }

            avg = avg / database.get(key).size();

            finalDB.put(key, avg);
        }

        return finalDB;
    }
    private static String[] getValues(String values){
        return values.split(" ");
    }

    private static boolean isFileValid(ArrayList<String> input){
        for (int x = 0 ; x < input.size() ; x++){
            String inputString = input.get(x);

            String[] seperation = inputString.split("");

            try{
                Integer.parseInt(seperation[0]);
            }catch (Exception e){
                System.out.println("Invalid File");
                return false;
            }

            if (!seperation[1].equals(" ")){
                System.out.println("Give me something real");
                return false;
            }
        }
        return true;
    }

    private static ArrayList<String> getFileArray(String nameOfFile) {

        Scanner scanner = null;

        ArrayList<String> arrayList = new ArrayList<String>();

        boolean foundFile = false;


            try {
                File toFind = new File(nameOfFile);
                scanner = new Scanner(toFind);
            } catch (FileNotFoundException e) {
                System.out.println("Incorrect File");
                return null;
            }

        while (scanner.hasNextLine()){
            arrayList.add(scanner.nextLine());
        }

        scanner.close();
        return arrayList;
    }

   }
