package com.test.authorizer.pojo;

import com.openpojo.reflection.PojoClass;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.rule.Rule;

public class NoNestedClassExceptPrivateRule implements Rule {

    @Override
    public void evaluate(PojoClass pojoClass) {
        if (pojoClass.isNestedClass() && !pojoClass.isPrivate()) {
            Affirm.fail(String.format("Private Nested Classes not allowed please make it private or refactor out to a separate class [%s]",
                    pojoClass));
        }
    }

}
