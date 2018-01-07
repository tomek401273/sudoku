import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    int numberchoosenGrid = -1;
    int numberChossenPlusNine = 0;
    String acualRow = "";
    List<String> allGrids = new ArrayList<>();
    List<String> choosenGrid = new ArrayList<>();

    public void readFile() {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/text.txt").getFile());

        Path path = Paths.get(file.getPath());

        try {
            allGrids = Files.readAllLines(path);

        } catch (IOException e) {
            System.out.println("Something go wrong with file.....");
            System.out.println(e);
        }
    }

    public List<String> chooseGrid(String grid) {
        grid = "Grid " + grid;

        for (int i = 0; i < allGrids.size(); i++) {
            acualRow = allGrids.get(i);

            if (allGrids.get(i).equals(grid)) {
                numberchoosenGrid = i;
                numberChossenPlusNine = numberchoosenGrid + 9;
            }
            if (numberchoosenGrid > -1) {
                choosenGrid.add(allGrids.get(i));
                if (i == numberchoosenGrid + 9) {
                    numberchoosenGrid = -1;
                }
            }
        }
        return choosenGrid;
    }

    public int[][] parseData(List<String> grid) {
        int[][] exportedData = new int[9][9];
        String row;
        int value;

        System.out.println("Your grid: " + grid.get(0));
        System.out.println();
        grid.remove(0);
        for (int i = 0; i < grid.size(); i++) {
            row = grid.get(i);

            for (int j = 0; j < 9; j++) {
                value = Integer.parseInt(row.substring(j, j + 1));
                exportedData[i][j] = value;
            }
        }
        return exportedData;
    }
}
