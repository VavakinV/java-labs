package predicates;
import furniture.*;

public class isWhite implements FurniturePredicate{
    public boolean test(Furniture furniture){
        return furniture.getColor().equals("white");
    }
}
