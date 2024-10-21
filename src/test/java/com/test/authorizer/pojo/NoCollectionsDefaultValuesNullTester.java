package com.test.authorizer.pojo;

import java.util.Collection;

import com.openpojo.business.annotation.BusinessKey;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoField;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.test.Tester;
import com.openpojo.validation.utils.ValidationHelper;

public class NoCollectionsDefaultValuesNullTester implements Tester {

    public void run(final PojoClass pojoClass) {
        final Object classInstance = ValidationHelper.getBasicInstance(pojoClass);

        for (final PojoField fieldEntry : pojoClass.getPojoFields()) {
            if (!Collection.class.isAssignableFrom(fieldEntry.getType()) && !fieldEntry.isPrimitive()
                    && !fieldEntry.isFinal() && fieldEntry.getAnnotation(BusinessKey.class) == null) {
                Affirm.affirmNull(String.format("Expected null value for for field=[%s]", fieldEntry),
                        fieldEntry.get(classInstance));
            }
        }

    }
}
