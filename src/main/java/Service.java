import java.util.*;
import java.util.stream.Collectors;

public class Service {
    private List<Sheep> sheepList = new ArrayList<>();

    public Service(Sheep[] sheepList) {
        this.sheepList = Arrays.asList(sheepList);
    }

    public List<Sheep> getSheepList() {
        return sheepList;
    }

    public Sheep maxAgeSheep() {
        return
                sheepList
                        .stream()
                        .max(Comparator.comparing(Sheep::getAge))
                        .orElseThrow(NoSuchElementException::new);//чтобы не надо было использовать Optional<Sheep>
    }

    public int maxAgeSheepFilterColor(String color){
        Map<String, List<Sheep>> groupByColor2 =
                sheepList.stream().collect(Collectors.groupingBy(Sheep::getColor));

         return groupByColor2.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .filter(x->color.equals(x.getKey())).findFirst().get().getValue()
                .stream()
                .max(Comparator.comparing(Sheep::getAge))
                .orElseThrow(NoSuchElementException::new).getAge();
    }

    public int allWeight(){
        return sheepList.stream().reduce(0, (partialAgeResult, sheep) -> partialAgeResult + sheep.getWeight(), Integer::sum);
    }

    public int groupByColor(){
        Map<String, List<Sheep>> groupByColor =
                sheepList.stream().collect(Collectors.groupingBy(Sheep::getColor));
                return  groupByColor.entrySet().stream()
               .sorted(Comparator.comparing(Map.Entry::getKey))
               .findFirst().get().getValue().size();
    }
}
