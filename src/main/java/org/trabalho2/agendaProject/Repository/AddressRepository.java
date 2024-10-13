package org.trabalho2.agendaProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trabalho2.agendaProject.Model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
