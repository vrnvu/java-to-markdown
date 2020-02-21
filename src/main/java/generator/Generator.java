package generator;

import io.github.classgraph.*;
import net.steppschuh.markdowngenerator.table.Table;
import net.steppschuh.markdowngenerator.text.heading.Heading;

public class Generator {
    public static void main(String[] args) {
        Generator generator = new Generator();
        generator.run();
    }

    private void run() {

        StringBuilder sb = new StringBuilder()
                .append(new Heading("DTO information", 1)).append("\n\n");

        try (ScanResult scanResult = new ClassGraph()
                .whitelistPackages("dtos")
                .enableClassInfo()
                .enableFieldInfo()
                .enableAnnotationInfo()
                .scan()) {
            for (ClassInfo allClass : scanResult.getAllClasses()) {
                sb.append(new Heading(allClass.getName(), 2)).append("\n\n");
                Table.Builder tableBuilder = new Table.Builder()
                        .addRow("Filed type", "Field name", "Description");
                FieldInfoList fieldInfoList = allClass.getFieldInfo();
                for (FieldInfo fieldInfo : fieldInfoList) {
                    String type = fieldInfo.getTypeSignatureOrTypeDescriptor()
                            .toStringWithSimpleNames()
                            .replace("<", "\\<");
                    String name = fieldInfo.getName();
                    AnnotationInfo annotationInfo = fieldInfo.getAnnotationInfo("generator.Description");
                    //prettyPrint(type, name);
                    String description = annotationInfo.getParameterValues().getValue("description").toString();
                    tableBuilder.addRow(type, name, description);
                }
                sb.append(tableBuilder.build()).append("\n");
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private void prettyPrint(String typeSignatureStr, String name) {
        System.out.println("Type: " + typeSignatureStr + ", name: " + name);
    }
}
