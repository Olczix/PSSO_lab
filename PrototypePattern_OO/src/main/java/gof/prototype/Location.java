package gof.prototype;

import java.io.Serializable;

public class Location implements Serializable {
    protected int x,y;

    Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    int getX(){
        return this.x;
    }

    int getY(){
        return this.y;
    }

    void gotoXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Location other = (Location) obj;
        if (this.x != other.x) return false;
        if (this.y != other.y) return false;
        return true;
    }
}
