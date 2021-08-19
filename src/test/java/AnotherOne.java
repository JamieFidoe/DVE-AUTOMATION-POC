import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class AnotherOne {

    private static String url = "http://demo.guru99.com";
    private static String api = "/V4/sinkministatement.php";
    @Steps
    public service service;

    @Test()
    @WithTag("customTag")
    public void verifyThatWeCanFindUnitedStatesOfAmericaUsingTheCodeUS(){
        service.getRequest();
        service.getRequest();
        service.getRequest();
    }
}
