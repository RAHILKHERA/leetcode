import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LeetCode_210_CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] completedCoursesOrder = new int[numCourses];

        if (prerequisites.length == 0) {
            for (int i = completedCoursesOrder.length - 1; i >= 0; i--) {
                completedCoursesOrder[i] = i;
            }
        }

        Map<Integer, List<Integer>> dependencyMap = new HashMap<>();
        int[] inorderDegree = new int[numCourses];

        for (int i[] : prerequisites) {
            dependencyMap.computeIfAbsent(i[1], key -> new ArrayList<>()).add(i[0]);
            inorderDegree[i[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inorderDegree.length; i++) {
            if (inorderDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int numCoursesCompleted = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            completedCoursesOrder[numCoursesCompleted++] = node;
            List<Integer> list = dependencyMap.get(node);
            if (list != null) {
                for (Integer nextCourse : list) {
                    if (--inorderDegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }

        }

        if (numCourses == numCoursesCompleted) {
            return completedCoursesOrder;
        } else {
            return new int[] {};
        }

    }
}
