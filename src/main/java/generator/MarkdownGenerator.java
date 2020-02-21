package generator;

import net.steppschuh.markdowngenerator.text.heading.Heading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class MarkdownGenerator {

    public static class Builder {

        public String header = "Empty";
        public String outputPath = "doc.md";
        public List<String> packages = Collections.emptyList();

        public Builder() {
        }

        public Builder with(Consumer<Builder> builder) {
            builder.accept(this);
            return this;
        }

        public MarkdownGenerator createMarkdownGenerator() {
            return new MarkdownGenerator(header, outputPath, packages);
        }

    }

    private final String header;
    private final List<String> packages;
    private final StringBuilder documentBuilder;
    private final String outputPath;

    private MarkdownGenerator(String header, String outputPath, List<String> packages) {
        this.header = header;
        this.packages = packages;
        this.documentBuilder = new StringBuilder();
        this.outputPath = outputPath;
    }

    private void run() {

        addTitle();

        for (var packageName : packages) {
            var packageGenerator = new PackageGenerator(packageName);
            packageGenerator.run();
            add(packageGenerator.build());
        }

        writeToFile();
    }


    private void addTitle() {
        documentBuilder.append(new Heading(header, 1));
        documentBuilder.append("\n");
        documentBuilder.append("\n");
    }

    private void add(String string) {
        documentBuilder.append(string);
    }

    private void writeToFile() {
        try {
            Files.writeString(Paths.get(outputPath), documentBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        var markdownGenerator = new MarkdownGenerator.Builder().with(builder -> {
                    builder.packages = List.of("dtos1", "dtos2");
                    builder.outputPath = "doc.md";
                    builder.header = "DTO information";
                }
        ).createMarkdownGenerator();

        markdownGenerator.run();
    }

}
