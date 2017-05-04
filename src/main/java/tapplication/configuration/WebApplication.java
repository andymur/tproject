package tapplication.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tapplication.model.AdProduct;
import tapplication.repositories.AdProductDao;
import tapplication.service.WebApiService;
import tapplication.service.WebApiServiceImpl;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by apenchukov on 5/3/2017.
 */

@ApplicationPath("/rest")
public class WebApplication extends Application {
}
