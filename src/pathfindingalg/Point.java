package pathfindingalg;

import java.util.*;


public class Point {
    protected final int index;
    protected final float waitTime;

    protected final List<Connection> connects;
    protected float timeFromStart;
    protected boolean isVisited;
    
    public Point(int index, float waitTime)
    {
        this.index = index;
        this.waitTime = waitTime;
        this.connects = new ArrayList<Connection>();
        this.timeFromStart = 0.0f;
        this.isVisited = false;
    }
}
