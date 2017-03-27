package com.example.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.repository")
@ComponentScan(basePackages = {"com.example.service"})
public class AppConfig {

    @Value("${elasticsearch.home:/usr/local/Cellar/elasticsearch/2.3.2}")
    private String elasticSearchHome;

    @Bean
    public Client client() {
        try {
            final Path tmpDir = Files.createTempDirectory(Paths.get(System.getProperty("java.io.tmpdir")), "elasticsearch_data");

            //@formatter:off
            final Settings.Builder elasticSettings = Settings.settingsBuilder().put("http.enabled", "false")
                                                                               .put("path.data", tmpDir.toAbsolutePath().toString())
                                                                               .put("path.home", elasticSearchHome);
            return new NodeBuilder()
                       .local(true)
                       .settings(elasticSettings)
                       .node()
                       .client();

            //@formatter:om

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }
}
