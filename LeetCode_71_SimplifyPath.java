import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

public class LeetCode_71_SimplifyPath {
    public static void main(String[] args) {
        assertEquals("/a/b/c/d",new Solution_LeetCode_71_SimplifyPath().simplifyPath("/a//b//c//////d"));
        assertEquals("/home",new Solution_LeetCode_71_SimplifyPath().simplifyPath("/home/"));
        assertEquals("/c",new Solution_LeetCode_71_SimplifyPath().simplifyPath("/a/./b/../../c/"));
        assertEquals("/home/user/Pictures",new Solution_LeetCode_71_SimplifyPath().simplifyPath("/home/user/./Downloads/../Pictures/././"));
        assertEquals("/home/user/Documents",new Solution_LeetCode_71_SimplifyPath().simplifyPath("/../home/user/Documents"));
        assertEquals("/", new Solution_LeetCode_71_SimplifyPath().simplifyPath("/../"));
    }
}

class Solution_LeetCode_71_SimplifyPath {
    public String simplifyPath(String path) {
        String pathSeperator = "/";
        String tokens [] = path.split(pathSeperator); 
        LinkedList<String> list = new LinkedList<String>();
        for (String token : tokens) {
            if (!token.isEmpty() && !token.equals(".")) {
                if (token.equals("..")) {
                    if (!list.isEmpty()) list.removeLast();
                } else {
                    list.addLast(token);
                }
            }
        }

        StringBuilder builder = new StringBuilder();

        for (String token : list) {
            builder.append(pathSeperator).append(token);
        }

        if (builder.isEmpty()) {
            builder.append(pathSeperator);
        }

        
        return builder.toString();
    }
}
