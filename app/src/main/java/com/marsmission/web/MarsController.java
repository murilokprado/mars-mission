package com.marsmission.web;

import com.marsmission.core.usecase.MoveUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "mars", produces = ("application/json"))
@Tag(name = "Mars")
@RequiredArgsConstructor
@Validated
public class MarsController {

    private final MoveUseCase moveUseCase;

    @Operation(summary = "Realiza a movimentação do robô na superfície de Marte", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movimentação realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Movimentação não autorizado"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a movimentação")
    })
    @PostMapping("{commands}")
    public ResponseEntity<Object> move(
            @Valid @PathVariable("commands")
            @Pattern(regexp = "^[MLR]*$", message = "Somente é permitido os seguintes caracteres maiúsculos: 'M', 'L' e 'R'.")
            String commands) {
        int xEdge = 5, yEdge = 5;
        return ResponseEntity.ok(moveUseCase.moveRobot(commands, xEdge, yEdge));
    }
}
