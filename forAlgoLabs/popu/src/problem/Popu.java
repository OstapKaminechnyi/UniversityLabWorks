package problem;

import java.util.Stack;

public class Popu {

    private int dfs(String[] friends){

        Stack<Integer> stack = new Stack<>();
        int doubleFriends = 0;
        int maxFriends = 0;
        for (int i=0;i<friends.length;i++){
                boolean []isVisited = new boolean[friends[i].length()];
            isVisited[i] = true;
            for (int j=0;j<friends[i].length();j++){
                if(friends[i].charAt(j) == 'Y' && isVisited[i]){
                    stack.push(j);
                    doubleFriends++;
                    isVisited[j] = true;
                }
            }
            doubleFriends += checkDoubleFriends(isVisited, friends, 0, stack);
            maxFriends = Math.max(maxFriends,doubleFriends);
            System.out.println(i+" "+ doubleFriends);
            doubleFriends = 0;
        }

        return maxFriends;
    }
    private static int checkDoubleFriends(boolean isVisited[], String[] friends, int count, Stack stack) {
        while (!stack.isEmpty()){
            int j = (Integer) stack.pop();
            for (int k=0;k<friends[j].length();k++){
                if (isVisited[k]) continue;
                else if (friends[j].charAt(k) == 'Y')
                    count++;
            }
        }
        return count;
    }

    public static void main(String arg[]){
        String friends[] = new String[]
                {"NYY", "YNY", "YYN"};
        System.out.println(new Popu().dfs(friends));
    }}