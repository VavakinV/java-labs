package predicates;
import furniture.*;

public class isChair implements FurniturePredicate{
    public boolean test(Furniture furniture){
        return furniture.getCategory().equals("chair");
    }
}
