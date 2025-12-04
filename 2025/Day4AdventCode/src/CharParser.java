import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CharParser {

    public static void main(String[] args) {
        String filePath = "input.txt";
        ArrayList<ArrayList<Character>> input = readCharsFromFile(filePath);
        int res = 0;
        boolean removed;
        do{
            removed = false;
            for (int y = 0; y < input.size(); y++){
                int x = 0;
                for(char c: input.get(y)){
                    if(c == '@'){
                        if(checkAccess(x, y, input)){
                            removed = true;
                            input.get(y).set(x, '.');
                            res++;
                        }
                    }
                    x++;
                }
            }
        } while(removed);


        System.out.println("Result: " + res);
    }

    public static int[][] dirs = {{1,0}, {1,1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,-1}};

    public static boolean checkAccess(int x, int y, ArrayList<ArrayList<Character>> input){
        int rollCounter = 0;
        for(int[] d: dirs){
            int nx = x + d[0];
            int ny = y + d[1];
            if(nx < 0 || nx >= input.get(0).size() || ny < 0 || ny >= input.size()){
                continue;
            }
            if(input.get(ny).get(nx) == '@'){
                rollCounter++;
            }
        }

        if(rollCounter < 4){
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<ArrayList<Character>> readCharsFromFile(String path) {
        ArrayList<ArrayList<Character>> mainList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                ArrayList<Character> lineList = new ArrayList<>();

                for (char ch : line.toCharArray()) {
                    lineList.add(ch);
                }

                if (lineList.size() > 0) {
                    mainList.add(lineList);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + path);
            return null;
        }

        return mainList;
    }
}