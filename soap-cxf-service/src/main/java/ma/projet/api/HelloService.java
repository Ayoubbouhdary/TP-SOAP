package ma.projet.api;

import ma.projet.model.Person;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService(targetNamespace = "http://api.projet.ma/")
public interface HelloService {

    @WebMethod(operationName = "SayHello")
    @WebResult(name = "greeting")
    String sayHello(@WebParam(name = "name") String name);

    @WebMethod(operationName = "FindPerson")
    @WebResult(name = "person")
    Person findPersonById(@WebParam(name = "id") String id);
}
