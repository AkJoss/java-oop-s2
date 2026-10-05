# ☕ Java OOP — Semester 2 Coursework

Coursework from **2nd semester** of **Software Development Engineering** (Ingeniería en Desarrollo de Software) at Universidad Tecmilenio.

These projects are the **Java** assignments I delivered for the **Object-Oriented Programming** course. Small console apps and Maven demos — not production software.

**Author:** José Alberto Rocha Munguía

---

## 📂 Contents

| Folder | Project |
|---|---|
| `coffee-machine/` | Coffee machine simulator (cups, coins, supplies) |
| `arcade/` | Arcade shell: pick a minigame stub, register customer, daily report |
| `excel-reader/` | Apache POI demo: read `data.xlsx` and print the first sheet |
| `java-basics/` | Six short Maven exercises (inventory, collections, tickets, …) |

More projects from this course will be added as they are cleaned up and tested.

---

## 🛠 Requirements

- **JDK 21+** (tested with JDK 26 on macOS)
- **Maven** for `excel-reader/` and other POI/Maven projects (`brew install maven` on macOS)
- Optional: Maven for the rest (projects include `pom.xml`)

```bash
export JAVA_HOME=$(/usr/libexec/java_home)   # macOS
export PATH="$JAVA_HOME/bin:$PATH"
java -version
```

---

## 🚀 Run — coffee machine

```bash
cd coffee-machine/CoffeeMachineSimulator
mkdir -p out
javac -d out $(find src -name '*.java')
java -cp out com.josealrocmun.coffeemachinesimulator.CoffeeMachineMain
```

Quick test: `1` → `1` → `11` (one small cup, pay $11, get change).

See `coffee-machine/README.md` for details.

---

## 🚀 Run — arcade

```bash
cd arcade/GameArcadeApp
mkdir -p out
javac -d out $(find src -name '*.java')
java -cp out com.josealrocmun.gamearcadeapp.GameArcadeApp
```

Minigames are stubs (print a start line only). Set `ACTIVATIONS` in `GameArcadeApp.java` (1 for a quick test, 10 for the full loop).


## 🚀 Run — excel-reader

Needs **Maven** (Apache POI). Run from the project folder so `data.xlsx` is found:

```bash
export JAVA_HOME=$(/usr/libexec/java_home)
export PATH="$JAVA_HOME/bin:/opt/homebrew/bin:$PATH"
cd excel-reader/ExcelReader
mvn -q compile exec:java
```

See `excel-reader/README.md` for details.

## 🚀 Run — java-basics (example)

```bash
cd java-basics/BoxInventorySystem
mkdir -p out
javac -d out $(find src -name '*.java')
# main class depends on each project — see its pom.xml exec.mainClass
```

---

## 📝 Notes

- Identifiers and comments are in English.
- Build output (`target/`, `out/`) is gitignored.
- Empty placeholder repos from earlier uploads will be cleaned up later.
