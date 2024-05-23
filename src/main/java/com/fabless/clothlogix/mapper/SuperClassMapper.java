package com.fabless.clothlogix.mapper;


import com.fabless.clothlogix.DTO.ColoreDTO;
import com.fabless.clothlogix.DTO.MaterialeDTO;
import com.fabless.clothlogix.Entity.ColoreEntity;
import com.fabless.clothlogix.Entity.MaterialeEntity;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface SuperClassMapper {
    //COLORE
    ColoreDTO toColoreDTO(ColoreEntity coloreEntity);

    ColoreEntity toColoreEntity(ColoreDTO coloreDTO);

    default List<ColoreDTO> toColoreDTOs(Iterable<ColoreEntity> list) {
        try {
            List<ColoreDTO> coloreDTOs = new ArrayList<>();
            for (ColoreEntity coloreEntity : list) {
                coloreDTOs.add(toColoreDTO(coloreEntity));
            }
            return coloreDTOs;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return new ArrayList<>();
        }
    }
    //MATERIALE
    MaterialeDTO toMaterialeDTO(MaterialeEntity materialeEntity);

    MaterialeEntity toMaterialeEntity(MaterialeDTO materialeDTO);

    default List<MaterialeDTO> toMaterialeDTOs(Iterable<MaterialeEntity> list) {
        try {
            List<MaterialeDTO> materialeDTOs = new ArrayList<>();
            for (MaterialeEntity materialeEntity : list) {
                materialeDTOs.add(toMaterialeDTO(materialeEntity));
            }
            return materialeDTOs;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return new ArrayList<>();
        }
    }


}