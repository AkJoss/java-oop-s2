# Coffee Machine Simulator

Console OOP demo: buy cups, pay with coins, track supplies and revenue.

## Run (no Maven required)

```bash
export JAVA_HOME=$(/usr/libexec/java_home)
cd "/Users/joss/Library/CloudStorage/OneDrive-Personal/Documents/Tecmi/2° Semestre/Programacion orientada a objetos/Entregables/Java/coffee-machine/CoffeeMachineSimulator"

mkdir -p out
javac -d out $(find src -name '*.java')
java -cp out com.josealrocmun.coffeemachinesimulator.CoffeeMachineMain
```

## Quick happy-path test

1. Cups to buy: `1`
2. Option: `1` (small, no sugar, $10.50)
3. Coin: `11` → change $0.50
4. Report should show 1 cup sold and revenue `$10.5`
