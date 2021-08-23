import Credentials.TokenService;
import Service.Video;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class VideoTest {

    private static String url = "http://demo.guru99.com";
    private static String api = "/V4/sinkministatement.php";
    private String authToken;

    @Steps
    public Video service;
    @Steps
    private TokenService tokenService;

    @Before
    public void setup(){


    }

    @Test
    @WithTag("vll-management")
    public void verifyThatWeCanFindUnitedStatesOfAmericaUsingTheCodeUS(){
        service.getRequest();
    }

    @Test
    public void verifyThagtWeCanFindUnitedStatesOfAmericaUsingTheCodeUS(){
        service.getRequest();
        service.getRequest();
    }
}
