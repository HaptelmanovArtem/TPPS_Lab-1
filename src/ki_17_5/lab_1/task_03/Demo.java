package ki_17_5.lab_1.task_03;

import java.util.*;
import java.util.stream.*;

public class Demo {

    public static void main(String[] args) {
        ArrayList<Building> buildings = new ArrayList<>();

        buildings.add(new Building("L. Svobody", 8, 51));
        buildings.add(new Building("Peremohy", 5, 14));
        buildings.add(new Building("Nauky", 5, 12));
        buildings.add(new Building("Haharina", 14, 21));
        buildings.add(new Building("Moskovskiy", 8, 11));

        System.out.println("Initial list of buildings:");
        buildings.forEach(i -> System.out.println(i.getStreetName() + " " + i.getBuildingNumber() + " (" +
                i.getFloorsNumber() + ")"));
        System.out.println();

        // Получить поток элементов списочного массива,
        Stream<Building> buildingStream = buildings.stream();

        // определить максимальное (метод max() ) и минимальное(метод min()) значение номера дома,
        Optional<Building> max = buildingStream.max(Comparator.comparing(Building::getBuildingNumber));
        if (max.isPresent()) {
            String output = String.format("Maximal building number - %d", max.get().getBuildingNumber());
            System.out.println(output);
        }

        buildingStream = buildings.stream();
        Optional<Building> min = buildingStream.min(Comparator.comparing(Building::getBuildingNumber));
        if (min.isPresent()) {
            String output = String.format("Minimal building number - %d", min.get().getBuildingNumber());
            System.out.println(output);
        }
        System.out.println();

        // отсортировать (метод sorted()) здания в потоке в порядке убывания номеров домов.
        Stream<Building> sortedBuildings = buildings.stream().
                sorted(Comparator.comparing(Building::getBuildingNumber).reversed());

        System.out.println("Sorted buildings");
        sortedBuildings.forEach(building -> System.out.println(building.getBuildingNumber() + ", "));
        System.out.println();

        // Произвести вывод на экран данных о зданиях с четным значением
        // количества этажей и о зданиях с нечетным значением количества этажей,
        // большим, значения, введенного с клавиатуры
        Scanner in = new Scanner(System.in);
        System.out.println("Input number of floors");
        Integer num = in.nextInt();

        Stream<Building> evenFloors = buildings.stream().filter((i) -> i.getFloorsNumber() % 2 == 0).
                filter(i -> i.getFloorsNumber() > num);
        System.out.println("Buildings with even floors number and bigger floors number then given value");
        evenFloors.forEach(i -> System.out.println(i.getStreetName() + " " + i.getBuildingNumber() + " (" +
                i.getFloorsNumber() + ")"));
        System.out.println();

        Stream<Building> oddFloors = buildings.stream().filter((i) -> i.getFloorsNumber() % 2 != 0).
                filter(i -> i.getFloorsNumber() > num);
        System.out.println("Buildings with odd floors number and bigger floors number then given value");
        oddFloors.forEach(i -> System.out.println(i.getStreetName() + " " + i.getBuildingNumber() + " (" +
                i.getFloorsNumber() + ")"));
        System.out.println();
    }
}
