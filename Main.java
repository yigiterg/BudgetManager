package budget;

import java.io.IOException;
public class Main {




    public static void main(String[] args) throws IOException {

      //   File file = new File("C:\\Users\\90539\\Desktop\\JavaDeneme");
         // file.delete()  // Deletes file in that path
       /*  try {
             boolean isFile = file.mkdir();
             if (isFile) {
                 System.out.println("File was succesfully created");
             } else {
                 System.out.println("File is already exist");
             }
         } catch (Exception e) {
             System.out.println("File was not created succesfully!");
         } */
        BudgetManager budgetManager = new BudgetManager();
        budgetManager.showMenu();




    }

}
