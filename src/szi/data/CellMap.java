package szi.data;


/**
 * Created by Fingal on 15.04.2016.
 */
public class CellMap {

    private Cell[][] map;


    public CellMap(Cell[][] Cells) {
        map = Cells;
    }


//    public CellMap() {
//        // map =
//    }

    public Cell[][] getMap() {
        return map;
    }

    public void nextDay() {
        for (Cell[] row : map) {
            for (Cell Cell : row) {
                Cell.nextDay();
            }
        }
    }
}
