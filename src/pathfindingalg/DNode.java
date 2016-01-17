

package pathfindingalg;
import java.util.*;
import java.lang.Float.*;


public class DNode implements Comparable<DNode>{ //djikstra node
    private static int n = 0;
    
    
    private final int index;
    protected final String id;
    protected List<Neighbour> neighbours;
    private final float waitTime;
    
    private DNode prev; 
    private float travelTimeToStart; // 0 - initial start , inf - initial others
    
    DNode(int i, String s, float wt){
        index = i;
        id = s;
        waitTime = wt;
        neighbours = new ArrayList<>();
        prev = null;
        travelTimeToStart = java.lang.Float.POSITIVE_INFINITY;
    }
    
    public void loadNbor(DNode dn, float v, float dt){
        Neighbour tmpbor = new Neighbour(dn, v, dt);
        neighbours.add(tmpbor);
    }
    
    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append(id);
        return string.toString();
    }
    
    @Override
    public int compareTo(DNode dn){
        return Comparators.DISTANCE.compare(this, dn);
    }
    
    public float getWaitTime(){
        return waitTime;
    }
    
    public float getTravelTimeTo(){
        return travelTimeToStart;
    }
    
    public DNode getPrev(){
        return prev;
    }
    
    public void setPrev(DNode dn){
        prev = dn;
    }
    
    public void setTravelTimeTo(float dist){
        travelTimeToStart = dist;
    }
    
    public static class Comparators{
        public static final Comparator<DNode> DISTANCE = (DNode dn1, DNode dn2) -> Float.compare(dn1.travelTimeToStart, dn2.travelTimeToStart);
    }

}

