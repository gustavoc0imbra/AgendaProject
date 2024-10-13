package org.trabalho2.agendaProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trabalho2.agendaProject.Model.Address;
import org.trabalho2.agendaProject.Repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAll()
    {
        return addressRepository.findAll();
    }

    public Address add(Address address)
    {
        return addressRepository.save(address);
    }

    public Optional<Address> findOne(Integer id)
    {
        return addressRepository.findById(id);
    }

    public void delete (Integer id)
    {
        addressRepository.deleteById(id);
    }
}
