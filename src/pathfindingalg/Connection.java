
package pathfindingalg;

import java.util.*;

public class Connection {
    protected final Point destination;
    protected final float velocity;
    protected final float distance;
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
        return this.velocity / this.distance;
    }
}
