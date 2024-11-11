package org.exercises.designpatterns.BuilderPattern;

// SearchQuery.java
import java.time.LocalDate;

public class SearchQuery {
    // Optional filter criteria fields
    private final String keyword;
    private final String category;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String location;
    private final Integer minPrice;
    private final Integer maxPrice;

    // Private constructor that accepts the builder
    private SearchQuery(SearchQueryBuilder builder) {
        this.keyword = builder.keyword;
        this.category = builder.category;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.location = builder.location;
        this.minPrice = builder.minPrice;
        this.maxPrice = builder.maxPrice;
    }

    // Getters for each field
    public String getKeyword() {
        return keyword;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getLocation() {
        return location;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    @Override
    public String toString() {
        return "SearchQuery{" +
                "keyword='" + keyword + '\'' +
                ", category='" + category + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", location='" + location + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                '}';
    }

    // Static inner builder class
    public static class SearchQueryBuilder {
        // Fields matching the SearchQuery fields
        private String keyword;
        private String category;
        private LocalDate startDate;
        private LocalDate endDate;
        private String location;
        private Integer minPrice;
        private Integer maxPrice;

        // Setter for keyword filter
        public SearchQueryBuilder keyword(String keyword) {
            this.keyword = keyword;
            return this;
        }

        // Setter for category filter
        public SearchQueryBuilder category(String category) {
            this.category = category;
            return this;
        }

        // Setter for start date filter
        public SearchQueryBuilder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        // Setter for end date filter
        public SearchQueryBuilder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        // Setter for location filter
        public SearchQueryBuilder location(String location) {
            this.location = location;
            return this;
        }

        // Setter for minimum price filter
        public SearchQueryBuilder minPrice(Integer minPrice) {
            this.minPrice = minPrice;
            return this;
        }

        // Setter for maximum price filter
        public SearchQueryBuilder maxPrice(Integer maxPrice) {
            this.maxPrice = maxPrice;
            return this;
        }

        // Build method to create the SearchQuery instance
        public SearchQuery build() {
            return new SearchQuery(this);
        }
    }
}

