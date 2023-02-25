package com.groupe.cardgame.app.infrastructure.springboot.adapter.in;

import com.groupe.cardgame.app.domain.model.Specialty;
import com.groupe.cardgame.app.infrastructure.springboot.models.SpecialtyEntity;
import org.springframework.stereotype.Component;

@Component
public class SpecialtyEntityMapper {
    public static SpecialtyEntity toEntity(Specialty specialty) {
        return new SpecialtyEntity(
                null,
                specialty.name(),
                specialty.healthPointsAtLevel1(),
                specialty.attackPowerAtLevel1(),
                specialty.armorPointsAtLevel1(),
                specialty.additionalAttackPowerAgainstWeakestSpeciality(),
                specialty.weakerSpeciality()
        );
    }
}
