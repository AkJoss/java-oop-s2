# 💊 Pharmacy Inventory

Console OOP demo: login, register medications, apply a markup by pharmaceutical form, print an inventory report.

**Author:** José Alberto Rocha Munguía

## Demo login (coursework)

| Field | Value |
|---|---|
| Username | `josea` |
| Password | `ramb3rt0` |

## Sales markup

| Form | Markup |
|---|---|
| solid | +9% |
| semi-solid | +12% |
| liquid | +13% |

## Run (no Maven required)

```bash
export JAVA_HOME=$(/usr/libexec/java_home)
export PATH="$JAVA_HOME/bin:$PATH"

cd pharmacy-inventory/PharmacyInventoryApp
mkdir -p out
javac -d out $(find src -name '*.java')
java -cp out com.josealrocmun.pharmacyinventoryapp.PharmacyInventoryApp
```

## Quick happy-path test

1. Login: `josea` / `ramb3rt0`
2. Chemical: `Paracetamol`
3. Generic: `Acetaminophen`
4. Brand: `Tylenol`
5. Public price: `100`
6. Form: `solid`
7. Another medication?: `no`

Expected final sales price: **$109.00**
