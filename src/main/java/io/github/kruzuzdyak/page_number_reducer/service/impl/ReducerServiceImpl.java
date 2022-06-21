package io.github.kruzuzdyak.page_number_reducer.service.impl;

import io.github.kruzuzdyak.page_number_reducer.dto.PageNumbersResponse;
import io.github.kruzuzdyak.page_number_reducer.service.ReducerService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.StringJoiner;

@Service
public class ReducerServiceImpl implements ReducerService {

    @Override
    public PageNumbersResponse reducePages(String pageNumbers) {
        int[] pages = Arrays.stream(pageNumbers.split(","))
                .map(String::trim)
                .distinct()
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        return new PageNumbersResponse(pageNumbers, mergeIntervals(pages));
    }

    private String mergeIntervals(int[] pages) {
        StringJoiner joiner = new StringJoiner(",");
        for (int currPos = 0; currPos < pages.length; currPos++) {
            int counter = currPos + 1;
            counter = countIntervalLength(pages, counter);
            currPos = mergeInterval(pages, joiner, currPos, counter);
        }
        return joiner.toString();
    }

    private int mergeInterval(int[] pages, StringJoiner joiner, int currPos, int counter) {
        if (counter - currPos > 1) {
            joiner.add(String.format("%d-%d", pages[currPos], pages[counter]));
            currPos = counter;
        } else {
            joiner.add(String.valueOf(pages[currPos]));
        }
        return currPos;
    }

    private int countIntervalLength(int[] pages, int counter) {
        while (counter < pages.length) {
            if (pages[counter] - 1 == pages[counter - 1]) {
                counter++;
            } else {
                break;
            }
        }
        return --counter;
    }
}
