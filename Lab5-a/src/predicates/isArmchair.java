package predicates;
import furniture.*;

public class isArmchair implements FurniturePredicate{
    public boolean test(Furniture furniture){
        return furniture.getCategory().equals("armchair");
    }
}
