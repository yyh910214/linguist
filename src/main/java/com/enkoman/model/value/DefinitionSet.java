package com.enkoman.model.value;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Word's definition value
 * Created by kolian on 2017. 1. 16..
 */

@ToString
public class DefinitionSet {
    @Getter
    @Setter
    private Set<String> definitions = new HashSet<>();

    public DefinitionSet() {}
    public DefinitionSet(Set<String> definitions) {
        this.definitions = definitions;
    }

    /**
     * Entity converter for word's definitions set.
     * Created by kolian on 2017. 1. 16..
     */
    @NoArgsConstructor
    @Converter(autoApply = true)
    public static class DefinitionSetConverter implements AttributeConverter<DefinitionSet, String> {
        private static final String DELIMETER = "||";
        private static final String DELIMETER_REGEX = "\\|\\|";

        @Override
        public String convertToDatabaseColumn(DefinitionSet definitionSet) {
            if (definitionSet == null) {
                return null;
            }

            return definitionSet.getDefinitions().stream().collect(Collectors.joining(DELIMETER));
        }

        @Override
        public DefinitionSet convertToEntityAttribute(String dbData) {
            if (dbData == null) {
                return null;
            }

            Stream<String> stream = Arrays.stream(dbData.split(DELIMETER_REGEX));
            Set<String> definitions = stream.collect(Collectors.toSet());
            return new DefinitionSet(definitions);
        }
    }

}
