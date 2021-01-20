/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author thema
 */
import java.util.*;

public class Graph {

    private int V;

    private LinkedList<Integer> adj[];
    private boolean visited[];


    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        visited = new boolean[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();

    }

    void addEdge(int v, int w)
    {
        adj[v].add(w);
    }



    void DFS(int s)
    {

        Stack<Integer> stack = new Stack<>();
        stack.add(s);
        while (!stack.isEmpty()) {
            stack.pop();
            if(visited[s] == false)
            {
                visited[s] = true;
                System.out.print(s + " ");

            }
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                    DFS(n);
            }
        }
    }

    void BFS(int s)
    {

        boolean visited[] = new boolean[V];


        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[])
    {
        Graph g = new Graph(18);
        Scanner n = new Scanner(System.in);
        System.out.println("*****  Visualisasi Novel Dalam Kehidupan Perkuliahan  *****\n");
        System.out.println("Ketika pertama kali masuk perkuliahan, jurusan mana yang anda pilih?");
        System.out.println("1. Informatika");
        System.out.println("2. Teknik Sipil");
        System.out.println("3. Teknik Elektro");
        System.out.println("4. lain-lain\n");
        System.out.println("Masukkan pilihan anda");
        int p = n.nextInt();
        {
            if (p<=4)
                g.addEdge(1, 2);
        
        else{
                System.out.println("pilihan anda tidak ada didalam menu");
                return;
                }        
        }
        
        System.out.println("\nApakah Jurusan yang Anda pilih sudah selesai?");
        System.out.println("1. ya");
        System.out.println("2. tidak");
        int t = n.nextInt();
        {
            switch (t) {
                case 1:
                    
                    g.addEdge(2, 3);
                    System.out.println("\nApakah anda lakukan setelah itu?");
                    System.out.println("1. berusaha belajar");
                    System.out.println("2. bersantai");
                    break;
                case 2:
                    
                    g.addEdge(2, 4);
                    System.out.println("\nApakah anda lakukan setelah itu?");
                    System.out.println("1. berusaha belajar");
                    System.out.println("3. menyerah");
                    break;
                default:
                    System.out.println("not found");
                    break;
            }
        }

        System.out.println("\nApakah anda lakukan setelah itu?");
        int r = n.nextInt();
        


        System.out.println("DFS : ");
        g.DFS(1);
        System.out.println("\nBFS : ");
        g.BFS(1);
    }
}