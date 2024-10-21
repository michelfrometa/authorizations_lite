package com.test.authorizer.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.test.authorizer", importOptions = ImportOption.DoNotIncludeTests.class)
class CleanArchitectureTest {
    // TODO Describe layer boundaries

    static final String PRESENTATION_LAYER = "Presentation";
    static final String USE_CASE_LAYER = "UseCase";
    static final String DOMAIN_LAYER = "Domain";
    static final String INFRASTRUCTURE_LAYER = "Infrastructure";

    @ArchTest
    static final ArchRule layer_dependencies_are_respected = layeredArchitecture()
            .consideringAllDependencies()
            .layer(PRESENTATION_LAYER).definedBy("com.test.authorizer.presentation..")
            .layer(USE_CASE_LAYER).definedBy("com.test.authorizer.domain.usecase..")
            .layer(DOMAIN_LAYER).definedBy("com.test.authorizer.domain..")
            .layer(INFRASTRUCTURE_LAYER).definedBy("com.test.authorizer.infrastructure..")

            .whereLayer(PRESENTATION_LAYER).mayNotBeAccessedByAnyLayer()
            .whereLayer(USE_CASE_LAYER).mayOnlyBeAccessedByLayers(PRESENTATION_LAYER)
            .whereLayer(INFRASTRUCTURE_LAYER).mayNotBeAccessedByAnyLayer()
            .withOptionalLayers(true);


}
