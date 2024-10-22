package com.test.authorizer.pojo;

import java.util.Collection;
import java.util.Optional;

import com.openpojo.business.annotation.BusinessKey;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoField;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.test.Tester;
import com.openpojo.validation.utils.ValidationHelper;

public class DefaultValuesNullTester implements Tester {

    public void run(final PojoClass pojoClass) {
        final Object classInstance = ValidationHelper.getBasicInstance(pojoClass);
        if (pojoClass.getName().equals("com.test.authorizer.presentation.output.ResponseDto")) {
            for (final PojoField fieldEntry : pojoClass.getPojoFields()) {
                if (!isCollection(fieldEntry) && !isGenericType(fieldEntry) && !fieldEntry.isPrimitive()
                    && !fieldEntry.isFinal() && fieldEntry.getAnnotation(BusinessKey.class) == null) {
                    Affirm.affirmNull(String.format("Expected null value for for field=[%s]", fieldEntry),
                            fieldEntry.get(classInstance));
                }
            }
        }

    }

    private boolean isCollection(PojoField pojoField) {
        return Collection.class.isAssignableFrom(pojoField.getType());
    }

    private boolean isGenericType(PojoField pojoField) {
        return Optional.of(pojoField)
                .map(PojoField::getType)
                .map(Class::getTypeParameters)
                .map(typeParameters -> typeParameters.length == 0)
                .orElse(false);
    }
}
