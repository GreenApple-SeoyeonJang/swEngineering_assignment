package unit_testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Appointment_Test {

	@Test
	void Create_test() {
		assertEquals(1,Main_Appointment.create("�׽�Ʈ ����",2018,01,02,03,04,"���","�б�"));
	}
	
	@Test
	void Delete_test() {
		Main_Appointment.create("Please_Delete", 2018, 05, 07, 04, 52, "freind", "park");
		assertEquals(2,Main_Appointment.delete("Don't have this appointment"));
		assertEquals(1,Main_Appointment.delete("Please_Delete"));
	}
	
}
