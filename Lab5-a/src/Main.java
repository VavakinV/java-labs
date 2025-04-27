import comparators.CostComparator;
import comparators.VolumeComparator;
import furniture.*;
import predicates.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Furniture> furnitureList = Arrays.asList(
                new Furniture("table", "black", 150.0, new int[]{80, 120, 60}),
                new Furniture("table", "white", 200.0, new int[]{85, 130, 65}),
                new Furniture("table", "brown", 250.0, new int[]{90, 130, 100}),
                new Furniture("table", "brown", 180.0, new int[]{50, 100, 50}),
                new Furniture("chair", "black", 50.0, new int[]{90, 40, 40}),
                new Furniture("chair", "white", 60.0, new int[]{150, 50, 50}),
                new Furniture("chair", "brown", 75.0, new int[]{180, 45, 45}),
                new Furniture("chair", "brown", 70.0, new int[]{175, 75, 75}),
                new Furniture("chair", "brown", 80.0, new int[]{150, 50, 50}),
                new Furniture("chair", "brown", 90.0, new int[]{180, 60, 60}),
                new Furniture("sofa", "brown", 500.0, new int[]{150, 250, 80}),
                new Furniture("sofa", "brown", 550.0, new int[]{125, 210, 75}),
                new Furniture("armchair", "black", 200.0, new int[]{100, 80, 80}),
                new Furniture("armchair", "white", 250.0, new int[]{105, 85, 85}),
                new Furniture("armchair", "brown", 250.0, new int[]{120, 90, 90}),
                new Furniture("armchair", "brown", 225.0, new int[]{115, 85, 85})
        );

        //Предикаты
        List<Furniture> chairs = Furniture.filterByPredicate(furnitureList, new isChair());
        List<Furniture> tables = Furniture.filterByPredicate(furnitureList, new isTable());
        List<Furniture> sofas = Furniture.filterByPredicate(furnitureList, new isSofa());
        List<Furniture> armchairs = Furniture.filterByPredicate(furnitureList, new isArmchair());

        System.out.println("---------------------------------------------------------\nПРЕДИКАТЫ\n---------------------------------------------------------");

        System.out.println("Самый маленький стул: " + Furniture.findMin(chairs, new VolumeComparator()));
        System.out.println("Самый большой стул: " + Furniture.findMax(chairs, new VolumeComparator()));

        System.out.println("Самый маленький стол: " + Furniture.findMin(tables, new VolumeComparator()));
        System.out.println("Самый большой стол: " + Furniture.findMax(tables, new VolumeComparator()));

        System.out.println("Самый маленький диван: " + Furniture.findMin(sofas, new VolumeComparator()));
        System.out.println("Самый большой диван: " + Furniture.findMax(sofas, new VolumeComparator()));

        System.out.println("Самое маленькое кресло: " + Furniture.findMin(armchairs, new VolumeComparator()));
        System.out.println("Самое большое кресло: " + Furniture.findMax(armchairs, new VolumeComparator()));

        System.out.println("---------------------------------------------------------");

        chairs.sort(new CostComparator());
        tables.sort(new CostComparator());
        sofas.sort(new CostComparator());
        armchairs.sort(new CostComparator());

        System.out.println("Самый дешёвый стул: " + chairs.getFirst());
        System.out.println("Самый дорогой стул: " + chairs.getLast());

        System.out.println("Самый дешёвый стол: " + tables.getFirst());
        System.out.println("Самый дорогой стол: " + tables.getLast());

        System.out.println("Самый дешёвый диван: " + sofas.getFirst());
        System.out.println("Самый дорогой диван: " + sofas.getLast());

        System.out.println("Самое дешёвое кресло: " + armchairs.getFirst());
        System.out.println("Самое дорогое кресло: " + armchairs.getLast());

        System.out.println("---------------------------------------------------------");

        List<Furniture> brownSet = new ArrayList<>();
        FurniturePredicate isbrown = new isBrown();

        List<Furniture> brownChairs = Furniture.filterByPredicate(chairs, isbrown);
        List<Furniture> brownSofas = Furniture.filterByPredicate(sofas, isbrown);
        List<Furniture> brownArmchairs = Furniture.filterByPredicate(armchairs, isbrown);

        brownSet.addAll(brownChairs.subList(0, 4));
        brownSet.add(brownSofas.getFirst());
        brownSet.addAll(brownArmchairs.subList(0, 2));

        System.out.println("Набор коричневого цвета: " + brownSet);
        System.out.println("Суммарная стоимость набора: " + Furniture.totalCost(brownSet));

        //Лямбда
        System.out.println("---------------------------------------------------------\nЛЯМБДА\n---------------------------------------------------------");
        chairs = Furniture.filterByPredicate(furnitureList, (Furniture furniture) -> furniture.getCategory().equals("chair"));
        tables = Furniture.filterByPredicate(furnitureList, (Furniture furniture) -> furniture.getCategory().equals("table"));
        sofas = Furniture.filterByPredicate(furnitureList, (Furniture furniture) -> furniture.getCategory().equals("sofa"));
        armchairs = Furniture.filterByPredicate(furnitureList, (Furniture furniture) -> furniture.getCategory().equals("armchair"));

        Comparator<Furniture> volumeComparator = Comparator.comparingDouble(Furniture::getVolume);

        System.out.println("Самый маленький стул: " + Furniture.findMin(chairs, volumeComparator));
        System.out.println("Самый большой стул: " + Furniture.findMax(chairs, volumeComparator));

        System.out.println("Самый маленький стол: " + Furniture.findMin(tables, volumeComparator));
        System.out.println("Самый большой стол: " + Furniture.findMax(tables, volumeComparator));

        System.out.println("Самый маленький диван: " + Furniture.findMin(sofas, volumeComparator));
        System.out.println("Самый большой диван: " + Furniture.findMax(sofas, volumeComparator));

        System.out.println("Самое маленькое кресло: " + Furniture.findMin(armchairs, volumeComparator));
        System.out.println("Самое большое кресло: " + Furniture.findMax(armchairs, volumeComparator));

        System.out.println("---------------------------------------------------------");

        Comparator<Furniture> costComparator = Comparator.comparingDouble(Furniture::getCost);

        chairs.sort(costComparator);
        tables.sort(costComparator);
        sofas.sort(costComparator);
        armchairs.sort(costComparator);

        System.out.println("Самый дешёвый стул: " + chairs.getFirst());
        System.out.println("Самый дорогой стул: " + chairs.getLast());

        System.out.println("Самый дешёвый стол: " + tables.getFirst());
        System.out.println("Самый дорогой стол: " + tables.getLast());

        System.out.println("Самый дешёвый диван: " + sofas.getFirst());
        System.out.println("Самый дорогой диван: " + sofas.getLast());

        System.out.println("Самое дешёвое кресло: " + armchairs.getFirst());
        System.out.println("Самое дорогое кресло: " + armchairs.getLast());

        System.out.println("---------------------------------------------------------");

        brownSet = new ArrayList<>();

        brownChairs = Furniture.filterByPredicate(chairs, (Furniture furniture) -> furniture.getColor().equals("brown"));
        brownSofas = Furniture.filterByPredicate(sofas, (Furniture furniture) -> furniture.getColor().equals("brown"));
        brownArmchairs = Furniture.filterByPredicate(armchairs, (Furniture furniture) -> furniture.getColor().equals("brown"));

        brownSet.addAll(brownChairs.subList(0, 4));
        brownSet.add(brownSofas.getFirst());
        brownSet.addAll(brownArmchairs.subList(0, 2));

        System.out.println("Набор коричневого цвета: " + brownSet);
        System.out.println("Суммарная стоимость набора: " + Furniture.totalCost(brownSet));

        System.out.println("---------------------------------------------------------");
    }
}