package com.example.controller;

import com.example.dto.KisiDto;
import com.example.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class KisiController {

    private final KisiService kisiService;


    @PostMapping
    public ResponseEntity<KisiDto> kaydet(@RequestBody KisiDto kisiDto){
        return ResponseEntity.ok(kisiService.save(kisiDto)) ;

    }
    @GetMapping
    public ResponseEntity<List<KisiDto>> listele(){
        return ResponseEntity.ok(kisiService.getAll()) ;

    }
}
