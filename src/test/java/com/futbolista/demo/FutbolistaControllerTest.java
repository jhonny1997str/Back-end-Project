package com.futbolista.demo;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.futbolista.controller.FutbolistaController;
import com.futbolista.entity.Futbolista;
import com.futbolista.service.FutbolistaService;
import com.futbolista.service.PosicionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FutbolistaControllerTest {

    @Mock
    private FutbolistaService futbolistaService;

    @Mock
    private PosicionService posicionService;

    @InjectMocks
    private FutbolistaController futbolistaController;

    private Futbolista futbolistaMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks

        futbolistaMock = new Futbolista();
        futbolistaMock.setId(1);
        futbolistaMock.setNombres("Juan");
        futbolistaMock.setApellidos("Pérez");
    }

    @Test
    public void testGetAllFutbolistas() {
        List<Futbolista> futbolistas = new ArrayList<>();
        futbolistas.add(futbolistaMock);

        when(futbolistaService.listaTodos()).thenReturn(futbolistas);

        List<Futbolista> result = futbolistaController.getAllFutbolistas();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Juan", result.get(0).getNombres());
    }

    @Test
    public void testRegistraFutbolista() {
        when(futbolistaService.registraFutbolista(futbolistaMock)).thenReturn(futbolistaMock);

        ResponseEntity<?> response = futbolistaController.registra(futbolistaMock);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertInstanceOf(HashMap.class, response.getBody());

        HashMap<String, Object> body = (HashMap<String, Object>) response.getBody();
        assertEquals("Se registró exitosamente el futbolista 'Juan Pérez' ID asignado: 1", body.get("mensaje"));
    }

    @Test
    public void testActualizaFutbolista() {
        when(futbolistaService.actualizaFutbolista(futbolistaMock)).thenReturn(futbolistaMock);

        ResponseEntity<?> response = futbolistaController.actualizaFutbolista(futbolistaMock);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertInstanceOf(HashMap.class, response.getBody());

        HashMap<String, Object> body = (HashMap<String, Object>) response.getBody();
        assertEquals("Se actualizó correctamente.", body.get("mensaje"));
    }

    @Test
    public void testEliminaFutbolista() {
        doNothing().when(futbolistaService).eliminaFutbolista(1);

        ResponseEntity<?> response = futbolistaController.eliminaFutbolista(1);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertInstanceOf(HashMap.class, response.getBody());

        HashMap<String, Object> body = (HashMap<String, Object>) response.getBody();
        assertEquals("Se eliminó correctamente.", body.get("mensaje"));

    }
}