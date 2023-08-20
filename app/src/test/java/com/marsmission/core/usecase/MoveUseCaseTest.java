package com.marsmission.core.usecase;

import com.marsmission.config.util.exception.MapEndException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MoveUseCaseTest {

    @InjectMocks
    MoveUseCase moveUseCase;

    @Test
    public void shouldMovement() {
        String input = "MMRMMRMM";
        String result = moveUseCase.moveRobot(input, 5, 5);

        assertThat("(2, 0, S)").isEqualTo(result);
    }

    @Test
    public void shouldMovementTwo() {
        String input = "MML";
        String result = moveUseCase.moveRobot(input, 5, 5);

        assertThat("(0, 2, W)").isEqualTo(result);
    }

    @Test(expected = MapEndException.class)
    public void shouldThrowMapEdgeException() {
        String input = "MMMMMMMMMMMMMMMMMMMMMMMM";

        moveUseCase.moveRobot(input, 5, 5);
    }
}
