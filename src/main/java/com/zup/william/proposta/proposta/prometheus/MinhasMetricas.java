package com.zup.william.proposta.proposta.prometheus;

import io.micrometer.core.instrument.*;
import org.springframework.stereotype.Component;

@Component
public class MinhasMetricas {

    private final MeterRegistry meterRegistry;

    public MinhasMetricas(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    public void meuContador(String feature, String situacao) {
        Counter contador = Counter.builder("Propostas Criadas")
                .description("qtde de prostas criadas")
                .tags(Tags.of(Tag.of(feature, situacao)))
                .baseUnit("propostaria").register(meterRegistry);
        contador.increment();


    }

    public void recordTime(String feature, String situacao) {
        Timer metricaTempo = Timer.builder("Tempo de execucao")
                .description("Latencia na criacao de propostas")
                .tags(Tags.of(Tag.of(feature, situacao)))
                .register(meterRegistry);

        metricaTempo.record(() -> this);
    }

}
