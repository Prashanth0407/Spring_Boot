package com.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appointment.entity.Appointment;

@Repository
public interface AppointmentReprository extends JpaRepository<Appointment,Integer>{


}
