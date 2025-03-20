package com.futbolista.demo;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.futbolista.entity.Futbolista;
import com.futbolista.repository.FutbolistaRepository;
import com.futbolista.service.FutbolistaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class FutbolistaServiceImplTest {

    @Mock
    private FutbolistaRepository futbolistaRepository;

    @InjectMocks
    private FutbolistaServiceImpl futbolistaService;

    private Futbolista futbolistaEjemplo;

    @BeforeEach
    public void setUp() {
        futbolistaEjemplo = new Futbolista();
        futbolistaEjemplo.setId(1);
        futbolistaEjemplo.setNombres("Juan");
        futbolistaEjemplo.setApellidos("Pérez");
    }

    @Test
    public void testListaTodos() {
        when(futbolistaRepository.findAll()).thenReturn(Collections.singletonList(futbolistaEjemplo));

        List<Futbolista> result = futbolistaService.listaTodos();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Juan", result.get(0).getNombres());
    }

    @Test
    public void testBuscarFutbolistaPorId() {
        when(futbolistaRepository.listaPorIdIgual(1)).thenReturn(Collections.singletonList(futbolistaEjemplo));

        List<Futbolista> result = futbolistaService.buscarFutbolistaPorId(1);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Juan", result.get(0).getNombres());
    }

    @Test
    public void testRegistraFutbolista() {
        when(futbolistaRepository.save(any(Futbolista.class))).thenReturn(futbolistaEjemplo);

        Futbolista result = futbolistaService.registraFutbolista(futbolistaEjemplo);

        assertNotNull(result);
        assertEquals("Juan", result.getNombres());
    }
    //
    @Test
    public void testEliminaFutbolista() {
        doNothing().when(futbolistaRepository).deleteById(1);

        futbolistaService.eliminaFutbolista(1);

        verify(futbolistaRepository, times(1)).deleteById(1);
    }

    //.
    @Test
    public void testActualizaFutbolista() {
        when(futbolistaRepository.save(any(Futbolista.class))).thenReturn(futbolistaEjemplo);

        Futbolista result = futbolistaService.actualizaFutbolista(futbolistaEjemplo);

        assertNotNull(result);
        assertEquals("Juan", result.getNombres());
    }
}
