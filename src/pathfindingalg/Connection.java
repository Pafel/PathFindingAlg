
package pathfindingalg;

import java.util.*;

public class Connection {
    protected final Point destination;
    private final float velocity;
    private final float distance;
    protected final boolean isBilateral;
    
    public Connection(Point destination, float velocity, float distance)
    {
        this.destination = destination;
        this.velocity = velocity;
        this.distance = distance;
        this.isBilateral = false;
    }
    
    protected float travelTime()  
    {
        return this.distance/ this.velocity;
    }
}
