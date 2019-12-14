package com.huxl.java8.chapter10;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.function.Supplier;

/**
 * 用
 * @see java.util.Optional 替换 null
 *
 * 对可能缺失的值建模
 *
 * @author huxl
 * @since 2019/12/6-8:47
 */
public class Chapter10Demo {

    public static void main(String[] args) {

        Person person = new Person();

        //声明一个空的Optional
        Optional<Car> optCar = Optional.empty();
        //根据一个非空值创建
        Car car = new Car();
        Optional<Car> optCar1 = Optional.of(car);

        //可接受null的Optional对象 底层三元运算符决定是空还是非空
        Optional<Car> optCar2 = Optional.ofNullable(car);


        //使用map从Optional中提取和转换值
        Insurance insurance = new Insurance();
        insurance.setName("中国平安");
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optInsurance.map(Insurance::getName);
        System.out.println(name.get());

        car.setMaybeInsurance(optInsurance);
        person.setMaybeCar(optCar);

        String insuranceName = person.getMaybeCar().flatMap(Car::getMaybeInsurance).map(Insurance::getName).orElse("Unknown");

        System.out.println("insurance name :" +insuranceName);


        //在域模型中使用Optional 以及为什么它们无法序列化

        //将允许暂无定义或者缺失的变量用特殊的形式标记出来，Optional的设计初衷仅仅是为了要支持能返回Optional对象的语法 Brian

        //并不是设计来用做字段的，所以可以在域对象中提供一个访问声明为Optional、变量值可能缺失的接口
        /*
         *     class Person{
         *         private Car car;
         *
         *         public Optional<Car> getCarAsOptional(){
         *             return Optional.ofNullable(car);
         *         }
         *     }
         */

        //默认行为及解引用Optional对象

        Car car1 = optCar.orElseGet(() -> car);

        //实战演练
        Map<String,Object> map = new HashMap<>();
        Optional<Object> value = Optional.ofNullable(map.get("key"));
        System.out.println(value.orElse("无"));
    }

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        }catch (Exception e) {
            return Optional.empty();
        }
    }

    /**
     * 命令式的方式
     * 要解决的问题是：从属性中读取一个值，该值是以秒为单位计量的一段时间，且时间必须是正数
     * @param properties
     * @param name
     * @return
     */
    public int readDuration1(Properties properties,String name) {
        String value = properties.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            }catch (NumberFormatException e) {

            }
        }
        return 0;
    }

    /**
     * Optional的方式
     * @param properties
     * @param name
     * @return
     */
    public int readDuration(Properties properties, String name) {
        return Optional.ofNullable(properties.getProperty(name))
                .flatMap(Chapter10Demo::stringToInt)
                .filter( i -> i > 0)
                .orElse(0);
    }





}

class Person{
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    //人可能有车 也可能没车，所以声明为Optional
    private Optional<Car> maybeCar;

    public Optional<Car> getMaybeCar() {
        return maybeCar;
    }

    public void setMaybeCar(Optional<Car> maybeCar) {
        this.maybeCar = maybeCar;
    }
}

class Car{
    private Insurance insurance;

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    private Optional<Insurance> maybeInsurance;

    public Optional<Insurance> getMaybeInsurance() {
        return maybeInsurance;
    }

    public void setMaybeInsurance(Optional<Insurance> maybeInsurance) {
        this.maybeInsurance = maybeInsurance;
    }
}

class Insurance{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

