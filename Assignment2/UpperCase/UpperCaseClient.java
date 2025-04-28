import UpperApp.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;

public class UpperCaseClient {
    public static void main(String args[]) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            UpperCase upperObj = UpperCaseHelper.narrow(ncRef.resolve_str("UpperService"));

            String input = "corba on two machines";
            String output = upperObj.to_upper(input);

            System.out.println("Response: " + output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
