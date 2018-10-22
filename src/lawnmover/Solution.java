package lawnmover;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String args[]) {
        List<String> fileLines = Read.stockFile("file.txt");
        int numberOfLines = fileLines.size();

        List<String> lawnmovers = new ArrayList<>();

        String grassCoordinates = fileLines.get(0);
        char firstNumber = grassCoordinates.charAt(0);
        char secondNumber = grassCoordinates.charAt(2);

        int width = (int)firstNumber - 47;
        int height = (int)secondNumber - 47;

        List<String> dir = null;
        String lawnmover ;
        String path ;
        String[] direct = null;
        //object list
        List<Lawnmover> lms = new ArrayList<>();
        Lawnmover lm ;

        for (int i = 0; i < numberOfLines; i++) {
            if(i%2 == 1){
                //creation
                lm = new Lawnmover();
                //get the initial position and orientation
                lawnmover = fileLines.get(i);
                //get the position and orientation of the lawnmover:
                String[] lawnM = lawnmover.split(" ");

                int x = Integer.parseInt(lawnM[0]);
                int y = Integer.parseInt(lawnM[1]);
                String orientation = lawnM[2];
                //initialize the landmovers
                lm.setX(x);
                lm.setY(y);
                lm.setDirection(orientation.charAt(0));
                //
                lms.add(lm);
                //get the directions (path) of each lawnmover
                path = fileLines.get(i+1);
                lm.setPath(path);
                lm.calculate(path);
            }
        }
        //print the final result , final position of every lawnmovers:
        lms.forEach(System.out::println);
    }
}
