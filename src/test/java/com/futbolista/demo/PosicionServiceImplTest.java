package com.futbolista.demo;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.futbolista.entity.Posicion;
import com.futbolista.repository.PosicionRepository;
import com.futbolista.service.PosicionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PosicionServiceImplTest {
    //d
    @Mock
    private PosicionRepository posicionRepository;

    @InjectMocks
    private PosicionServiceImpl posicionService;

    private Posicion posicionMock;

    @BeforeEach
    public void setUp() {
        posicionMock = new Posicion();
        posicionMock.setId(1);
        posicionMock.setNombre("Delantero");
    }

    @Test
    public void testListarPosiciones() {
        when(posicionRepository.findAll()).thenReturn(List.of(posicionMock));

        List<Posicion> result = posicionService.listarPosiciones();

        assertNotNull(result, "La lista de posiciones no debe ser nula");
        assertFalse(result.isEmpty(), "La lista de posiciones no debe estar vacía");
        assertEquals(1, result.size(), "Debe haber exactamente una posición en la lista");
        assertEquals("Delantero", result.get(0).getNombre(), "El nombre de la posición debe ser 'Delantero'");
    }
}
