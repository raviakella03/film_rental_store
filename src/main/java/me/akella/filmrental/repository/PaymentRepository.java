package me.akella.filmrental.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.akella.filmrental.entity.Payment;

@ApplicationScoped
public class PaymentRepository
        implements PanacheRepositoryBase<Payment, Integer> {

}
