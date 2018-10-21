package lawnmover;

public class Lawnmover {
    private int x;
    private int y;
    private char direction;

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
                y++;
                break;
            case 'S':
                y--;
                break;
            case 'E':
                x++;
                break;
            case 'W':
                x--;
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

    @Override
    public String toString() {
        return "Lawnmover{" + "x=" + x + ", y=" + y + ", direction=" + direction + '}';
    }

    public static void main(String[] args) {
        Lawnmover t = new Lawnmover(1, 2, 'N');
        System.out.println(t);
        /*t.tournerGauche();
        t.avancer();
        System.out.println(t);

        t.tournerGauche();
        t.avancer();
        System.out.println(t);

        t.tournerGauche();
        t.avancer();
        System.out.println(t);

        t.tournerGauche();
        t.avancer();
        t.avancer();
        System.out.println(t);*/
    }
}
