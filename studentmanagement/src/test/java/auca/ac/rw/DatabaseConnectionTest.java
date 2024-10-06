package auca.ac.rw;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import auca.ac.rw.contoller.ConnectionController;;

public class DatabaseConnectionTest {

    @Test
    public void testConnection() {
        ConnectionController conn = new ConnectionController();
        assertEquals("Connection Established", conn.establishConnection());
    }

}
