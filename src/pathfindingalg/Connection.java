
package pathfindingalg;

import java.util.*;

public class Connection {
    protected final Point destination;
    private final float velocity;
    private final float distance;
   
    public Connection(Point destination, float velocity, float distance)
    {
        this.destination = destination;
        this.velocity = velocity;
        this.distance = distance;
    }
    
    protected float travelTime()  
    {
        return this.distance/ this.velocity;
    }
}
