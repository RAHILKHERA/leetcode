public class LeetCode_1700_NumberOfStudentsUnabletoEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {

        int count = 0;
        int student = 0, sandwich = 0;
        boolean countChanged = false;
        while (sandwich < sandwiches.length) {
            if (students[student] == sandwiches[sandwich]) {
                countChanged = true;
                count++;
                students[student] = 2;
                student++;
                sandwich++;

            } else {
                student++;
            }

            if (student == students.length) {
                if (!countChanged) {
                    break;
                } else {
                    student = 0;
                    countChanged = false;
                }
            }
        }

        return students.length - count;
    }
}
