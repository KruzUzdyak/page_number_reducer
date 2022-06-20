package io.github.kruzuzdyak.page_number_reducer.controller;

import io.github.kruzuzdyak.page_number_reducer.dto.PageNumbersResponse;
import io.github.kruzuzdyak.page_number_reducer.service.ReducerService;
import io.github.kruzuzdyak.page_number_reducer.validation.annotation.RawPageNumbers;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/reducedPageNumbers")
@RequiredArgsConstructor
public class ReducerController {

    private final ReducerService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully reduced page list", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PageNumbersResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content =
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)))
    })
    public PageNumbersResponse reducePageNumbers(@RawPageNumbers @RequestParam String rawPageNumbers) {
        return service.reducePages(rawPageNumbers);
    }
}
