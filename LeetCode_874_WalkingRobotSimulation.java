import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.junit.Test;

public class LeetCode_874_WalkingRobotSimulation {

    @Test
    public void test1() {
        assertEquals(25, robotSim(new int[] { 4, -1, 3 }, new int[][] {}));
    }

    @Test
    public void test2() {
        assertEquals(65, robotSim(new int[] { 4, -1, 4, -2, 4 }, new int[][] { { 2, 4 } }));
    }

    @Test
    public void test3() {
        assertEquals(36, robotSim(new int[] { 6, -1, -1, 6 }, new int[][] {}));
    }

    public int robotSim(int[] commands, int[][] obstacles) {

        int maxDistance = 0;
        Set<Pair> obstaclesSet = new HashSet<>();

        for (int[] obstacle : obstacles) {
            obstaclesSet.add(new Pair(obstacle[0], obstacle[1]));
        }

        // Starting at origing facing North
        int[] direction = { 0, 1 };
        int x = 0;
        int y = 0;

        for (int command : commands) {
            if (command < 0) { // change direction
                direction = newDirection(command, direction);
            } else { // move
                if (direction[0] == 0) {

                    if (direction[1] == 1) { // move North

                        while (command > 0) {
                            if (obstaclesSet.contains(new Pair(x, y + 1))) {
                                break;
                            }
                            y++;
                            maxDistance = Math.max(maxDistance, (x * x) + (y * y));
                            command--;
                        }

                    } else { // move South
                        while (command > 0) {
                            if (obstaclesSet.contains(new Pair(x, y - 1))) {
                                break;
                            }
                            y--;
                            maxDistance = Math.max(maxDistance, (x * x) + (y * y));
                            command--;
                        }
                    }

                } else {
                    if (direction[0] == 1) { // Move East
                        while (command > 0) {
                            if (obstaclesSet.contains(new Pair(x + 1, y))) {
                                break;
                            }
                            x++;
                            maxDistance = Math.max(maxDistance, (x * x) + (y * y));
                            command--;
                        }
                    } else { // move west

                        while (command > 0) {
                            if (obstaclesSet.contains(new Pair(x - 1, y))) {
                                break;
                            }
                            x--;
                            maxDistance = Math.max(maxDistance, (x * x) + (y * y));
                            command--;
                        }
                    }
                }
            }
        }

        return maxDistance;
    }

    private int[] newDirection(int command, int[] currentDirection) {

        int x = currentDirection[0];
        int y = currentDirection[1];

        if (x == 0) { // N or S

            if (y == 1) { // N

                currentDirection = command == -1 ? new int[] { 1, 0 } : new int[] { -1, 0 };

            } else { // S
                currentDirection = command == -1 ? new int[] { -1, 0 } : new int[] { 1, 0 };
            }

        } else { // E or W

            if (x == 1) { // E
                currentDirection = command == -1 ? new int[] { 0, -1 } : new int[] { 0, 1 };
            } else { // W
                currentDirection = command == -1 ? new int[] { 0, 1 } : new int[] { 0, -1 };
            }
        }

        return currentDirection;
    }

    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Pair pair = (Pair) obj;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
