package predicates;
import furniture.*;

public class isBrown implements FurniturePredicate{
    public boolean test(Furniture furniture){
        return furniture.getColor().equals("brown");
    }
}