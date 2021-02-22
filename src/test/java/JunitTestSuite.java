import com.tests.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        BlogPostTest.class,
        CategoriaTest.class,
        LoginTest.class,
        CrearCategoriaTest.class,
        ConsultarCategoriaTest.class,
        EliminarCategoriaTest.class

})
public class JunitTestSuite {


}
