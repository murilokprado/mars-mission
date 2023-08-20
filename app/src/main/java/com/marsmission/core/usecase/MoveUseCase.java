package com.marsmission.core.usecase;

import com.marsmission.config.util.exception.MapEndException;
import com.marsmission.core.enumeration.Orientation;
import com.marsmission.factory.RotateFactory;
import com.marsmission.factory.Rotation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MoveUseCase {

    public String moveRobot(String commands, int xEdge, int yEdge) {
        int left = 0, right = 0, x = 0;
        int up = 0, down = 0, y = 0;

        char[] commandsChar = commands.toCharArray();
        Orientation position = Orientation.NORTH;

        for (char command : commandsChar) {
            if (command == 'M') {
                if (position.equals(Orientation.NORTH)) {
                    up++;
                } else if (position.equals(Orientation.EAST)) {
                    right++;
                } else if (position.equals(Orientation.WEST)) {
                    left++;
                } else if (position.equals(Orientation.SOUTH)) {
                    down++;
                }
            } else {
                Rotation typeRotation = RotateFactory.getRotation(String.valueOf(command));
                position = typeRotation.rotate(position);
            }

            x = (right - left);
            y = (up - down);

            if (x >= xEdge || y >= yEdge) {
                throw new MapEndException(String.format("Ultrapassado os limites do terreno de Marte. (%d, %d, %s)",
                        x, y, position.getKey()));
            }
        }

        String result = String.format("(%d, %d, %s)", x, y, position.getKey());
        System.out.println("Final Position: " + result);

        return result;
    }
}
