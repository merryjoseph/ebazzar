package com.sayone.ebazzar.model.request;

import java.io.Serializable;

public class ReviewRequestModel implements Serializable {

    private Long productId;
    private Long userId;
    private Integer rating;
    private String description;

    public ReviewRequestModel() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long  productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ReviewRequestModel{" + "productId=" + productId + ", userId=" + userId + ", rating=" + rating + ", description='" + description + '\'' + '}';
    }
}
