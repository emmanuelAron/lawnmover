package lawnmover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String args[]) {
        List<String> fileLines = Read.stockFile("file.txt");
        int numberOfLines = fileLines.size();

        List<String> lawnmovers = new ArrayList<>();

       List<List<String>> list_dir = new ArrayList<>();

        String grassCoordinates = fileLines.get(0);
        char firstNumber = grassCoordinates.charAt(0);
        char secondNumber = grassCoordinates.charAt(2);

        int width = (int)firstNumber - 47;
        int height = (int)secondNumber - 47;

        List<String> dir = null;
        String lawnmover = null;
        String directions = null;
        String[] direct = null;
        //object list
        List<Lawnmover> lms = new ArrayList<>();
        Lawnmover lm = null;
        Directions d = null;
        List<Directions> ld = null;

        System.err.println("number of lines: "+numberOfLines);
        for (int i = 0; i < numberOfLines; i++) {
            if(i%2 == 1){
                d = new Directions();
                dir = new ArrayList<>();
                //creation
                lm = new Lawnmover();
                //get the initial position and orientation
                lawnmover = fileLines.get(i);
                System.out.println("lawnmover: "+lawnmover);
                //get the position and orientation of the lawnmover:
                String[] lawnM = lawnmover.split(" ");

                int x = Integer.parseInt(lawnM[0]);
                int y = Integer.parseInt(lawnM[1]);
                String orientation = lawnM[2];
                System.out.println("x: "+x+" y: "+y+" orient: "+orientation);
                //initialize the landmovers
                lm.setX(x);
                lm.setY(y);
                lm.setDirection(orientation.charAt(0));
                //
                lms.add(lm);
                System.out.println("lms: "+lms);

                //j'en suis ici :)
               // System.out.println(lms.get(i));


                //get the directions of each lawnmover
                directions = fileLines.get(i+1);

                direct = directions.split("");
                dir = Arrays.asList(direct);

                list_dir.add(dir);

                //ld.add(d);
                //
                d.setDirections(dir);
                //
                //ld.add(d);
            }
        }
        System.err.println("d: "+d);
        System.err.println("directions: "+directions);
        System.err.println("dir: "+dir);
        System.err.println("list_dir: "+list_dir);

       /* String letter = "";
        for(int i=0;i< list_dir.size(); i++){
            List<String> _directions = list_dir.get(i);
            System.err.println("_directions: "+_directions);
            //to do : une boucle imbriquee ici pour avoir les lettres!
            for(int j=0;j< _directions.size(); j++) {
                letter = _directions.get(j);
                //System.err.println("letter: " + letter);
            }
        }*/
    }
}
