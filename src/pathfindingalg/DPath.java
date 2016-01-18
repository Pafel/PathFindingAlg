
package pathfindingalg;
import java.util.*;
import java.lang.Float.*;
import java.util.Stack.*;


public class DPath {
    protected Stack<DNode> travelPath = new Stack();

    DPath(Stack<DNode> sdn){
        travelPath = sdn;
    }
    
    @Override
    public String toString(){
        
        StringBuilder string = new StringBuilder();
        
        while (!travelPath.empty()){
           string.append(travelPath.pop().toString());
           string.append(" -> "); 
        }
        
        return string.toString().substring(0, string.lastIndexOf(" -> "));
    }
    
}