/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Admin
 */
public class Graph {

    private int V;
    private ArrayList<Integer> list[];

    public Graph(int v) {
        this.V = v;
        list = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            list[i] = new ArrayList();
        }
    }

    void addEdge(int v, int w) {
        list[v].add(w);
    }

    void BFS(int s) {
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queueOpen = new LinkedList<Integer>();
        LinkedList<Integer> queueClose = new LinkedList<Integer>();
        while (queueOpen.peek() != null) {
            int temp = queueOpen.poll();
            System.out.print(s + "");
            int n = list[temp].size();
            for (int i = 0; i < n; i++) {
                int close = list[temp].get(i);
                queueClose.addLast(close);
            }
        }
    }
}
