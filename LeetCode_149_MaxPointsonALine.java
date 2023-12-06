import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LeetCode_149_MaxPointsonALine {

    public static void main(String[] args) {
        int [] [] points = new int [][] {
                                         {0,0}, 
                                         {4,5},
                                         {7,8},
                                         {8,9},
                                         {5,6},
                                         {3,4},
                                         {1,1}
                                        };
        new Solution_LeetCode_149_MaxPointsonALine().maxPoints(points);
    }
    
}

class Solution_LeetCode_149_MaxPointsonALine {
    public int maxPoints (int [][] points) {

       if (points.length == 1) {
        return 1;
       }
       
        HashMap <String, HashSet<String>> slopeCount = new HashMap<String, HashSet<String>>();
        HashMap <Integer, HashSet<String>> verticalLines = new HashMap<Integer, HashSet<String>>();


        for (int i = 0; i < points.length; i++) {

          
            int x1 = points[i][0];
            int y1 =  points[i][1];
            String point1 = x1 + "_" + y1;
                        

            for (int j = i + 1; j < points.length; j++) {

                int x2 = points[j][0];
                int y2 = points[j][1];
                
                String point2 = x2 + "_" + y2;

                if (x1 == x2) {
                    if (verticalLines.containsKey(x1)) {
                        HashSet<String>  pointList = verticalLines.get(x1);
                        if (!pointList.contains(point1)) {
                            pointList.add(point1);
                        }

                        if (!pointList.contains(point2)) {
                            pointList.add(point2);
                        }
                    } else {
                        HashSet<String> pointList = new HashSet<>();
                        pointList.add(point1);
                        pointList.add(point2);
                        verticalLines.put(x1, pointList);
                    }
                } else {
                    double slope = (double)(y2 - y1)/(x2-x1);
                    double y_intercept = y1 - slope * x1; 

                    String sc = slope + "_" + y_intercept;

                    if (slopeCount.containsKey(sc)) {
                        HashSet<String> pointList = slopeCount.get(sc);
                        if (!pointList.contains(point1)) {
                            pointList.add(point1);
                        }

                        if (!pointList.contains(point2)) {
                            pointList.add(point2);
                        }
                    } else {
                        HashSet<String> pointList = new HashSet<>();
                        pointList.add(point1);
                        pointList.add(point2);
                        slopeCount.put(sc, pointList);
                    }
                }
            }
        }

        int max = 0; 

        for (Map.Entry <String, HashSet<String>>entry : slopeCount.entrySet() ) {
            int numberOfPoints = entry.getValue().size();
            if (numberOfPoints > max) {
                max = numberOfPoints;
            }
        }

        for (Map.Entry <Integer, HashSet<String>>entry : verticalLines.entrySet() ) {
            int numberOfPoints = entry.getValue().size();
            if (numberOfPoints > max) {
                max = numberOfPoints;
            }
        }

        return max;
    }
}






