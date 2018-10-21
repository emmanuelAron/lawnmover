package lawnmover;

import java.util.List;

public class Directions {

    private List<String> directions;

    public Directions(List<String> directions) {
        this.directions = directions;
    }
    public Directions(){

    }

    public List<String> getDirections() {
        return directions;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }

    @Override
    public String toString() {
        return "Directions{" + "directions=" + directions + '}';
    }
}
