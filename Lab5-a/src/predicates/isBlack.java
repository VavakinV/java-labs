package predicates;
import furniture.*;

public class isBlack implements FurniturePredicate{
    public boolean test(Furniture furniture){
        return furniture.getColor().equals("black");
    }
}
