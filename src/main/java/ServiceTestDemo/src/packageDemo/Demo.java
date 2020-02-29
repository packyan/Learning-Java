package packageDemo;

import package_1.ServiceImpl;
import package_1.ServiceImplTwo;
import package_1.myServiceInter;
import java.util.ServiceLoader;

public class Demo {
    public static void main(String[] args) {
        ServiceImpl ser = new ServiceImpl();
        ServiceImplTwo ser2 = new ServiceImplTwo();
        ser.service();
        ser2.service();
        ServiceLoader<package_1.myServiceInter> myServiceInters =
                ServiceLoader.load(package_1.myServiceInter.class);
        for(var myser : myServiceInters){
            myser.service();
        }
    }
}
