package comparators;

import furniture.*;
import java.util.Comparator;

public class VolumeComparator implements Comparator<Furniture>{
    public int compare(Furniture f1, Furniture f2) {
        return Integer.compare(f1.getVolume(), f2.getVolume());
    }
}
