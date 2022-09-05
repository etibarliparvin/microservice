package az.ingress.aop.services;

public class Service1 {

    public void sayHello0() {
        sayHello();
    }

    public void sayHello() {
        System.out.println("Hello World");
    }
}
