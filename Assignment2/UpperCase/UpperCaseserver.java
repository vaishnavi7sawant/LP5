import UpperApp.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;

public class UpperCaseServer {
    public static void main(String args[]) {
        try {
            ORB orb = ORB.init(args, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            UpperCaseImpl upperImpl = new UpperCaseImpl();
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(upperImpl);
            UpperCase href = UpperCaseHelper.narrow(ref);

            // Bind to Name Service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            ncRef.rebind(ncRef.to_name("UpperService"), href);

            System.out.println("UpperCase Server ready...");
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
