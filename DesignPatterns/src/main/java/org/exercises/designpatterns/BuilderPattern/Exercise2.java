package org.exercises.designpatterns.BuilderPattern;

import java.time.LocalDate;

public class Exercise2 {
    public static void main(String[] args) {
        // Create a query with multiple filters
        SearchQuery query1 = new SearchQuery.SearchQueryBuilder()
                .keyword("Java")
                .category("Programming")
                .startDate(LocalDate.of(2023, 1, 1))
                .endDate(LocalDate.of(2023, 12, 31))
                .location("New York")
                .minPrice(100)
                .maxPrice(500)
                .build();

        // Create a query with only a few filters
        SearchQuery query2 = new SearchQuery.SearchQueryBuilder()
                .keyword("Technology")
                .location("San Francisco")
                .build();

        System.out.println(query1);
        System.out.println(query2);
    }
}
