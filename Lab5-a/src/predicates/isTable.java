package predicates;
import furniture.*;

public class isTable implements FurniturePredicate{
    public boolean test(Furniture furniture){
        return furniture.getCategory().equals("table");
    }
}
