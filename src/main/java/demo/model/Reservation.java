package demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Reservation {

    Reservation() { // jpa
    }

    public Reservation(String reservationName) {
        this.reservationName = reservationName;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String reservationName;

    public Long getId() {
        return id;
    }

    public String getReservationName() {
        return reservationName;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservationName='" + reservationName + '\'' +
                '}';
    }

}