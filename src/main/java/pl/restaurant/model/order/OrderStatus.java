package pl.restaurant.model.order;

public enum OrderStatus {


    ORDERED,
    IN_PROGRESS,
    READY
    ;


    public static OrderStatus nextStatus(OrderStatus status){

        if (status == ORDERED){
            return IN_PROGRESS;
        }
        else if (status == IN_PROGRESS){
            return READY;
        }
        else
            throw new IllegalArgumentException("Nie ma takiego statusu");
    }

}
