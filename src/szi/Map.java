package szi;

import szi.data.Cell;
import szi.data.State;
import szi.data.cells.*;
import szi.data.plants.Beetroot;
import szi.data.plants.Corn;
import szi.data.plants.Tabaco;
import szi.data.plants.UnknownPlant;

public class Map<S, I> {

    public static Cell[][] create() {
        State state = new State(0.5, 0.5, 0.5, 0.5, 0.5, false);
        Cell[][] cells = new Cell[][]{
                new Cell[]{new House(), (new House()), new House(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road()},
                new Cell[]{new House(), (new House()), new House(), new Road(), new Mud(), new Road(), new Mud(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road(), new Rock()},
                new Cell[]{new House(), (new House()), new House(), new Road(), new Road(), new Road(), new Rock(), new Road(), new Road(), new Road(), new Road(), new Road(), new Rock(), new Road()},
                new Cell[]{new House(), (new House()), new House(), new Road(), new Mud(), new Road(), new Road(), new Rock(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road()},
                new Cell[]{new Road(), (new Road()), new Road(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road(), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new UnknownPlant()), new Road(), new Field(state,
                        new UnknownPlant()), new Field(state, new Tabaco()), new Road(), new Field(state,
                        new UnknownPlant()), new Road(), new Field(state, new Beetroot()), new Field(state,
                        new Beetroot()), new Field(state, new Beetroot()), new Field(state,
                        new Beetroot()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new UnknownPlant()), new Road(), new Field(state,
                        new UnknownPlant()), new Field(state, new Tabaco()), new Road(), new Field(state,
                        new UnknownPlant()), new Road(), new Field(state, new Beetroot()), new Field(state,
                        new Beetroot()), new Field(state, new Beetroot()), new Field(state,
                        new Beetroot()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new UnknownPlant()), new Road(), new Field(state,
                        new UnknownPlant()), new Field(state, new Tabaco()), new Road(), new Field(state,
                        new UnknownPlant()), new Road(), new Field(state, new Beetroot()), new Field(state,
                        new Beetroot()), new Field(state, new Beetroot()), new Field(state,
                        new Beetroot()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new UnknownPlant()), new Road(), new Field(state,
                        new UnknownPlant()), new Water(), new Water(), new Water(), new Water(), new Field(state,
                        new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(
                        state, new Beetroot()), new Mud()},
                new Cell[]{new Road(), (new Mud()), new Field(state, new UnknownPlant()), new Road(), new Field(state,
                        new UnknownPlant()), new Water(), new Water(), new Water(), new Water(), new Field(state,
                        new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(
                        state, new Beetroot()), new Road()},
                new Cell[]{new Road(), (new Mud()), new Field(state, new UnknownPlant()), new Road(), new Field(state,
                        new UnknownPlant()), new Water(), new Water(), new Water(), new Water(), new Field(state,
                        new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(
                        state, new Beetroot()), new Mud()},
                new Cell[]{new Road(), (new Road()), new Road(), new Road(), new Road(), new Water(), new Water(), new Water(), new Water(), new Road(), new Rock(), new Mud(), new Mud(), new Mud()},
                new Cell[]{new Road(), (new Road()), new Field(state, new Tabaco()), new Field(state,
                        new Tabaco()), new Field(state,
                        new Tabaco()), new Water(), new Water(), new Water(), new Water(), new Field(state,
                        new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(
                        state, new Beetroot()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new Tabaco()), new Field(state,
                        new Tabaco()), new Field(state,
                        new Tabaco()), new Water(), new Water(), new Water(), new Water(), new Field(state,
                        new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(
                        state, new Beetroot()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new Tabaco()), new Field(state,
                        new Tabaco()), new Field(state,
                        new Tabaco()), new Water(), new Water(), new Water(), new Water(), new Field(state,
                        new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(
                        state, new Beetroot()), new Road()},
                new Cell[]{new Road(), (new Mud()), new Field(state, new Tabaco()), new Field(state,
                        new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state,
                        new Tabaco()), new Mud(), new Field(state, new Beetroot()), new Field(state,
                        new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(
                        state, new Beetroot()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new Tabaco()), new Field(state,
                        new Tabaco()), new Field(state, new Tabaco()), new Field(state, new Tabaco()), new Field(state,
                        new Tabaco()), new Mud(), new Field(state, new Beetroot()), new Field(state,
                        new Beetroot()), new Field(state, new Beetroot()), new Field(state, new Beetroot()), new Field(
                        state, new Beetroot()), new Road()},
                new Cell[]{new Road(), (new Mud()), new Mud(), new Road(), new Road(), new Rock(), new Mud(), new Mud(), new Mud(), new Mud(), new Road(), new Road(), new Road(), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new UnknownPlant()), new Road(), new Field(state,
                        new UnknownPlant()), new Road(), new Field(state, new UnknownPlant()), new Mud(), new Field(
                        state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state,
                        new Corn()), new Field(state, new Corn()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new UnknownPlant()), new Road(), new Field(state,
                        new UnknownPlant()), new Road(), new Field(state, new UnknownPlant()), new Road(), new Field(
                        state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state,
                        new Corn()), new Field(state, new Corn()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new UnknownPlant()), new Road(), new Field(state,
                        new UnknownPlant()), new Road(), new Field(state, new UnknownPlant()), new Road(), new Field(
                        state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state,
                        new Corn()), new Field(state, new Corn()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new UnknownPlant()), new Road(), new Field(state,
                        new UnknownPlant()), new Road(), new Field(state, new UnknownPlant()), new Road(), new Field(
                        state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state,
                        new Corn()), new Field(state, new Corn()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new UnknownPlant()), new Road(), new Field(state,
                        new UnknownPlant()), new Road(), new Field(state, new UnknownPlant()), new Road(), new Field(
                        state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state,
                        new Corn()), new Field(state, new Corn()), new Road()},
                new Cell[]{new Road(), (new Road()), new Field(state, new UnknownPlant()), new Road(), new Field(state,
                        new UnknownPlant()), new Road(), new Field(state, new UnknownPlant()), new Road(), new Field(
                        state, new Corn()), new Field(state, new Corn()), new Field(state, new Corn()), new Field(state,
                        new Corn()), new Field(state, new Corn()), new Road()}
        };
        return cells;
    }

}
