package az.ingress.aop.services;

public class Service1Proxy extends Service1{

    public void sayHello() {
        System.out.println("Proxy in action");
        super.sayHello();
        System.out.println("Proxy completed");
    }
}
