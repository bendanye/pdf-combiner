# pdf-combiner

A tool that combines PDF files into one.

## Introduction

Although there are many online tools that does the combination but many of them either can combine only two files or select the files one by one which is time consuming. Also since is a online tool therefore sensitive documents will be exposed to the provider.

## Prerequisite

Miniumum Java 7 JDK

## Setup

1. Create a build directory at root project.

2. To compile the project, run the following command:

```shell
javac -d ./build src/bendanye\app\pdfcombiner\PdfCombinerByDirectory.java src/bendanye\app\pdfcombiner\gui\PdfCombinerByConsol.java   -classpath lib\commons-cli-1.3.1.jar;lib\pdfbox-app-2.0.0.jar

```

## Run

1. Copy all PDF files you want to combine into the specified folder. The order of the combination is by file name.
2. Run the program by executing the following command

```shell
java -cp ./build;lib\commons-cli-1.3.1.jar;lib\pdfbox-app-2.0.0.jar bendanye.app.pdfcombiner.gui.PdfCombinerByConsol
```

## Impetus

When I was study master degree in 2016 when the lecture notes are given in PDF and split by modules and I prefer to read the whole module notes as one PDF instead of switching to read next module.
