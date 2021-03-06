package hospital.management.Hospital.controller;


import hospital.management.Hospital.dto.AppointmentDto;
import hospital.management.Hospital.dto.PrescriptionDto;
import hospital.management.Hospital.service.AppointmentService;
import hospital.management.Hospital.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/api/appointment")
    public List<AppointmentDto> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/api/appointment/patient/{patient_id}")
    public List<AppointmentDto> getPatientAppointments(@PathVariable("patient_id") Integer id) {
        return appointmentService.getAppointmentsOfaPatient(id);
    }

    @GetMapping("/api/appointment/doctor/{doctor_id}")
    public List<AppointmentDto> getDoctorAppointments(@PathVariable("doctor_id") Integer id) {
        return appointmentService.getAppointmentsOfaDoctor(id);
    }

    @GetMapping("/api/appointment/{id}")
    public AppointmentDto getAppointmentById(@PathVariable("id") Integer id) {
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping("/api/appointment/{id}/prescription")
    public PrescriptionDto addPrescription(@PathVariable("id") Integer appointmentId, @RequestBody PrescriptionDto prescriptionDto) {
        AppointmentDto appointmentDto = appointmentService.getAppointmentById(appointmentId);
        prescriptionDto.setDoctor(appointmentDto.getDoctor());
        prescriptionDto.setPatient(appointmentDto.getPatient());
        return prescriptionService.addPrescription(prescriptionDto);
    }

    @PostMapping("/api/appointment/{id}/{status}")
    public AppointmentDto updateAppointmentStatus(@PathVariable("id") Integer id, @PathVariable("status") String status, @RequestBody AppointmentDto appointmentDto) {
        System.out.println(id + " "+status);
        return appointmentService.updateAppointmentStatus(id, status);
    }

    @PostMapping("/api/appointment")
    public AppointmentDto createAppointment(@RequestBody AppointmentDto data) {
        return appointmentService.createAppointment(data);
    }
}
