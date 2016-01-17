
package pathfindingalg;
import java.util.*;


public class Neighbour {
    protected final DNode node;
    private final float distanceTo;
    private final float velocity;
    private final float travelTimeTo;
    
    
    Neighbour(DNode n, float v, float dt){
        node = n;
        distanceTo = dt;
        velocity = v;
        travelTimeTo = dt/v;
    }
    
    public float getTravelTimeTo(){
        return travelTimeTo;
    }
    
}
