package com.example.service.impl;

import com.example.dto.KisiDto;
import com.example.entity.Adres;
import com.example.entity.Kisi;
import com.example.repository.AdresRepository;
import com.example.repository.KisiRepo;
import com.example.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KisiServiceImpl implements KisiService {

    private final  KisiRepo  kisiRepo;
    private final AdresRepository adresRepository;
    @Override
    @Transactional
    public KisiDto save(KisiDto kisiDto) {

        //Assert.isNull(kisiDto.getAdi(),"Adi zorunlu" );

         Kisi kisi = new Kisi();
         kisi.setAdi(kisiDto.getAdi());
         kisi.setSoyadi(kisiDto.getSoyadi());

   final Kisi kisiDb =  kisiRepo.save(kisi);


        List<Adres> liste = new ArrayList<>();
        kisiDto.getAdresler().forEach(item -> {
            Adres adres = new Adres();
            adres.setAdres(item);
            adres.setAdresTip(Adres.AdresTip.DIGER);
            adres.setAktif(true);
            adres.setKisi(kisiDb);
            liste.add(adres);
        });

            adresRepository.saveAll(liste);
                kisiDto.setId(kisiDto.getId());
             return kisiDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<KisiDto> getAll() {

      List<Kisi> kisiler =  kisiRepo.findAll();

      List<KisiDto> kisiDtos = new ArrayList<>();
        kisiler.forEach(it -> {
            KisiDto kisiDto= new KisiDto();
            kisiDto.setId(it.getId());
            kisiDto.setAdi(it.getAdi());
            kisiDto.setSoyadi(it.getSoyadi());
            kisiDto.setAdresler(it.getAdresleri().stream().map(Adres::getAdres)
                    .collect(Collectors.toList()));
    kisiDtos.add(kisiDto);

        });
        return kisiDtos;
    }


    @Override
    public Page<Kisi> getAll(Pageable pageable) {
        return null;
    }
}

