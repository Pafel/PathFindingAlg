package pathfindingalg;

import java.util.*;
import java.io.*;

public class PathFindingAlg { 
    
    public static void main(String[] args) throws IOException {
        
        String basefile = args[0];
        List<Point> points = new ArrayList<Point>();
        
        try (BufferedReader in = new BufferedReader(
                new FileReader(basefile))) {
            String s;
            
            while((s = in.readLine()) != null)
            {
                String parts[] = s.split(" ");
                if(parts.length == 2)
                {
                    int a = Integer.parseInt(parts[0]);
                    float b = Float.parseFloat(parts[1]);
                    points.add(new Point(a, b));
                }
                else if(parts.length == 4) {
                    int a = Integer.parseInt(parts[0]);
                    int b = Integer.parseInt(parts[1]);
                    float c = Float.parseFloat(parts[2]);
                    float d = Float.parseFloat(parts[3]);
                    Point from = points.get(a);
                    Point to = points.get(b);
                    from.connects.add(new Connection(to, c, d));
                }
            }
        }
             
        MPAlg nasz = new MPAlg(points);
        nasz.find(points.get(0), points.get(5));
        System.out.println(nasz.path);
        System.out.println(Float.toString(nasz.time));
    }
    
}
