package generator;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.FieldInfo;
import io.github.classgraph.ScanResult;
import net.steppschuh.markdowngenerator.table.Table;
import net.steppschuh.markdowngenerator.text.Text;
import net.steppschuh.markdowngenerator.text.heading.Heading;

import java.util.ArrayList;
import java.util.List;

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
                addTableNameToPackage(allClass.getName());
                addTableDescriptionToPackage(allClass);

                Table.Builder tableInfo = new Table.Builder();
                addTableHeader(tableInfo);

                for (var fieldInfo : allClass.getFieldInfo()) {
                    var type = getType(fieldInfo);

                    var name = getName(fieldInfo);

                    var annotations = getAnnotations(fieldInfo);

                    addTableInfo(tableInfo, type, name, annotations);
                }

                addTableToPackage(tableInfo.build());
            }
        }
    }

    private void addTableDescriptionToPackage(ClassInfo allClass) {
        var annotationInfo = allClass.getAnnotationInfo("generator.Description");

        var description = (annotationInfo == null)
                ? ""
                : annotationInfo.getParameterValues().getValue("description").toString();

        packageBuilder.append(new Text(">" + description));
        newLine();
        newLine();
    }

    private Table.Builder addTableHeader(Table.Builder tableInfo) {
        return tableInfo.addRow(
                "Filed type",
                "Field name",
                "Description"
        );
    }

    private String getName(FieldInfo fieldInfo) {
        return fieldInfo.getName();
    }

    private String getType(FieldInfo fieldInfo) {
        return fieldInfo.getTypeSignatureOrTypeDescriptor()
                .toStringWithSimpleNames()
                .replace("<", "\\<");
    }

    private List<String> getAnnotations(FieldInfo fieldInfo) {
        var annotationInfo = fieldInfo.getAnnotationInfo("generator.Description");

        var description = (annotationInfo == null)
                ? ""
                : annotationInfo.getParameterValues().getValue("description").toString();

        return List.of(description);
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

    private void addTableInfo(Table.Builder tableBuilder, String type, String name, List<String> annotations) {
        var elements = new ArrayList<String>();
        elements.add(type);
        elements.add(name);
        elements.addAll(annotations);
        tableBuilder.addRow(elements.toArray(Object[]::new));
    }


    private void addTableToPackage(Table table) {
        packageBuilder.append(table);
        newLine();
        newLine();
    }

    private void addTableNameToPackage(String name) {
        packageBuilder.append(new Heading(name, 2));
        newLine();
        newLine();
    }

    private void newLine() {
        packageBuilder.append("\n");
    }


}
