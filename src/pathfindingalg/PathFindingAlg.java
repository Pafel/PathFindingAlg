package pathfindingalg;

import java.util.*;

public class PathFindingAlg {
        
    public static void main(String[] args) {
        List<Point> points = new ArrayList<Point>();
        Point a = new Point(0, 3);
        Point b = new Point(1, 5);
        Point c = new Point(2, 2);
        Point d = new Point(3, 7);
        Point e = new Point(4, 17);
        Point f = new Point(5, 5);
        Point g = new Point(6, 1);
        
        
        a.connects.add(new Connection(b, 4, 1));
        a.connects.add(new Connection(d, 1, 1));
        
        b.connects.add(new Connection(c, 6, 1));
        
        c.connects.add(new Connection(g, 6, 1));
        c.connects.add(new Connection(f, 5, 1));
        c.connects.add(new Connection(d, 2, 1));
        
        d.connects.add(new Connection(a, 1, 1));
        d.connects.add(new Connection(c, 2, 1));
        d.connects.add(new Connection(e, 10, 1));
        
        e.connects.add(new Connection(f, 12, 1));
        
        f.connects.add(new Connection(g, 4, 1));
        f.connects.add(new Connection(c, 5, 1));
        
        g.connects.add(new Connection(f, 4, 1));
                
        
        points.add(a);
        points.add(b);
        points.add(c);
        points.add(d);
        points.add(e);
        points.add(f);
        points.add(g);
        
        MPAlg nasz = new MPAlg(points);
        nasz.find(a, f);
        System.out.println(nasz.path);
        System.out.println(Float.toString(nasz.time));
    }
    
}
