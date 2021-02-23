package com.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CrearConsultarEliminarCategoryTest.class,
        CrearCategoriaTest.class,
        BlogPostTest.class,
        LoginTest.class,
        ConsultarCategoriaTest.class,
        EliminarCategoriaTest.class
})
public class TestSuite {


}
