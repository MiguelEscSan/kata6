package tests;

import org.junit.Test;
import software.ulpgc.kata6.Board;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardTests {
    @Test
    public void given_an_empty_board_should_return_an_empty_board() {
        Board board = new Board(Cases.emptyBoard).next();
        assertThat(board.state()).isEqualTo(Cases.emptyBoard);
    }

    @Test
    public void given_a_one_cell_dead_should_return_one_cell_dead() {
        Board board = new Board(Cases.oneCellDead).next();
        assertThat(board.state()).isEqualTo(Cases.oneCellDead);
    }

    @Test
    public void given_one_alive_cell_should_return_one_dead_cell() {
        Board board = new Board(Cases.oneCellAlive).next();
        assertThat(board.state()).isEqualTo(Cases.oneCellDead);
    }

    @Test
    public void given_an_2x2_all_dead_cells_should_return_2x2_all_dead_cells() {
        Board board = new Board(Cases.allDead2x2).next();
        assertThat(board.state()).isEqualTo(Cases.allDead2x2);
    }

    @Test
    public void given_2x2_board_all_alive_cells_should_return_all_alive_cells() {
        Board board = new Board(Cases.allAlive2x2).next();
        assertThat(board.state()).isEqualTo(Cases.allAlive2x2);
    }

    @Test
    public void given_2x2_board_triangle_structure_cells_should_return_all_alive_cells() {
        Board board = new Board(Cases.triangleStructure2x2).next();
        assertThat(board.state()).isEqualTo(Cases.allAlive2x2);
    }

    @Test
    public void given_2x2_board_line_structure_cells_should_return_all_dead_cells() {
        Board board = new Board(Cases.lineStructure2x2).next();
        assertThat(board.state()).isEqualTo(Cases.allDead2x2);
    }

    @Test
    public void given_3x3_board_triangle_structure_should_return_square_structure() {
        Board board = new Board(Cases.triangleStructure3x3).next();
        assertThat(board.state()).isEqualTo(Cases.squareStructure3x3);
    }

    @Test
    public void given_4x4_board_triangle_structure_should_return_square_structure() {
        Board board = new Board(Cases.triangleStructure4x4).next();
        assertThat(board.state()).isEqualTo(Cases.squareStructure4x4);
    }

    public static class Cases {
        static final String[][] emptyBoard = {{}};
        static final String[][] oneCellDead = {{"."}};
        static final String[][] oneCellAlive = {{"X"}};
        static final String[][] allDead2x2 = {{".","."},
                                              {".","."}};
        static final String[][] allAlive2x2 = {{"X","X"},
                                               {"X","X"}};

        static final String[][] triangleStructure2x2 = {{".","X"},
                                                        {"X","X"}};

        static final String[][] lineStructure2x2 = {{".","."},
                                                   {"X","X"}};

        static final String[][] triangleStructure3x3 = {{".",".", "X"},
                                                        {".","X","X"},
                                                        {".",".","."}};
        static final String[][] squareStructure3x3 = {{".","X", "X"},
                                                        {".","X","X"},
                                                        {".",".","."}};

        static final String[][] triangleStructure4x4 = {{".",".", "X","."},
                                                        {".","X","X","."},
                                                        {".",".",".","."},
                                                        {".",".",".","."}};
        static final String[][] squareStructure4x4 = {{".","X", "X","."},
                                                      {".","X","X","."},
                                                      {".",".",".","."},
                                                      {".",".",".","."}};
    }
}
