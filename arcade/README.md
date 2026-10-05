# Arcade (Game Arcade App)

Console OOP demo: choose a minigame stub, register a customer, print a daily report.

**Note:** the three games only print `Starting '...'` — game logic was never finished in this coursework version. The valuable part is the class hierarchy + registration report.

## Run

```bash
export JAVA_HOME=$(/usr/libexec/java_home)
export PATH="$JAVA_HOME/bin:$PATH"

cd "/Users/joss/Library/CloudStorage/OneDrive-Personal/Documents/Tecmi/2° Semestre/Programacion orientada a objetos/Entregables/Java/arcade/GameArcadeApp"

mkdir -p out
javac -d out $(find src -name '*.java')
java -cp out com.josealrocmun.gamearcadeapp.GameArcadeApp
```

## Quick test (`ACTIVATIONS = 1` in `GameArcadeApp.java`)

```
1
Jose
jose@mail.com
5551234567
01/01/2000
```

You should see “Starting 'Guess the Number'...” and a daily report with that customer.
