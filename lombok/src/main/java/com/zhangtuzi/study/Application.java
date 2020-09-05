package com.zhangtuzi.study;

import com.zhangtuzi.study.dto.Animal;
import com.zhangtuzi.study.dto.Dog;

public class Application {

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.setId(1);
        animal.setName("豆豆");
        animal.setAge(3);
        animal.setType("狗");
        System.out.println(animal.toString());

        Dog dog = new Dog();
        dog.setId(2);
        dog.setName("旺财");
        dog.setAge(1);
        dog.setType("狗");
        dog.setBreed("柯基");
        System.out.println(dog.toString());

//        Dog dog = Dog.builder().id(1).name("狗").age(3).type("柯基").build();
//        System.out.println(dog.toString());
    }
}
