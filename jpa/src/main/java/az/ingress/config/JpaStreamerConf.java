package az.ingress.config;

import com.speedment.jpastreamer.application.JPAStreamer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
@RequiredArgsConstructor
public class JpaStreamerConf {

    private final EntityManagerFactory factory;

    @Bean
    public JPAStreamer jpaStreamer() {
        return JPAStreamer.of(factory);
    }
}
