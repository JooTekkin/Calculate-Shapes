
import perimeterAssignmentPart1.PerimeterAssignmentRunner;

public class Main {
    public static void main(String[] args) {
        PerimeterAssignmentRunner perimeter = new PerimeterAssignmentRunner();
        // Use this to show information about the file you choose
        perimeter.testPerimeter();
        // Use this to show the largest Perimeter from the files you choose
        perimeter.testPerimeterMultipleFiles();
        // Use this to show the name of file with largest perimeter
        perimeter.testFileWithLargestPerimeter();
    }
}