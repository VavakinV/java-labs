package comparators;

import furniture.*;
import java.util.Comparator;

public class CostComparator implements Comparator<Furniture> {
    public int compare(Furniture f1, Furniture f2) {
        return Double.compare(f1.getCost(), f2.getCost());
    }
}
