package 自己玩.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动物动态代理
 */
public class AnimalProxy implements InvocationHandler {

    private Animal animal;

    public AnimalProxy(Animal animal) {
        this.animal = animal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动物发出声音前执行的动作");
        Object invoke = method.invoke(animal, args);
        System.out.println("动物发出声音后执行的动作");
        return invoke;
    }
}
