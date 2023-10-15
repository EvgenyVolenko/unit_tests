package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VehicleTest {

    Car car;
    Motorcycle moto;

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        car = new Car("Dodge", "Ram", 2010);
        moto = new Motorcycle("Honda", "Africa", 2015);
    }

    @Test
    public void testCarIsInstanceOfVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    @Test
    public void testCarIsCreatedWith4Wheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    public void testMotorcycleCreatedWith2Wheels() {
        assertThat(moto.getNumWheels()).isEqualTo(2);
    }

    @Test
    public void testCarTestDriveSpeed() {
        car.testDrive();
        assertEquals(car.getSpeed(), 60);
    }

    @Test
    public void testMotorcycleTestDriveSpeed() {
        moto.testDrive();
        assertEquals(moto.getSpeed(), 75);
    }

    @Test
    public void testCarChangeSpeed() {
        car.testDrive();
        car.park();
        assertEquals(car.getSpeed(), 0);
    }

    @Test
    public void testMotorcycleChangeSpeed() {
        moto.testDrive();
        moto.park();
        assertEquals(moto.getSpeed(), 0);
    }
}