import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
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

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if (perimeter > largestPerimeter ) {
                largestPerimeter = perimeter;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        File temp = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if (perimeter > largestPerimeter ) {
                largestPerimeter = perimeter;
                temp = f;
            }
        }
        return temp.getName();
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
    
    public void testPerimeterMultipleFiles() {
        System.out.println("Largest Perimeter = " + getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        System.out.println("Largest Perimeter File is " + getFileWithLargestPerimeter());
    }

    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testFileWithLargestPerimeter();
    }
}
