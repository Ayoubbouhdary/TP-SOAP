package ma.projet;

import ma.projet.impl.HelloServiceImpl;
import ma.projet.security.UTPasswordCallback;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;

import java.util.Map;

public class SecureServer {

    public static void main(String[] args) {

        // Configuration WS-Security
        Map<String,Object> inProps = Map.of(
                "action", "UsernameToken",
                "passwordType", "PasswordText",
                "passwordCallbackRef", new UTPasswordCallback(Map.of("student", "secret123"))
        );

        // Intercepteur WS-Security
        WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);

        // Création du serveur
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(HelloServiceImpl.class);
        factory.setAddress("http://localhost:8080/services/hello-secure");
        factory.getInInterceptors().add(wssIn);

        factory.create();

        System.out.println("Secure WSDL: http://localhost:8080/services/hello-secure?wsdl");
    }
}
