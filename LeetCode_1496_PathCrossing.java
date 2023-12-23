import java.util.HashSet;
import java.util.Set;

public class LeetCode_1496_PathCrossing {
    public boolean isPathCrossing(String path) {

        Set<Pair> map = new HashSet<>();
        map.add(new Pair(0, 0));

        int x = 0, y = 0;
        for (char ch : path.toCharArray()) {

            switch (ch) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }

            Pair currentPosition = new Pair(x, y);

            if (map.contains(currentPosition)) {
                return true;
            } else {
                map.add(currentPosition);
            }
        }

        return false;
    }

    private class Pair {

        private int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Pair other = (Pair) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }

    }
}
