import java.util.*;

public class MazeSolverRecursivo implements MazeSolver {
    private boolean[][] visited;
    private List<List<Cell>> allPaths;

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        if (grid == null || grid.length == 0) {
            return new ArrayList<>();
        }
        visited = new boolean[grid.length][grid[0].length];
        allPaths = new ArrayList<>();

        List<Cell> currentPath = new ArrayList<>();
        findAllPaths(grid, start, end, currentPath);

        if (!allPaths.isEmpty()) {
            // Si solo quieres un camino (el primero encontrado)
            return allPaths.get(0);
        }
        return new ArrayList<>();
    }

    public List<List<Cell>> getAllPaths(boolean[][] grid, Cell start, Cell end) {
        if (grid == null || grid.length == 0) {
            return new ArrayList<>();
        }
        visited = new boolean[grid.length][grid[0].length];
        allPaths = new ArrayList<>();

        List<Cell> currentPath = new ArrayList<>();
        findAllPaths(grid, start, end, currentPath);

        return allPaths;
    }

    private void findAllPaths(boolean[][] grid, Cell current, Cell end, List<Cell> currentPath) {
        int row = current.row;
        int col = current.col;

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length ||
            !grid[row][col] || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        currentPath.add(new Cell(row, col));

        if (row == end.row && col == end.col) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            findAllPaths(grid, new Cell(row + 1, col), end, currentPath); // Abajo
            findAllPaths(grid, new Cell(row - 1, col), end, currentPath); // Arriba
            findAllPaths(grid, new Cell(row, col + 1), end, currentPath); // Derecha
            findAllPaths(grid, new Cell(row, col - 1), end, currentPath); // Izquierda
        }

        // Backtrack
        currentPath.remove(currentPath.size() - 1);
        visited[row][col] = false;
    }
}
