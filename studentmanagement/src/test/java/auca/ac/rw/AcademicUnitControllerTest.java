package auca.ac.rw;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import auca.ac.rw.contoller.AcademicUnitController;
import auca.ac.rw.model.AcademicUnit;
import auca.ac.rw.model.EAcademicUnit;

public class AcademicUnitControllerTest {

    @Test
    @DisplayName("Test adding an Academic Unit")
    public AcademicUnit testAddAcademicUnit() {
        AcademicUnitController academicUnitController = new AcademicUnitController();
        AcademicUnit academicUnit = new AcademicUnit();
        academicUnit.setAcademicUnitName("Faculty of Information Technology");
        academicUnit.setAcademicUnitType(EAcademicUnit.FACULTY);

        AcademicUnit result = academicUnitController.addAcademicUnit(academicUnit);
        System.out.println(result);

        // Testing the Faculty registration
        assertNotNull(result);
        assertEquals(result.getAcademicUnitName(), academicUnit.getAcademicUnitName());

        if (result != null && result.getAcademicUnitType() == EAcademicUnit.FACULTY) {
            AcademicUnit department = new AcademicUnit();
            department.setAcademicUnitName("Software Engineering");
            department.setAcademicUnitType(EAcademicUnit.DEPARTMENT);
            department.setParentId(result);
            AcademicUnit returnedDepartment = academicUnitController.addAcademicUnit(department);
            System.out.println(returnedDepartment);

            // Testing the Department registration
            assertNotNull(returnedDepartment);
            assertEquals(returnedDepartment.getAcademicUnitName(), department.getAcademicUnitName());
            return returnedDepartment;
        } else {
            return null;
        }
    }
}
