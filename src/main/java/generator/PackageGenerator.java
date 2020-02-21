package generator;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.FieldInfo;
import io.github.classgraph.ScanResult;
import net.steppschuh.markdowngenerator.table.Table;
import net.steppschuh.markdowngenerator.text.heading.Heading;

public class PackageGenerator {

    private final StringBuilder packageBuilder;
    private final String packageName;

    public PackageGenerator(String packageName) {
        this.packageBuilder = new StringBuilder();
        this.packageName = packageName;
    }

    public void run() {
        try (var scanResult = getScan(packageName)) {
            for (var allClass : scanResult.getAllClasses()) {
                addTableName(allClass.getName());

                var tableBuilder = new Table.Builder().addRow(
                        "Filed type",
                        "Field name",
                        "Description"
                );

                for (var fieldInfo : allClass.getFieldInfo()) {
                    addTableInfo(tableBuilder, fieldInfo);
                }

                addTable(tableBuilder.build());
            }
        }
    }

    public String build() {
        return packageBuilder.toString();
    }

    private ScanResult getScan(String packageName) {
        return new ClassGraph()
                .whitelistPackages(packageName)
                .enableClassInfo()
                .enableFieldInfo()
                .enableAnnotationInfo()
                .scan();
    }

    private void addTableInfo(Table.Builder tableBuilder, FieldInfo fieldInfo) {
        var type = fieldInfo.getTypeSignatureOrTypeDescriptor()
                .toStringWithSimpleNames()
                .replace("<", "\\<");

        var name = fieldInfo.getName();

        var annotationInfo = fieldInfo.getAnnotationInfo("generator.Description");

        var description = (annotationInfo == null)
                ? ""
                : annotationInfo.getParameterValues().getValue("description").toString();

        tableBuilder.addRow(type, name, description);
    }


    private void addTable(Table table) {
        packageBuilder.append(table);
        newLine();
        newLine();
    }

    private void addTableName(String name) {
        packageBuilder.append(new Heading(name, 2));
        newLine();
        newLine();
    }

    private void newLine() {
        packageBuilder.append("\n");
    }


}
