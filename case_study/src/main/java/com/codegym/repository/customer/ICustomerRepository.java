package com.codegym.repository.customer;

import com.codegym.dto.IInHouseGuestsDto;
import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "select * from customer where customer_name like :nameVal and customer_address like :address and customer_type_id like :type and status = 1",
            countQuery = "select * from customer where customer_name like :nameVal and customer_address like :address and customer_type_id like :type and status = 1", nativeQuery = true)
    Page<Customer> findAndSearch(@Param("nameVal") String nameVal,@Param("type") String typeFind,@Param("address") String addressFind, Pageable pageable);


    @Query(value ="select c.customer_name customerName,\n" +
            "       f.facility_name facilityName,\n" +
            "       c2.contract_start_day startDay,\n" +
            "       c2.contract_end_day endDay,\n" +
            "       GROUP_CONCAT(a.name_attach_service) attachService,\n" +
            "        SUM(coalesce(cd.quantity * a.cost_attach_service,0))+ f.facility_cost total\n" +
            "       from customer c\n" +
            "inner join contract c2 on c.customer_id = c2.customer_id\n" +
            "inner join facility f on c2.facility_id = f.facility_id\n" +
            "left join contract_detail cd on c2.contract_id = cd.contract_id\n" +
            "left join attach_service a on cd.attach_service_id = a.attach_service_id\n" +
            "group by c2.contract_id",
    countQuery = "select c.customer_name customerName,\n" +
            "       f.facility_name facilityName,\n" +
            "       c2.contract_start_day startDay,\n" +
            "       c2.contract_end_day endDay,\n" +
            "       GROUP_CONCAT(a.name_attach_service) attachService,\n" +
            "        SUM(coalesce(cd.quantity * a.cost_attach_service,0))+ f.facility_cost total\n" +
            "       from customer c\n" +
            "inner join contract c2 on c.customer_id = c2.customer_id\n" +
            "inner join facility f on c2.facility_id = f.facility_id\n" +
            "left join contract_detail cd on c2.contract_id = cd.contract_id\n" +
            "left join attach_service a on cd.attach_service_id = a.attach_service_id\n" +
            "group by c2.contract_id",nativeQuery = true)
    Page<IInHouseGuestsDto> findAllCustomerHaveBooking(Pageable pageable);
}
