# 📊 Excel Reader

Reads `data.xlsx` with **Apache POI** and prints the first sheet to the console.

**Author:** José Alberto Rocha Munguía

## Requirements

- JDK 21+
- **Maven** (this project needs POI on the classpath)

```bash
# macOS Homebrew, once:
brew install maven
```

## Run

```bash
export JAVA_HOME=$(/usr/libexec/java_home)
export PATH="$JAVA_HOME/bin:/opt/homebrew/bin:$PATH"

cd excel-reader/ExcelReader
mvn -q compile exec:java
```

You must run from the `ExcelReader` folder so `data.xlsx` is found.

## What you should see

A header line `--- Reading Excel Content ---` and then rows of the spreadsheet printed with tab separators.
