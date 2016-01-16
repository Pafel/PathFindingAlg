
package pathfindingalg;

import java.util.*;

public class MPAlg {
    private final List<Point> allPoints;
    private Path newPath;
    public String path = "nope";
    public float time;
    
    public MPAlg(List<Point> list)
    {
        this.allPoints = list;
        this.time = 0.0f;
    }
    
    private void resetVisits()
    {
        for(Point point : allPoints)
            point.isVisited = false;
    }
    
    public void find(Point start, Point finish)
    {
        newPath = new Path(start, finish);
        for (Connection connect : start.connects) {
                start.isVisited = true;
                search(connect, finish);
                resetVisits();
                newPath.timeReset();
        }
    }
    
    private void search(Connection a, Point z)
    {
        //System.out.println(newPath.toString() + Integer.toString(a.destination.index));
        if(newPath.totalTravelTime > time && time != 0) {
            return;
        }
        
        if (a.destination.timeFromStart != 0)
            a.destination.timeFromStart = Math.min(a.destination.timeFromStart, newPath.totalTravelTime);
        else
            a.destination.timeFromStart = newPath.totalTravelTime;
        
        if(a.destination.isVisited) {
            return;
        } else
            a.destination.isVisited = true;
        
        if(a.destination == z) {
            newPath.travelPath.push(a);
            newPath.setTime();
            time = newPath.getTime();
            path = newPath.toString();
        }
        else {
            newPath.travelPath.push(a);
            newPath.setTime();
            for (Connection connect : a.destination.connects) {
                search(connect, z);
            }
        }
            
        a.destination.isVisited = false;
        newPath.travelPath.pop();
        return;
    }
}
