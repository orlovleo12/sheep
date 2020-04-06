import java.util.*;
import java.util.stream.Collectors;


/*8. Класс Овца - возраст, цвет шерсти, вес. С помощью стримов написать методы,
которые будут из коллекции овец получать:
суммарный вес.
количество овец с наиболее часто встречавшимся цветом шерсти
максимальный возраст
самую старую овцу с заданным в аргументах цветом шерсти

По задаче правки сейчас распишу
6:33

6:33
должен быть класс сервис который имеет методы, возвращающие значения
6:33
Сервис конструируется от массива овец
6:34
Тестирование того, что все работает, происходит так же в отдельном классе

*/
public class SheepStream {

    public static void main(String[] args) {

        Service serviceSheep = new Service(new Sheep [] {
                new Sheep(12, "black", 50),
                new Sheep(15, "black", 50),
                new Sheep(25, "black", 50),
                new Sheep(100, "white", 50),
                new Sheep(8, "black", 50),
                new Sheep(411, "black", 50)});

        //суммарный вес.
        System.out.println(serviceSheep.allWeight());

        //количество овец с наиболее часто встречавшимся цветом шерсти
        System.out.println(serviceSheep.groupByColor());
        //максимальный возраст
        System.out.println(serviceSheep.maxAgeSheep().getAge());
        //самую старую овцу с заданным в аргументах цветом шерсти
        System.out.println(serviceSheep.maxAgeSheepFilterColor("white"));
    }
}
