import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static Integer[] swapElements(Integer[] array, int firstIndex, int secondIndex) {
        Integer c = array[secondIndex];
        array[secondIndex] = array[firstIndex];
        array[firstIndex] = c;
        return array;
    }

    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3, 4, 5 };
        Integer[] newArray = swapElements(array, 0, 1);
        System.out.println(Arrays.toString(newArray));
        Apple apple1 = new Apple(1.0);
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(apple1);
        Box<Apple> appleBox = new Box<>(apples);

        Orange orange1 = new Orange(1.5);
        Orange orange3 = new Orange(1.5);
        ArrayList<Orange> oranges = new ArrayList<>();
        ArrayList<Orange> oranges2 = new ArrayList<>();
        oranges.add(orange1);
        oranges.add(orange3);
        Box<Orange> orangeBox = new Box<>(oranges);
        System.out.println(orangeBox.getTotalWeight());
        System.out.println(appleBox.getTotalWeight());
        System.out.println(orangeBox.compare(appleBox));

        Apple apple2 = new Apple(1.0);
        Orange orange2 = new Orange(1.5);
        oranges2.add(orange2);
        appleBox.addFruit(apple2);
        System.out.println(appleBox.getTotalWeight());

        Box<Orange> orangeBox2 = new Box<>(oranges2);
        System.out.println("1 коробка с апельсинами: " + orangeBox.getTotalWeight());
        System.out.println("2 коробка с апельсинами: " + orangeBox2.getTotalWeight());
        orangeBox2.sprinkleFruits(orangeBox, 1);
        System.out.println("1 коробка с апельсинами: " + orangeBox.getTotalWeight());
        System.out.println("2 коробка с апельсинами: " + orangeBox2.getTotalWeight());
    }
}
