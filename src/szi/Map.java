package szi;

import szi.data.Cell;
import szi.data.State;
import szi.data.cells.Field;
import szi.data.cells.Mud;
import szi.data.cells.Road;
import szi.data.cells.Water;
import szi.data.plants.Beetroot;
import szi.data.plants.Corn;
import szi.data.plants.Tabaco;

public class Map {

    public static Cell[][] create() {
        State state = new State(0.5, 0.5, 0.5, 0.5, 0.5, false);
        Cell[][] cells = new Cell[][]{
                new Cell[]{new Road(), (new Road()), new Road(), new Road(), new Road(), new Road(), new Road(), new Road(), new Water(), new Water(), new Water(), new Water(), new Road(), new Road()},
                new Cell[]{new Road(), (new Road()), new Mud(), new Road(), new Mud(), new Road(), new Mud(), new Road(), new Water(), new Water(), new Water(), new Water(), new Road(), new Road()},
                new Cell[]{new Road(), (new Mud()), new Mud(), new Road(), new Road(), new Road(), new Road(), new Road(), new Water(), new Water(), new Water(), new Water(), new Road(), new Road()},
                new Cell[]{new Road(), (new Mud()), new Mud(), new Mud(), new Mud(), new Road(), new Road(), new Road(), new Water(), new Water(), new Road(), new Road(), new Road(), new Road()},
                new Cell[]{new Road(), (new Road()), new Road(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Road(), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Road(), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Road(), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Water(), new Water(), new Water(), new Water(), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Mud()},
                new Cell[]{new Road(), (new Mud()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Water(), new Water(), new Water(), new Water(), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Road()},
                new Cell[]{new Road(), (new Mud()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Water(), new Water(), new Water(), new Water(), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Mud()},
                new Cell[]{new Road(), (new Road()), new Road(), new Road(), new Road(), new Water(), new Water(), new Water(), new Water(), new Road(), new Road(), new Mud(), new Mud(), new Mud()},
                new Cell[]{new Road(), (new Road()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Water(), new Water(), new Water(), new Water(), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Water(), new Water(), new Water(), new Water(), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Water(), new Water(), new Water(), new Water(), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Road()},
                new Cell[]{new Road(), (new Mud()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Mud(), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Mud(), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Road()},
                new Cell[]{new Road(), (new Mud()), new Mud(), new Road(), new Road(), new Road(), new Mud(), new Mud(), new Mud(), new Mud(), new Road(), new Road(), new Road(), new Road()},
                new Cell[]{new Road(), (new Mud()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Mud(), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Road()},
                new Cell[]{new Road(), (new Mud()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Road(), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Road(), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Road(), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Road(), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Road(), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Road()}
        };
        return cells;
    }

}
