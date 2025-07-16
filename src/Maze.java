public class Maze {

    private boolean[][] grid;

    private boolean[][] predefineMaze = {
        {true, true, true, true},
        {false, true, true, true},
        {true, true, false, false},
        {true, true, true, true}
    };

    public Maze(boolean[][] predefineMaze) {
        this.grid = predefineMaze;
    }

    public void printMaze() {
        for (int i = 0; i < predefineMaze.length; i++) {
            for (int j = 0; j < predefineMaze[i].length; j++) {
                if (predefineMaze[i][j]) {
                    System.out.print("- "); // Path
                } else {
                    System.out.print("* "); // Wall
                }
            }
            System.out.println();
        }
    }

    public boolean[][] getGrid() {
        return grid;
    }

    // Additional methods to solve the maze can be added here
}
