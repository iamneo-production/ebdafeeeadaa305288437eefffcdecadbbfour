package com.examly.springapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.examly.springapp.controller.TruckController;
import com.examly.springapp.model.Truck;
import com.examly.springapp.service.ApiService;

@ExtendWith(MockitoExtension.class)
public class SpringappApplicationTests {

	@Mock
	private ApiService apiService;

	@InjectMocks
	private TruckController truckController;

	@Test
	public void testAddTruck() {
		Truck truckToAdd = new Truck(1, "5000 lbs", "Red", "Automatic");

		when(apiService.addTruck(truckToAdd)).thenReturn(true);

		boolean response = truckController.addTruck(truckToAdd);

		assertThat(response).isTrue();

		verify(apiService, times(1)).addTruck(truckToAdd);
	}

	@Test
	public void testGetTruckById() {
		Truck truck = new Truck(1, "5000 lbs", "Red", "Automatic");

		when(apiService.getTruckById(1)).thenReturn(truck);

		Truck response = truckController.getTruckById(1);

		assertThat(response).isEqualTo(truck);

		verify(apiService, times(1)).getTruckById(1);
	}

	@Test
	public void testGetAllTrucks() {
		List<Truck> mockTrucks = new ArrayList<>();
		mockTrucks.add(new Truck(1, "5000 lbs", "Red", "Automatic"));
		mockTrucks.add(new Truck(2, "6000 lbs", "Blue", "Manual"));

		when(apiService.getAllTrucks()).thenReturn(mockTrucks);

		List<Truck> response = truckController.getAllTrucks();

		assertThat(response).isEqualTo(mockTrucks);

		verify(apiService, times(1)).getAllTrucks();
	}

	@Test
	public void testControllerFolder() {
		String directoryPath = "src/main/java/com/examly/springapp/controller";
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}

	@Test
	public void testControllerFile() {
		String filePath = "src/main/java/com/examly/springapp/controller/TruckController.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

	@Test
	public void testModelFolder() {
		String directoryPath = "src/main/java/com/examly/springapp/model";
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}

	@Test
	public void testModelFile() {
		String filePath = "src/main/java/com/examly/springapp/model/Truck.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

	@Test
	public void testServiceFolder() {
		String directoryPath = "src/main/java/com/examly/springapp/service";
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}

	@Test
	public void testServiceFile() {
		String filePath = "src/main/java/com/examly/springapp/service/ApiService.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}
}
