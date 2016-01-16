package pathfindingalg;

import java.util.*;

public class Path implements Cloneable {
    protected Stack<Connection> travelPath;
    protected float totalTravelTime;
    protected Point from, to;
    
    public Path(Point from, Point to)
    {
        this.travelPath = new Stack();
        this.from = from;
        this.to = to;
        this.totalTravelTime = 0.0f;
    }
    
    protected void setTime()
    {
        this.totalTravelTime = 0.0f;
        Iterator<Connection> i = this.travelPath.iterator();
        Connection tmp;
        while(i.hasNext()) {
            tmp = i.next();
            this.totalTravelTime += tmp.travelTime();
            if (tmp.destination != to)
                this.totalTravelTime += tmp.destination.waitTime;
                
        }
    }
    
    protected void timeReset()
    {
        this.totalTravelTime = 0.0f;
    }
    
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        string.append(from.id + " -> ");
        Iterator<Connection> i = this.travelPath.iterator();
        Connection tmp;
        while(i.hasNext()) {
            tmp = i.next();
            string.append(tmp.destination.id);
            if(tmp.destination != to)
                string.append(" -> ");
        }
        return string.toString();
    }
    
    protected float getTime()
    {
        return totalTravelTime;
    }
}
