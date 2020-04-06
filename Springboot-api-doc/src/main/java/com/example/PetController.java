package com.example;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet")

public class PetController {

  private  List<Pet> petList = new ArrayList<>();

  @PostConstruct
  public void init(){

      petList.add(new Pet(1, "Test Pet", new Date()));

  }

    @PostMapping
    @ApiOperation(value = "add new pat",notes = "use carefully this method")
    public ResponseEntity<Pet> kaydet(@RequestBody @ApiParam(value = "animal") Pet pet){
        petList.add(pet);
        return ResponseEntity.ok(pet) ;

    }
    @GetMapping
    @ApiOperation(value = "list pat",notes = "this method make paging ")
    public ResponseEntity<List<Pet>> listele(){
        return ResponseEntity.ok(petList) ;

    }

}
