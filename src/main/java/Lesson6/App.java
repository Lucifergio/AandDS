package Lesson6;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        int level = 0;
        int numberTree = 0;
        final int TOTAL_TREE = 20;
        int notBalancedTree = 0;

        List<TreeImpl> treeArr = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            treeArr.add(new TreeImpl());
        }

        for (TreeImpl tree : treeArr) {

            while (level < 4) {
                int Random = (int) (Math.random() * (50 + 1)) - 25;
                tree.add(Random);
                level = tree.getLevel();
            }

            if (tree.getLevelLeft() > tree.getLevelRight() + 1 || tree.getLevelLeft() + 1 < tree.getLevelRight()) {
                System.out.println("Tree - " + ++numberTree + " Not balanced!!!");
                notBalancedTree++;
            } else {
                System.out.println("Tree - " + ++numberTree + ". Tree depth = " + level);
                level = 0;
            }
        }

        System.out.println("The percentage of unbalanced trees is = " + ((notBalancedTree * 100) / TOTAL_TREE) + "%");

    }
}
