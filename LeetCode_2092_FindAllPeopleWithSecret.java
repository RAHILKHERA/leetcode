import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode_2092_FindAllPeopleWithSecret {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        /**
         * If the secret is shared with the person in lower time slot, then that person
         * can share the secret in all the future meetings. This requires to process the
         * meetings as per the time slot. So the meetings should be sorted as per time
         * slot.
         */
        Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[2]));

        /**
         * Visited keeps the track of the people who knows secret.
         * 0th person knows the secret by default and at time 0 it passes it to
         * firstPerson. So 0 and first person is set to true.
         */
        boolean[] visited = new boolean[n];
        visited[0] = true;
        visited[firstPerson] = true;

        for (int i = 0; i < meetings.length;) {

            /**
             * Find the meetings in a given time interval slot.
             */
            int j = i;
            while (j + 1 < meetings.length && meetings[j + 1][2] == meetings[i][2]) {
                j++;
            }

            /**
             * Process the meetings in the given time interval.
             * Here map will be used to keep the adj list i.e. for a given member, the list
             * of members shows the memberes with which it is in meeting.
             * 
             * Members set maintiains the list of all the members in the meeting in current
             * time slot.
             */
            Map<Integer, List<Integer>> adjMap = new HashMap<>();
            Set<Integer> members = new HashSet<>();

            for (int k = i; k <= j; k++) {
                adjMap.computeIfAbsent(meetings[k][0], member -> new ArrayList<>()).add(meetings[k][1]);
                adjMap.computeIfAbsent(meetings[k][1], member -> new ArrayList<>()).add(meetings[k][0]);

                members.add(meetings[k][0]);
                members.add(meetings[k][1]);
            }

            /**
             * If a member is already visite i.e. they have the secret, it will passed to
             * all the members of its adj list.
             * Implement BFS. Add all those members into the queue which already have the
             * secret.
             */

            Deque<Integer> queue = new ArrayDeque<>();

            for (int member : members) {
                if (visited[member]) {
                    queue.offer(member);
                }
            }

            while (!queue.isEmpty()) {

                int member = queue.poll();
                for (int negihbor : adjMap.getOrDefault(member, new ArrayList<>())) {

                    if (!visited[negihbor]) {
                        visited[negihbor] = true;
                        queue.offer(negihbor);
                    }
                }
            }

            i = j + 1;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                result.add(i);
            }
        }
        return result;

    }

    class Solution {
        public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

            int maxMeetTime = 0;

            for (int i = 0; i < meetings.length; i++)
                maxMeetTime = Math.max(maxMeetTime, meetings[i][2]);

            List<List<int[]>> list = new ArrayList<List<int[]>>();
            for (int i = 0; i <= maxMeetTime; i++) {
                list.add(new ArrayList<int[]>());
            }

            for (int i = 0; i < meetings.length; i++) {
                int time = meetings[i][2];
                int a = meetings[i][0];
                int b = meetings[i][1];

                list.get(time).add(new int[] { a, b });
            }

            int parent[] = new int[n];
            for (int i = 0; i < parent.length; i++)
                parent[i] = i;
            parent[firstPerson] = 0;

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).size() == 0)
                    continue;

                for (int j = 0; j < list.get(i).size(); j++) {
                    int a = list.get(i).get(j)[0];
                    int b = list.get(i).get(j)[1];

                    union(a, b, parent);
                }

                for (int j = 0; j < list.get(i).size(); j++) {
                    int a = list.get(i).get(j)[0];
                    int b = list.get(i).get(j)[1];
                    find(a, parent);
                    find(b, parent);

                    if (parent[a] != 0)
                        parent[a] = a;
                    if (parent[b] != 0)
                        parent[b] = b;
                }

            }

            List<Integer> result = new ArrayList<Integer>();
            for (int i = 0; i < parent.length; i++) {
                find(i, parent);

                if (parent[i] == 0)
                    result.add(i);
            }

            return result;
        }

        private static int find(int a, int[] parent) {
            if (a == parent[a])
                return a;
            return parent[a] = find(parent[a], parent);
        }

        private static void union(int a, int b, int[] parent) {
            a = find(a, parent);
            b = find(b, parent);

            if (a != b) {
                if (a <= b) {
                    parent[b] = a;
                } else {
                    parent[a] = b;
                }
            }
        }
    }
}
