package br.psc.guilherme.lol.data.output;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Component
public class OutputWriter {
    public void writeOutput(List<OutputRecord> playerMatchRecords, String outputFileName) {
        OutputMappingStrategy<OutputRecord> mappingStrategy = new OutputMappingStrategy<>();
        mappingStrategy.setType(OutputRecord.class);

        try (Writer fileWriter = new FileWriter(outputFileName)) {
            StatefulBeanToCsv<OutputRecord> beanToCsv =
                    new StatefulBeanToCsvBuilder<OutputRecord>(fileWriter)
                            .withMappingStrategy(mappingStrategy)
                            .build();

            beanToCsv.write(playerMatchRecords);
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            throw new RuntimeException("Failed to write records to the CSV file.");
        } catch (IOException e) {
            throw new RuntimeException("Failed to create the CSV file.");
        }
    }
}
