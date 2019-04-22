package test.clyde.springconfigclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Spring Config Client Rest Controller")
public class ConfigRestController {

	@Autowired
	private SpringConfigClientConfiguration configuration;

	@ApiOperation(value = "Get all config values", response = String.class)
	@RequestMapping(value = "/values", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String getValues() {
		return String.format("Values %s, %s", configuration.getMinimum(), configuration.getMaximum());
	}
}
