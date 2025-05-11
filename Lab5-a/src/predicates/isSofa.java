package predicates;
import furniture.*;

public class isSofa implements FurniturePredicate{
    public boolean test(Furniture furniture){
        return furniture.getCategory().equals("sofa");
    }
}
