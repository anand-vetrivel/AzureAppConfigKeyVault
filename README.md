## 1. POC Implementation - Azure APP CONFIG only

### 1.1 pom.xml parent and dependencies

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.5</version>
        <relativePath /> <!-- lookup parent from repository -->
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>com.azure.spring</groupId>
            <artifactId>spring-cloud-azure-appconfiguration-config-web</artifactId>
            <version>5.12.0</version>
        </dependency>
    </dependencies>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>com.azure.spring</groupId>
                <artifactId>spring-cloud-azure-dependencies</artifactId>
                <version>5.16.0</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>


### 1.2 AppConfigProperty.java 		(config/AppConfigProperty.java)

	@ConfigurationProperties(prefix = "config")
	public class AppConfigProperty {
		private String reciprocityHost;

		public String getReciprocityHost() {
			return reciprocityHost;
		}

		public void setReciprocityHost(String reciprocityHost) {
			this.reciprocityHost = reciprocityHost;
		}

		@Override
		public String toString() {
			return "AppConfigProperty{" +
						"reciprocityHost=" + reciprocityHost +
					'}';
		}
	}


### 1.3 DemoApp.java 	(app/DemoApp.java)

	@ComponentScan({"controller","config"})
	@EnableConfigurationProperties(AppConfigProperty.class)
	@SpringBootApplication
	public class DemoApp {
		public static void main(String[] args) {
			SpringApplication.run(DemoApp.class, args);
		}
	}

### 1.4	DemoRestController.java		(controller/DemoRestController.java)

	@RestController
	public class DemoRestController {
		private final AppConfigProperty properties;

		public DemoRestController(AppConfigProperty properties) {
			this.properties = properties;
		}

		@RequestMapping(value = "hello", method = RequestMethod.GET)
		public String readAppConfigValue() {
			System.out.println("Inside readAppConfigValue() !");
			return properties.toString();
		}
	}


### 1.5 bootstrap.properties

```
spring.cloud.azure.appconfiguration.stores[0].connection-string=${APPCONFIG_CONNECTIONSTRING}
logging.level.org.springframework=INFO
```

### 1.6 Run DemoApp

Run configuration
```
APPCONFIG_CONNECTIONSTRING		Endpoint=https://unity-appconf-eus-d.azconfig.io;Id=3V1j;Secret=G9sk7GBWgkq16u3r8siZBADiqG18Lkr0aIR9Lp1YanRxzENldTAOJQQJ99AIACYeBjFoYEw6AAACAZACycG0
```

### 1.7 http://localhost:8080/hello

AppConfigProperty{reciprocityHost=https://r99-api-int-01.fmcgds-np.com}
