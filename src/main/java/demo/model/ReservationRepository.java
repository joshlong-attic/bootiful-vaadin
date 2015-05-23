package demo.model;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation , Long> {

    Collection<Reservation> findByReservationNameIgnoreCase(String rn) ;

}
