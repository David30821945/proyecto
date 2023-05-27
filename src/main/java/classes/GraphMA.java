/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author carre
 */
public class GraphMA{
    private boolean directed;
    private int maxNodes;
    private int numEdges;
    private int [][] matrixAdy;

    public GraphMA(boolean directed) {
        this.directed = directed;
        maxNodes = numEdges = 0;
    }
    public GraphMA (int n, boolean d) {
        directed = d;
        maxNodes = n;
        numEdges = 0;
        matrixAdy = new int[n][n];
}
    public void insertArista(int i, int j, int relationshipValue){
        matrixAdy [i][j] = relationshipValue;
        if (!directed){
            matrixAdy [j] [i] = matrixAdy [i] [j];
        }
    }
    public void deleteArista(int i, int j){
        matrixAdy [i][j] = 0;
        if (!directed){
            matrixAdy [j] [i] = 0;
        }
    }
    public void insertaVertice (int n) {
        if ( n > maxNodes - numEdges )
        System.out.println ("Error, se supera el número de nodos máximo");
        else {
        for (int i=0; i < numEdges + n; i++) {
        for (int j = numEdges; j < numEdges + n; j++)
        matrixAdy [i] [j] = matrixAdy [j] [i] = 0;
        }
        numEdges = numEdges + n;
        }
    }
    
    public void imprimirTable () {
    System.out.println ("La matriz contiene " + numEdges + " vértices: \n");
    for (int i = 0; i < numEdges; i++) {
        for (int j = 0; j < numEdges; j++) {
            if (matrixAdy [i] [j] !=0){
            System.out.print (matrixAdy [i][j]);}
            else {System.out.print ("0 ");
            }
        }
        System.out.println("\n");
    }
    }
    public boolean existeArista (int i, int j){
        return matrixAdy [i] [j] != 0;
    }

    public int countIslands() {
        int islandsCount = 0;
        int rows = matrixAdy.length;
        int cols = matrixAdy[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrixAdy[i][j] != 0 && !visited[i][j]) {
                    islandsCount++;
                    dfs(matrixAdy, visited, i, j);
                }
            }
        }

        return islandsCount;
    }
    private void dfs(int[][] graph, boolean[][] visited, int row, int col) {
        int rows = graph.length;
        int cols = graph[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || graph[row][col] == 0 || visited[row][col]) {
            return;
        }
        visited[row][col] = true; // Mark as visited
        // Explore adjacent cells
        dfs(graph, visited, row - 1, col); // Up
        dfs(graph, visited, row + 1, col); // Down
        dfs(graph, visited, row, col - 1); // Left
        dfs(graph, visited, row, col + 1); // Right
    }

}