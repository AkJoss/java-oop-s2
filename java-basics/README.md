# 📦 Java Basics

Six short Maven console exercises from 2nd-semester OOP coursework.

**Author:** José Alberto Rocha Munguía

| Folder | What it does |
|---|---|
| `BoxInventorySystem/` | Buy/sell paper boxes + cash report |
| `CollectionsDemo/` | List / set / map product demos |
| `DictionarySystem/` | Dictionary lookup console |
| `GradeAverageCalculator/` | Grade average calculator |
| `MatrixStatsApp/` | Square matrix even/odd stats (random fill) |
| `TicketSalesApp/` | Ticket sales + passenger list ($10 each) |

Names are PascalCase Maven project folders under the kebab-case parent `java-basics/`.

## Run (example)

```bash
export JAVA_HOME=$(/usr/libexec/java_home)
export PATH="$JAVA_HOME/bin:$PATH"
cd java-basics/TicketSalesApp
mkdir -p out
javac -d out $(find src -name '*.java')
java -cp out com.josealrocmun.ticketsalesapp.TicketSalesApp
```

See `@author` / quick-test notes in each main class for expected output.
