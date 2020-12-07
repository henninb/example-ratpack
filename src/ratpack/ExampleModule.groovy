import com.google.inject.AbstractModule
import finance.services.ExampleService

class ExampleModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ExampleService)
    }
}

