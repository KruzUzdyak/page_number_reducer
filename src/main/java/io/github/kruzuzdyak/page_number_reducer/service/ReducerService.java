package io.github.kruzuzdyak.page_number_reducer.service;

import io.github.kruzuzdyak.page_number_reducer.dto.PageNumbersResponse;

public interface ReducerService {

    PageNumbersResponse reducePages(String pageNumbers);
}
