import UpperApp.*;
import org.omg.CORBA.*;

public class UpperCaseImpl extends UpperCasePOA {
    public String to_upper(String input) {
        return input.toUpperCase();
    }
}
