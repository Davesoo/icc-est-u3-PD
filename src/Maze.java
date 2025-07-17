public class Maze {

    private boolean[][] grid;

    public Maze(boolean[][] predefineMaze) {
        this.grid = predefineMaze;
    }

    public void printMaze() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]) {
                    System.out.print("- "); // Path libre
                } else {
                    System.out.print("* "); // Pared
                }
            }
            System.out.println();
        }
    }

    public void printMazeWithPath(java.util.List<Cell> path) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Cell current = new Cell(i, j);
                if (!grid[i][j]) {
                    System.out.print("* "); // Pared
                } else if (path.contains(current)) {
                    System.out.print("o "); // Camino encontrado
                } else {
                    System.out.print("- "); // Path libre
                }
            }
            System.out.println();
        }
    }

    public boolean[][] getGrid() {
        return grid;
    }
}

