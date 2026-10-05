# 💼 HR Payroll

Console OOP demo: capture employees, pick a job category, compute regular + overtime pay, print a payroll report.

**Author:** José Alberto Rocha Munguía

## Categories (hourly rates)

| # | Category | Regular | Overtime |
|---|---|---|---|
| 1 | Sales | $100 | $50 |
| 2 | Administrator | $180 | $100 |
| 3 | Manager | $250 | $150 |

## Run (no Maven required)

```bash
export JAVA_HOME=$(/usr/libexec/java_home)
export PATH="$JAVA_HOME/bin:$PATH"

cd hr-payroll/HRManagementApp
mkdir -p out
javac -d out $(find src -name '*.java')
java -cp out com.josealrocmun.hrmanagementapp.HumanResourcesMain
```

## Quick happy-path test

Enter:

1. Number of employees: `1`
2. Name: `Ana Lopez`
3. Phone: `5551234567`
4. Birth date: `15/03/1995`
5. Regular hours: `40`
6. Overtime hours: `2`
7. Category: `1` (Sales)

Expected net pay: `(40 * 100) + (2 * 50) = $4100.00`
