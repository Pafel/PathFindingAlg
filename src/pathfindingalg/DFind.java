
package pathfindingalg;
import java.util.*;
import java.lang.Float.*;
import java.util.Stack.*;


public class DFind {
    
    private float theTravelTime;
    
    public float getTime(){
        return theTravelTime;
    }
    
    public void findShortestPath(List<DNode> nodes, DNode source, DNode destination){
        List<DNode> unvisited = new ArrayList<>(nodes);
        source.setTravelTimeTo(0.0f);
        DNode currentNode = source;

        while(!unvisited.isEmpty()){
            for (Neighbour nb : currentNode.neighbours){
                DNode currentNborNode = nb.node;
                if (unvisited.contains(currentNborNode)){
                    float totalDist = currentNode.getTravelTimeTo() + nb.getTravelTimeTo() + currentNborNode.getWaitTime();

                    if (totalDist < currentNborNode.getTravelTimeTo()){
                        currentNborNode.setTravelTimeTo(totalDist);
                        currentNborNode.setPrev(currentNode);
                    }
                }
            }
            unvisited.remove(currentNode);
            if (currentNode == destination)
                return;
            Collections.sort(unvisited, DNode.Comparators.DISTANCE);
            if (Float.isInfinite(unvisited.get(0).getTravelTimeTo()))
                return;
            currentNode = unvisited.get(0);
        }
    }
        
    public Stack<DNode> getShortestPath(DNode destination){
        theTravelTime = destination.getTravelTimeTo() - destination.getWaitTime();
        Stack<DNode> thePath = new Stack<>();
        DNode node = destination;
        while (node.getPrev() != null){
            thePath.push(node);
            node = node.getPrev();
        }
        thePath.push(node);
        
        return thePath;
    }
}