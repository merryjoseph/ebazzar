package com.sayone.ebazzar.exception;

public enum ErrorMessages {

    MISSING_REQUIRED_FIELD("Missing Required field. Please check documentation for required fields"),
    CART_ALREADY_CHECKED_OUT("Cart Already Checked Out"),
    EMPTY_CART("There are no products in the cart"),
    INVALID_CART("There is no cart with this ID"),
    INVALID_ADDRESS("There is no address with this ID"),
    INVALID_ORDERID("There is no order with this ID"),
    OUT_OF_STOCK("required quantity not available. Please update Cart Quantity/ Please wait for the seller to add products"),
    INTERNAL_SERVER_ERROR("internal error.Please debug."),
    NO_RECORD_FOUND("no record found.Please debug."),
    NO_ORDER_FOUND("There are no orders for this user"),
    COULD_NOT_UPDATE_RECORD("could not update record.Please debug."),
    COULD_NOT_DELETE_RECORD("could not delete record.Please debug."),
    RECORD_ALREADY_EXISTS("Record already exists"),
    REVIEW_ALREADY_GIVEN("User has Already given review for this product"),
    NO_REVIEW_GIVEN("There are no reviews given "),
    NO_REVIEW_FOUND("There is no review given for the specified product");

    ErrorMessages(String errorMessages) {
        this.errorMessages = errorMessages;
    }


    private String errorMessages;

    public String getErrorMessages() {
        return errorMessages;
    }
}