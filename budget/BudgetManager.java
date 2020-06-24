package budget;

import java.io.*;
import java.util.*;

public class BudgetManager {




    private double income = 0;
    private final Scanner scanner = new Scanner(System.in);
    private double foodExpense = 0;
    private double clothesExpense = 0;
    private double entertainmentExpense = 0;
    private double otherExpense = 0;
    private double allExpense = 0;
    private final Map<String, Double> FoodMap = new LinkedHashMap<>();
    private final Map<String, Double> ClothesMap = new LinkedHashMap<>();
    private final Map<String, Double> EntertainmentMap = new LinkedHashMap<>();
    private final Map<String, Double> OtherMap = new LinkedHashMap<>();
    private final Map<String, Double> AllMap = new LinkedHashMap<>();
    private final Map<Double, String> sortedFood = new TreeMap<>(Collections.reverseOrder());
    private final Map<Double, String> sortedClothes = new TreeMap<>(Collections.reverseOrder());
    private final Map<Double, String> sortedEntertainment = new TreeMap<>(Collections.reverseOrder());
    private final Map<Double, String> sortedOther = new TreeMap<>(Collections.reverseOrder());
    private final Map<Double, String> sortedAll = new TreeMap<>(Collections.reverseOrder());
  //  private final File file = new File("purchases.txt");
    private final File file = new File("C:\\Users\\90539\\IdeaProjects\\Budget Manager\\Budget Manager\\task\\purchases.txt");

    public BudgetManager() throws IOException {
    }



    public void showMenu() throws IOException {
        boolean exit = true;
        while (exit) {
            System.out.println("Choose your action:");
            System.out.println("1) Add income");
            System.out.println("2) Add purchase");
            System.out.println("3) Show list of purchases");
            System.out.println("4) Balance");
            System.out.println("5) Save");
            System.out.println("6) Load");
            System.out.println("7) Analyze (Sort)");
            System.out.println("0) Exit");
            String str = scanner.nextLine();
            int choice = Integer.parseInt(str);
            System.out.println();
            switch (choice) {
                case 0: {
                    exit = false;
                    System.out.println("Bye!");
                    break;
                }
                case 1: {
                    this.addIncome();
                    break;
                }
                case 2: {
                    this.addPurchase();
                    break;
                }
                case 3: {
                    this.printExpense();
                    break;
                }
                case 4: {
                    this.getBalance();
                    break;
                }
                case 5: {
                    this.saveFile();
                    break;
                }
                case 6: {
                    this.loadFile();
                    break;
                }
                case 7 : {
                    this.analyze();
                    break;
                }
                default: {
                    //showMenu();
                    break;
                }
            }
        }
    }

    public void addIncome() {
        System.out.println("Enter income:");
        String incomeStr = scanner.nextLine();
        System.out.println();
        double income = java.lang.Double.parseDouble(incomeStr);
        this.income += income;
        System.out.println("Income was added!");
        // System.out.println();
    }

    public void getBalance() {
        if(income - allExpense < 0) {
            System.out.printf("Balance: $%.2f", 0.00);
        } else {
            System.out.printf("Balance: $%.2f", income - allExpense);
        }
        System.out.println();
        System.out.println();
    }

    public void addPurchase() {
        boolean exit = true;
        while (exit) {
            System.out.println("Choose the type of purchase:");
            System.out.println("1) Food");
            System.out.println("2) Clothes");
            System.out.println("3) Entertainment");
            System.out.println("4) Other");
            System.out.println("5) Back");
            String purchase = scanner.nextLine();
            int choice = 0;
            try {
                choice = Integer.parseInt(purchase);
            } catch (Exception e) {
                addPurchase();
            }
            switch (choice) {
                case 1: {
                    addFood();
                    break;
                }
                case 2: {
                    addClothes();
                    break;
                }
                case 3: {
                    addEntertainment();
                    break;
                }
                case 4: {
                    addOther();
                    break;
                }
                case 5: {
                    System.out.println();
                    exit = false;
                    break;
                }
                default: {
                    // System.out.println();
                    addPurchase();
                    break;
                }
            }
        }

    }

    public void addFood() {
        System.out.println();
        System.out.println("Enter purchase name:");
        String purchaseName = scanner.nextLine();
        System.out.println("Enter its price:");
        String purchasePrice = scanner.nextLine();
        double productPrice = java.lang.Double.parseDouble(purchasePrice);
        String doubleformat = java.lang.String.format("%.2f",productPrice);
        System.out.println(doubleformat);
        productPrice = java.lang.Double.parseDouble(doubleformat);
        foodExpense += productPrice;
        allExpense += productPrice;
        FoodMap.put(purchaseName, productPrice);
        AllMap.put(purchaseName, productPrice);
        sortedFood.put(productPrice,purchaseName);
        sortedAll.put(productPrice,purchaseName);
        System.out.println("Purchase was added!");
        System.out.println();
    }

    public void addClothes() {
        System.out.println();
        System.out.println("Enter purchase name:");
        String purchaseName = scanner.nextLine();
        System.out.println("Enter its price:");
        String purchasePrice = scanner.nextLine();
        double productPrice = java.lang.Double.parseDouble(purchasePrice);
        String doubleformat = java.lang.String.format("%.2f",productPrice);
        productPrice = java.lang.Double.parseDouble(doubleformat);
        clothesExpense += productPrice;
        allExpense += productPrice;
        ClothesMap.put(purchaseName, productPrice);
        AllMap.put(purchaseName, productPrice);
        sortedClothes.put(productPrice,purchaseName);
        sortedAll.put(productPrice,purchaseName);
        System.out.println("Purchase was added!");
        System.out.println();
    }

    public void addEntertainment() {
        System.out.println();
        System.out.println("Enter purchase name:");
        String purchaseName = scanner.nextLine();
        System.out.println("Enter its price:");
        String purchasePrice = scanner.nextLine();
        double productPrice = java.lang.Double.parseDouble(purchasePrice);
        String doubleformat = java.lang.String.format("%.2f",productPrice);
        productPrice = java.lang.Double.parseDouble(doubleformat);
        entertainmentExpense += productPrice;
        allExpense += productPrice;
        EntertainmentMap.put(purchaseName, productPrice);
        AllMap.put(purchaseName, productPrice);
        sortedEntertainment.put(productPrice,purchaseName);
        sortedAll.put(productPrice,purchaseName);
        System.out.println("Purchase was added!");
        System.out.println();
    }

    public void addOther() {
        System.out.println();
        System.out.println("Enter purchase name:");
        String purchaseName = scanner.nextLine();
        System.out.println("Enter its price:");
        String purchasePrice = scanner.nextLine();
        double productPrice = java.lang.Double.parseDouble(purchasePrice);
        String doubleformat = java.lang.String.format("%.2f",productPrice);
        productPrice = java.lang.Double.parseDouble(doubleformat);
        otherExpense += productPrice;
        allExpense += productPrice;
        OtherMap.put(purchaseName, productPrice);
        AllMap.put(purchaseName, productPrice);
        sortedOther.put(productPrice,purchaseName);
        sortedAll.put(productPrice,purchaseName);
        System.out.println("Purchase was added!");
        System.out.println();
    }

    public void printExpense() {
        boolean exit = true;
        while (exit) {
            System.out.println();
            System.out.println("Choose the type of purchase:");
            System.out.println("1) Food");
            System.out.println("2) Clothes");
            System.out.println("3) Entertainment");
            System.out.println("4) Other");
            System.out.println("5) All");
            System.out.println("6) Back");
            String purchase = scanner.nextLine();
            int choice = Integer.parseInt(purchase);
            switch (choice) {
                case 1: {
                    showFood();
                    break;
                }
                case 2: {
                    showClothes();
                    break;
                }
                case 3: {
                    showEntertainment();
                    break;
                }
                case 4: {
                    showOther();
                    break;
                }
                case 5: {
                    showAll();
                    break;
                }
                case 6: {
                    exit = false;
                    //System.out.println();
                    break;
                }
                default: {
                    System.out.println();
                    printExpense();
                    break;
                }
            }
            System.out.println();
        }
    }

    public void showFood() {
        System.out.println();
        if (FoodMap.isEmpty()) {
            System.out.println("Purchase list is empty");
            System.out.println();
            return;
        }
        System.out.println("Food:");
        for (String s : FoodMap.keySet()) {
            System.out.printf("%s $%.2f ", s, FoodMap.get(s));
            System.out.println();
        }
        System.out.printf("Total sum: $%.2f", foodExpense);
    }

    public void showClothes() {
        System.out.println();
        if (ClothesMap.isEmpty()) {
            System.out.println("Purchase list is empty");
            System.out.println();
            return;
        }
        System.out.println("Clothes:");
        for (String s : ClothesMap.keySet()) {
            System.out.printf("%s $%.2f", s, ClothesMap.get(s));
            System.out.println();
        }
        System.out.printf("Total sum: $%.2f", clothesExpense);
    }

    public void showEntertainment() {
        System.out.println();
        if (EntertainmentMap.isEmpty()) {
            System.out.println("Purchase list is empty");
            return;
        }
        System.out.println("Entertainment:");
        for (String s : EntertainmentMap.keySet()) {
            System.out.printf("%s $%.2f", s, EntertainmentMap.get(s));
            System.out.println();
        }
        System.out.printf("Total sum: $%.2f", entertainmentExpense);

    }

    public void showOther() {
        System.out.println();
        if (OtherMap.isEmpty()) {
            System.out.println("Purchase list is empty");
            return;
        }
        System.out.println("Other:");
        for (String s : OtherMap.keySet()) {
            System.out.printf("%s $%.2f", s, OtherMap.get(s));
            System.out.println();
        }
        System.out.printf("Total sum: $%.2f", otherExpense);
    }

    public void showAll() {
        System.out.println();
        if (AllMap.isEmpty()) {
            System.out.println("Purchase list is empty");
            return;
        }
        for (String s : AllMap.keySet()) {
            System.out.printf("%s $%.2f", s, AllMap.get(s));
            System.out.println();
        }
        System.out.printf("Total sum: $%.2f", allExpense);
    }

    public void saveFile() throws IOException {
        File file = new File("purchases.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("Food:\n");
        for (String s : FoodMap.keySet()) {
            fileWriter.write(s + " $" + FoodMap.get(s));
            fileWriter.write("\n");
        }
        fileWriter.write("Total sum: $" + foodExpense + "\n");
        // System.out.println("Purchases were saved!");
        fileWriter.write("Clothes:\n");
        for (String s : ClothesMap.keySet()) {
            fileWriter.write(s + " $" + ClothesMap.get(s));
            fileWriter.write("\n");
        }
        fileWriter.write("Total sum: $" + clothesExpense + "\n");
        fileWriter.write("Entertainment:\n");
        for (String s : EntertainmentMap.keySet()) {
            fileWriter.write(s + " $" + EntertainmentMap.get(s));
            fileWriter.write("\n");
        }
        fileWriter.write("Total sum: $" + entertainmentExpense + "\n");
        fileWriter.write("Other: \n");
        for (String s : OtherMap.keySet()) {
            fileWriter.write(s + " $" + OtherMap.get(s));
            fileWriter.write("\n");
        }
        fileWriter.write("Total sum: $" + otherExpense + "\n");
        fileWriter.close();
        System.out.println("Purchases were saved!");

    }

    public void loadFile() throws FileNotFoundException {
        this.income += 1000;
        Scanner fileScanner = new Scanner(file);
        ArrayList<String> input = new ArrayList<>();

        while (fileScanner.hasNext()) {
            input.add(fileScanner.nextLine());
        }
        if(input.size() != 0) {
            loadFood(input);
            loadClothes(input);
            loadEntertainment(input);
            loadOther(input);
            System.out.println("Purchases were loaded");
            System.out.println();
        } else {
            System.out.println("Size is empty");
        }


    // System.out.println("Purchases were loaded" + "\n");
    }
    public void loadFood (ArrayList <String> input) {
        int i = 1;
        while (!input.get(i).substring(0,5).equals("Total")) {
            String[] arr = input.get(i).split("\\$");
            FoodMap.put(arr[0], Double.parseDouble(arr[1]));
            AllMap.put(arr[0], Double.parseDouble(arr[1]));
            sortedFood.put(Double.parseDouble(arr[1]), arr[0] );
            sortedAll.put(Double.parseDouble(arr[1]), arr[0] );
            foodExpense += java.lang.Double.parseDouble(arr[1]);
            allExpense +=  java.lang.Double.parseDouble(arr[1]);
        //    System.out.println(input.get(i).split("\\$"));
            i++;
        }

    }
    public void loadClothes (ArrayList <String> input) {
        int i = 0;
        while(!input.get(i).equals("Clothes:")) {
            i++;
        }
        i++;
        while (!input.get(i).substring(0,5).equals("Total")) {
            String[] arr = input.get(i).split("\\$");
            ClothesMap.put(arr[0], Double.parseDouble(arr[1]));
            AllMap.put(arr[0], Double.parseDouble(arr[1]));
            sortedClothes.put(Double.parseDouble(arr[1]), arr[0]);
            sortedAll.put(Double.parseDouble(arr[1]), arr[0]);
            clothesExpense += java.lang.Double.parseDouble(arr[1]);
            allExpense +=  java.lang.Double.parseDouble(arr[1]);
            i++;
        }

    }
    public void loadEntertainment (ArrayList <String> input) {
        int i = 0;
        while(!input.get(i).equals("Entertainment:")) {
            i++;
        }
        i++;
        while (!input.get(i).substring(0,5).equals("Total")) {
            String[] arr = input.get(i).split("\\$");
            EntertainmentMap.put(arr[0], Double.parseDouble(arr[1]));
            AllMap.put(arr[0], Double.parseDouble(arr[1]));
            sortedEntertainment.put(Double.parseDouble(arr[1]), arr[0]);
            sortedAll.put(Double.parseDouble(arr[1]), arr[0]);
            entertainmentExpense += java.lang.Double.parseDouble(arr[1]);
            allExpense +=  java.lang.Double.parseDouble(arr[1]);
            i++;
        }

    }
    public void loadOther (ArrayList <String> input) {
        int i = 0;
        while(!input.get(i).equals("Other: ")) {
            i++;
        }
        i++;
        while (!input.get(i).substring(0,5).equals("Total")) {
            String[] arr = input.get(i).split("\\$");
            if(arr.length > 2) {
                StringBuffer stringBuffer = new StringBuffer();
                boolean exit = true;
                for(int j = 0; j < arr.length-1; j++) {
                    stringBuffer.append(arr[j]);
                    if(exit) {
                        stringBuffer.append("$");
                        exit = false;
                    }
                }
                OtherMap.put(stringBuffer.toString(), Double.parseDouble(arr[arr.length-1]));
                AllMap.put(stringBuffer.toString(), Double.parseDouble(arr[arr.length-1]));
                sortedOther.put(Double.parseDouble(arr[arr.length-1]), stringBuffer.toString());
                sortedAll.put(Double.parseDouble(arr[arr.length-1]), stringBuffer.toString());
                otherExpense += java.lang.Double.parseDouble(arr[arr.length-1]);
                allExpense += java.lang.Double.parseDouble(arr[arr.length-1]);
                i++;
            } else {
                OtherMap.put(arr[0], Double.parseDouble(arr[1]));
                AllMap.put(arr[0], Double.parseDouble(arr[1]));
                sortedOther.put(Double.parseDouble(arr[1]), arr[0]);
                sortedAll.put(Double.parseDouble(arr[1]), arr[0]);
                otherExpense += java.lang.Double.parseDouble(arr[1]);
                allExpense += java.lang.Double.parseDouble(arr[1]);
                i++;
            }
        }

    }

    public void analyze() {
        boolean exit = true;
        while (exit) {
            System.out.println();
            System.out.println("How do you want to sort?");
            System.out.println("1) Sort all purchases");
            System.out.println("2) Sort by type");
            System.out.println("3) Sort certain type");
            System.out.println("4) Back");
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);
            System.out.println();
            switch (choice) {
                case 1: {
                    sortAll();
                    break;
                }
                case 2: {
                    sortByType();
                    break;
                }
                case 3: {
                    sortCertainType();
                    break;
                }
                case 4 : {
                    exit = false;
                    break;
                }
                default : {
                    break;
                }
            }
        }
    }



    public void sortAll() {

        if(sortedAll.size() == 0) {
            System.out.println("list is empty");
            return;
        } else {
            for (Double s : sortedAll.keySet()) {
                System.out.printf("%s$%.2f \n",sortedAll.get(s),s);
            }
        }
      //  System.out.printf("Total sum: $%.2f\n", allExpense);
    }
    public void sortByType() {
        TreeMap <Double, String> byType = new TreeMap<>(Collections.reverseOrder());
        if(allExpense == 0) {
            return;
        }
        byType.put(foodExpense,"Food - $");
        byType.put(clothesExpense,"Clothes - $");
        byType.put(entertainmentExpense,"Entertainment - $");
        byType.put(otherExpense,"Other - $");
         for(Double d : byType.keySet()) {
            System.out.printf("%s%.2f\n",byType.get(d),d);
        }
        System.out.printf("Total sum: $%.2f\n", allExpense);
    }
    public void sortCertainType() {
        if(sortedAll.isEmpty()) {
            System.out.println("list is empty");
        } else {
            System.out.println();
            System.out.println("How do you want to sort?");
            System.out.println("1) Food");
            System.out.println("2) Clothes");
            System.out.println("3) Entertainment");
            System.out.println("4) Other");
            String choice = scanner.nextLine();
            int intchoice = Integer.parseInt(choice);
            System.out.println();
            switch (intchoice) {
                case 1: {
                    if (sortedFood.size() == 0) {
                        System.out.println("list is empty");
                        break;
                    } else {
                        for (Double s : sortedFood.keySet()) {
                            System.out.printf("%s$%.2f \n", sortedFood.get(s), s);
                        }
                    }
                    System.out.printf("Total sum: $%.2f\n", foodExpense);
                    break;
                }
                case 2: {
                    if (sortedClothes.size() == 0) {
                        System.out.println("list is empty");
                    } else {
                        for (Double s : sortedClothes.keySet()) {
                            System.out.printf("%s$%.2f \n", sortedClothes.get(s), s);
                        }
                    }
                    System.out.printf("Total sum: $%.2f\n", clothesExpense);
                    break;
                }
                case 3: {
                    if (sortedEntertainment.size() == 0) {
                        System.out.println("list is empty");
                    } else {
                        for (Double s : sortedEntertainment.keySet()) {
                            System.out.printf("%s$%.2f \n", sortedEntertainment.get(s), s);
                        }
                    }
                    System.out.printf("Total sum: $%.2f\n", entertainmentExpense);
                    break;
                }
                case 4: {
                    if (sortedOther.size() == 0) {
                        System.out.println("list is empty");
                        System.out.println();
                    } else {
                        for (Double s : sortedOther.keySet()) {
                            System.out.printf("%s$%.2f \n", sortedOther.get(s), s);
                        }
                    }
                    System.out.printf("Total sum: $%.2f\n", otherExpense);
                    break;
                }
            }
        }

    }




}
