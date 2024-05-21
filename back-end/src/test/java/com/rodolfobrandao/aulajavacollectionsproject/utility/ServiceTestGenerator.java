package com.rodolfobrandao.aulajavacollectionsproject.utility;

import org.instancio.Instancio;
import org.instancio.junit.InstancioExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class ServiceTestGenerator {

    public static void main(String[] args) throws IOException {
        String sourceDir = "src/main/java";
        String testDir = "src/test/java";

        File srcDir = new File(sourceDir);
        File testBaseDir = new File(testDir);

        if (!srcDir.exists()) {
            System.out.println("Source directory does not exist!");
            return;
        }

        generateServiceTests(srcDir, testBaseDir);
    }

    private static void generateServiceTests(File srcDir, File testBaseDir) throws IOException {
        List<File> serviceFiles = new ArrayList<>();
        findAllServiceFiles(srcDir, serviceFiles);

        for (File serviceFile : serviceFiles) {
            String className = getClassName(serviceFile);
            String testClassName = className.substring(className.lastIndexOf('.') + 1) + "Test";
            File testFile = new File(testBaseDir, className.replace('.', File.separatorChar) + "Test.java");

            if (!testFile.exists()) {
                createTestFile(testFile, className, testClassName);
            }
        }
    }

    private static void findAllServiceFiles(File dir, List<File> serviceFiles) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                findAllServiceFiles(file, serviceFiles);
            } else if (file.getName().endsWith(".java") && file.getPath().contains("service")) {
                serviceFiles.add(file);
            }
        }
    }

    private static String getClassName(File file) {
        String filePath = file.getPath();
        filePath = filePath.substring(filePath.indexOf("src/main/java/") + "src/main/java/".length());
        filePath = filePath.replace(File.separatorChar, '.');
        return filePath.substring(0, filePath.length() - 5); // remove .java extension
    }

    private static void createTestFile(File testFile, String className, String testClassName) throws IOException {
        testFile.getParentFile().mkdirs();

        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("package " + getPackageName(testFile) + ";\n\n");
            writer.write("import org.junit.jupiter.api.BeforeEach;\n");
            writer.write("import org.junit.jupiter.api.Test;\n");
            writer.write("import org.junit.jupiter.api.extension.ExtendWith;\n");
            writer.write("import org.mockito.InjectMocks;\n");
            writer.write("import org.mockito.Mock;\n");
            writer.write("import org.mockito.MockitoAnnotations;\n");
            writer.write("import org.mockito.junit.jupiter.MockitoExtension;\n");
            writer.write("import org.instancio.Instancio;\n");
            writer.write("import org.instancio.junit.InstancioExtension;\n");
            writer.write("import static org.mockito.Mockito.*;\n");
            writer.write("import static org.junit.jupiter.api.Assertions.*;\n");
            writer.write("import " + className + ";\n\n");
            writer.write("@ExtendWith(MockitoExtension.class)\n");
            writer.write("@ExtendWith(InstancioExtension.class)\n");
            writer.write("public class " + testClassName + " {\n\n");

            // Adiciona mocks e injeções de mocks
            writer.write("    @InjectMocks\n");
            writer.write("    private " + className.substring(className.lastIndexOf('.') + 1) + " service;\n\n");

            // Adiciona campos de mocks para dependências (suposição simples)
            writer.write("    @BeforeEach\n");
            writer.write("    void setUp() {\n");
            writer.write("        MockitoAnnotations.openMocks(this);\n");
            writer.write("    }\n\n");

            try {
                Class<?> clazz = Class.forName(className);

                for (Method method : clazz.getDeclaredMethods()) {
                    if (method.getModifiers() == java.lang.reflect.Modifier.PUBLIC) {
                        writer.write("    @Test\n");
                        writer.write("    void " + method.getName() + "Test() {\n");
                        writer.write("        // Arrange\n");

                        // Gera dados de teste para cada parâmetro do método
                        for (Parameter parameter : method.getParameters()) {
                            String paramType = parameter.getType().getSimpleName();
                            String paramName = parameter.getName();
                            writer.write("        " + paramType + " " + paramName + " = Instancio.create(" + paramType + ".class);\n");
                        }

                        writer.write("        // Act\n");
                        writer.write("        ");
                        if (!method.getReturnType().equals(Void.TYPE)) {
                            writer.write(method.getReturnType().getSimpleName() + " result = ");
                        }
                        writer.write("service." + method.getName() + "(");
                        for (int i = 0; i < method.getParameters().length; i++) {
                            writer.write(method.getParameters()[i].getName());
                            if (i < method.getParameters().length - 1) {
                                writer.write(", ");
                            }
                        }
                        writer.write(");\n");

                        // Assert
                        writer.write("        // Assert\n");
                        if (!method.getReturnType().equals(Void.TYPE)) {
                            writer.write("        assertNotNull(result);\n");
                        }
                        writer.write("    }\n\n");
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            writer.write("}\n");
        }
    }

    private static String getPackageName(File file) {
        String filePath = file.getPath();
        filePath = filePath.substring(filePath.indexOf("src/test/java/") + "src/test/java/".length());
        filePath = filePath.substring(0, filePath.lastIndexOf(File.separatorChar));
        return filePath.replace(File.separatorChar, '.');
    }
}
