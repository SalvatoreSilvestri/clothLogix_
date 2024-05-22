package com.fabless.clothlogix.mapper;


import com.fabless.clothlogix.DTO.ColoreDTO;
import com.fabless.clothlogix.Entity.ColoreEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface SuperClassMapper {

    ColoreDTO toColoreDTO(ColoreEntity coloreEntity);

    ColoreEntity toColoreEntity(ColoreDTO coloreDTO);

//    default Iterable<ColoreDTO> toColoreDTOs(Iterable<ColoreEntity> list) {
//        if (list == null) {
//            return null;
//        }
//
//        List<ColoreDTO> coloreDTOs = new ArrayList<>();
//        for (ColoreEntity coloreEntity : list) {
//            coloreDTOs.add(toColoreDTO(coloreEntity));
//        }
//
//        return coloreDTOs;
//    }

}