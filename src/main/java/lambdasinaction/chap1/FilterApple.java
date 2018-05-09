package lambdasinaction.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 筛选苹果的Lambda的例子
 *
 * @author Sean.Xiao
 * @date 2018/5/9 下午2:18
 */
public class FilterApple {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(), new Apple(100, "green"),
        new Apple(70, "red"), new Apple(120, "red"), new Apple(110, "green"));

        List<Apple> greenApples = filterApples(inventory, (Apple a)->"green".equals(a.getColor()));
        System.out.println("greenApples = [" + greenApples + "]");

        List<Apple> redApples = filterApples(inventory, (Apple a)->"red".equals(a.getColor()));
        System.out.println("redApples = [" + redApples + "]");

        List<Apple> heavyApples = filterApples(inventory, (Apple a)->a.weight>100);
        System.out.println("heavyApples = [" + heavyApples + "]");

        List<Apple> lightApples = filterApples(inventory, (Apple a)->a.weight<30);
        System.out.println("lightApples = [" + lightApples + "]");

        List<Apple> hotApples = filterApples(inventory, (Apple a)->a.weight>100 && "red".equals(a.getColor()));
        System.out.println("hotApples = [" + hotApples + "]");
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static class Apple {

        public int weight = 10;
        public String color = "red";

        public Apple(){}

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{color='"+color+"', weight="+weight+"}";
        }
    }
}
