package pathfindingalg;

import java.util.*;


public class Point {
    private final int index;
    protected final float waitTime;
    protected final String id;
    protected final List<Connection> connects;
    protected float timeFromStart;
    protected boolean isVisited;
    
    public Point(int index, String id, float waitTime)
    {
        this.index = index;
        this.waitTime = waitTime;
        this.connects = new ArrayList<Connection>();
        this.id = id;
        this.timeFromStart = 0.0f;
        this.isVisited = false;
    }
}
