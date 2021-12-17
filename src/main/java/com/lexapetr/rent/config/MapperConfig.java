package com.lexapetr.rent.config;

import com.lexapetr.rent.mapper.RenterMapper;
import com.lexapetr.rent.mapper.RenterPatchMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import partial.update.mapper.ChangeLoggerAnnotationIntrospector;
import partial.update.mapper.PartialUpdateMapperProducer;

import java.util.List;

@Configuration
public class MapperConfig implements WebMvcConfigurer {
    private final PartialUpdateMapperProducer partialUpdateMapperProducer;

    public MapperConfig() {
        this.partialUpdateMapperProducer = new PartialUpdateMapperProducer();

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters
                .stream()
                .filter(converter -> converter instanceof MappingJackson2HttpMessageConverter)
                .forEach(
                        converter -> ((MappingJackson2HttpMessageConverter) converter)
                                .getObjectMapper().setAnnotationIntrospector(new ChangeLoggerAnnotationIntrospector())
                );
    }

    @Bean
    public RenterPatchMapper renterPatchMapper() {
        return partialUpdateMapperProducer.createMapper(RenterPatchMapper.class);
    }
}
