package com.diplomski.backend.external.service_external;

import com.diplomski.backend.domain.Airline;
import com.diplomski.backend.domain.Airplane;
import com.diplomski.backend.exception.NoSuchElementFoundException;
import com.diplomski.backend.external.dto_external.AirplaneEDTO;
import com.diplomski.backend.repository.AirplaneRepository;
import com.diplomski.backend.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AirplaneExternalService extends ExternalService<Airplane, AirplaneEDTO> {
    @Autowired
    private AirlineService airlineService;
    @Autowired
    private AirplaneRepository airplaneRepository;
    @Override
    List<Airplane> saveObjects(List<Airplane> list) {
        return airplaneRepository.saveAll(
                list.stream()
                        .filter(airplane -> airplane.getIataCodeLong()!=null && airplane.getIataCodeShort()!=null)
                        .map(airplane -> {
                            try{
                                Airline airline=airlineService.findByIataCode(airplane.getAirline());
                                airplane.setAirline(airline);
                                System.out.println(airplane.getFirstFlightDate());
                                return airplane;
                            }catch (NoSuchElementFoundException ex){
                                return null;
                            }
                        })
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList())
        );
    }

    @Override
    protected AirplaneEDTO trimList(AirplaneEDTO airplaneEDTO) {
        if(airplaneEDTO.getAirlineIata()==null){
            return null;
        }
        return airplaneEDTO;
    }
}
