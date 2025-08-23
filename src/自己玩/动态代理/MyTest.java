package 自己玩.动态代理;

import java.lang.reflect.Proxy;

public class MyTest {

    public static void main(String[] args) {
        Animal cat = new Cat();
        AnimalProxy animalProxy = new AnimalProxy(cat);
        Animal proxyCat = (Animal) Proxy.newProxyInstance(animalProxy.getClass().getClassLoader(), cat.getClass().getInterfaces(), animalProxy);
        proxyCat.speak();

        System.out.println("================================");

        Animal dog = new Dog();
        AnimalProxy dogProxy = new AnimalProxy(dog);
        Animal proxyDog = (Animal) Proxy.newProxyInstance(dogProxy.getClass().getClassLoader(), dog.getClass().getInterfaces(), dogProxy);
        proxyDog.speak();
    }

}
