package software.ulpgc.kata6;

public class Board {
    private final String[][] state;

    public Board(String[][] state) {
        this.state = state;
    }

    public String[][] state() {
        return state;
    }

    public Board next() {
        return new Board(calculateNextState());
    }

    private String[][] calculateNextState() {
        String[][] result = new String[rows()][cols()];
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                result[i][j] = validateNextStateOfCell(i,j);
            }
        }
        return result;
    }

    private String validateNextStateOfCell(int row, int col) {
        return validateCell(row, col) ? "X" : ".";
    }

    private boolean validateCell(int row, int col) {
        int neighbors  = countNeigborsOfCell(row, col);
        return isAlive(row, col) && neighbors >= 2 && neighbors <= 3 || neighbors == 3 && !isAlive(row, col);
    }

    private boolean isAlive(int row, int col) {
        return state[row][col].equals("X");
    }


    private int countNeigborsOfCell(int row, int col) {
        int cont = 0;
        if(validNeighbor(row-1, col-1)) cont++;
        if(validNeighbor(row-1, col+1)) cont++;
        if(validNeighbor(row-1, col)) cont++;
        if(validNeighbor(row+1, col-1)) cont++;
        if(validNeighbor(row+1, col+1)) cont++;
        if(validNeighbor(row+1, col)) cont++;
        if(validNeighbor(row, col+1)) cont++;
        if(validNeighbor(row, col-1)) cont++;
        return cont;
    }

    private boolean validNeighbor(int row, int col) {
        return isBounds(row, col) && state[row][col].equals("X");
    }

    private boolean isBounds(int row, int col) {
        return row >= 0 && row < rows() && col >= 0 && col < cols();
    }

    private int rows() {
        return state.length;
    }

    private int cols() {
        return state[0].length;
    }
}
