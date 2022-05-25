import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> arrayList;
    private Double weight;

    public Box(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
    }

    public void addFruit(T fruit) {
        arrayList.add(fruit);
    }

    public void removeFruit(T fruit) {
        arrayList.remove(fruit);
    }

    public void sprinkleFruits(Box<T> boxToSprincle, int amount) {
        System.out.println("Пересыпаем");
        for (int i = 0; i < amount; i++) {
            T fruit = arrayList.get(0);
            this.removeFruit(fruit);
            boxToSprincle.addFruit(fruit);
        }
    }

    public Double getTotalWeight() {
        Double sum = 0.0;
        for (int i = 0; i < arrayList.size(); i++) {
            sum += arrayList.get(i).getWeight();
        }
        this.weight = sum;
        return sum;
    }

    public Boolean compare(Box<?> boxToCompare) {
        return Math.abs(this.getTotalWeight() - boxToCompare.getTotalWeight()) < 0.0001;
    }
}
