public class LeetCode_2418_SortthePeople {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Person[] people = new Person[n];

        for (int i = 0; i < n; i++) {
            people[i] = new Person(names[i], heights[i]);
        }

        Person[] sortedPeople = mergeSort(people, 0, n - 1);
        String[] result = new String[n];

        for (int i = 0; i < result.length; i++) {
            result[i] = sortedPeople[i].name;
        }

        return result;
    }

    private Person[] mergeSort(Person[] people, int left, int right) {

        if (right - left == 1) {

            if (people[left].height > people[right].height) {
                return new Person[] { people[left], people[right] };
            }

            return new Person[] { people[right], people[left] };
        }

        int mid = left + (right - left) / 2;

        Person[] leftPeople = mergeSort(people, left, mid);
        Person[] rightPeople = mergeSort(people, mid + 1, right);

        Person[] mergedPeople = new Person[leftPeople.length + rightPeople.length];

        int i = 0, j = 0, index = 0;

        while (i < leftPeople.length && j < rightPeople.length) {
            if (leftPeople[i].height > rightPeople[j].height) {
                mergedPeople[index++] = leftPeople[i++];
            } else {
                mergedPeople[index++] = rightPeople[j++];
            }
        }

        while (i < leftPeople.length) {
            mergedPeople[index++] = leftPeople[i++];
        }

        while (j < rightPeople.length) {
            mergedPeople[index++] = rightPeople[j++];
        }

        return mergedPeople;
    }

    private class Person {

        String name;
        int height;

        Person(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
}
