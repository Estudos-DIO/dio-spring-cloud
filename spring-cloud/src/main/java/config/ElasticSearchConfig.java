package config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages="cloud.spring.dio.repository")
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

    @Override
    public RestHighLevelClient elasticsearchClient() {

        ClientConfiguration configuracaoCliente = ClientConfiguration.builder()
                .connectedTo("localhost:9200", "localhost:9300")
                .build();

        return RestClients.create( configuracaoCliente ).rest();
    }

//    @Bean
//    @Override
//    public EntityMapper entityManager() {
//        ElasticsearchEntityMapper entityMapper = new ElasticsearchEntityMapper( elasticsearchMappingContext(),
//                new DefaultConversionService());
//
//        entityMapper.setConversions( elasticsearchCustomConversions() );
//
//        return entityMapper;
//    }

}
