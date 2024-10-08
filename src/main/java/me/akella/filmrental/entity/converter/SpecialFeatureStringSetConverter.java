package me.akella.filmrental.entity.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Set;

@Converter(autoApply = true)
public class SpecialFeatureStringSetConverter
        implements AttributeConverter<Set<String>, String> {

    @Override
    public String convertToDatabaseColumn(Set<String> specialFeaturesSet) {
        return String.join(",", specialFeaturesSet);
    }

    @Override
    public Set<String> convertToEntityAttribute(String specialFeatures) {
        return Set.of(specialFeatures.split(","));
    }
}
