package perimeterAssignmentPart1;

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
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

    //This method calculate the number of the shapes
     public int getNumPoints (Shape s) {
        int numPoints = 0;
        for(Point ignored : s.getPoints()){
            numPoints++;
        }
        return numPoints;
    }

    //This method calculate the average of the shapes
    public double getAverageLength(Shape s) {
        return getPerimeter(s) / getNumPoints(s);
    }

    // This method calculate the largest side of the shape
    public double getLargestSide(Shape s) {
        double largestSide = 0.0;
        Point lastPoint = s.getLastPoint();
        for(Point point : s.getPoints()){
            double distance = point.distance(lastPoint);
            if(distance >= largestSide){
                largestSide = distance;
            }
        }
        return largestSide;
    }

    // This method calculate the largest X point of the shape
    public double getLargestX(Shape s) {
        double largestX = 0.0;
        for(Point point : s.getPoints()){
            int xlong = point.getX();
            if(xlong >= largestX){
                largestX = xlong;
            }
        }
        return largestX;
    }

    // This method calculate the largest Perimeter of many shapes
    public double getLargestPerimeterMultipleFiles() {
        double largestPerimeterMultipleFiles = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for(File file : dr.selectedFiles()){
            FileResource fileResource = new FileResource(file);
            Shape s = new Shape(fileResource);
            double largestPerimeter = getPerimeter(s);
            if(largestPerimeter >= largestPerimeterMultipleFiles){
                largestPerimeterMultipleFiles = largestPerimeter;
            }
        }
        return largestPerimeterMultipleFiles;
    }

    // This method show the name of the file of the largest Perimeter
    public String getFileWithLargestPerimeter() {
        File temp = null;
        double largestPerimeterMultipleFiles = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for(File file : dr.selectedFiles()){
            FileResource fileResource = new FileResource(file);
            Shape s = new Shape(fileResource);
            double largestPerimeter = getPerimeter(s);
            if(largestPerimeter >= largestPerimeterMultipleFiles){
                largestPerimeterMultipleFiles = largestPerimeter;
                temp = file;
            }
        }
        assert temp != null;
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double averageLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestx = getLargestX(s);
        System.out.println("perimeter = " + length +"\nnumber of points = " + numPoints +
                "\nAverage Length = " + averageLength + "\nLargest side = " + largestSide +
                "\nLargest X = " + largestx);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPerimeterMultipleFiles = getLargestPerimeterMultipleFiles();
        System.out.println("largestPerimeterMultipleFiles = " + largestPerimeterMultipleFiles);
    }

    public void testFileWithLargestPerimeter() {
        String name = getFileWithLargestPerimeter();
        System.out.println("File name = " + name);
    }


}
