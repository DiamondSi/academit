import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SmallArrayList {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> listString = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("in.txt"))) {
            while (scanner.hasNextLine()) {
                listString.add(scanner.nextLine());
            }
        }
        System.out.println(listString);

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 1, 1, 2, 2, 3, 4, 4, 4, 5, 6, 1, 1, 1));
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(2, 6, 5, 2, 1, 1, 2, 2, 3, 4, 4, 4, 5, 6, 1, 1, 1));
        System.out.println(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        for (Integer element : list1) {
            if (!list2.contains(element)) {
                list2.add(element);
            }
        }
        System.out.println(list2);
    }
}
