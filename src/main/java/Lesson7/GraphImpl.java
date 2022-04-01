package Lesson7;

import java.util.*;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    /**
     * HomeWork
     */
    public void findingProfitableRoute() {

        int totalPrice = 0;
        int localPrice = 0;
        Queue<Vertex> totalQueue = new ArrayDeque<>();
        Queue<Vertex> localQueue = new ArrayDeque<>();

        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] > 0) {
                    totalPrice += adjMatrix[i][j];
                }
            }
        }

        for (int i = 0; i < vertexList.size() - 1; i++) {
            for (int j = 0; j < vertexList.size(); j++) {
                if (adjMatrix[i][j] > 0 && !vertexList.get(j).isVisited()) {

                    localQueue.add(vertexList.get(j));
                    vertexList.get(j).setIsVisited(true);
                    localPrice = localPrice + adjMatrix[i][j];
                    i = j - 1;

                    if (vertexList.get(j).getLabel().equals("Воронеж")) {
                        vertexList.get(j).setIsVisited(false);
                        vertexList.get(0).setIsVisited(false);
                        if (localPrice < totalPrice) {
                            totalQueue.clear();
                            totalQueue.addAll(localQueue);
                            localQueue.clear();
                            totalPrice = localPrice;
                            localPrice = 0;
                            i = -1;
                        }
                    }
                    break;
                }
            }
        }
        System.out.print("Самый выгодный маршрут: ");
        System.out.print("Москва -> ");
        while (!totalQueue.isEmpty()) {
            if (totalQueue.peek().getLabel().equals("Воронеж")) {
                System.out.print(totalQueue.poll().getLabel() + " = " + totalPrice + " Попугаев.");
            } else {
                System.out.print(totalQueue.poll().getLabel() + " -> ");
            }
        }
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, int price) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = price;


        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] > 0) {
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
