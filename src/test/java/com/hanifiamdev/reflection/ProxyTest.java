package com.hanifiamdev.reflection;

import com.hanifiamdev.reflection.data.Car;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    void testProxy() {
        InvocationHandler invocationHandler = new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if(method.getName().equals("getName")) {
                    return "Car Proxy";
                }

                if (method.getName().equals("run")) {
                    System.out.println("Car is running");
                }
                return null;
            }
        };

        // Membuat Proxy
        Car car = (Car) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Car.class}, invocationHandler);

        System.out.println(car.getClass());
        System.out.println(car.getName());
        System.out.println("=============");
        // panggil run
        car.run();;
    }
}
