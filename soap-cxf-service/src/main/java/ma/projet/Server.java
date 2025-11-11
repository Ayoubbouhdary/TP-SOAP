package ma.projet;

import ma.projet.impl.HelloServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server {

    public static void main(String[] args) {
        String address = "http://localhost:8080/services/hello";

        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(HelloServiceImpl.class);
        factory.setAddress(address);
        factory.create();

        System.out.println("Service SOAP publié ! WSDL: " + address + "?wsdl");
    }
}
