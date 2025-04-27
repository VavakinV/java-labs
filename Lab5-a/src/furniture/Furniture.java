package furniture;

import predicates.FurniturePredicate;

import java.util.*;

public class Furniture {
    private String category;
    private String color;
    private double cost;
    private int[] dimensions; // высота, ширина, глубина

    public Furniture(String category, String color, double cost, int[] dimensions) {
        this.category = category;
        this.color = color;
        this.cost = cost;
        this.dimensions = dimensions;
    }

    public int getVolume() {
        return dimensions[0] * dimensions[1] * dimensions[2];
    }

    public String getCategory(){
        return category;
    }

    public String getColor(){
        return color;
    }

    public double getCost() {
        return cost;
    }

    public static List<Furniture> filterByPredicate(List<Furniture> list, FurniturePredicate predicate){
        List<Furniture> result = new ArrayList<>();
        for (Furniture furniture:list){
            if (predicate.test(furniture)){
                result.add(furniture);
            }
        }
        return result;
    }

    public static Furniture findMin(List<Furniture> list, Comparator<Furniture> comparator){
        if (list.isEmpty()) throw new RuntimeException("List is empty");
        Furniture result = list.getFirst();
        for (int i = 0; i < list.size()-1; i++){
            Furniture f1 = list.get(i);
            Furniture f2 = list.get(i+1);
            if (comparator.compare(result, f2) > 0){
                result = f2;
            }
        }
        return result;
    }

    public static Furniture findMax(List<Furniture> list, Comparator<Furniture> comparator) {
        if (list.isEmpty()) throw new RuntimeException("List is empty");
        Furniture result = list.getFirst();
        for (int i = 0; i < list.size() - 1; i++) {
            Furniture f1 = list.get(i);
            Furniture f2 = list.get(i + 1);
            if (comparator.compare(result, f2) < 0) {
                result = f2;
            }
        }
        return result;
    }

    public static double totalCost(List<Furniture> list){
        double result = 0;
        for (Furniture furniture : list) {
            result += furniture.getCost();
        }
        return result;
    }

    @Override
    public String toString() {
        return category + " (Color: " + color + ", Cost: " + cost + ", Dimensions: " + Arrays.toString(dimensions) + ")";
    }
}

