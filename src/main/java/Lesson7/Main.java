package Lesson7;

public class Main {
    public static void main(String[] args) {
        dfsCity();
    }

    private static void dfsCity() {
        Graph graph = new GraphImpl(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва", "Тула", 6);
        graph.addEdge("Москва", "Рязань", 3);
        graph.addEdge("Москва", "Калуга", 5);
        graph.addEdge("Тула", "Липецк", 7);
        graph.addEdge("Липецк", "Воронеж", 15);
        graph.addEdge("Рязань", "Тамбов", 5);
        graph.addEdge("Тамбов", "Саратов", 4);
        graph.addEdge("Саратов", "Воронеж", 4);
        graph.addEdge("Калуга", "Орел",6);
        graph.addEdge("Орел", "Курск", 8);
        graph.addEdge("Курск", "Воронеж", 12);

        graph.findingProfitableRoute();
    }
}
