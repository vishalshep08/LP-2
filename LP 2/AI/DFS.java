import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Scanner;

public class DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        int n = sc.nextInt();
        System.out.println("Enter the number of edges:");
        int m = sc.nextInt();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        System.out.println("Enter the edges:");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];
        System.out.println("Enter the starting node:");
        int l = sc.nextInt();
        System.out.println("DFS Traversal starting from node" + l +":");
        traversal.dfsUsingStack(adjList, l, visited);
    }
}

class traversal {
    public static void dfsUsingStack(List<List<Integer>> adjList, int startNode, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();

        stack.push(startNode);

        visited[startNode] = true;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            System.out.print(node + " ");
            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }
}