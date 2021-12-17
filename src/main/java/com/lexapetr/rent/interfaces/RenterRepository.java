package com.lexapetr.rent.interfaces;

import com.lexapetr.rent.entity.Renter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RenterRepository extends JpaRepository<Renter, Integer> {
}
