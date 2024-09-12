import java.util.PriorityQueue;

public class LeetCode_138_4 {
    public long minDamage(int power, int[] damage, int[] health) {

        long result = 0;
        int n = damage.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return -1 * Integer.compare(a.damage * b.timeRequired, a.timeRequired * b.damage);
        });

        long totalDamage = 0;

        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(damage[i], health[i], (int) Math.ceil((double) health[i] / power)));
            totalDamage += damage[i];
        }

        while (!pq.isEmpty()) {

            Pair currentEnemy = pq.poll();
            result += totalDamage * currentEnemy.timeRequired;
            totalDamage -= currentEnemy.damage;
        }

        return result;
    }

    class Pair {

        private int damage;
        private int health;
        private int timeRequired;

        Pair(int damage, int health, int timeRequired) {
            this.damage = damage;
            this.health = health;
            this.timeRequired = timeRequired;
        }

    }
}
