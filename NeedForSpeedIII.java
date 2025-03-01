package ExamPreparation;

import java.util.*;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> car = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] commandParts = scanner.nextLine().split("\\|");
            String brand = commandParts[0];
            int km = Integer.parseInt(commandParts[1]);
            int fuel = Integer.parseInt(commandParts[2]);

            List<Integer> currentCar = new ArrayList<>();

            currentCar.add(km);
            currentCar.add(fuel);

            car.put(brand,currentCar);

        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")){
            String[] array = command.split(" : ");
            String currentCmd = array[0];
            String brand = array[1];
            switch (currentCmd){
                case "Drive":
                    int distance = Integer.parseInt(array[2]);
                    int fuel = Integer.parseInt(array[3]);

                    int currentFuel = car.get(brand).get(1);
                    int currentKM = car.get(brand).get(0);
                    int diffKM = currentKM + distance;
                    int diffFuel = currentFuel - fuel;
                    if (currentFuel <= fuel){
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        car.get(brand).set(0,diffKM);
                        car.get(brand).set(1,diffFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",brand,distance,fuel);
                    }
                    if (diffKM >= 100000) {
                        System.out.printf("Time to sell the %s!%n", brand);
                        car.remove(brand);
                    }
                    break;
                case "Refuel":
                    int refuel = Integer.parseInt(array[2]);
                    int currentF = car.get(brand).get(1);
                    if (refuel + currentF > 75) {
                        int diff = 75 - currentF;
                        System.out.printf("%s refueled with %d liters%n",brand,diff);
                        car.get(brand).set(1,75);
                    } else {
                        System.out.printf("%s refueled with %d liters%n",brand,refuel);
                        int totalFuel = refuel + currentF;
                        car.get(brand).set(1,totalFuel);
                    }
                    break;
                case "Revert":
                    int km = Integer.parseInt(array[2]);
                    int currentKm = car.get(brand).get(0);
                    int diff = currentKm - km;
                    if (diff < 10000){
                        car.get(brand).set(0,10000);
                    } else {
                        car.get(brand).set(0,diff);
                        System.out.printf("%s mileage decreased by %d kilometers%n",brand,km);
                    }
                    break;
            }


            command = scanner.nextLine();
        }

        car.entrySet().forEach(entry -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",entry.getKey(),entry.getValue().get(0),entry.getValue().get(1)));
    }
}
