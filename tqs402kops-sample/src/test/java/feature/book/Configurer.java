package feature.book;

import com.hascode.tutorial.cucumber.salary.Employee;
import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Map;

public class Configurer implements TypeRegistryConfigurer {

    @Override
    public void configureTypeRegistry(TypeRegistry registry) {


        registry.defineParameterType(new ParameterType<>("date_iso_local_date_time", // 2011-12-03T10:15:30
                "\\d{4}-\\d{2}-\\d{2}", LocalDateTime.class,
                (String s) -> LocalDateTime.parse(s.concat("T00:00:00"))));

    }



    public Locale locale() {
        return Locale.ENGLISH;
    }

}
