/**
 * HackerRank Problem statement:
 * 
 * https://www.hackerrank.com/challenges/bfsshortreach
 * 
 */

package com.hackerRank;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class BFSshortestReach {

	private int distances[];  
    private Set<Integer> settled;  
    private Set<Integer> unsettled;  
    private int number_of_nodes;  
    private int adjacencyMatrix[][];  
    public BFSshortestReach(int number_of_nodes)  
    {  
        this.number_of_nodes = number_of_nodes;  
        distances = new int[number_of_nodes + 1];  
        settled = new HashSet<Integer>();  
        unsettled = new HashSet<Integer>();  
        adjacencyMatrix = new int[number_of_nodes + 1][number_of_nodes + 1];  
    }  
    public void dijkstra_algorithm(int adjacency_matrix[][], int source)  
    {  
        int evaluationNode;  
        for (int i = 1; i <= number_of_nodes; i++)  
            for (int j = 1; j <= number_of_nodes; j++)  
            adjacencyMatrix[i][j] = adjacency_matrix[i][j];  
            for (int i = 1; i <= number_of_nodes; i++)  
        {  
            distances[i] = Integer.MAX_VALUE;  
        }  
        unsettled.add(source);  
        distances[source] = 0;  
        while (!unsettled.isEmpty())  
        {  
            evaluationNode = getNodeWithMinimumDistanceFromUnsettled();  
            unsettled.remove(evaluationNode);  
            settled.add(evaluationNode);  
            evaluateNeighbours(evaluationNode);  
        }  
    }  
    private int getNodeWithMinimumDistanceFromUnsettled()  
    {  
        int min ;  
        int node = 0;  
        Iterator<Integer> iterator = unsettled.iterator();  
        node = iterator.next();  
        min = distances[node];  
        for (int i = 1; i <= distances.length; i++)  
        {  
            if (unsettled.contains(i))  
            {  
                if (distances[i] <= min)  
                {  
                    min = distances[i];  
                    node = i;  
                }  
            }  
        }  
        return node;  
    }  
    private void evaluateNeighbours(int evaluationNode)  
    {  
        int edgeDistance = -1;  
        int newDistance = -1;  
        for (int destinationNode = 1; destinationNode <= number_of_nodes; destinationNode++)  
        {  
            if (!settled.contains(destinationNode))  
            {  
                if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE)  
                {  
                    edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];  
                    newDistance = distances[evaluationNode] + edgeDistance;  
                    if (newDistance < distances[destinationNode])  
                    {  
                        distances[destinationNode] = newDistance;  
                    }  
                    unsettled.add(destinationNode);  
                }  
            }  
        }  
    }  
    public static void main(String... arg)  
    {  
        int adjacency_matrix[][];  
        int number_of_vertices;  
        int source = 0;  
        Scanner s = new Scanner(System.in);  
        int T = s.nextInt();  
        s.nextLine();  
        while(T-->0) {  
            String l = s.nextLine();  
            String[] temp = l.split(" ");  
            number_of_vertices = Integer.parseInt(temp[0]);  
            int M = Integer.parseInt(temp[1]);  
            adjacency_matrix = new int[number_of_vertices+1][number_of_vertices+1];  
            while (M-- > 0) {  
                l = s.nextLine();  
                temp = l.split(" ");  
                int n1 = Integer.parseInt(temp[0]);  
                int n2 = Integer.parseInt(temp[1]);  
                adjacency_matrix[n1][n2] = 1;  
                adjacency_matrix[n2][n1] = 1;  
            }  
            source = s.nextInt();  
            if(T>0)  
                s.nextLine();  
            for (int i = 1; i <= number_of_vertices; i++)  
            {  
                for (int j = 1; j <= number_of_vertices; j++)  
                {  
                    if (i == j)  
                    {  
                        adjacency_matrix[i][j] = 0;  
                        continue;  
                    }  
                    if (adjacency_matrix[i][j] == 0)  
                    {  
                        adjacency_matrix[i][j] = Integer.MAX_VALUE;  
                    }  
                }  
            }
            s.close();
            BFSshortestReach dijkstrasAlgorithm = new BFSshortestReach(number_of_vertices);  
            dijkstrasAlgorithm.dijkstra_algorithm(adjacency_matrix, source);  
            for (int i = 1; i <= dijkstrasAlgorithm.distances.length - 1; i++)  
            {  
                if(source!=i) {  
                    if (dijkstrasAlgorithm.distances[i] < Integer.MAX_VALUE)  
                        System.out.print(dijkstrasAlgorithm.distances[i] * 6 + " ");  
                    else  
                        System.out.print(-1 + " ");  
                }  
            }  
            System.out.println();  
        }  
   }
}
