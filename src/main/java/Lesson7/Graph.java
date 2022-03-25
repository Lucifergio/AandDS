package Lesson7;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, int price);

    int getSize();

    void display();

    void findingProfitableRoute ();  //HomeWork
}
