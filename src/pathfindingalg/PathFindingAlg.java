package pathfindingalg;

import java.util.*;
import java.io.*;

public class PathFindingAlg { 
    
    public static void main(String[] args) throws IOException {
        
        if (args.length != 3)
        {
            System.out.println("Nie podano wystarczającej liczby parametrów");
            return;
        }
            
        
        String basefile = args[0];
        List<Point> points = new ArrayList<>();
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
                    index++;
                }
                else if(parts.length == 4) {
                    float a = Float.parseFloat(parts[2]);
                    float b = Float.parseFloat(parts[3]);
                    Point c = null;
                    Point d = null;
                    for(Point point : points) {
                        if(point.id.equals(parts[0]))
                            c = point;
                        else if(point.id.equals(parts[1]))
                            d = point;
                    }
                    if(c != null && d != null)
                        c.connects.add(new Connection(d, a, b));
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
        
        nasz.find(point1, point2);
        System.out.println(nasz.path);
        System.out.println(Float.toString(nasz.time));
    } 
}
