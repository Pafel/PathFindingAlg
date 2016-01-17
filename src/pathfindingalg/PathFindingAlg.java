package pathfindingalg;

import java.util.*;
import java.io.*;

public class PathFindingAlg { 
    
    
    
    public static void main(String[] args) throws IOException {
        
        if (args[0].equals("r"))
        {
            int[][] res = new int[1][2];
        
            for(int k = 0 ; k < 1 ; k++) {
            
            Random generator = new Random();
            List<Point> points = new ArrayList<>();
            int index;
            int n = 0;
            int c = 0;
            while (n == 0)
                n = generator.nextInt(1000);
            while (c == 0)
                c = generator.nextInt(500);
            int con = 0;

            for(int i = 0 ; i < n ; i++)
            {
              points.add(new Point(i, Integer.toString(i), generator.nextFloat()*20));
            }

            for(int i = 0 ; i < n+c ; i++)
            {
              Point p = points.get(generator.nextInt(n));
              Point q = points.get(generator.nextInt(n));
              p.connects.add(new Connection(q, generator.nextFloat()*20, generator.nextFloat()*20));
            }
        
            for(Point p : points)
            {
                if(p.connects.isEmpty() == true)
                    p.connects.remove(p);
                else
                    con += p.connects.size();
                    
            }
            System.out.println(Integer.toString(points.size()) + " " + Integer.toString(con));
            
            MPAlg nasz = new MPAlg(points);
            Point point1 = points.get(generator.nextInt(points.size()));
            Point point2 = points.get(generator.nextInt(points.size()));
            long start_time = System.nanoTime();
            res[k][1] = nasz.find(point1, point2);
            long end_time = System.nanoTime();
            double difference = (end_time - start_time)/1e6;
            if(!nasz.path.equals("nope")) {
                System.out.println(nasz.path);
                System.out.println(Float.toString(nasz.time));
                System.out.println(Double.toString(difference));
                res[k][0] = con;
            }
            else
            {
                res[k][0] = 0;
                res[k][1] = 0;
            }
            }
            for (int k = 0 ; k < 1 ; k++)
                if(res[k][0] != 0 && res[k][1] != 0)
                    System.out.println(Integer.toString(res[k][0]) + " " + Integer.toString(res[k][1]));
            
            return;
        }
        
        
        if (args.length != 3)
        {
            System.out.println("Nie podano wystarczającej liczby parametrów");
            return;
        }
            
        
        String basefile = args[0];
        List<Point> points = new ArrayList<>();
        List<DNode> nodes = new ArrayList<>();
        int index = 0;
        
        try (BufferedReader in = new BufferedReader(
                new FileReader(basefile))) {
            String s;
            
            while((s = in.readLine()) != null)
            {
                String parts[] = s.split(" ");
                if(parts.length == 2)
                {
                    float a = Float.parseFloat(parts[1]);
                    points.add(new Point(index, parts[0], a));
                    nodes.add(new DNode(index, parts[0], a));
                    index++;
                }
                else if(parts.length == 4) {
                    float a = Float.parseFloat(parts[2]);
                    float b = Float.parseFloat(parts[3]);
                    Point c = null;
                    Point d = null;
                    DNode e = null;
                    DNode f = null;
                    for(Point point : points) {
                        if(point.id.equals(parts[0]))
                            c = point;
                        else if(point.id.equals(parts[1]))
                            d = point;  
                    }
                    
                    for(DNode node : nodes) {
                        if(node.id.equals(parts[0]))
                            e = node;
                        else if(node.id.equals(parts[1]))
                            f = node;
                    }
                    if(c != null && d != null && e != null && f != null) {
                        c.connects.add(new Connection(d, b, a));
                        e.neighbours.add(new Neighbour(f, b, a));
                    }
                    else {
                        System.out.println("Błędny plik, nie można dodać ścieżki");
                        return;
                    }  
                }
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
            return;
        }
             
        MPAlg nasz = new MPAlg(points);
        Point point1 = null;
        Point point2 = null;
        for(Point point : points) {
            if (point.id.equals(args[1]))
                point1 = point;
            else if (point.id.equals(args[2]))
                point2 = point;
        }
        if(point1 == null || point2 == null) {
            System.out.println("Nie znaleziono punktów");
            return;
        }    
        System.out.println("Oryginalny algorytm:");
        nasz.find(point1, point2);
        System.out.println(nasz.path);
        System.out.println(Float.toString(nasz.time));
        
        System.out.println("Algorytm Dijkstry:");
        DFind djikstra = new DFind();
        djikstra.findShortestPath(nodes, nodes.get(0), nodes.get(5));
        Stack<DNode> tmp = djikstra.getShortestPath(nodes.get(5));
        DPath thePath = new DPath(tmp);
        System.out.println(thePath.toString() + "\n" + djikstra.getTime());
    } 
    
}
