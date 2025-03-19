package com.futbolista.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.futbolista.entity.Futbolista;
import com.futbolista.entity.Posicion;
import com.futbolista.service.FutbolistaService;
import com.futbolista.service.PosicionService;
import com.futbolista.util.AppSettings;

@RestController
@RequestMapping("/url/futbolista")

@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class FutbolistaController {

    @Autowired
    private FutbolistaService futbolistaService;


    @Autowired
    private PosicionService posicionService;


    @GetMapping("/posiciones")
    @ResponseBody
    public List<Posicion> listarPosiciones() {

        return posicionService.listarPosiciones();
    }

    @GetMapping
    @ResponseBody // Devuelve el resultado como JSON.
    public List<Futbolista> getAllFutbolistas() {

        return futbolistaService.listaTodos();
    }

    @GetMapping("/buscarPorId/{id}")
    @ResponseBody // Devuelve el resultado como JSON.
    public List<Futbolista> buscarFutbolistaPorId(@PathVariable Integer id) {

        return futbolistaService.buscarFutbolistaPorId(id);
    }


    @PostMapping("/registrarFutbolista")
    @ResponseBody // Devuelve el resultado como JSON.

    public ResponseEntity<?> registra(@RequestBody Futbolista obj) {

        HashMap<String, Object> salida = new HashMap<>();

        try {

            Futbolista objSalida = futbolistaService.registraFutbolista(obj);

            if (objSalida == null) {
                salida.put("mensaje", "Ocurrió un error al registrar");
            } else {
                salida.put("mensaje", "Se registró exitosamente el futbolista " + "'" +
                        objSalida.getNombres() + " " + obj.getApellidos() + "'" +
                        " ID asignado: " + objSalida.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
        }

        return ResponseEntity.ok(salida);
    }

    @PutMapping("/actualizaFutbolista")
    @ResponseBody // Devuelve el resultado como JSON.

    public ResponseEntity<Map<String, Object>> actualizaFutbolista(@RequestBody Futbolista obj) {
        Map<String, Object> salida = new HashMap<>();

        try {
            Futbolista objSalida = futbolistaService.actualizaFutbolista(obj);

            if (objSalida == null) {
                salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
            } else {
                salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
        }

        return ResponseEntity.ok(salida);
    }


    @DeleteMapping("/eliminaFutbolista/{id}")
    @ResponseBody // Devuelve el resultado como JSON.
    public ResponseEntity<Map<String, Object>> eliminaFutbolista(@PathVariable("id") int id) {
        Map<String, Object> salida = new HashMap<>();

        try {

            futbolistaService.eliminaFutbolista(id);
            salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO);
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
        }

        return ResponseEntity.ok(salida);
    }
}

