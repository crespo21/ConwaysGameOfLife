import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GAmeOfLifeTest {
    @Test
    public void AnyLiveCellWithFewerThanTwoLiveNeighborsDies() {
        int columns=10;
        int rows =10;
        int neighbors = 0;
        int[][] currentState = new int[columns][rows];

        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++)
                neighbors +=(currentState[i+i][j+j]);
        int[][] nextState = new int[columns][rows];
        for (int i = -1; i <= 1; i++){
            for (int j = -1; j <= 1; j++) {
                if ((currentState[i][j] == 1) && (neighbors < 2)) nextState[i][j] = 0;
                else if ((currentState[i][j] == 1) && (neighbors < 2)) nextState[i][j] = 0;
                else if ((currentState[i][j] == 1) && (neighbors == 2 || neighbors == 3)) nextState[i][j] = 1;
                else if ((currentState[i][j] == 1) && (neighbors > 3)) nextState[i][j] = 0;
                else if ((currentState[i][j] == 0) && (neighbors == 3)) nextState[i][j] = 1;
                else nextState[i][j] = currentState[i][j];
            }
        }
    }
}

