package com.test.authorizer.pojo;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.NoFieldShadowingRule;
import com.openpojo.validation.rule.impl.NoPublicFieldsExceptStaticFinalRule;
import com.openpojo.validation.rule.impl.NoStaticExceptFinalRule;
import com.openpojo.validation.rule.impl.SerializableMustHaveSerialVersionUIDRule;
import com.openpojo.validation.rule.impl.TestClassMustBeProperlyNamedRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

/**
 * Validate the structure and behavior of the Pojo classes in the package.
 * https://github.com/OpenPojo/openpojo/wiki
 */
class MultiPackageTest {

    // Configured for expectation, so we know when a class gets added or removed.
    private static final int EXPECTED_NUMBER_OF_POJO_CLASSES = 42; // TODO remove at the end of development

    // The top level package for all classes to be tested
    private static final String PACKAGE_NAME = "com.test.authorizer";
    private static Validator pojoValidator;
    private static List<PojoClass> pojoClasses;
    private static final PojoClassFilter filterTestClasses = new FilterTestClasses();

    @BeforeAll
    static void setupTestEnvironment() {
        createValidatorForPojoClasses();
        loadPojoClassesFromPackage();
    }

    @Test
    void ensureExpectedPojoCount() {
        Assertions.assertEquals(EXPECTED_NUMBER_OF_POJO_CLASSES, pojoClasses.size(), "Classes added / removed?");
    }

    @Test
    void testPojoStructureAndBehavior() {
        pojoValidator.validate(pojoClasses);

        // FIXME !!!!!!!!
        //  java.lang.reflect.InaccessibleObjectException: Unable to make field static final long java.lang.RuntimeException.serialVersionUID accessible: module java.base does not "opens java.lang" to unnamed module
        // https://stackoverflow.com/questions/41265266/how-to-solve-inaccessibleobjectexception-unable-to-make-member-accessible-m
    }

    private static void loadPojoClassesFromPackage() {
        pojoClasses = PojoClassFactory.getPojoClassesRecursively(PACKAGE_NAME, filterTestClasses);
    }

    private static void createValidatorForPojoClasses() { // TODO build different validator for DTOs and Entities
        // Get all classes recursively under package
        pojoValidator = ValidatorBuilder.create()
                /****
                 * Create Rules to validate structure of the classes
                 ****/
                // Make sure we have a getter and setter
                // .with(new GetterMustExistRule()).with(new SetterMustExistRule())

                // We don't want any primitives in our Pojos.
                // .with(new NoPrimitivesRule())

                // Pojo's should stay simple, don't allow nested classes, anonymous or declared.
                // allow them only if they are private.
 //               .with(new NoNestedClassExceptPrivateRule())

                // Static fields must be final
                .with(new NoStaticExceptFinalRule())

                // Serializable must have serialVersionUID
                //.with(new SerializableMustHaveSerialVersionUIDRule()) TODO Verify it is needed in the current situation

                // Don't shadow parent's field names.
                // .with(new NoFieldShadowingRule())

                // What about public fields, use one of the following rules
                // allow them only if they are static and final.
                .with(new NoPublicFieldsExceptStaticFinalRule())

                // Or you can be more restrictive and not allow ANY public fields in a Pojo.
                // pojoValidator.addRule(new NoPublicFieldsRule());

                // Finally, what if you are testing your Testing code?
                // Make sure your tests are properly named
                //.with(new TestClassMustBeProperlyNamedRule())

                /****
                 * Create Testers to validate the behavior of the classes at runtime.
                 ****/
                // Make sure our setters and getters are behaving as expected.
                .with(new SetterTester()).with(new GetterTester())

                // We don't want any default values to any fields, exceptions:
                // declared final
                // are primitive.
                // Collections(need to be set because of Lombok)
                .with(new DefaultValuesNullTester())

                /**
                 * finalize Validator building.
                 */
                .build();
    }

    private static class FilterTestClasses implements PojoClassFilter {
        public boolean include(PojoClass pojoClass) {
            return !pojoClass.getSourcePath().contains("/test-classes/");
        }
    }
}
