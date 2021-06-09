package gt.treinamento.backend.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final long MAX_AGE_SECS = 3600;


    private final ResourceProperties resourceProperties = new ResourceProperties();

    private final ServletContext servletContext;

    @Autowired
    public WebConfig(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .maxAge(MAX_AGE_SECS);
    }

    private List<MediaType> getSupportedMediaTypes() {

        List<MediaType> list = new ArrayList<>();

        list.add(MediaType.IMAGE_JPEG);
        list.add(MediaType.IMAGE_PNG);
        list.add(MediaType.APPLICATION_OCTET_STREAM);
        list.add(MediaType.APPLICATION_PDF);
        list.add(MediaType.MULTIPART_FORM_DATA);

        return list;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        final String[] staticLocations = resourceProperties.getStaticLocations();
        final String[] indexLocations = new String[staticLocations.length];

        for (int i = 0; i < staticLocations.length; i++) {

            indexLocations[i] = staticLocations[i] + "index.html";

        }

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler(
                "/**/*.css",
                "/**/*.html",
                "/**/*.js",
                "/**/*.json",
                "/**/*.bmp",
                "/**/*.jpeg",
                "/**/*.jpg",
                "/**/*.gif",
                "/**/*.ico",
                "/**/*.png",
                "/**/*.ttf",
                "/**/*.wav",
                "/**/*.mp3",
                "/**/*.eot",
                "/**/*.svg",
                "/**/*.woff",
                "/**/*.woff2",
                "/**/*.map"
        ).addResourceLocations(staticLocations);

        registry.addResourceHandler("/**")
                .addResourceLocations(indexLocations)
                .resourceChain(true)
                .addResolver(new PathResourceResolver() {

                    @Override
                    protected Resource getResource(String resourcePath, Resource location) {
                        return location.exists() && location.isReadable() ? location : null;
                    }

                });

    }

    @Bean
    public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {

        ByteArrayHttpMessageConverter arrayHttpMessageConverter = new ByteArrayHttpMessageConverter();

        arrayHttpMessageConverter.setSupportedMediaTypes(getSupportedMediaTypes());

        return arrayHttpMessageConverter;
    }
}

