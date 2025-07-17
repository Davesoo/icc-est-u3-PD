import java.util.*;

public class App {
    public static void runMaze() {
        boolean[][] predefineMaze = {
            {true, true, true, true},
            {false, true, true, true},
            {true, true, false, false},
            {true, true, true, true}
        };
        Maze maze = new Maze(predefineMaze);
        System.out.println("Laberinto cargado:");
        maze.printMaze();

        Cell start = new Cell(0, 0);
        Cell end = new Cell(3, 3);

        MazeSolverRecursivo solver = new MazeSolverRecursivo();
        List<List<Cell>> allPaths = solver.getAllPaths(maze.getGrid(), start, end);

        if (!allPaths.isEmpty()) {
            System.out.println("\nSe encontraron " + allPaths.size() + " caminos:");

            int count = 1;
            for (List<Cell> path : allPaths) {
                System.out.println("\nCamino #" + count + ":");
                for (Cell cell : path) {
                    System.out.print("(" + cell.getRow() + "," + cell.getCol() + ") ");
                }
                count ++;
            }
        } else {
            System.out.println("No se encontró ningún camino.");
        }
    }
    
    // private static void runEjerciciosPD() {
    //     System.out.println("Dave Siguenza");
    //     EjerciciosPD ejerciciosPD = new EjerciciosPD();

    //     System.out.println("Fibonacci recursivo");
    //     long start = System.nanoTime();
    //     long resultado = ejerciciosPD.getFibonaci(50);
    //     long end = System.nanoTime();
    //     long duration = end - start;
    //     System.out.println("Resultado = " + resultado + " en tiempo = " + duration + " ns");

    //     System.out.println("Fibonacci recursivo con Caching");
    //     start = System.currentTimeMillis();
    //     resultado = ejerciciosPD.getFibonaciPD(100);
    //     end = System.currentTimeMillis();
    //     duration = end - start;
    //     System.out.println("Resultado = " + resultado + " en tiempo = " + duration + " ns");
    // }

    public static void main(String[] args) {
        System.out.println("Dave Sigüenza");
        runMaze();
    }
}
