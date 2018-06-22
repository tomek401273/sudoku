import java.util.Scanner;

public class ValidateUserChoice {
    Scanner sc = new Scanner(System.in);

    public String validate() {
        int gridI = 0;
        String numberGrid = "";

        System.out.println("Which grid would You like to solve. Write number since 1 to 50");

        while (gridI <= 0) {
            try {
                numberGrid = sc.nextLine();
            } catch (Exception e) {
                System.out.println("Somenthing go wrong. Can you write again your choice number since 1 to 50");
            }
            try {
                gridI = Integer.parseInt(numberGrid);
                if (gridI < 10 && gridI > 0) {
                    numberGrid = "0" + numberGrid;
                }
                if (gridI <= 0 || gridI > 50) {
                    gridI = 0;
                    System.out.println("Somenthing go wrong. Can you write again your choice number since 01 to 50");

                }
            } catch (Exception e) {
                System.out.println("Something go wrong, Can you write again your choice since 01 to 50");
            }
        }
        System.out.println("You choice grid number: " + numberGrid);
        return numberGrid;
    }
}
