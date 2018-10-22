package lawnmover;

import java.util.Arrays;
import java.util.List;

public class Lawnmover {
    private int x;
    private int y;
    private char direction;//initial orientation
    /***
     * It corresponds to GAGAGAGAA , for instance.
     */
    private String path;
    //
    private String pathToFile = "file.txt";
    private int size = Read.grassSize(pathToFile);

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public Lawnmover(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Lawnmover(int x, int y, char direction,String path) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.path = path;
    }

    public Lawnmover() {
        //default direction to avoid exceptions
        setDirection('N');
    }

    /***
     * movement of one, considering each directions
     */
    public void move() {
        switch (direction) {
            case 'N':
                if(y<=size) {
                    y++;
                }
                break;
            case 'S':
                if(y>=0) {
                    y--;
                }
                break;
            case 'E':
                if(x<=size) {
                    x++;
                }
                break;
            case 'W':
                if(x>=0) {
                    x--;
                }
                break;
        }
    }

    public void turnLeft() {
        switch (direction) {
            case 'N':
                setDirection('W');
                break;
            case 'S':
                setDirection('E');
                break;
            case 'E':
                setDirection('N');
                break;
            case 'W':
                setDirection('S');
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case 'N':
                setDirection('E');
                break;
            case 'E':
                setDirection('S');
                break;
            case 'S':
                setDirection('W');
                break;
            case 'W':
                setDirection('N');
                break;
        }
    }

    /***
     * Calculate/Move the lawnmover , given a path.
     * @param path
     */
    public void calculate(String path){
        String[] directions = path.split("");
        List<String> l_directions = Arrays.asList(directions);
        l_directions.forEach(letter ->{
            if ("A".equals(letter)) {
                move();
            }
            if ("G".equals(letter)) {
                turnLeft();
            }
            if ("D".equals(letter)) {
                turnRight();
            }
        });
    }

    @Override
    public String toString() {
        return   x + " " + y + " " + direction ;
    }

    public static void main(String[] args) {
        String path = "GAGAGAGAA";
        Lawnmover lm = new Lawnmover(1, 2, 'N',path);
        System.out.println(lm);
        lm.calculate(path);
        System.out.println(lm);

        String path2 = "AADAADADDA";
        Lawnmover lm2 = new Lawnmover(3, 3, 'E',path2);
        System.out.println(lm2);
        lm2.calculate(path2);
        System.out.println(lm2);

    }
}
