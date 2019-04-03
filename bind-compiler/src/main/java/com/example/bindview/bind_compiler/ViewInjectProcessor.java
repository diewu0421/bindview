package com.example.bindview.bind_compiler;

import com.google.auto.service.AutoService;
import com.google.common.reflect.TypeToken;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

/**
 * 浙江集商优选电子商务有限公司
 *
 * @author zenglw
 * @date 2019/4/4 0:24
 */

@AutoService(Processor.class)
@SupportedAnnotationTypes({"com.example.bindview.bind_annotation.BindView"})
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class ViewInjectProcessor extends AbstractProcessor {


    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {

        TypeSpec.Builder builder = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(
                        MethodSpec.methodBuilder("test")
                                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                                .addCode("int total(){}")
                                .build());
        JavaFile build = JavaFile.builder("com.example.bindview.bindviewdemo", builder.build()).build();
        try {
            build.writeTo(processingEnv.getFiler());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}