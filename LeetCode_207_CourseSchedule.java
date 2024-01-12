import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.List;

public class LeetCode_207_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites.length == 0) {
            return true;
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
            numCoursesCompleted++;
            List<Integer> list = dependencyMap.get(node);
            if (list != null) {
                for (Integer nextCourse : list) {
                    if (--inorderDegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }

        }

        return numCourses == numCoursesCompleted;
    }
}
