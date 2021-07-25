/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstrashortestpatharray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DijkstraShortestPathArray {

    public static int max = 100000;
    Scanner sc;
    int n;
    int a[][];
    boolean shortest[];
    int thePrevious[];
    int distance[];
    int start, end;
    boolean isConnected;

    public void readMatrix(String fileName) throws FileNotFoundException {
        sc = new Scanner(new File(fileName));
        n = sc.nextInt();
        a = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                a[r][c] = sc.nextInt();
            }
        }
    }

    public void printGraph() {
        System.out.printf("The graph %dx%d is:\n", n, n);
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.printf("%5d", a[r][c]);
            }
            System.out.println();
        }
    }

    public void Dijkstra_init() {
        shortest = new boolean[n];
        Arrays.fill(shortest, false);
        distance = new int[n];
        thePrevious = new int[n];
        for (int i = 0; i < n; ++i) {
            thePrevious[i] = i;
            distance[i] = max;
        }
        start = 0;
        end = 6;
        distance[start] = 0;
        isConnected = false;
    }

    public int nextNearestVertex() {
        int min = max, minIndex = -1;
        for (int i = 0; i < n; ++i) {
            if (shortest[i] == false && min > distance[i]) {
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void updateDistance(int from) {
        for (int to = 0; to < n; ++to) {
            if (shortest[to] == false
                    && //chua duoc to mau vang
                    a[from][to] > 0
                    && //co duong di truc tiep tu "from" den "to"
                    distance[to] > distance[from] + a[from][to]) {
                distance[to] = distance[from] + a[from][to];
                thePrevious[to] = from;
            }
        }
    }

    public void Dijkstra() {
        int from;
        while (true) {
            from = nextNearestVertex();
            shortest[from] = true; //to mau vang cho dinh "from"

            if (from == end) {
                isConnected = true;
                break;
            } else if (from == -1) { //do thi khong lien thong
                break;
            } else {
                updateDistance(from);
            }
        }
    }

    public void Dijkstra_displayResult() {
        if (isConnected) {
            System.out.printf("The shortest path from %d to %d (Cost: %d)\n", start, end, distance[end]);
            Dijsktra_displayPath();
        } else {
            System.out.printf("Don't find any path from %d to %d\n", start, end);
        }
    }

    public void Dijsktra_displayPath() {
        int vertex = end;
        Stack<Integer> s = new Stack<>();
        s.push(vertex);
        do {
            vertex = thePrevious[vertex];
            s.push(vertex);

        } while (vertex != start);
        vertex = s.pop();
        System.out.printf("%d", vertex);
        while (!s.isEmpty()) {
            vertex = s.pop();
            System.out.printf("-> %d", vertex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            DijkstraShortestPathArray app = new DijkstraShortestPathArray();
            app.readMatrix("data\\data.txt");
            app.printGraph();
            app.Dijkstra_init();
            app.Dijkstra();
            app.Dijkstra_displayResult();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DijkstraShortestPathArray.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
