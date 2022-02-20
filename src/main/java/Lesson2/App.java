package Lesson2;

public class App {
    public static void main(String[] args) {

        Notebook[] notebooks = new Notebook[10000];
        int length = notebooks.length;
        int counter = 0;

        while (length > 0) {
            length--;
            notebooks[counter] = new Notebook();
            counter++;
        }
     /*
        for (int i = 0; i < notebooks.length; i++) {
          System.out.println(notebooks[i].getBrand() + " " + notebooks[i].getPrice() + " " + notebooks[i].getRam());
        }
      */

        //System.out.println();
        Notebook[] arr2 = sort(notebooks);
        /*
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(notebooks[i].getBrand() + " " + notebooks[i].getPrice() + " " + notebooks[i].getRam());
        }
         */

    }

    public static Notebook[] sort(Notebook[] arr) {

        boolean isChange;
        int limit = arr.length;
        Notebook notebook = new Notebook();

        do {
            limit--;
            isChange = false;
            for (int i = 0; i < limit; i++) { // Сортировка по цене
                if (arr[i].getPrice() > arr[i + 1].getPrice()) {
                    Notebook temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isChange = true;
                } else if (arr[i].getPrice() == arr[i + 1].getPrice()) {// Сортировка по RAM
                    if (arr[i].getRam() > arr[i + 1].getRam()) {
                        Notebook temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        isChange = true;
                    } else if (arr[i].getRam() == arr[i + 1].getRam()) {
                        if (!arr[i].getBrand().equals(arr[i + 1].getBrand())) { // Сортировка по бренду
                            int counter1 = 0;
                            int counter2 = 0;

                            for (int j = 0; j < notebook.getARRAY_BRAND().length; j++) {

                                if (arr[i].getBrand().equals(notebook.getARRAY_BRAND()[j])) {
                                    counter1 = j;
                                }

                                if (arr[i + 1].getBrand().equals(notebook.getARRAY_BRAND()[j])) {
                                    counter2 = j;
                                }
                            }
                            if (counter1 > counter2) {
                                Notebook temp = arr[i];
                                arr[i] = arr[i + 1];
                                arr[i + 1] = temp;
                                isChange = true;
                            }
                        }
                    }
                }
            }
        } while (isChange);
        return arr;
    }
}
