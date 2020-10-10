import edu.duke.*;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    
    public int getNumPoints (Shape s) {
        int numPoints = 0;
        for(Point point : s.getPoints()){
            numPoints += 1;
        }
        return numPoints;
    }
    
    public double getAverageLength (Shape s) {
        return getPerimeter(s) / getNumPoints(s);      
    }
    
    public double getLargestSide (Shape s) {
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double side = prevPt.distance(currPt);
            if (side > largestSide) {
                largestSide = side;
            }
        }
        return largestSide; 
    }
    
    public double getLargestX (Shape s) {
        double largestX = 0.0;
        for (Point point : s.getPoints()) {
            if (point.getX() > largestX) {
                largestX = point.getX();
            }
        }
        return largestX; 
    }

    
    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        
        System.out.println("Points of the shape are " + getNumPoints(s));
        System.out.println("perimeter = " + getPerimeter(s));
        System.out.println("Average Side Lengths = " + getAverageLength(s));
        System.out.println("Largest Side = " + getLargestSide(s));
        System.out.println("Largest X Value = " + getLargestX(s));
    }
    
    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
