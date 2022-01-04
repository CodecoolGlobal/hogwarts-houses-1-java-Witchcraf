package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.HouseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class Room {
    private UUID id;
    private HouseType houseType;
}
