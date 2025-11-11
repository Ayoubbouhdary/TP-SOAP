package ma.projet.impl;

import ma.projet.api.HelloService;
import ma.projet.model.Person;
import jakarta.jws.WebService;

@WebService(
        serviceName = "HelloService",
        portName = "HelloServicePort",
        endpointInterface = "ma.projet.api.HelloService",
        targetNamespace = "http://api.projet.ma/"
)
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Bonjour, " + (name == null ? "inconnu" : name);
    }

    @Override
    public Person findPersonById(String id) {
        return new Person(id, "Ada Lovelace", 36); // valeur exemple
    }
}
